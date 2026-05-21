-- =============================================================================
-- TABLA AUXILIAR PARA AUDITORÍA
-- =============================================================================
CREATE TABLE AUDITORIA_SISTEMA (
    id_auditoria NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    tabla_afectada VARCHAR2(50),
    operacion VARCHAR2(20),
    detalle VARCHAR2(4000),
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);



-- =============================================================================
-- 1. FUNCIONES (Mínimo 2)
-- =============================================================================

-- FN 1: Calcular monto acumulado de pagos aprobados por cuenta
CREATE OR REPLACE FUNCTION FN_CALCULAR_MONTO(p_id_cuenta IN NUMBER)
RETURN NUMBER IS
    v_total NUMBER(10,2);
BEGIN
    SELECT COALESCE(SUM(monto), 0.00) INTO v_total
    FROM PAGO
    WHERE id_cuenta = p_id_cuenta AND estado_pago = 'Aprobado';
    
    RETURN v_total;
END;
 

-- FN 2: Recomendar contenido basado en la categoría del último contenido calificado con más de 3 estrellas
CREATE OR REPLACE FUNCTION FN_CONTENIDO_RECOMENDADO(p_id_perfil IN NUMBER)
RETURN NUMBER IS
    v_id_cat_favorita NUMBER;
    v_id_cont_recomendado NUMBER;
BEGIN
    -- Buscar la categoría del contenido mejor calificado por el perfil utilizando la sintaxis de ordenación de Oracle
    BEGIN
        SELECT id_categoria INTO v_id_cat_favorita
        FROM (
            SELECT c.id_categoria
            FROM CALIFICACION cal
            JOIN CONTENIDO c ON cal.id_contenido = c.id_contenido
            WHERE cal.id_perfil = p_id_perfil AND cal.estrellas >= 4
            ORDER BY cal.fecha DESC
        )
        WHERE ROWNUM = 1;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            v_id_cat_favorita := NULL;
    END;

    -- Si no ha calificado nada alto, tomamos la primera categoría que encontremos
    IF v_id_cat_favorita IS NULL THEN
        BEGIN
            SELECT id_categoria INTO v_id_cat_favorita FROM CATEGORIA WHERE ROWNUM = 1;
        EXCEPTION
            WHEN NO_DATA_FOUND THEN
                RETURN NULL;
        END;
    END IF;

    -- Seleccionar un contenido de esa categoría que el perfil no haya reproducido aún
    BEGIN
        SELECT id_contenido INTO v_id_cont_recomendado
        FROM (
            SELECT id_contenido
            FROM CONTENIDO
            WHERE id_categoria = v_id_cat_favorita
              AND id_contenido NOT IN (SELECT id_contenido FROM REPRODUCCION WHERE id_perfil = p_id_perfil)
        )
        WHERE ROWNUM = 1;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            v_id_cont_recomendado := NULL;
    END;

    RETURN v_id_cont_recomendado;
END;

-- FN 3: Listar perfiles asociados a una cuenta utilizando BULK COLLECT para simular el mapeo de Java
CREATE OR REPLACE FUNCTION FN_FIND_BY_CUENTA_ID(p_id_cuenta IN NUMBER)
RETURN PerfilDTO_List IS
    v_lista_dtos PerfilDTO_List := PerfilDTO_List();
BEGIN
    -- El BULK COLLECT hace el trabajo del .stream().map().toList() de Java
    SELECT PerfilDTO_Obj(id_perfil, id_cuenta, nombre, avatar, tipo_perfil)
    BULK COLLECT INTO v_lista_dtos
    FROM PERFIL
    WHERE id_cuenta = p_id_cuenta;

    -- Si la lista está vacía, puedes manejarlo o simplemente retornar la lista inicializada en 0
    RETURN v_lista_dtos;
EXCEPTION
    WHEN OTHERS THEN
        RAISE_APPLICATION_ERROR(-20005, 'Error al consultar los perfiles de la cuenta: ' || SQLERRM);
END;
/
 


-- =============================================================================
-- 2. PROCEDIMIENTOS ALMACENADOS (Mínimo 3 - Incluyen Excepciones Personalizadas)
-- =============================================================================

-- SP 1: Registrar Usuario con validación de correo electrónico único e inicialización de cuenta básica
CREATE OR REPLACE PROCEDURE SP_REGISTRAR_USUARIO(
    p_nombre IN VARCHAR2,
    p_correo IN VARCHAR2,
    p_telefono IN VARCHAR2,
    p_fecha_nac IN DATE,
    p_ciudad IN VARCHAR2,
    p_id_plan_inicial IN NUMBER
) IS
    v_nuevo_id_user NUMBER;
    v_existe NUMBER;
BEGIN
    -- [Excepción Personalizada 1]: Validar correo duplicado
    SELECT COUNT(*) INTO v_existe FROM USUARIO WHERE correo_electronico = p_correo;
    IF v_existe > 0 THEN
        RAISE_APPLICATION_ERROR(-20001, 'El correo electrónico ya se encuentra registrado en la plataforma.');
    END IF;

    -- Insertar el nuevo usuario utilizando la cláusula RETURNING de Oracle
    INSERT INTO USUARIO (nombre_completo, correo_electronico, telefono, fecha_nacimiento, ciudad_residencia)
    VALUES (p_nombre, p_correo, p_telefono, p_fecha_nac, p_ciudad)
    RETURNING id_usuario INTO v_nuevo_id_user;

    -- Crear automáticamente su cuenta activa vinculada al plan solicitado
    INSERT INTO CUENTA (estado_servicio, fecha_ultimo_pago, id_usuario, id_plan)
    VALUES ('Activo', SYSDATE, v_nuevo_id_user, p_id_plan_inicial);

END;
 

-- SP 2: Cambiar Plan de una Cuenta validando que exista y esté al día
CREATE OR REPLACE PROCEDURE SP_CAMBIAR_PLAN(
    p_id_cuenta IN NUMBER,
    p_id_nuevo_plan IN NUMBER
) IS
    v_existe NUMBER;
    v_estado VARCHAR2(50);
BEGIN
    -- Verificar si la cuenta existe
    SELECT COUNT(*) INTO v_existe FROM CUENTA WHERE id_cuenta = p_id_cuenta;
    IF v_existe = 0 THEN
        RAISE_APPLICATION_ERROR(-20002, 'La cuenta especificada no existe en el sistema.');
    END IF;

    -- [Excepción Personalizada 2]: Impedir cambios si el servicio está suspendido por morosidad
    SELECT estado_servicio INTO v_estado FROM CUENTA WHERE id_cuenta = p_id_cuenta;
    IF v_estado = 'Suspendido' THEN
        RAISE_APPLICATION_ERROR(-20003, 'No se puede cambiar el plan de una cuenta suspendida. Regularice sus pagos.');
    END IF;

    -- Actualizar el plan si pasa las restricciones de negocio
    UPDATE CUENTA
    SET id_plan = p_id_nuevo_plan
    WHERE id_cuenta = p_id_cuenta;
END;
 

-- SP 3: Reporte de Consumo (Simulación de procesamiento y guardado de métricas de auditoría)
CREATE OR REPLACE PROCEDURE SP_REPORTE_CONSUMO(
    p_id_cuenta IN NUMBER,
    p_total_reproducciones OUT NUMBER
) IS
BEGIN
    SELECT COUNT(r.id_reproduccion) INTO p_total_reproducciones
    FROM REPRODUCCION r
    JOIN PERFIL p ON r.id_perfil = p.id_perfil
    WHERE p.id_cuenta = p_id_cuenta;
END;
 


-- =============================================================================
-- 3. CURSORES (Mínimo 2)
-- =============================================================================

-- CURSOR 1: Identificar cuentas morosas (sin pagos en los últimos 30 días) para suspender el servicio
CREATE OR REPLACE PROCEDURE SP_PROCESAR_USUARIOS_MOROSOS IS
    -- Declaración explícita del Cursor 1
    CURSOR cur_morosos IS
        SELECT id_cuenta, fecha_ultimo_pago 
        FROM CUENTA 
        WHERE estado_servicio = 'Activo' 
          AND fecha_ultimo_pago < (SYSDATE - 30);
          
    v_id_cuenta NUMBER;
    v_fecha_pago DATE;
BEGIN
    OPEN cur_morosos;
    LOOP
        FETCH cur_morosos INTO v_id_cuenta, v_fecha_pago;
        EXIT WHEN cur_morosos%NOTFOUND;
        
        -- Acción: Cambiar estado a Suspendido por morosidad
        UPDATE CUENTA 
        SET estado_servicio = 'Suspendido' 
        WHERE id_cuenta = v_id_cuenta;
        
        DBMS_OUTPUT.PUT_LINE('Cuenta ' || v_id_cuenta || ' suspendida automáticamente. Último pago: ' || v_fecha_pago);
    END LOOP;
    CLOSE cur_morosos;
END;
 

-- CURSOR 2: Cálculo de popularidad de contenido (actualiza métricas o evalúa reproducciones masivas)
CREATE OR REPLACE PROCEDURE SP_CALCULAR_POPULARIDAD IS
    -- Declaración explícita del Cursor 2 con agregaciones
    CURSOR cur_popularidad IS
        SELECT id_contenido, COUNT(id_reproduccion) AS total_vistas
        FROM REPRODUCCION
        GROUP BY id_contenido;
        
    v_id_contenido NUMBER;
    v_total_vistas NUMBER;
BEGIN
    OPEN cur_popularidad;
    LOOP
        FETCH cur_popularidad INTO v_id_contenido, v_total_vistas;
        EXIT WHEN cur_popularidad%NOTFOUND;
        
        -- Evaluación de métricas
        IF v_total_vistas >= 1000 THEN
            DBMS_OUTPUT.PUT_LINE('Contenido ID: ' || v_id_contenido || ' es tendencia global con ' || v_total_vistas || ' vistas.');
        ELSE
            DBMS_OUTPUT.PUT_LINE('Contenido ID: ' || v_id_contenido || ' mantiene un flujo regular de ' || v_total_vistas || ' vistas.');
        END IF;
    END LOOP;
    CLOSE cur_popularidad;
END;
 


-- =============================================================================
-- 4. DISPARADORES   TRIGGERS (Mínimo 4)
-- =============================================================================

-- TRIGGER 1 (A nivel de Fila - BEFORE INSERT): Validar límite de perfiles permitidos según el Plan de la Cuenta
CREATE OR REPLACE TRIGGER TR_VALIDAR_PERFILES
BEFORE INSERT ON PERFIL
FOR EACH ROW
DECLARE
    v_max_perfiles NUMBER;
    v_perfiles_actuales NUMBER;
BEGIN
    -- Obtener el límite de perfiles permitidos por el plan de la cuenta vinculada
    SELECT p.perfiles_permitidos INTO v_max_perfiles
    FROM CUENTA c
    JOIN PLAN p ON c.id_plan = p.id_plan
    WHERE c.id_cuenta = :NEW.id_cuenta;

    -- Contar perfiles ya creados en esa cuenta
    SELECT COUNT(*) INTO v_perfiles_actuales
    FROM PERFIL
    WHERE id_cuenta = :NEW.id_cuenta;

    IF v_perfiles_actuales >= v_max_perfiles THEN
        RAISE_APPLICATION_ERROR(-20004, 'Límite de perfiles superado para esta cuenta. Su plan actual solo permite un máximo de ' || v_max_perfiles || ' perfiles.');
    END IF;
END;
 

-- TRIGGER 2 (A nivel de Fila - AFTER UPDATE): Registrar en auditoría cuando un usuario cambia de plan
CREATE OR REPLACE TRIGGER TR_AUDITAR_PLAN
AFTER UPDATE OF id_plan ON CUENTA
FOR EACH ROW
BEGIN
    INSERT INTO AUDITORIA_SISTEMA (tabla_afectada, operacion, detalle)
    VALUES ('CUENTA', 'UPDATE_PLAN', 'La cuenta ID ' || :NEW.id_cuenta || ' cambió del plan ' || :OLD.id_plan || ' al plan ' || :NEW.id_plan);
END;
 

-- TRIGGER 3 (A nivel de Fila - AFTER INSERT): Actualizar la fecha de último pago en Cuenta al aprobar un Pago
CREATE OR REPLACE TRIGGER TR_ACTUALIZAR_CUENTA_PAGO
AFTER INSERT ON PAGO
FOR EACH ROW
BEGIN
    IF :NEW.estado_pago = 'Aprobado' THEN
        UPDATE CUENTA
        SET fecha_ultimo_pago = :NEW.fecha_pago,
            estado_servicio = 'Activo' -- Restaura el servicio si estaba en estado Suspendido
        WHERE id_cuenta = :NEW.id_cuenta;
    END IF;
END;
 

-- TRIGGER 4 (A nivel de Sentencia - AFTER DELETE): Registrar eventos de depuración masiva de reproducciones obsoletas
CREATE OR REPLACE TRIGGER TR_LOG_SENTENCIA_REPRODUCCION
AFTER DELETE ON REPRODUCCION
BEGIN
    INSERT INTO AUDITORIA_SISTEMA (tabla_afectada, operacion, detalle)
    VALUES ('REPRODUCCION', 'DELETE_BULK', 'Se ejecutó una sentencia de eliminación masiva o limpieza estructural en la tabla de reproducciones.');
END;
 