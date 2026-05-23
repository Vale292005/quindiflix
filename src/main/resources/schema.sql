-- Esquema de la base de datos para Quindiflix
--limpieza de tablas (si es necesario)
-- Limpieza de tablas previas (en orden inverso por las llaves foráneas)
DROP TABLE REPRODUCCION CASCADE CONSTRAINTS PURGE/
DROP TABLE CALIFICACION CASCADE CONSTRAINTS PURGE/
DROP TABLE FAVORITO CASCADE CONSTRAINTS PURGE/
DROP TABLE EPISODIO CASCADE CONSTRAINTS PURGE/
DROP TABLE CONTENIDO_GENERO CASCADE CONSTRAINTS PURGE/
DROP TABLE PAGO CASCADE CONSTRAINTS PURGE/
DROP TABLE PERFIL CASCADE CONSTRAINTS PURGE/
DROP TABLE TEMPORADA CASCADE CONSTRAINTS PURGE/
DROP TABLE REFERIDO CASCADE CONSTRAINTS PURGE/
DROP TABLE CUENTA CASCADE CONSTRAINTS PURGE/
DROP TABLE CONTENIDO CASCADE CONSTRAINTS PURGE/
DROP TABLE EMPLEADO CASCADE CONSTRAINTS PURGE/
DROP TABLE GENERO CASCADE CONSTRAINTS PURGE/
DROP TABLE CATEGORIA CASCADE CONSTRAINTS PURGE/
DROP TABLE PLAN CASCADE CONSTRAINTS PURGE/
DROP TABLE DEPARTAMENTO CASCADE CONSTRAINTS PURGE/
DROP TABLE USUARIO CASCADE CONSTRAINTS PURGE/
-- Creación de tablas principales
CREATE TABLE USUARIO (
    id_usuario NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nombre_completo VARCHAR2(255) NOT NULL,
    correo_electronico VARCHAR2(150) NOT NULL UNIQUE,
    telefono VARCHAR2(20),
    fecha_nacimiento DATE,
    ciudad_residencia VARCHAR2(100),
    password VARCHAR2(255) 
)/

CREATE TABLE DEPARTAMENTO (
    id_departamento NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nombre VARCHAR2(50) NOT NULL UNIQUE
)/

CREATE TABLE PLAN (
    id_plan NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nombre_plan VARCHAR2(50) NOT NULL,
    precio NUMBER(10,2) NOT NULL,
    calidad_video VARCHAR2(20),
    cantidad_pantallas NUMBER(2),
    perfiles_permitidos NUMBER(2)
)/

CREATE TABLE CATEGORIA (
    id_categoria NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nombre VARCHAR2(50) NOT NULL
)/

CREATE TABLE GENERO (
    id_genero NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nombre VARCHAR2(100) NOT NULL
)/

-- Creación de tablas con relaciones
CREATE TABLE EMPLEADO (
    id_empleado NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nombre_completo VARCHAR2(255) NOT NULL,
    correo VARCHAR2(150) NOT NULL UNIQUE,
    telefono VARCHAR2(30),
    cargo VARCHAR2(100),
    id_departamento NUMBER NOT NULL,
    id_supervisor NUMBER,
    CONSTRAINT fk_emp_depto FOREIGN KEY (id_departamento) REFERENCES DEPARTAMENTO(id_departamento),
    CONSTRAINT fk_emp_sup FOREIGN KEY (id_supervisor) REFERENCES EMPLEADO(id_empleado),
    password VARCHAR2(255) 
)/

CREATE TABLE CONTENIDO(
    id_contenido NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    titulo VARCHAR2(255) NOT NULL,
    fecha_incorporacion DATE,
    tipo_contenido VARCHAR2(50),
    es_original NUMBER(1) DEFAULT 0 CHECK (es_original IN (0, 1)),
    id_empleado NUMBER NOT NULL,
    id_categoria NUMBER NOT NULL,
    CONSTRAINT fk_emp_responsable FOREIGN KEY (id_empleado) REFERENCES EMPLEADO(id_empleado),
    CONSTRAINT fk_categoria FOREIGN KEY (id_categoria) REFERENCES CATEGORIA(id_categoria),
    url_imagen VARCHAR2(500)
)/

CREATE TABLE CUENTA (
    id_cuenta NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    estado_servicio VARCHAR2(50),
    fecha_ultimo_pago DATE,
    id_usuario NUMBER NOT NULL UNIQUE,
    id_plan NUMBER NOT NULL,
    CONSTRAINT fk_cuenta_user FOREIGN KEY (id_usuario) REFERENCES USUARIO(id_usuario),
    CONSTRAINT fk_cuenta_plan FOREIGN KEY (id_plan) REFERENCES PLAN(id_plan)
)/

-- Segunda capa
CREATE TABLE REFERIDO (
    id_referido NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    id_usuario_referidor NUMBER NOT NULL,
    id_usuario_referido NUMBER NOT NULL,
    fecha_referido DATE,
    activo NUMBER(1) DEFAULT 1 CHECK (activo IN (0, 1)),
    CONSTRAINT fk_referido_user FOREIGN KEY (id_usuario_referido) REFERENCES USUARIO(id_usuario),
    CONSTRAINT fk_referidor_user FOREIGN KEY (id_usuario_referidor) REFERENCES USUARIO(id_usuario)
)/

CREATE TABLE TEMPORADA (
    id_temporada NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    numero_temporada NUMBER(3),
    titulo VARCHAR2(200) NOT NULL,
    id_contenido NUMBER NOT NULL,
    CONSTRAINT fk_temporada_contenido FOREIGN KEY (id_contenido) REFERENCES CONTENIDO(id_contenido)
)/

CREATE TABLE PERFIL (
    id_perfil NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nombre VARCHAR2(100) NOT NULL,
    avatar VARCHAR2(500),
    tipo_perfil VARCHAR2(20) CHECK (tipo_perfil IN ('Adulto', 'Infantil', 'Empleado')),
    id_cuenta NUMBER,
    CONSTRAINT fk_perfil_cuenta FOREIGN KEY (id_cuenta) REFERENCES CUENTA(id_cuenta)
)/

CREATE TABLE PAGO (
    id_pago NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    fecha_pago DATE,
    monto NUMBER(10,2) NOT NULL,
    metodo_pago VARCHAR2(50),
    estado_pago VARCHAR2(20) CHECK (estado_pago IN ('Exitoso', 'Fallido', 'Pendiente')),
    id_cuenta NUMBER NOT NULL,
    CONSTRAINT fk_pago_cuenta FOREIGN KEY (id_cuenta) REFERENCES CUENTA(id_cuenta)
)/

CREATE TABLE CONTENIDO_GENERO (
    id_contenido NUMBER NOT NULL,
    id_genero NUMBER NOT NULL,
    CONSTRAINT pk_contenido_genero PRIMARY KEY (id_contenido, id_genero),
    CONSTRAINT fk_cg_contenido FOREIGN KEY (id_contenido) REFERENCES CONTENIDO(id_contenido),
    CONSTRAINT fk_cg_genero FOREIGN KEY (id_genero) REFERENCES GENERO(id_genero)
)/
--Tercera capa
CREATE TABLE EPISODIO (
    id_episodio NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    titulo VARCHAR2(255) NOT NULL,
    numero NUMBER(4),
    id_temporada NUMBER NOT NULL,
    CONSTRAINT fk_episodio_temporada FOREIGN KEY (id_temporada) REFERENCES TEMPORADA(id_temporada)
)/

CREATE TABLE FAVORITO (
    id_favorito NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    id_perfil NUMBER NOT NULL,
    id_contenido NUMBER NOT NULL,
    fecha_agregado TIMESTAMP,
    CONSTRAINT fk_favorito_perfil FOREIGN KEY (id_perfil) REFERENCES PERFIL(id_perfil),
    CONSTRAINT fk_favorito_contenido FOREIGN KEY (id_contenido) REFERENCES CONTENIDO(id_contenido)  
)/

CREATE TABLE CALIFICACION (
    id_calificacion NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    id_perfil NUMBER NOT NULL,
    id_contenido NUMBER NOT NULL,
    estrellas NUMBER(2) CHECK (estrellas BETWEEN 1 AND 5),
    fecha_calificacion TIMESTAMP,
    CONSTRAINT fk_calificacion_perfil FOREIGN KEY (id_perfil) REFERENCES PERFIL(id_perfil),
    CONSTRAINT fk_calificacion_contenido FOREIGN KEY (id_contenido) REFERENCES CONTENIDO(id_contenido)
)/

-- Tabla de reproducciones para métricas
CREATE TABLE REPRODUCCION (
    id_reproduccion NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    fecha_hora_inicio TIMESTAMP,
    fecha_hora_fin TIMESTAMP,
    dispositivo VARCHAR2(50),
    porcentaje_avance NUMBER(5,2) CHECK (porcentaje_avance BETWEEN 0 AND 100),
    id_perfil NUMBER NOT NULL,
    id_contenido NUMBER NOT NULL,
    id_episodio NUMBER,
    CONSTRAINT fk_reproduccion_perfil FOREIGN KEY (id_perfil) REFERENCES PERFIL(id_perfil),
    CONSTRAINT fk_reproduccion_contenido FOREIGN KEY (id_contenido) REFERENCES CONTENIDO(id_contenido),
    CONSTRAINT fk_reproduccion_episodio FOREIGN KEY (id_episodio) REFERENCES EPISODIO(id_episodio)
)/


--Consultas PL/SQL para reportes
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
/

-- =============================================================================
-- CREACIÓN DE TIPOS REQUERIDOS PARA LA FUNCIÓN 3 (Mapeo DTO)
-- =============================================================================
CREATE OR REPLACE TYPE PerfilDTO_Obj AS OBJECT (
    id_perfil NUMBER,
    id_cuenta NUMBER,
    nombre VARCHAR2(50),
    avatar VARCHAR2(255),
    tipo_perfil VARCHAR2(20)
);
/

CREATE OR REPLACE TYPE PerfilDTO_List AS TABLE OF PerfilDTO_Obj;
/

-- =============================================================================
-- 1. FUNCIONES
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
/

-- FN 2: Recomendar contenido basado en la categoría del último contenido calificado con más de 3 estrellas
CREATE OR REPLACE FUNCTION FN_CONTENIDO_RECOMENDADO(p_id_perfil IN NUMBER)
RETURN NUMBER IS
    v_id_cat_favorita NUMBER;
    v_id_cont_recomendado NUMBER;
BEGIN
    -- Buscar la categoría del contenido mejor calificado por el perfil
    BEGIN
        SELECT id_categoria INTO v_id_cat_favorita
        FROM (
            SELECT c.id_categoria
            FROM CALIFICACION cal
            JOIN CONTENIDO c ON cal.id_contenido = c.id_contenido
            WHERE cal.id_perfil = p_id_perfil AND cal.estrellas >= 4
            ORDER BY cal.fecha_calificacion DESC
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
/

-- FN 3: Listar perfiles asociados a una cuenta utilizando BULK COLLECT
CREATE OR REPLACE FUNCTION FN_FIND_BY_CUENTA_ID(p_id_cuenta IN NUMBER)
RETURN PerfilDTO_List IS
    v_lista_dtos PerfilDTO_List := PerfilDTO_List();
BEGIN
    SELECT PerfilDTO_Obj(id_perfil, id_cuenta, nombre, avatar, tipo_perfil)
    BULK COLLECT INTO v_lista_dtos
    FROM PERFIL
    WHERE id_cuenta = p_id_cuenta;

    RETURN v_lista_dtos;
EXCEPTION
    WHEN OTHERS THEN
        RAISE_APPLICATION_ERROR(-20005, 'Error al consultar los perfiles de la cuenta: ' || SQLERRM);
END;
/

-- =============================================================================
-- 2. PROCEDIMIENTOS ALMACENADOS
-- =============================================================================

-- SP 1: Registrar Usuario con validación de correo único e inicialización de cuenta
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
    SELECT COUNT(*) INTO v_existe FROM USUARIO WHERE correo_electronico = p_correo;
    IF v_existe > 0 THEN
        RAISE_APPLICATION_ERROR(-20001, 'El correo electrónico ya se encuentra registrado en la plataforma.');
    END IF;

    INSERT INTO USUARIO (nombre_completo, correo_electronico, telefono, fecha_nacimiento, ciudad_residencia)
    VALUES (p_nombre, p_correo, p_telefono, p_fecha_nac, p_ciudad)
    RETURNING id_usuario INTO v_nuevo_id_user;

    INSERT INTO CUENTA (estado_servicio, fecha_ultimo_pago, id_usuario, id_plan)
    VALUES ('Activo', SYSDATE, v_nuevo_id_user, p_id_plan_inicial);
END;
/

-- SP 2: Cambiar Plan de una Cuenta
CREATE OR REPLACE PROCEDURE SP_CAMBIAR_PLAN(
    p_id_cuenta IN NUMBER,
    p_id_nuevo_plan IN NUMBER
) IS
    v_existe NUMBER;
    v_estado VARCHAR2(50);
BEGIN
    SELECT COUNT(*) INTO v_existe FROM CUENTA WHERE id_cuenta = p_id_cuenta;
    IF v_existe = 0 THEN
        RAISE_APPLICATION_ERROR(-20002, 'La cuenta especificada no existe en el sistema.');
    END IF;

    SELECT estado_servicio INTO v_estado FROM CUENTA WHERE id_cuenta = p_id_cuenta;
    IF v_estado = 'Suspendido' THEN
        RAISE_APPLICATION_ERROR(-20003, 'No se puede cambiar el plan de una cuenta suspendida. Regularice sus pagos.');
    END IF;

    UPDATE CUENTA
    SET id_plan = p_id_nuevo_plan
    WHERE id_cuenta = p_id_cuenta;
END;
/

-- SP 3: Reporte de Consumo
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
/

-- =============================================================================
-- 3. CURSORES
-- =============================================================================

-- CURSOR 1: Identificar cuentas morosas
CREATE OR REPLACE PROCEDURE SP_PROCESAR_USUARIOS_MOROSOS IS
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
        
        UPDATE CUENTA 
        SET estado_servicio = 'Suspendido' 
        WHERE id_cuenta = v_id_cuenta;
        
        DBMS_OUTPUT.PUT_LINE('Cuenta ' || v_id_cuenta || ' suspendida automáticamente. Último pago: ' || v_fecha_pago);
    END LOOP;
    CLOSE cur_morosos;
END;
/

-- CURSOR 2: Cálculo de popularidad de contenido
CREATE OR REPLACE PROCEDURE SP_CALCULAR_POPULARIDAD IS
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
        
        IF v_total_vistas >= 1000 THEN
            DBMS_OUTPUT.PUT_LINE('Contenido ID: ' || v_id_contenido || ' es tendencia global con ' || v_total_vistas || ' vistas.');
        ELSE
            DBMS_OUTPUT.PUT_LINE('Contenido ID: ' || v_id_contenido || ' mantiene un flujo regular de ' || v_total_vistas || ' vistas.');
        END IF;
    END LOOP;
    CLOSE cur_popularidad;
END;
/

-- =============================================================================
-- 4. DISPARADORES (TRIGGERS)
-- =============================================================================

-- TRIGGER 1 (BEFORE INSERT): Validar límite de perfiles permitidos según el Plan
CREATE OR REPLACE TRIGGER TR_VALIDAR_PERFILES
BEFORE INSERT ON PERFIL
FOR EACH ROW
DECLARE
    v_max_perfiles NUMBER;
    v_perfiles_actuales NUMBER;
BEGIN
    SELECT p.perfiles_permitidos INTO v_max_perfiles
    FROM CUENTA c
    JOIN PLAN p ON c.id_plan = p.id_plan
    WHERE c.id_cuenta = :NEW.id_cuenta;

    SELECT COUNT(*) INTO v_perfiles_actuales
    FROM PERFIL
    WHERE id_cuenta = :NEW.id_cuenta;

    IF v_perfiles_actuales >= v_max_perfiles THEN
        RAISE_APPLICATION_ERROR(-20004, 'Límite de perfiles superado para esta cuenta. Su plan actual solo permite un máximo de ' || v_max_perfiles || ' perfiles.');
    END IF;
END;
/

-- TRIGGER 2 (AFTER UPDATE): Registrar en auditoría cuando un usuario cambia de plan
CREATE OR REPLACE TRIGGER TR_AUDITAR_PLAN
AFTER UPDATE OF id_plan ON CUENTA
FOR EACH ROW
BEGIN
    INSERT INTO AUDITORIA_SISTEMA (tabla_afectada, operacion, detalle)
    VALUES ('CUENTA', 'UPDATE_PLAN', 'La cuenta ID ' || :NEW.id_cuenta || ' cambió del plan ' || :OLD.id_plan || ' al plan ' || :NEW.id_plan);
END;
/

-- TRIGGER 3 (AFTER INSERT): Actualizar la fecha de último pago en Cuenta
CREATE OR REPLACE TRIGGER TR_ACTUALIZAR_CUENTA_PAGO
AFTER INSERT ON PAGO
FOR EACH ROW
BEGIN
    IF :NEW.estado_pago = 'Aprobado' THEN
        UPDATE CUENTA
        SET fecha_ultimo_pago = :NEW.fecha_pago,
            estado_servicio = 'Activo'
        WHERE id_cuenta = :NEW.id_cuenta;
    END IF;
END;
/

-- TRIGGER 4 (AFTER DELETE): Registrar eventos de depuración masiva de reproducciones
CREATE OR REPLACE TRIGGER TR_LOG_SENTENCIA_REPRODUCCION
AFTER DELETE ON REPRODUCCION
BEGIN
    INSERT INTO AUDITORIA_SISTEMA (tabla_afectada, operacion, detalle)
    VALUES ('REPRODUCCION', 'DELETE_BULK', 'Se ejecutó una sentencia de eliminación masiva o limpieza estructural en la tabla de reproducciones.');
END;
/

-- =============================================================================
-- PROCEDIMIENTO AVANZADO: Reporte Estadístico de Consumo en Formato JSON
-- =============================================================================
CREATE OR REPLACE PROCEDURE SP_GET_REPORTE_CONSUMO_JSON(
    p_json_resultado OUT CLOB
) IS
    v_ciudad_plan_arr CLOB;
    v_dispositivos_arr CLOB;
    v_matriz_generos_arr CLOB;
BEGIN
    -- 1. CONSTRUCCIÓN DE "ciudadPlan" UTILIZANDO ROLLUP / CUBE
    SELECT JSON_ARRAYAGG(
               JSON_OBJECT(
                   'ciudad'        VALUE COALESCE(ciudad, 'TOTAL GLOBAL'),
                   'plan'          VALUE COALESCE(nombre_plan, 'TODOS LOS PLANES'),
                   'totalVistas'   VALUE total_vistas
               ) RETURNING CLOB
           )
    INTO v_ciudad_plan_arr
    FROM (
        SELECT u.ciudad_residencia AS ciudad, 
               pl.nombre_plan, 
               COUNT(r.id_reproduccion) AS total_vistas
        FROM REPRODUCCION r
        JOIN PERFIL p ON r.id_perfil = p.id_perfil
        JOIN CUENTA c ON p.id_cuenta = c.id_cuenta
        JOIN USUARIO u ON c.id_usuario = u.id_usuario
        JOIN PLAN pl ON c.id_plan = pl.id_plan
        GROUP BY ROLLUP(u.ciudad_residencia, pl.nombre_plan)
    );

    -- 2. CONSTRUCCIÓN DE "dispositivos" SIMULADO MEDIANTE UNPIVOT
    SELECT JSON_ARRAYAGG(
               JSON_OBJECT(
                   'tipoContenido'      VALUE tipo_contenido,
                   'dispositivo'        VALUE dispositivo,
                   'totalInteracciones' VALUE total_interacciones
               ) RETURNING CLOB
           )
    INTO v_dispositivos_arr
    FROM (
        WITH METRICAS_BASE AS (
            SELECT cont.tipo_contenido,
                   COUNT(CASE WHEN MOD(r.id_reproduccion, 2) = 0 THEN 1 END) AS clics_web,
                   COUNT(CASE WHEN MOD(r.id_reproduccion, 2) <> 0 THEN 1 END) AS clics_movil
            FROM REPRODUCCION r
            JOIN CONTENIDO cont ON r.id_contenido = cont.id_contenido
            GROUP BY cont.tipo_contenido
        )
        SELECT tipo_contenido, dispositivo, total_interacciones
        FROM METRICAS_BASE
        UNPIVOT (
            total_interacciones FOR dispositivo IN (
                clics_web AS 'Plataforma Web', 
                clics_movil AS 'Aplicación Móvil'
            )
        )
    );

    -- 3. CONSTRUCCIÓN DE "matrizGeneros" UTILIZANDO PIVOT (Géneros vs Perfiles)
    SELECT JSON_ARRAYAGG(
               JSON_OBJECT(
                   'idCategoria'    VALUE id_categoria,
                   'perfilAdulto'   VALUE perfil_adulto,
                   'perfilInfantil' VALUE perfil_infantil,
                   'perfilEmpleado' VALUE perfil_empleado
               ) RETURNING CLOB
           )
    INTO v_matriz_generos_arr
    FROM (
        SELECT id_categoria, perfil_adulto, perfil_infantil, perfil_empleado
        FROM (
            SELECT c.id_categoria, p.tipo_perfil, r.id_reproduccion
            FROM REPRODUCCION r
            JOIN PERFIL p ON r.id_perfil = p.id_perfil
            JOIN CONTENIDO c ON r.id_contenido = c.id_contenido
        )
        PIVOT (
            COUNT(id_reproduccion)
            FOR tipo_perfil IN (
                'Adulto' AS perfil_adulto, 
                'Infantil' AS perfil_infantil, 
                'Empleado' AS perfil_empleado
            )
        )
    );

    -- 4. ENSAMBLAJE FINAL DEL OBJETO JSON REQUERIDO POR EL FRONTEND
    p_json_resultado := JSON_OBJECT(
        'ciudadPlan'   VALUE JSON_QUERY(v_ciudad_plan_arr, '$'),
        'dispositivos' VALUE JSON_QUERY(v_dispositivos_arr, '$'),
        'matrizGeneros' VALUE JSON_QUERY(v_matriz_generos_arr, '$')
    );

END;
/