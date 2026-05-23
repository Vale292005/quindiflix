-- Insertar datos de ejemplo en la tabla USUARIO
INSERT INTO USUARIO (nombre_completo, correo_electronico, telefono, fecha_nacimiento, ciudad_residencia) 
VALUES ('Juan Fernando Hoyos', 'juan.hoyos@gmail.com', '3104567890', TO_DATE('1990-05-15', 'YYYY-MM-DD'), 'Armenia')
/

INSERT INTO USUARIO (nombre_completo, correo_electronico, telefono, fecha_nacimiento, ciudad_residencia) 
VALUES ('María Camila Restrepo', 'camila.res@outlook.com', '3127894561', TO_DATE('1995-08-22', 'YYYY-MM-DD'), 'Armenia')
/

INSERT INTO USUARIO (nombre_completo, correo_electronico, telefono, fecha_nacimiento, ciudad_residencia) 
VALUES ('Carlos Mario Betancur', 'carlos.mario@hotmail.com', '3153334455', TO_DATE('1988-12-01', 'YYYY-MM-DD'), 'Calarcá')
/

INSERT INTO USUARIO (nombre_completo, correo_electronico, telefono, fecha_nacimiento, ciudad_residencia) 
VALUES ('Diana Marcela Beltrán', 'diana.beltran@yahoo.com', '3209876543', TO_DATE('2000-03-10', 'YYYY-MM-DD'), 'Circasia')
/

INSERT INTO USUARIO (nombre_completo, correo_electronico, telefono, fecha_nacimiento, ciudad_residencia) 
VALUES ('Andrés Felipe Jaramillo', 'andres.felipe@gmail.com', '3006543210', TO_DATE('1993-07-19', 'YYYY-MM-DD'), 'Montenegro')
/

INSERT INTO USUARIO (nombre_completo, correo_electronico, telefono, fecha_nacimiento, ciudad_residencia) 
VALUES ('Sandra Milena Gómez', 'sandra.gomez@outlook.com', '3114445566', TO_DATE('1985-02-14', 'YYYY-MM-DD'), 'Quimbaya')
/

INSERT INTO USUARIO (nombre_completo, correo_electronico, telefono, fecha_nacimiento, ciudad_residencia) 
VALUES ('Jorge Iván Cardona', 'jorge.ivan@gmail.com', '3145556677', TO_DATE('1978-10-30', 'YYYY-MM-DD'), 'La Tebaida')
/

INSERT INTO USUARIO (nombre_completo, correo_electronico, telefono, fecha_nacimiento, ciudad_residencia) 
VALUES ('Valeria Aristizábal', 'valeria.aris@gmail.com', '3182223344', TO_DATE('2002-11-25', 'YYYY-MM-DD'), 'Salento')
/

INSERT INTO USUARIO (nombre_completo, correo_electronico, telefono, fecha_nacimiento, ciudad_residencia) 
VALUES ('Mateo Alejandro Osorio', 'mateo.osorio@hotmail.com', '3178889900', TO_DATE('1997-04-05', 'YYYY-MM-DD'), 'Pereira')
/

INSERT INTO USUARIO (nombre_completo, correo_electronico, telefono, fecha_nacimiento, ciudad_residencia) 
VALUES ('Estefanía Londoño', 'estefania.lon@outlook.com', '3167778899', TO_DATE('1994-09-12', 'YYYY-MM-DD'), 'Bogotá')
/

INSERT INTO USUARIO (nombre_completo, correo_electronico, telefono, fecha_nacimiento, ciudad_residencia) 
VALUES ('Liliana Patricia Duque', 'liliana.duque@gmail.com', '3156662211', TO_DATE('1987-06-25', 'YYYY-MM-DD'), 'Calarcá')
/

INSERT INTO USUARIO (nombre_completo, correo_electronico, telefono, fecha_nacimiento, ciudad_residencia) 
VALUES ('Mauricio Tobón', 'mauro.tobon@outlook.com', '3104448899', TO_DATE('1992-01-14', 'YYYY-MM-DD'), 'Armenia')
/

INSERT INTO USUARIO (nombre_completo, correo_electronico, telefono, fecha_nacimiento, ciudad_residencia) 
VALUES ('Camila Andrea Torres', 'camila.torres@hotmail.com', '3215554433', TO_DATE('1998-09-09', 'YYYY-MM-DD'), 'Montenegro')
/

INSERT INTO USUARIO (nombre_completo, correo_electronico, telefono, fecha_nacimiento, ciudad_residencia) 
VALUES ('Daniel Estiven Hurtado', 'daniel.hurt@gmail.com', '3123337788', TO_DATE('2001-07-04', 'YYYY-MM-DD'), 'Circasia')
/

INSERT INTO USUARIO (nombre_completo, correo_electronico, telefono, fecha_nacimiento, ciudad_residencia) 
VALUES ('Adriana María Morales', 'adri.morales@yahoo.com', '3172229900', TO_DATE('1983-11-20', 'YYYY-MM-DD'), 'La Tebaida')
/

INSERT INTO USUARIO (nombre_completo, correo_electronico, telefono, fecha_nacimiento, ciudad_residencia) 
VALUES ('Santiago Bedoya', 'santiago.b@gmail.com', '3148881122', TO_DATE('1996-03-30', 'YYYY-MM-DD'), 'Filandia')
/

INSERT INTO USUARIO (nombre_completo, correo_electronico, telefono, fecha_nacimiento, ciudad_residencia) 
VALUES ('Clara Inés Quintero', 'clara.quintero@outlook.com', '3117774455', TO_DATE('1975-08-14', 'YYYY-MM-DD'), 'Armenia')
/

INSERT INTO USUARIO (nombre_completo, correo_electronico, telefono, fecha_nacimiento, ciudad_residencia) 
VALUES ('Julian David Henao', 'julian.henao@gmail.com', '3186663344', TO_DATE('1991-12-05', 'YYYY-MM-DD'), 'Quimbaya')
/

INSERT INTO USUARIO (nombre_completo, correo_electronico, telefono, fecha_nacimiento, ciudad_residencia) 
VALUES ('Natalia Sofía Toro', 'natalia.toro@hotmail.com', '3002225566', TO_DATE('1999-02-27', 'YYYY-MM-DD'), 'Pijao')
/

INSERT INTO USUARIO (nombre_completo, correo_electronico, telefono, fecha_nacimiento, ciudad_residencia) 
VALUES ('Ricardo Antonio Marín', 'ricardo.marin@gmail.com', '3164440011', TO_DATE('1980-10-10', 'YYYY-MM-DD'), 'Génova')
/

-- Insertar datos de ejemplo en la tabla DEPARTAMENTO
INSERT INTO DEPARTAMENTO (nombre) VALUES ('Tecnología')
/

INSERT INTO DEPARTAMENTO (nombre) VALUES ('Contenido')
/

INSERT INTO DEPARTAMENTO (nombre) VALUES ('Marketing')
/

INSERT INTO DEPARTAMENTO (nombre) VALUES ('Soporte')
/

INSERT INTO DEPARTAMENTO (nombre) VALUES ('Finanzas')
/

-- Insertar datos de ejemplo en la tabla PLAN
INSERT INTO PLAN (nombre_plan, precio, calidad_video, cantidad_pantallas, perfiles_permitidos) 
VALUES ('Básico', 14900.00, 'SD', 1, 2)
/

INSERT INTO PLAN (nombre_plan, precio, calidad_video, cantidad_pantallas, perfiles_permitidos) 
VALUES ('Estándar', 24900.00, 'HD', 2, 4)
/

INSERT INTO PLAN (nombre_plan, precio, calidad_video, cantidad_pantallas, perfiles_permitidos) 
VALUES ('Premium', 34900.00, '4K', 4, 5)
/

-- Insertar datos de ejemplo en la tabla CATEGORIA
INSERT INTO CATEGORIA (nombre) VALUES ('Películas')
/

INSERT INTO CATEGORIA (nombre) VALUES ('Series')
/

INSERT INTO CATEGORIA (nombre) VALUES ('Documentales')
/

INSERT INTO CATEGORIA (nombre) VALUES ('Música')
/

INSERT INTO CATEGORIA (nombre) VALUES ('Podcasts')
/

-- Insertar datos de ejemplo en la tabla GENERO
INSERT INTO GENERO (nombre) VALUES ('Acción')
/

INSERT INTO GENERO (nombre) VALUES ('Comedia')
/

INSERT INTO GENERO (nombre) VALUES ('Drama')
/

INSERT INTO GENERO (nombre) VALUES ('Suspenso')
/

INSERT INTO GENERO (nombre) VALUES ('Romance')
/

INSERT INTO GENERO (nombre) VALUES ('Ciencia Ficción')
/

INSERT INTO GENERO (nombre) VALUES ('Terror')
/

INSERT INTO GENERO (nombre) VALUES ('Infantil')
/

-- Insertar datos de ejemplo en la tabla EMPLEADO
-- 1. Directores (Sin supervisor: id_supervisor = NULL)
INSERT INTO EMPLEADO (nombre_completo, correo, telefono, cargo, id_departamento, id_supervisor) 
VALUES ('Alejandro Gómez', 'alejandro.gomez@quindioflix.com', '3101112233', 'Director de Tecnología', 1, NULL)
/

INSERT INTO EMPLEADO (nombre_completo, correo, telefono, cargo, id_departamento, id_supervisor) 
VALUES ('Beatriz Elena Restrepo', 'beatriz.restrepo@quindioflix.com', '3122223344', 'Directora de Contenido', 2, NULL)
/

INSERT INTO EMPLEADO (nombre_completo, correo, telefono, cargo, id_departamento, id_supervisor) 
VALUES ('Carlos Mario Gutiérrez', 'carlos.gutierrez@quindioflix.com', '3153334455', 'Director de Marketing', 3, NULL)
/

-- 2. Equipo de Tecnología (Supervisados por Alejandro Gómez - id_empleado = 1)
INSERT INTO EMPLEADO (nombre_completo, correo, telefono, cargo, id_departamento, id_supervisor) 
VALUES ('David Fernando Plaza', 'david.plaza@quindioflix.com', '3204445566', 'Desarrollador Backend Senior', 1, 1)
/

INSERT INTO EMPLEADO (nombre_completo, correo, telefono, cargo, id_departamento, id_supervisor) 
VALUES ('Elena María Jaramillo', 'elena.jaramillo@quindioflix.com', '3005556677', 'Desarrolladora Frontend', 1, 1)
/

-- 3. Equipo de Contenido (Supervisados por Beatriz Restrepo - id_empleado = 2)
INSERT INTO EMPLEADO (nombre_completo, correo, telefono, cargo, id_departamento, id_supervisor) 
VALUES ('Fernando Castro', 'fernando.castro@quindioflix.com', '3116667788', 'Curador de Cine y Series', 2, 2)
/

INSERT INTO EMPLEADO (nombre_completo, correo, telefono, cargo, id_departamento, id_supervisor) 
VALUES ('Gloria Inés Valencia', 'gloria.valencia@quindioflix.com', '3147778899', 'Editora de Podcasts', 2, 2)
/

-- 4. Equipo de Marketing (Supervisados por Carlos Gutiérrez - id_empleado = 3)
INSERT INTO EMPLEADO (nombre_completo, correo, telefono, cargo, id_departamento, id_supervisor) 
VALUES ('Hugo Alberto Morales', 'hugo.morales@quindioflix.com', '3188889900', 'Analista de Social Media', 3, 3)
/

-- 5. Soporte y Finanzas (Para completar el organigrama y cubrir los departamentos 4 y 5)
INSERT INTO EMPLEADO (nombre_completo, correo, telefono, cargo, id_departamento, id_supervisor) 
VALUES ('Isabel Cristina Londoño', 'isabel.londono@quindioflix.com', '3179990011', 'Líder de Soporte al Cliente', 4, NULL)
/

INSERT INTO EMPLEADO (nombre_completo, correo, telefono, cargo, id_departamento, id_supervisor) 
VALUES ('Jorge Eliecer Alzate', 'jorge.alzate@quindioflix.com', '3160001122', 'Analista Financiero Senior', 5, NULL)
/

-- Insertar datos de ejemplo en la tabla CONTENIDO
-- CATEGORÍA 1: PELÍCULAS (id_categoria = 1)
INSERT INTO CONTENIDO (titulo, fecha_incorporacion, tipo_contenido, es_original, id_empleado, id_categoria) 
VALUES ('El Misterio del Jeepao', TO_DATE('2025-01-10', 'YYYY-MM-DD'), 'Película', 1, 2, 1)
/
INSERT INTO CONTENIDO (titulo, fecha_incorporacion, tipo_contenido, es_original, id_empleado, id_categoria) 
VALUES ('Atardecer en el Valle', TO_DATE('2025-01-15', 'YYYY-MM-DD'), 'Película', 0, 6, 1)
/
INSERT INTO CONTENIDO (titulo, fecha_incorporacion, tipo_contenido, es_original, id_empleado, id_categoria) 
VALUES ('Furia del Eje', TO_DATE('2025-02-20', 'YYYY-MM-DD'), 'Película', 0, 2, 1)
/
INSERT INTO CONTENIDO (titulo, fecha_incorporacion, tipo_contenido, es_original, id_empleado, id_categoria) 
VALUES ('Camino de Cafetales', TO_DATE('2025-03-05', 'YYYY-MM-DD'), 'Película', 1, 6, 1)
/
INSERT INTO CONTENIDO (titulo, fecha_incorporacion, tipo_contenido, es_original, id_empleado, id_categoria) 
VALUES ('Vuelo de Cóndor', TO_DATE('2025-03-12', 'YYYY-MM-DD'), 'Película', 0, 2, 1)
/
INSERT INTO CONTENIDO (titulo, fecha_incorporacion, tipo_contenido, es_original, id_empleado, id_categoria) 
VALUES ('Sombras de la Cordillera', TO_DATE('2025-04-01', 'YYYY-MM-DD'), 'Película', 1, 6, 1)
/
INSERT INTO CONTENIDO (titulo, fecha_incorporacion, tipo_contenido, es_original, id_empleado, id_categoria) 
VALUES ('La Cosecha del Destino', TO_DATE('2025-04-18', 'YYYY-MM-DD'), 'Película', 0, 2, 1)
/
INSERT INTO CONTENIDO (titulo, fecha_incorporacion, tipo_contenido, es_original, id_empleado, id_categoria) 
VALUES ('Oro Verde', TO_DATE('2025-05-02', 'YYYY-MM-DD'), 'Película', 1, 6, 1)
/

-- CATEGORÍA 2: SERIES (id_categoria = 2)
INSERT INTO CONTENIDO (titulo, fecha_incorporacion, tipo_contenido, es_original, id_empleado, id_categoria) 
VALUES ('Crónicas del Café', TO_DATE('2025-01-02', 'YYYY-MM-DD'), 'Serie', 1, 2, 2)
/
INSERT INTO CONTENIDO (titulo, fecha_incorporacion, tipo_contenido, es_original, id_empleado, id_categoria) 
VALUES ('Estación Salento', TO_DATE('2025-01-20', 'YYYY-MM-DD'), 'Serie', 1, 6, 2)
/
INSERT INTO CONTENIDO (titulo, fecha_incorporacion, tipo_contenido, es_original, id_empleado, id_categoria) 
VALUES ('Lazos de Sangre', TO_DATE('2025-02-15', 'YYYY-MM-DD'), 'Serie', 0, 7, 2)
/
INSERT INTO CONTENIDO (titulo, fecha_incorporacion, tipo_contenido, es_original, id_empleado, id_categoria) 
VALUES ('Niebla en el Páramo', TO_DATE('2025-03-01', 'YYYY-MM-DD'), 'Serie', 1, 2, 2)
/
INSERT INTO CONTENIDO (titulo, fecha_incorporacion, tipo_contenido, es_original, id_empleado, id_categoria) 
VALUES ('Aventuras de Antaño', TO_DATE('2025-03-22', 'YYYY-MM-DD'), 'Serie', 0, 6, 2)
/
INSERT INTO CONTENIDO (titulo, fecha_incorporacion, tipo_contenido, es_original, id_empleado, id_categoria) 
VALUES ('Código Secreto', TO_DATE('2025-04-10', 'YYYY-MM-DD'), 'Serie', 0, 4, 2)
/
INSERT INTO CONTENIDO (titulo, fecha_incorporacion, tipo_contenido, es_original, id_empleado, id_categoria) 
VALUES ('Guardianes del Quindío', TO_DATE('2025-04-25', 'YYYY-MM-DD'), 'Serie', 1, 7, 2)
/
INSERT INTO CONTENIDO (titulo, fecha_incorporacion, tipo_contenido, es_original, id_empleado, id_categoria) 
VALUES ('Destinos Cruzados', TO_DATE('2025-05-10', 'YYYY-MM-DD'), 'Serie', 0, 2, 2)
/

-- CATEGORÍA 3: DOCUMENTALES (id_categoria = 3)
INSERT INTO CONTENIDO (titulo, fecha_incorporacion, tipo_contenido, es_original, id_empleado, id_categoria) 
VALUES ('El Retorno de la Palma de Cera', TO_DATE('2025-01-05', 'YYYY-MM-DD'), 'Documental', 1, 6, 3)
/
INSERT INTO CONTENIDO (titulo, fecha_incorporacion, tipo_contenido, es_original, id_empleado, id_categoria) 
VALUES ('Secretos del Mariposa', TO_DATE('2025-01-28', 'YYYY-MM-DD'), 'Documental', 0, 7, 3)
/
INSERT INTO CONTENIDO (titulo, fecha_incorporacion, tipo_contenido, es_original, id_empleado, id_categoria) 
VALUES ('La Arquitectura de la Colonización', TO_DATE('2025-02-12', 'YYYY-MM-DD'), 'Documental', 1, 2, 3)
/
INSERT INTO CONTENIDO (titulo, fecha_incorporacion, tipo_contenido, es_original, id_empleado, id_categoria) 
VALUES ('Volcanes Durmientes', TO_DATE('2025-02-27', 'YYYY-MM-DD'), 'Documental', 0, 6, 3)
/
INSERT INTO CONTENIDO (titulo, fecha_incorporacion, tipo_contenido, es_original, id_empleado, id_categoria) 
VALUES ('Aves del Paraíso Cafetero', TO_DATE('2025-03-18', 'YYYY-MM-DD'), 'Documental', 1, 7, 3)
/
INSERT INTO CONTENIDO (titulo, fecha_incorporacion, tipo_contenido, es_original, id_empleado, id_categoria) 
VALUES ('Ríos de Responsabilidad', TO_DATE('2025-04-05', 'YYYY-MM-DD'), 'Documental', 0, 2, 3)
/
INSERT INTO CONTENIDO (titulo, fecha_incorporacion, tipo_contenido, es_original, id_empleado, id_categoria) 
VALUES ('Historia de un Pueblo Libre', TO_DATE('2025-04-20', 'YYYY-MM-DD'), 'Documental', 1, 6, 3)
/
INSERT INTO CONTENIDO (titulo, fecha_incorporacion, tipo_contenido, es_original, id_empleado, id_categoria) 
VALUES ('El Barranquero Errante', TO_DATE('2025-05-01', 'YYYY-MM-DD'), 'Documental', 0, 7, 3)
/

-- CATEGORÍA 4: MÚSICA (id_categoria = 4)
INSERT INTO CONTENIDO (titulo, fecha_incorporacion, tipo_contenido, es_original, id_empleado, id_categoria) 
VALUES ('Acordes de mi Tierra', TO_DATE('2025-01-11', 'YYYY-MM-DD'), 'Música', 1, 7, 4)
/
INSERT INTO CONTENIDO (titulo, fecha_incorporacion, tipo_contenido, es_original, id_empleado, id_categoria) 
VALUES ('Concierto En El Parque', TO_DATE('2025-02-01', 'YYYY-MM-DD'), 'Música', 0, 2, 4)
/
INSERT INTO CONTENIDO (titulo, fecha_incorporacion, tipo_contenido, es_original, id_empleado, id_categoria) 
VALUES ('Sinfonía del Café', TO_DATE('2025-02-22', 'YYYY-MM-DD'), 'Música', 1, 6, 4)
/
INSERT INTO CONTENIDO (titulo, fecha_incorporacion, tipo_contenido, es_original, id_empleado, id_categoria) 
VALUES ('Ritmos de la Selva', TO_DATE('2025-03-10', 'YYYY-MM-DD'), 'Música', 0, 7, 4)
/
INSERT INTO CONTENIDO (titulo, fecha_incorporacion, tipo_contenido, es_original, id_empleado, id_categoria) 
VALUES ('Parranda y Tradición', TO_DATE('2025-03-29', 'YYYY-MM-DD'), 'Música', 0, 2, 4)
/
INSERT INTO CONTENIDO (titulo, fecha_incorporacion, tipo_contenido, es_original, id_empleado, id_categoria) 
VALUES ('Guitarras del Recuerdo', TO_DATE('2025-04-14', 'YYYY-MM-DD'), 'Música', 1, 6, 4)
/
INSERT INTO CONTENIDO (titulo, fecha_incorporacion, tipo_contenido, es_original, id_empleado, id_categoria) 
VALUES ('Jazz en el Convento', TO_DATE('2025-04-29', 'YYYY-MM-DD'), 'Música', 0, 7, 4)
/
INSERT INTO CONTENIDO (titulo, fecha_incorporacion, tipo_contenido, es_original, id_empleado, id_categoria) 
VALUES ('Sonidos Ancestrales', TO_DATE('2025-05-12', 'YYYY-MM-DD'), 'Música', 1, 2, 4)
/

-- CATEGORÍA 5: PODCASTS (id_categoria = 5)
INSERT INTO CONTENIDO (titulo, fecha_incorporacion, tipo_contenido, es_original, id_empleado, id_categoria) 
VALUES ('Emprender en el Quindío', TO_DATE('2025-01-08', 'YYYY-MM-DD'), 'Podcast', 1, 7, 5)
/
INSERT INTO CONTENIDO (titulo, fecha_incorporacion, tipo_contenido, es_original, id_empleado, id_categoria) 
VALUES ('Historias de Camino', TO_DATE('2025-01-25', 'YYYY-MM-DD'), 'Podcast', 0, 2, 5)
/
INSERT INTO CONTENIDO (titulo, fecha_incorporacion, tipo_contenido, es_original, id_empleado, id_categoria) 
VALUES ('Tecnología para la Vida', TO_DATE('2025-02-14', 'YYYY-MM-DD'), 'Podcast', 1, 4, 5)
/
INSERT INTO CONTENIDO (titulo, fecha_incorporacion, tipo_contenido, es_original, id_empleado, id_categoria) 
VALUES ('Tertulias con Aroma', TO_DATE('2025-03-04', 'YYYY-MM-DD'), 'Podcast', 1, 7, 5)
/
INSERT INTO CONTENIDO (titulo, fecha_incorporacion, tipo_contenido, es_original, id_empleado, id_categoria) 
VALUES ('Mentes Conectadas', TO_DATE('2025-03-20', 'YYYY-MM-DD'), 'Podcast', 0, 5, 5)
/
INSERT INTO CONTENIDO (titulo, fecha_incorporacion, tipo_contenido, es_original, id_empleado, id_categoria) 
VALUES ('El Arte de la Cocina', TO_DATE('2025-04-08', 'YYYY-MM-DD'), 'Podcast', 0, 7, 5)
/
INSERT INTO CONTENIDO (titulo, fecha_incorporacion, tipo_contenido, es_original, id_empleado, id_categoria) 
VALUES ('Finanzas sin Enredos', TO_DATE('2025-04-22', 'YYYY-MM-DD'), 'Podcast', 1, 10, 5)
/
INSERT INTO CONTENIDO (titulo, fecha_incorporacion, tipo_contenido, es_original, id_empleado, id_categoria) 
VALUES ('Quindío Global', TO_DATE('2025-05-05', 'YYYY-MM-DD'), 'Podcast', 1, 7, 5)
/

--insertar datos de ejemplo en la tabla CUENTA
-- Cuenta para Usuario 1 (Juan Fernando Hoyos) -> Plan Premium
INSERT INTO CUENTA (estado_servicio, fecha_ultimo_pago, id_usuario, id_plan) 
VALUES ('Activo', TO_DATE('2026-05-01', 'YYYY-MM-DD'), 1, 3)
/

-- Cuenta para Usuario 2 (María Camila Restrepo) -> Plan Estándar
INSERT INTO CUENTA (estado_servicio, fecha_ultimo_pago, id_usuario, id_plan) 
VALUES ('Activo', TO_DATE('2026-04-28', 'YYYY-MM-DD'), 2, 2)
/

-- Cuenta para Usuario 3 (Carlos Mario Betancur) -> Plan Premium
INSERT INTO CUENTA (estado_servicio, fecha_ultimo_pago, id_usuario, id_plan) 
VALUES ('Activo', TO_DATE('2026-05-10', 'YYYY-MM-DD'), 3, 3)
/

-- Cuenta para Usuario 4 (Diana Marcela Beltrán) -> Plan Básico
INSERT INTO CUENTA (estado_servicio, fecha_ultimo_pago, id_usuario, id_plan) 
VALUES ('Suspendido', TO_DATE('2026-03-15', 'YYYY-MM-DD'), 4, 1)
/

-- Cuenta para Usuario 5 (Andrés Felipe Jaramillo) -> Plan Estándar
INSERT INTO CUENTA (estado_servicio, fecha_ultimo_pago, id_usuario, id_plan) 
VALUES ('Activo', TO_DATE('2026-05-05', 'YYYY-MM-DD'), 5, 2)
/

-- Cuenta para Usuario 6 (Sandra Milena Gómez) -> Plan Premium
INSERT INTO CUENTA (estado_servicio, fecha_ultimo_pago, id_usuario, id_plan) 
VALUES ('Activo', TO_DATE('2026-05-12', 'YYYY-MM-DD'), 6, 3)
/

-- Cuenta para Usuario 7 (Jorge Iván Cardona) -> Plan Básico
INSERT INTO CUENTA (estado_servicio, fecha_ultimo_pago, id_usuario, id_plan) 
VALUES ('Cancelado', TO_DATE('2026-02-20', 'YYYY-MM-DD'), 7, 1)
/

-- Cuenta para Usuario 8 (Valeria Aristizábal) -> Plan Estándar
INSERT INTO CUENTA (estado_servicio, fecha_ultimo_pago, id_usuario, id_plan) 
VALUES ('Activo', TO_DATE('2026-04-30', 'YYYY-MM-DD'), 8, 2)
/

-- Cuenta para Usuario 9 (Mateo Alejandro Osorio) -> Plan Premium
INSERT INTO CUENTA (estado_servicio, fecha_ultimo_pago, id_usuario, id_plan) 
VALUES ('Activo', TO_DATE('2026-05-18', 'YYYY-MM-DD'), 9, 3)
/

-- Cuenta para Usuario 10 (Estefanía Londoño) -> Plan Estándar
INSERT INTO CUENTA (estado_servicio, fecha_ultimo_pago, id_usuario, id_plan) 
VALUES ('Activo', TO_DATE('2026-05-02', 'YYYY-MM-DD'), 10, 2)
/
INSERT INTO CUENTA (estado_servicio, fecha_ultimo_pago, id_usuario, id_plan) VALUES ('Activo', SYSDATE, 11, 2)
/
INSERT INTO CUENTA (estado_servicio, fecha_ultimo_pago, id_usuario, id_plan) VALUES ('Activo', SYSDATE, 12, 3)
/
INSERT INTO CUENTA (estado_servicio, fecha_ultimo_pago, id_usuario, id_plan) VALUES ('Activo', SYSDATE, 13, 1)
/
INSERT INTO CUENTA (estado_servicio, fecha_ultimo_pago, id_usuario, id_plan) VALUES ('Activo', SYSDATE, 14, 2)
/
INSERT INTO CUENTA (estado_servicio, fecha_ultimo_pago, id_usuario, id_plan) VALUES ('Suspendido', SYSDATE-40, 15, 1)
/
INSERT INTO CUENTA (estado_servicio, fecha_ultimo_pago, id_usuario, id_plan) VALUES ('Activo', SYSDATE, 16, 3)
/
INSERT INTO CUENTA (estado_servicio, fecha_ultimo_pago, id_usuario, id_plan) VALUES ('Activo', SYSDATE, 17, 2)
/
INSERT INTO CUENTA (estado_servicio, fecha_ultimo_pago, id_usuario, id_plan) VALUES ('Activo', SYSDATE, 18, 3)
/
INSERT INTO CUENTA (estado_servicio, fecha_ultimo_pago, id_usuario, id_plan) VALUES ('Activo', SYSDATE, 19, 1)
/
INSERT INTO CUENTA (estado_servicio, fecha_ultimo_pago, id_usuario, id_plan) VALUES ('Activo', SYSDATE, 20, 3)
/

-- Insertar datos de ejemplo en la tabla REFERIDO
-- 1. Juan Fernando (1) refirió a María Camila (2)
INSERT INTO REFERIDO (id_usuario_referidor, id_usuario_referido, fecha_referido, activo) 
VALUES (1, 2, TO_DATE('2026-01-15', 'YYYY-MM-DD'), 1)
/

-- 2. Carlos Mario (3) refirió a Diana Marcela (4)
INSERT INTO REFERIDO (id_usuario_referidor, id_usuario_referido, fecha_referido, activo) 
VALUES (3, 4, TO_DATE('2026-02-10', 'YYYY-MM-DD'), 1)
/

-- 3. Andrés Felipe (5) refirió a Sandra Milena (6)
INSERT INTO REFERIDO (id_usuario_referidor, id_usuario_referido, fecha_referido, activo) 
VALUES (5, 6, TO_DATE('2026-02-28', 'YYYY-MM-DD'), 1)
/

-- 4. Mateo Alejandro (9) refirió a Estefanía Londoño (10)
INSERT INTO REFERIDO (id_usuario_referidor, id_usuario_referido, fecha_referido, activo) 
VALUES (9, 10, TO_DATE('2026-03-05', 'YYYY-MM-DD'), 1)
/

-- 5. Juan Fernando (1) también refirió a Jorge Iván (7) (pero este ya canceló la cuenta, lo ponemos inactivo)
INSERT INTO REFERIDO (id_usuario_referidor, id_usuario_referido, fecha_referido, activo) 
VALUES (1, 7, TO_DATE('2026-03-20', 'YYYY-MM-DD'), 0)
/

-- Insertar datos de ejemplo en la tabla TEMPORADA
-- Temporadas para la Serie: "Crónicas del Café" (id_contenido = 9)
INSERT INTO TEMPORADA (numero_temporada, titulo, id_contenido) VALUES (1, 'El Origen del Grano', 9)
/
INSERT INTO TEMPORADA (numero_temporada, titulo, id_contenido) VALUES (2, 'La Época de la Bonanza', 9)
/

-- Temporadas para la Serie: "Estación Salento" (id_contenido = 10)
INSERT INTO TEMPORADA (numero_temporada, titulo, id_contenido) VALUES (1, 'Bienvenidos al Pueblo', 10)
/
INSERT INTO TEMPORADA (numero_temporada, titulo, id_contenido) VALUES (2, 'Misterio en el Valle de Cocora', 10)
/

-- Temporadas para la Serie: "Lazos de Sangre" (id_contenido = 11)
INSERT INTO TEMPORADA (numero_temporada, titulo, id_contenido) VALUES (1, 'Secretos Familiares', 11)
/

-- Temporadas para la Serie: "Niebla en el Páramo" (id_contenido = 12)
INSERT INTO TEMPORADA (numero_temporada, titulo, id_contenido) VALUES (1, 'Desaparición en el Frío', 12)
/

-- Temporadas para la Serie: "Guardianes del Quindío" (id_contenido = 15)
INSERT INTO TEMPORADA (numero_temporada, titulo, id_contenido) VALUES (1, 'Defensores de la Tierra', 15)
/

-- Temporadas para el Podcast: "Emprender en el Quindío" (id_contenido = 33)
INSERT INTO TEMPORADA (numero_temporada, titulo, id_contenido) VALUES (1, 'Primeros Pasos y Modelos de Negocio', 33)
/
INSERT INTO TEMPORADA (numero_temporada, titulo, id_contenido) VALUES (2, 'Casos de Éxito de la Región', 33)
/

-- Temporadas para el Podcast: "Historias de Camino" (id_contenido = 34)
INSERT INTO TEMPORADA (numero_temporada, titulo, id_contenido) VALUES (1, 'Mitos y Leyendas del Eje', 34)
/

-- Temporadas para el Podcast: "Tecnología para la Vida" (id_contenido = 35)
INSERT INTO TEMPORADA (numero_temporada, titulo, id_contenido) VALUES (1, 'Inteligencia Artificial Básica', 35)
/
INSERT INTO TEMPORADA (numero_temporada, titulo, id_contenido) VALUES (2, 'Ciberseguridad en Casa', 35)
/

-- Temporadas para el Podcast: "Tertulias con Aroma" (id_contenido = 36)
INSERT INTO TEMPORADA (numero_temporada, titulo, id_contenido) VALUES (1, 'Café y Literatura', 36)
/

-- Temporadas para el Podcast: "Mentes Conectadas" (id_contenido = 37)
INSERT INTO TEMPORADA (numero_temporada, titulo, id_contenido) VALUES (1, 'Salud Mental en la Era Digital', 37)
/

-- Temporadas para el Podcast: "Finanzas sin Enredos" (id_contenido = 39)
INSERT INTO TEMPORADA (numero_temporada, titulo, id_contenido) VALUES (1, 'Ahorro e Inversión para Jóvenes', 39)
/

--insertar datos de ejemplo en la tabla PERFIL
-- Cuenta 1 (Premium): 4 perfiles
INSERT INTO PERFIL (nombre, avatar, tipo_perfil, id_cuenta) VALUES ('Juan Hoyos', 'avatar_juan.png', 'Adulto', 1) /
INSERT INTO PERFIL (nombre, avatar, tipo_perfil, id_cuenta) VALUES ('Esposa Juan', 'avatar_mujer1.png', 'Adulto', 1) /
INSERT INTO PERFIL (nombre, avatar, tipo_perfil, id_cuenta) VALUES ('Juanito', 'avatar_nino1.png', 'Infantil', 1) /
INSERT INTO PERFIL (nombre, avatar, tipo_perfil, id_cuenta) VALUES ('Invitado', 'avatar_gris.png', 'Adulto', 1) /

-- Cuenta 2 (Estándar): 2 perfiles
INSERT INTO PERFIL (nombre, avatar, tipo_perfil, id_cuenta) VALUES ('Camila Restrepo', 'avatar_camila.png', 'Adulto', 2) /
INSERT INTO PERFIL (nombre, avatar, tipo_perfil, id_cuenta) VALUES ('Camilita', 'avatar_nina1.png', 'Infantil', 2) /

-- Cuenta 3 (Premium): 5 perfiles
INSERT INTO PERFIL (nombre, avatar, tipo_perfil, id_cuenta) VALUES ('Carlos Betancur', 'avatar_carlos.png', 'Adulto', 3) /
INSERT INTO PERFIL (nombre, avatar, tipo_perfil, id_cuenta) VALUES ('Mafe', 'avatar_mujer2.png', 'Adulto', 3) /
INSERT INTO PERFIL (nombre, avatar, tipo_perfil, id_cuenta) VALUES ('Andresito', 'avatar_nino2.png', 'Infantil', 3) /
INSERT INTO PERFIL (nombre, avatar, tipo_perfil, id_cuenta) VALUES ('Abuela', 'avatar_abuela.png', 'Adulto', 3) /
INSERT INTO PERFIL (nombre, avatar, tipo_perfil, id_cuenta) VALUES ('Soporte QA', 'avatar_tech.png', 'Empleado', 3) /

-- Cuenta 4 (Básico): 1 perfil
INSERT INTO PERFIL (nombre, avatar, tipo_perfil, id_cuenta) VALUES ('Diana Beltrán', 'avatar_diana.png', 'Adulto', 4) /

-- Cuenta 5 (Estándar): 2 perfiles
INSERT INTO PERFIL (nombre, avatar, tipo_perfil, id_cuenta) VALUES ('Andrés Jaramillo', 'avatar_andres.png', 'Adulto', 5) /
INSERT INTO PERFIL (nombre, avatar, tipo_perfil, id_cuenta) VALUES ('Felipe', 'avatar_hombre1.png', 'Adulto', 5) /

-- Cuenta 6 (Premium): 4 perfiles
INSERT INTO PERFIL (nombre, avatar, tipo_perfil, id_cuenta) VALUES ('Sandra Gómez', 'avatar_sandra.png', 'Adulto', 6) /
INSERT INTO PERFIL (nombre, avatar, tipo_perfil, id_cuenta) VALUES ('Hijo Mayor', 'avatar_joven.png', 'Adulto', 6) /
INSERT INTO PERFIL (nombre, avatar, tipo_perfil, id_cuenta) VALUES ('Hija Menor', 'avatar_nina2.png', 'Infantil', 6) /
INSERT INTO PERFIL (nombre, avatar, tipo_perfil, id_cuenta) VALUES ('Prueba Empleado', 'avatar_emp1.png', 'Empleado', 6) /

-- Cuenta 7 (Básico): 1 perfil
INSERT INTO PERFIL (nombre, avatar, tipo_perfil, id_cuenta) VALUES ('Jorge Cardona', 'avatar_jorge.png', 'Adulto', 7) /

-- Cuenta 8 (Estándar): 2 perfiles
INSERT INTO PERFIL (nombre, avatar, tipo_perfil, id_cuenta) VALUES ('Valeria A.', 'avatar_valeria.png', 'Adulto', 8) /
INSERT INTO PERFIL (nombre, avatar, tipo_perfil, id_cuenta) VALUES ('Lucas', 'avatar_perro.png', 'Infantil', 8) /

-- Cuenta 9 (Premium): 4 perfiles
INSERT INTO PERFIL (nombre, avatar, tipo_perfil, id_cuenta) VALUES ('Mateo Osorio', 'avatar_mateo.png', 'Adulto', 9) /
INSERT INTO PERFIL (nombre, avatar, tipo_perfil, id_cuenta) VALUES ('Santi', 'avatar_nino3.png', 'Infantil', 9) /
INSERT INTO PERFIL (nombre, avatar, tipo_perfil, id_cuenta) VALUES ('Sofia', 'avatar_mujer3.png', 'Adulto', 9) /
INSERT INTO PERFIL (nombre, avatar, tipo_perfil, id_cuenta) VALUES ('Admin Contenido', 'avatar_emp2.png', 'Empleado', 9) /

-- Cuenta 10 (Estándar): 2 perfiles
INSERT INTO PERFIL (nombre, avatar, tipo_perfil, id_cuenta) VALUES ('Estefanía L.', 'avatar_estef.png', 'Adulto', 10) /
INSERT INTO PERFIL (nombre, avatar, tipo_perfil, id_cuenta) VALUES ('Estefanita', 'avatar_nina3.png', 'Infantil', 10) /

-- Cuenta 11 (Estándar): 2 perfiles
INSERT INTO PERFIL (nombre, avatar, tipo_perfil, id_cuenta) VALUES ('Liliana Duque', 'avatar_lili.png', 'Adulto', 11) /
INSERT INTO PERFIL (nombre, avatar, tipo_perfil, id_cuenta) VALUES ('Santi Duque', 'avatar_nino4.png', 'Infantil', 11) /

-- Cuenta 12 (Premium): 5 perfiles
INSERT INTO PERFIL (nombre, avatar, tipo_perfil, id_cuenta) VALUES ('Mauricio Tobón', 'avatar_mauro.png', 'Adulto', 12) /
INSERT INTO PERFIL (nombre, avatar, tipo_perfil, id_cuenta) VALUES ('Clara Tobón', 'avatar_mujer4.png', 'Adulto', 12) /
INSERT INTO PERFIL (nombre, avatar, tipo_perfil, id_cuenta) VALUES ('Mauro Hijo', 'avatar_nino5.png', 'Infantil', 12) /
INSERT INTO PERFIL (nombre, avatar, tipo_perfil, id_cuenta) VALUES ('Sobrino', 'avatar_joven2.png', 'Adulto', 12) /
INSERT INTO PERFIL (nombre, avatar, tipo_perfil, id_cuenta) VALUES ('Soporte Dev', 'avatar_code.png', 'Empleado', 12) /

-- Cuenta 13 (Básico): 1 perfil
INSERT INTO PERFIL (nombre, avatar, tipo_perfil, id_cuenta) VALUES ('Camila Torres', 'avatar_ctorres.png', 'Adulto', 13) /

-- Cuenta 14 (Estándar): 2 perfiles
INSERT INTO PERFIL (nombre, avatar, tipo_perfil, id_cuenta) VALUES ('Daniel Hurtado', 'avatar_daniel.png', 'Adulto', 14) /
INSERT INTO PERFIL (nombre, avatar, tipo_perfil, id_cuenta) VALUES ('Dani Junior', 'avatar_nino6.png', 'Infantil', 14) /

-- Cuenta 15 (Básico): 1 perfil
INSERT INTO PERFIL (nombre, avatar, tipo_perfil, id_cuenta) VALUES ('Adriana Morales', 'avatar_adriana.png', 'Adulto', 15) /

-- Cuenta 16 (Premium): 4 perfiles
INSERT INTO PERFIL (nombre, avatar, tipo_perfil, id_cuenta) VALUES ('Santiago B.', 'avatar_santi.png', 'Adulto', 16) /
INSERT INTO PERFIL (nombre, avatar, tipo_perfil, id_cuenta) VALUES ('Paola', 'avatar_mujer5.png', 'Adulto', 16) /
INSERT INTO PERFIL (nombre, avatar, tipo_perfil, id_cuenta) VALUES ('Pablito', 'avatar_nino7.png', 'Infantil', 16) /
INSERT INTO PERFIL (nombre, avatar, tipo_perfil, id_cuenta) VALUES ('Moderador 1', 'avatar_mod.png', 'Empleado', 16) /

-- Cuenta 17 (Estándar): 2 perfiles
INSERT INTO PERFIL (nombre, avatar, tipo_perfil, id_cuenta) VALUES ('Clara Quintero', 'avatar_clara.png', 'Adulto', 17) /
INSERT INTO PERFIL (nombre, avatar, tipo_perfil, id_cuenta) VALUES ('Clarita', 'avatar_nina4.png', 'Infantil', 17) /

-- Cuenta 18 (Premium): 4 perfiles
INSERT INTO PERFIL (nombre, avatar, tipo_perfil, id_cuenta) VALUES ('Julian Henao', 'avatar_julian.png', 'Adulto', 18) /
INSERT INTO PERFIL (nombre, avatar, tipo_perfil, id_cuenta) VALUES ('Mariana', 'avatar_mujer6.png', 'Adulto', 18) /
INSERT INTO PERFIL (nombre, avatar, tipo_perfil, id_cuenta) VALUES ('Tomas', 'avatar_nino8.png', 'Infantil', 18) /
INSERT INTO PERFIL (nombre, avatar, tipo_perfil, id_cuenta) VALUES ('Tester 2', 'avatar_test2.png', 'Empleado', 18) /

-- Cuenta 19 (Básico): 1 perfil
INSERT INTO PERFIL (nombre, avatar, tipo_perfil, id_cuenta) VALUES ('Natalia Toro', 'avatar_natalia.png', 'Adulto', 19) /

-- Cuenta 20 (Premium): 3 perfiles
INSERT INTO PERFIL (nombre, avatar, tipo_perfil, id_cuenta) VALUES ('Ricardo Marín', 'avatar_ricardo.png', 'Adulto', 20) /
INSERT INTO PERFIL (nombre, avatar, tipo_perfil, id_cuenta) VALUES ('Raimundo', 'avatar_hombre2.png', 'Adulto', 20) /
INSERT INTO PERFIL (nombre, avatar, tipo_perfil, id_cuenta) VALUES ('Richi', 'avatar_nino9.png', 'Infantil', 20) /

-- Insertar datos de ejemplo en la tabla PAGO
-- Pagos de Cuentas Premium ($34,900.00)
INSERT INTO PAGO (fecha_pago, monto, metodo_pago, estado_pago, id_cuenta) 
VALUES (TO_DATE('2026-04-01', 'YYYY-MM-DD'), 34900.00, 'Tarjeta de Crédito', 'Exitoso', 1) /
INSERT INTO PAGO (fecha_pago, monto, metodo_pago, estado_pago, id_cuenta) 
VALUES (TO_DATE('2026-05-01', 'YYYY-MM-DD'), 34900.00, 'Tarjeta de Crédito', 'Exitoso', 1) /

INSERT INTO PAGO (fecha_pago, monto, metodo_pago, estado_pago, id_cuenta) 
VALUES (TO_DATE('2026-05-10', 'YYYY-MM-DD'), 34900.00, 'PSE', 'Exitoso', 3) /

INSERT INTO PAGO (fecha_pago, monto, metodo_pago, estado_pago, id_cuenta) 
VALUES (TO_DATE('2026-04-12', 'YYYY-MM-DD'), 34900.00, 'PayPal', 'Exitoso', 6) /
INSERT INTO PAGO (fecha_pago, monto, metodo_pago, estado_pago, id_cuenta) 
VALUES (TO_DATE('2026-05-12', 'YYYY-MM-DD'), 34900.00, 'PayPal', 'Exitoso', 6) /

INSERT INTO PAGO (fecha_pago, monto, metodo_pago, estado_pago, id_cuenta) 
VALUES (TO_DATE('2026-05-18', 'YYYY-MM-DD'), 34900.00, 'PSE', 'Exitoso', 9) /

INSERT INTO PAGO (fecha_pago, monto, metodo_pago, estado_pago, id_cuenta) 
VALUES (TO_DATE('2026-05-01', 'YYYY-MM-DD'), 34900.00, 'Tarjeta de Crédito', 'Exitoso', 12) /

INSERT INTO PAGO (fecha_pago, monto, metodo_pago, estado_pago, id_cuenta) 
VALUES (TO_DATE('2026-05-01', 'YYYY-MM-DD'), 34900.00, 'PSE', 'Exitoso', 16) /

INSERT INTO PAGO (fecha_pago, monto, metodo_pago, estado_pago, id_cuenta) 
VALUES (TO_DATE('2026-05-18', 'YYYY-MM-DD'), 34900.00, 'Tarjeta de Crédito', 'Exitoso', 18) /

INSERT INTO PAGO (fecha_pago, monto, metodo_pago, estado_pago, id_cuenta) 
VALUES (TO_DATE('2026-05-02', 'YYYY-MM-DD'), 34900.00, 'PSE', 'Exitoso', 20) /

-- Pagos de Cuentas Estándar ($24,900.00)
INSERT INTO PAGO (fecha_pago, monto, metodo_pago, estado_pago, id_cuenta) 
VALUES (TO_DATE('2026-04-28', 'YYYY-MM-DD'), 24900.00, 'PSE', 'Exitoso', 2) /

INSERT INTO PAGO (fecha_pago, monto, metodo_pago, estado_pago, id_cuenta) 
VALUES (TO_DATE('2026-05-05', 'YYYY-MM-DD'), 24900.00, 'Tarjeta de Crédito', 'Exitoso', 5) /

INSERT INTO PAGO (fecha_pago, monto, metodo_pago, estado_pago, id_cuenta) 
VALUES (TO_DATE('2026-04-30', 'YYYY-MM-DD'), 24900.00, 'Efecty', 'Exitoso', 8) /

INSERT INTO PAGO (fecha_pago, monto, metodo_pago, estado_pago, id_cuenta) 
VALUES (TO_DATE('2026-05-02', 'YYYY-MM-DD'), 24900.00, 'Tarjeta de Crédito', 'Exitoso', 10) /

INSERT INTO PAGO (fecha_pago, monto, metodo_pago, estado_pago, id_cuenta) 
VALUES (TO_DATE('2026-05-01', 'YYYY-MM-DD'), 24900.00, 'PSE', 'Exitoso', 11) /

INSERT INTO PAGO (fecha_pago, monto, metodo_pago, estado_pago, id_cuenta) 
VALUES (TO_DATE('2026-05-01', 'YYYY-MM-DD'), 24900.00, 'Tarjeta de Crédito', 'Exitoso', 14) /

INSERT INTO PAGO (fecha_pago, monto, metodo_pago, estado_pago, id_cuenta) 
VALUES (TO_DATE('2026-05-01', 'YYYY-MM-DD'), 24900.00, 'PSE', 'Exitoso', 17) /

-- Pagos de Cuentas Básicas ($14,900.00)
INSERT INTO PAGO (fecha_pago, monto, metodo_pago, estado_pago, id_cuenta) 
VALUES (TO_DATE('2026-05-01', 'YYYY-MM-DD'), 14900.00, 'Efecty', 'Exitoso', 13) /

INSERT INTO PAGO (fecha_pago, monto, metodo_pago, estado_pago, id_cuenta) 
VALUES (TO_DATE('2026-05-01', 'YYYY-MM-DD'), 14900.00, 'PSE', 'Exitoso', 19) /

-- Casos Especiales (Pagos Fallidos, Pendientes o Cuentas Suspendidas/Canceladas)
-- Cuenta 4 (Suspendida): Tuvo un pago exitoso antiguo y el último falló
INSERT INTO PAGO (fecha_pago, monto, metodo_pago, estado_pago, id_cuenta) 
VALUES (TO_DATE('2026-02-15', 'YYYY-MM-DD'), 14900.00, 'Tarjeta de Crédito', 'Exitoso', 4) /
INSERT INTO PAGO (fecha_pago, monto, metodo_pago, estado_pago, id_cuenta) 
VALUES (TO_DATE('2026-03-15', 'YYYY-MM-DD'), 14900.00, 'Tarjeta de Crédito', 'Fallido', 4) /

-- Cuenta 7 (Cancelada): El usuario intentó pagar pero el pago falló y decidió cancelar
INSERT INTO PAGO (fecha_pago, monto, metodo_pago, estado_pago, id_cuenta) 
VALUES (TO_DATE('2026-02-20', 'YYYY-MM-DD'), 14900.00, 'PSE', 'Fallido', 7) /

-- Cuenta 15 (Suspendida): Pago vencido/fallido
INSERT INTO PAGO (fecha_pago, monto, metodo_pago, estado_pago, id_cuenta) 
VALUES (TO_DATE('2026-04-10', 'YYYY-MM-DD'), 14900.00, 'Efecty', 'Fallido', 15) /

-- Un par de pagos que actualmente están en procesamiento (Pendientes)
INSERT INTO PAGO (fecha_pago, monto, metodo_pago, estado_pago, id_cuenta) 
VALUES (SYSDATE, 24900.00, 'PSE', 'Pendiente', 11) /
INSERT INTO PAGO (fecha_pago, monto, metodo_pago, estado_pago, id_cuenta) 
VALUES (SYSDATE, 34900.00, 'Tarjeta de Crédito', 'Pendiente', 12) /

--insertar datos de ejemplo en la tabla CONTENIDO_GENERO
-- Contenido 1 (El Misterio del Jeepao): Acción (1) y Suspenso (4)
INSERT INTO CONTENIDO_GENERO (id_contenido, id_genero) VALUES (1, 1) /
INSERT INTO CONTENIDO_GENERO (id_contenido, id_genero) VALUES (1, 4) /

-- Contenido 2 (Atardecer en el Valle): Drama (3) y Romance (5)
INSERT INTO CONTENIDO_GENERO (id_contenido, id_genero) VALUES (2, 3) /
INSERT INTO CONTENIDO_GENERO (id_contenido, id_genero) VALUES (2, 5) /

-- Contenido 3 (Furia del Eje): Acción (1) y Suspenso (4)
INSERT INTO CONTENIDO_GENERO (id_contenido, id_genero) VALUES (3, 1) /
INSERT INTO CONTENIDO_GENERO (id_contenido, id_genero) VALUES (3, 4) /

-- Contenido 4 (Camino de Cafetales): Drama (3)
INSERT INTO CONTENIDO_GENERO (id_contenido, id_genero) VALUES (4, 3) /

-- Contenido 5 (Vuelo de Cóndor): Ciencia Ficción (6)
INSERT INTO CONTENIDO_GENERO (id_contenido, id_genero) VALUES (5, 6) /

-- Contenido 6 (Sombras de la Cordillera): Terror (7) y Suspenso (4)
INSERT INTO CONTENIDO_GENERO (id_contenido, id_genero) VALUES (6, 7) /
INSERT INTO CONTENIDO_GENERO (id_contenido, id_genero) VALUES (6, 4) /

-- Contenido 7 (La Cosecha del Destino): Romance (5)
INSERT INTO CONTENIDO_GENERO (id_contenido, id_genero) VALUES (7, 5) /

-- Contenido 8 (Oro Verde): Acción (1)
INSERT INTO CONTENIDO_GENERO (id_contenido, id_genero) VALUES (8, 1) /

-- Contenido 9 (Crónicas del Café - Serie): Drama (3)
INSERT INTO CONTENIDO_GENERO (id_contenido, id_genero) VALUES (9, 3) /

-- Contenido 10 (Estación Salento - Serie): Suspenso (4) y Drama (3)
INSERT INTO CONTENIDO_GENERO (id_contenido, id_genero) VALUES (10, 4) /
INSERT INTO CONTENIDO_GENERO (id_contenido, id_genero) VALUES (10, 3) /

-- Contenido 11 (Lazos de Sangre - Serie): Drama (3)
INSERT INTO CONTENIDO_GENERO (id_contenido, id_genero) VALUES (11, 3) /

-- Contenido 12 (Niebla en el Páramo - Serie): Terror (7) y Suspenso (4)
INSERT INTO CONTENIDO_GENERO (id_contenido, id_genero) VALUES (12, 7) /
INSERT INTO CONTENIDO_GENERO (id_contenido, id_genero) VALUES (12, 4) /

-- Contenido 13 (Aventuras de Antaño - Serie): Comedia (2)
INSERT INTO CONTENIDO_GENERO (id_contenido, id_genero) VALUES (13, 2) /

-- Contenido 14 (Código Secreto - Serie): Ciencia Ficción (6) y Acción (1)
INSERT INTO CONTENIDO_GENERO (id_contenido, id_genero) VALUES (14, 6) /
INSERT INTO CONTENIDO_GENERO (id_contenido, id_genero) VALUES (14, 1) /

-- Contenido 15 (Guardianes del Quindío - Serie): Infantil (8) y Comedia (2)
INSERT INTO CONTENIDO_GENERO (id_contenido, id_genero) VALUES (15, 8) /
INSERT INTO CONTENIDO_GENERO (id_contenido, id_genero) VALUES (15, 2) /

-- Contenido 16 (Destinos Cruzados - Serie): Romance (5)
INSERT INTO CONTENIDO_GENERO (id_contenido, id_genero) VALUES (16, 5) /

-- Contenidos del 17 al 24 (Documentales): Todos van para Drama (3) o Suspenso (4)
INSERT INTO CONTENIDO_GENERO (id_contenido, id_genero) VALUES (17, 3) /
INSERT INTO CONTENIDO_GENERO (id_contenido, id_genero) VALUES (18, 4) /
INSERT INTO CONTENIDO_GENERO (id_contenido, id_genero) VALUES (19, 3) /
INSERT INTO CONTENIDO_GENERO (id_contenido, id_genero) VALUES (20, 4) /
INSERT INTO CONTENIDO_GENERO (id_contenido, id_genero) VALUES (21, 3) /
INSERT INTO CONTENIDO_GENERO (id_contenido, id_genero) VALUES (22, 3) /
INSERT INTO CONTENIDO_GENERO (id_contenido, id_genero) VALUES (23, 3) /
INSERT INTO CONTENIDO_GENERO (id_contenido, id_genero) VALUES (24, 4) /

-- Contenidos del 25 al 32 (Música): Mapeados a Comedia/Drama de forma genérica para la relación
INSERT INTO CONTENIDO_GENERO (id_contenido, id_genero) VALUES (25, 2) /
INSERT INTO CONTENIDO_GENERO (id_contenido, id_genero) VALUES (26, 3) /
INSERT INTO CONTENIDO_GENERO (id_contenido, id_genero) VALUES (27, 2) /
INSERT INTO CONTENIDO_GENERO (id_contenido, id_genero) VALUES (28, 3) /
INSERT INTO CONTENIDO_GENERO (id_contenido, id_genero) VALUES (29, 2) /
INSERT INTO CONTENIDO_GENERO (id_contenido, id_genero) VALUES (30, 3) /
INSERT INTO CONTENIDO_GENERO (id_contenido, id_genero) VALUES (31, 2) /
INSERT INTO CONTENIDO_GENERO (id_contenido, id_genero) VALUES (32, 3) /

-- Contenidos del 33 al 40 (Podcasts): Mapeados a géneros variados
INSERT INTO CONTENIDO_GENERO (id_contenido, id_genero) VALUES (33, 2) /
INSERT INTO CONTENIDO_GENERO (id_contenido, id_genero) VALUES (34, 4) /
INSERT INTO CONTENIDO_GENERO (id_contenido, id_genero) VALUES (35, 6) /
INSERT INTO CONTENIDO_GENERO (id_contenido, id_genero) VALUES (36, 3) /
INSERT INTO CONTENIDO_GENERO (id_contenido, id_genero) VALUES (37, 3) /
INSERT INTO CONTENIDO_GENERO (id_contenido, id_genero) VALUES (38, 2) /
INSERT INTO CONTENIDO_GENERO (id_contenido, id_genero) VALUES (39, 2) /
INSERT INTO CONTENIDO_GENERO (id_contenido, id_genero) VALUES (40, 3) /

--insertar datos de ejemplo en la tabla EPISODIO
-- Temporada 1 (Crónicas del Café - T1): 4 episodios
INSERT INTO EPISODIO (titulo, numero, id_temporada) VALUES ('Siembra en el Quindío', 1, 1) /
INSERT INTO EPISODIO (titulo, numero, id_temporada) VALUES ('La Primera Recolección', 2, 1) /
INSERT INTO EPISODIO (titulo, numero, id_temporada) VALUES ('El Proceso del Beneficio', 3, 1) /
INSERT INTO EPISODIO (titulo, numero, id_temporada) VALUES ('Taza de Calidad', 4, 1) /

-- Temporada 2 (Crónicas del Café - T2): 3 episodios
INSERT INTO EPISODIO (titulo, numero, id_temporada) VALUES ('Exportando al Mundo', 1, 2) /
INSERT INTO EPISODIO (titulo, numero, id_temporada) VALUES ('Crisis Climática', 2, 2) /
INSERT INTO EPISODIO (titulo, numero, id_temporada) VALUES ('El Renacer de la Finca', 3, 2) /

-- Temporada 3 (Estación Salento - T1): 4 episodios
INSERT INTO EPISODIO (titulo, numero, id_temporada) VALUES ('El Jeepao de la Tarde', 1, 3) /
INSERT INTO EPISODIO (titulo, numero, id_temporada) VALUES ('Calle Real Arriba', 2, 3) /
INSERT INTO EPISODIO (titulo, numero, id_temporada) VALUES ('Artesanos del Tiempo', 3, 3) /
INSERT INTO EPISODIO (titulo, numero, id_temporada) VALUES ('Mirador Oculto', 4, 3) /

-- Temporada 4 (Estación Salento - T2): 3 episodios
INSERT INTO EPISODIO (titulo, numero, id_temporada) VALUES ('Niebla sobre Cocora', 1, 4) /
INSERT INTO EPISODIO (titulo, numero, id_temporada) VALUES ('La Palma Solitaria', 2, 4) /
INSERT INTO EPISODIO (titulo, numero, id_temporada) VALUES ('El Regreso del Cóndor', 3, 4) /

-- Temporada 5 (Lazos de Sangre - T1): 3 episodios
INSERT INTO EPISODIO (titulo, numero, id_temporada) VALUES ('Herencia Maldita', 1, 5) /
INSERT INTO EPISODIO (titulo, numero, id_temporada) VALUES ('El Testamento Oculto', 2, 5) /
INSERT INTO EPISODIO (titulo, numero, id_temporada) VALUES ('Verdades de Sangre', 3, 5) /

-- Temporada 6 (Niebla en el Páramo - T1): 3 episodios
INSERT INTO EPISODIO (titulo, numero, id_temporada) VALUES ('Frío Extremo', 1, 6) /
INSERT INTO EPISODIO (titulo, numero, id_temporada) VALUES ('Huellas en el Lodo', 2, 6) /
INSERT INTO EPISODIO (titulo, numero, id_temporada) VALUES ('El Guardián de la Cumbre', 3, 6) /

-- Temporada 7 (Guardianes del Quindío - T1): 4 episodios
INSERT INTO EPISODIO (titulo, numero, id_temporada) VALUES ('El Loro Orejiamarillo', 1, 7) /
INSERT INTO EPISODIO (titulo, numero, id_temporada) VALUES ('Rescate en el Río', 2, 7) /
INSERT INTO EPISODIO (titulo, numero, id_temporada) VALUES ('Sembrando Conciencia', 3, 7) /
INSERT INTO EPISODIO (titulo, numero, id_temporada) VALUES ('Eco-Héroes al Rescate', 4, 7) /

-- Temporada 8 (Emprender en el Quindío - T1): 3 episodios
INSERT INTO EPISODIO (titulo, numero, id_temporada) VALUES ('Idea y Propuesta de Valor', 1, 8) /
INSERT INTO EPISODIO (titulo, numero, id_temporada) VALUES ('Validando el Mercado Local', 2, 8) /
INSERT INTO EPISODIO (titulo, numero, id_temporada) VALUES ('Pitch Corporativo Eficaz', 3, 8) /

-- Temporada 9 (Emprender en el Quindío - T2): 3 episodios
INSERT INTO EPISODIO (titulo, numero, id_temporada) VALUES ('Financiación y Convocatorias', 1, 9) /
INSERT INTO EPISODIO (titulo, numero, id_temporada) VALUES ('Casos Exitosos: AgroTurismo', 2, 9) /
INSERT INTO EPISODIO (titulo, numero, id_temporada) VALUES ('Expandiendo Fronteras', 3, 9) /

-- Temporada 10 (Historias de Camino - T1): 4 episodios
INSERT INTO EPISODIO (titulo, numero, id_temporada) VALUES ('La Llorona del Río Quindío', 1, 10) /
INSERT INTO EPISODIO (titulo, numero, id_temporada) VALUES ('El Duende de los Cafetales', 2, 10) /
INSERT INTO EPISODIO (titulo, numero, id_temporada) VALUES ('La Madremonte del Páramo', 3, 10) /
INSERT INTO EPISODIO (titulo, numero, id_temporada) VALUES ('Gritos en la Noche', 4, 10) /

-- Temporada 11 (Tecnología para la Vida - T1): 3 episodios
INSERT INTO EPISODIO (titulo, numero, id_temporada) VALUES ('¿Qué es ChatGPT y LLMs?', 1, 11) /
INSERT INTO EPISODIO (titulo, numero, id_temporada) VALUES ('Automatización del Hogar', 2, 11) /
INSERT INTO EPISODIO (titulo, numero, id_temporada) VALUES ('El Futuro del Empleo', 3, 11) /

-- Temporada 12 (Tecnología para la Vida - T2): 3 episodios
INSERT INTO EPISODIO (titulo, numero, id_temporada) VALUES ('Protege tus Contraseñas', 1, 12) /
INSERT INTO EPISODIO (titulo, numero, id_temporada) VALUES ('Phishing: No Caigas en la Red', 2, 12) /
INSERT INTO EPISODIO (titulo, numero, id_temporada) VALUES ('Redes Seguras en WiFi Público', 3, 12) /

-- Temporada 13 (Tertulias con Aroma - T1): 3 episodios
INSERT INTO EPISODIO (titulo, numero, id_temporada) VALUES ('Gabriel García Márquez y el Eje', 1, 13) /
INSERT INTO EPISODIO (titulo, numero, id_temporada) VALUES ('Poesía Costumbrista', 2, 13) /
INSERT INTO EPISODIO (titulo, numero, id_temporada) VALUES ('Novelas Clásicas de la Región', 3, 13) /

-- Temporada 14 (Mentes Conectadas - T1): 3 episodios
INSERT INTO EPISODIO (titulo, numero, id_temporada) VALUES ('Ansiedad por Notificaciones', 1, 14) /
INSERT INTO EPISODIO (titulo, numero, id_temporada) VALUES ('El Síndrome del FOMO', 2, 14) /
INSERT INTO EPISODIO (titulo, numero, id_temporada) VALUES ('Detox Digital los Fines de Semana', 3, 14) /

-- Temporada 15 (Finanzas sin Enredos - T1): 4 episodios
INSERT INTO EPISODIO (titulo, numero, id_temporada) VALUES ('El Presupuesto 50/30/20', 1, 15) /
INSERT INTO EPISODIO (titulo, numero, id_temporada) VALUES ('Mata tus Deudas de Tarjeta', 2, 15) /
INSERT INTO EPISODIO (titulo, numero, id_temporada) VALUES ('Tu Primer Fondo de Emergencia', 3, 15) /
INSERT INTO EPISODIO (titulo, numero, id_temporada) VALUES ('Introducción a la Bolsa', 4, 15) /

--insertar datos de ejemplo en la tabla FAVORITO
-- Favoritos del Perfil 1 al 10 (Usuarios principales de las primeras cuentas)
INSERT INTO FAVORITO (id_perfil, id_contenido, fecha_agregado) VALUES (1, 1, SYSTIMESTAMP - INTERVAL '10' DAY) /
INSERT INTO FAVORITO (id_perfil, id_contenido, fecha_agregado) VALUES (1, 9, SYSTIMESTAMP - INTERVAL '9' DAY) /
INSERT INTO FAVORITO (id_perfil, id_contenido, fecha_agregado) VALUES (1, 17, SYSTIMESTAMP - INTERVAL '8' DAY) /
INSERT INTO FAVORITO (id_perfil, id_contenido, fecha_agregado) VALUES (2, 2, SYSTIMESTAMP - INTERVAL '15' DAY) /
INSERT INTO FAVORITO (id_perfil, id_contenido, fecha_agregado) VALUES (2, 10, SYSTIMESTAMP - INTERVAL '14' DAY) /
INSERT INTO FAVORITO (id_perfil, id_contenido, fecha_agregado) VALUES (3, 15, SYSTIMESTAMP - INTERVAL '5' DAY) /
INSERT INTO FAVORITO (id_perfil, id_contenido, fecha_agregado) VALUES (3, 33, SYSTIMESTAMP - INTERVAL '4' DAY) /
INSERT INTO FAVORITO (id_perfil, id_contenido, fecha_agregado) VALUES (4, 5, SYSTIMESTAMP - INTERVAL '20' DAY) /
INSERT INTO FAVORITO (id_perfil, id_contenido, fecha_agregado) VALUES (5, 2, SYSTIMESTAMP - INTERVAL '2' DAY) /
INSERT INTO FAVORITO (id_perfil, id_contenido, fecha_agregado) VALUES (5, 11, SYSTIMESTAMP - INTERVAL '1' DAY) /

-- Favoritos del Perfil 11 al 20 (Perfiles infantiles y secundarios)
INSERT INTO FAVORITO (id_perfil, id_contenido, fecha_agregado) VALUES (6, 15, SYSTIMESTAMP - INTERVAL '12' DAY) /
INSERT INTO FAVORITO (id_perfil, id_contenido, fecha_agregado) VALUES (7, 3, SYSTIMESTAMP - INTERVAL '30' DAY) /
INSERT INTO FAVORITO (id_perfil, id_contenido, fecha_agregado) VALUES (7, 4, SYSTIMESTAMP - INTERVAL '25' DAY) /
INSERT INTO FAVORITO (id_perfil, id_contenido, fecha_agregado) VALUES (8, 12, SYSTIMESTAMP - INTERVAL '18' DAY) /
INSERT INTO FAVORITO (id_perfil, id_contenido, fecha_agregado) VALUES (9, 15, SYSTIMESTAMP - INTERVAL '7' DAY) /
INSERT INTO FAVORITO (id_perfil, id_contenido, fecha_agregado) VALUES (10, 17, SYSTIMESTAMP - INTERVAL '6' DAY) /
INSERT INTO FAVORITO (id_perfil, id_contenido, fecha_agregado) VALUES (11, 25, SYSTIMESTAMP - INTERVAL '4' DAY) /
INSERT INTO FAVORITO (id_perfil, id_contenido, fecha_agregado) VALUES (12, 1, SYSTIMESTAMP - INTERVAL '3' DAY) /
INSERT INTO FAVORITO (id_perfil, id_contenido, fecha_agregado) VALUES (13, 10, SYSTIMESTAMP - INTERVAL '11' DAY) /
INSERT INTO FAVORITO (id_perfil, id_contenido, fecha_agregado) VALUES (14, 15, SYSTIMESTAMP - INTERVAL '1' DAY) /

-- Favoritos del Perfil 21 al 30 (Nuevos usuarios agregados)
INSERT INTO FAVORITO (id_perfil, id_contenido, fecha_agregado) VALUES (15, 6, SYSTIMESTAMP - INTERVAL '19' DAY) /
INSERT INTO FAVORITO (id_perfil, id_contenido, fecha_agregado) VALUES (15, 12, SYSTIMESTAMP - INTERVAL '15' DAY) /
INSERT INTO FAVORITO (id_perfil, id_contenido, fecha_agregado) VALUES (16, 7, SYSTIMESTAMP - INTERVAL '22' DAY) /
INSERT INTO FAVORITO (id_perfil, id_contenido, fecha_agregado) VALUES (17, 15, SYSTIMESTAMP - INTERVAL '5' DAY) /
INSERT INTO FAVORITO (id_perfil, id_contenido, fecha_agregado) VALUES (18, 8, SYSTIMESTAMP - INTERVAL '8' DAY) /
INSERT INTO FAVORITO (id_perfil, id_contenido, fecha_agregado) VALUES (19, 13, SYSTIMESTAMP - INTERVAL '9' DAY) /
INSERT INTO FAVORITO (id_perfil, id_contenido, fecha_agregado) VALUES (20, 22, SYSTIMESTAMP - INTERVAL '14' DAY) /
INSERT INTO FAVORITO (id_perfil, id_contenido, fecha_agregado) VALUES (21, 9, SYSTIMESTAMP - INTERVAL '3' DAY) /
INSERT INTO FAVORITO (id_perfil, id_contenido, fecha_agregado) VALUES (22, 15, SYSTIMESTAMP - INTERVAL '2' DAY) /
INSERT INTO FAVORITO (id_perfil, id_contenido, fecha_agregado) VALUES (23, 35, SYSTIMESTAMP - INTERVAL '1' DAY) /

-- Favoritos del Perfil 31 al 40 (Completando la variedad del catálogo)
INSERT INTO FAVORITO (id_perfil, id_contenido, fecha_agregado) VALUES (24, 39, SYSTIMESTAMP - INTERVAL '29' DAY) /
INSERT INTO FAVORITO (id_perfil, id_contenido, fecha_agregado) VALUES (25, 10, SYSTIMESTAMP - INTERVAL '21' DAY) /
INSERT INTO FAVORITO (id_perfil, id_contenido, fecha_agregado) VALUES (26, 15, SYSTIMESTAMP - INTERVAL '13' DAY) /
INSERT INTO FAVORITO (id_perfil, id_contenido, fecha_agregado) VALUES (27, 4, SYSTIMESTAMP - INTERVAL '12' DAY) /
INSERT INTO FAVORITO (id_perfil, id_contenido, fecha_agregado) VALUES (28, 19, SYSTIMESTAMP - INTERVAL '6' DAY) /
INSERT INTO FAVORITO (id_perfil, id_contenido, fecha_agregado) VALUES (29, 34, SYSTIMESTAMP - INTERVAL '5' DAY) /
INSERT INTO FAVORITO (id_perfil, id_contenido, fecha_agregado) VALUES (30, 2, SYSTIMESTAMP - INTERVAL '4' DAY) /
INSERT INTO FAVORITO (id_perfil, id_contenido, fecha_agregado) VALUES (31, 14, SYSTIMESTAMP - INTERVAL '2' DAY) /
INSERT INTO FAVORITO (id_perfil, id_contenido, fecha_agregado) VALUES (32, 15, SYSTIMESTAMP - INTERVAL '1' DAY) /
INSERT INTO FAVORITO (id_perfil, id_contenido, fecha_agregado) VALUES (35, 40, SYSTIMESTAMP - INTERVAL '7' DAY) /

--insertar datos de ejemplo en la tabla CALIFICACION
-- Calificaciones de 5 Estrellas (Contenido muy popular)
INSERT INTO CALIFICACION (id_perfil, id_contenido, estrellas, fecha_calificacion) VALUES (1, 1, 5, SYSTIMESTAMP - INTERVAL '2' DAY) /
INSERT INTO CALIFICACION (id_perfil, id_contenido, estrellas, fecha_calificacion) VALUES (2, 1, 5, SYSTIMESTAMP - INTERVAL '5' DAY) /
INSERT INTO CALIFICACION (id_perfil, id_contenido, estrellas, fecha_calificacion) VALUES (3, 9, 5, SYSTIMESTAMP - INTERVAL '1' DAY) /
INSERT INTO CALIFICACION (id_perfil, id_contenido, estrellas, fecha_calificacion) VALUES (4, 9, 5, SYSTIMESTAMP - INTERVAL '3' DAY) /
INSERT INTO CALIFICACION (id_perfil, id_contenido, estrellas, fecha_calificacion) VALUES (5, 10, 5, SYSTIMESTAMP - INTERVAL '10' DAY) /
INSERT INTO CALIFICACION (id_perfil, id_contenido, estrellas, fecha_calificacion) VALUES (6, 15, 5, SYSTIMESTAMP - INTERVAL '12' DAY) /
INSERT INTO CALIFICACION (id_perfil, id_contenido, estrellas, fecha_calificacion) VALUES (7, 15, 5, SYSTIMESTAMP - INTERVAL '15' DAY) /
INSERT INTO CALIFICACION (id_perfil, id_contenido, estrellas, fecha_calificacion) VALUES (8, 17, 5, SYSTIMESTAMP - INTERVAL '8' DAY) /
INSERT INTO CALIFICACION (id_perfil, id_contenido, estrellas, fecha_calificacion) VALUES (9, 33, 5, SYSTIMESTAMP - INTERVAL '4' DAY) /
INSERT INTO CALIFICACION (id_perfil, id_contenido, estrellas, fecha_calificacion) VALUES (10, 35, 5, SYSTIMESTAMP - INTERVAL '6' DAY) /
INSERT INTO CALIFICACION (id_perfil, id_contenido, estrellas, fecha_calificacion) VALUES (11, 2, 5, SYSTIMESTAMP - INTERVAL '7' DAY) /
INSERT INTO CALIFICACION (id_perfil, id_contenido, estrellas, fecha_calificacion) VALUES (12, 4, 5, SYSTIMESTAMP - INTERVAL '9' DAY) /
INSERT INTO CALIFICACION (id_perfil, id_contenido, estrellas, fecha_calificacion) VALUES (13, 12, 5, SYSTIMESTAMP - INTERVAL '11' DAY) /
INSERT INTO CALIFICACION (id_perfil, id_contenido, estrellas, fecha_calificacion) VALUES (14, 14, 5, SYSTIMESTAMP - INTERVAL '14' DAY) /
INSERT INTO CALIFICACION (id_perfil, id_contenido, estrellas, fecha_calificacion) VALUES (15, 20, 5, SYSTIMESTAMP - INTERVAL '20' DAY) /

-- Calificaciones de 4 Estrellas (Buen contenido)
INSERT INTO CALIFICACION (id_perfil, id_contenido, estrellas, fecha_calificacion) VALUES (16, 2, 4, SYSTIMESTAMP - INTERVAL '1' DAY) /
INSERT INTO CALIFICACION (id_perfil, id_contenido, estrellas, fecha_calificacion) VALUES (17, 3, 4, SYSTIMESTAMP - INTERVAL '2' DAY) /
INSERT INTO CALIFICACION (id_perfil, id_contenido, estrellas, fecha_calificacion) VALUES (18, 5, 4, SYSTIMESTAMP - INTERVAL '3' DAY) /
INSERT INTO CALIFICACION (id_perfil, id_contenido, estrellas, fecha_calificacion) VALUES (19, 6, 4, SYSTIMESTAMP - INTERVAL '4' DAY) /
INSERT INTO CALIFICACION (id_perfil, id_contenido, estrellas, fecha_calificacion) VALUES (20, 7, 4, SYSTIMESTAMP - INTERVAL '5' DAY) /
INSERT INTO CALIFICACION (id_perfil, id_contenido, estrellas, fecha_calificacion) VALUES (21, 8, 4, SYSTIMESTAMP - INTERVAL '6' DAY) /
INSERT INTO CALIFICACION (id_perfil, id_contenido, estrellas, fecha_calificacion) VALUES (22, 11, 4, SYSTIMESTAMP - INTERVAL '7' DAY) /
INSERT INTO CALIFICACION (id_perfil, id_contenido, estrellas, fecha_calificacion) VALUES (23, 13, 4, SYSTIMESTAMP - INTERVAL '8' DAY) /
INSERT INTO CALIFICACION (id_perfil, id_contenido, estrellas, fecha_calificacion) VALUES (24, 16, 4, SYSTIMESTAMP - INTERVAL '9' DAY) /
INSERT INTO CALIFICACION (id_perfil, id_contenido, estrellas, fecha_calificacion) VALUES (25, 18, 4, SYSTIMESTAMP - INTERVAL '10' DAY) /
INSERT INTO CALIFICACION (id_perfil, id_contenido, estrellas, fecha_calificacion) VALUES (26, 19, 4, SYSTIMESTAMP - INTERVAL '11' DAY) /
INSERT INTO CALIFICACION (id_perfil, id_contenido, estrellas, fecha_calificacion) VALUES (27, 21, 4, SYSTIMESTAMP - INTERVAL '12' DAY) /
INSERT INTO CALIFICACION (id_perfil, id_contenido, estrellas, fecha_calificacion) VALUES (28, 22, 4, SYSTIMESTAMP - INTERVAL '13' DAY) /
INSERT INTO CALIFICACION (id_perfil, id_contenido, estrellas, fecha_calificacion) VALUES (29, 23, 4, SYSTIMESTAMP - INTERVAL '14' DAY) /
INSERT INTO CALIFICACION (id_perfil, id_contenido, estrellas, fecha_calificacion) VALUES (30, 24, 4, SYSTIMESTAMP - INTERVAL '15' DAY) /

-- Calificaciones de 3 Estrellas (Contenido regular)
INSERT INTO CALIFICACION (id_perfil, id_contenido, estrellas, fecha_calificacion) VALUES (31, 25, 3, SYSTIMESTAMP - INTERVAL '4' DAY) /
INSERT INTO CALIFICACION (id_perfil, id_contenido, estrellas, fecha_calificacion) VALUES (32, 26, 3, SYSTIMESTAMP - INTERVAL '5' DAY) /
INSERT INTO CALIFICACION (id_perfil, id_contenido, estrellas, fecha_calificacion) VALUES (33, 27, 3, SYSTIMESTAMP - INTERVAL '6' DAY) /
INSERT INTO CALIFICACION (id_perfil, id_contenido, estrellas, fecha_calificacion) VALUES (34, 28, 3, SYSTIMESTAMP - INTERVAL '7' DAY) /
INSERT INTO CALIFICACION (id_perfil, id_contenido, estrellas, fecha_calificacion) VALUES (35, 29, 3, SYSTIMESTAMP - INTERVAL '8' DAY) /
INSERT INTO CALIFICACION (id_perfil, id_contenido, estrellas, fecha_calificacion) VALUES (36, 30, 3, SYSTIMESTAMP - INTERVAL '9' DAY) /
INSERT INTO CALIFICACION (id_perfil, id_contenido, estrellas, fecha_calificacion) VALUES (37, 31, 3, SYSTIMESTAMP - INTERVAL '10' DAY) /
INSERT INTO CALIFICACION (id_perfil, id_contenido, estrellas, fecha_calificacion) VALUES (38, 32, 3, SYSTIMESTAMP - INTERVAL '11' DAY) /
INSERT INTO CALIFICACION (id_perfil, id_contenido, estrellas, fecha_calificacion) VALUES (39, 34, 3, SYSTIMESTAMP - INTERVAL '12' DAY) /
INSERT INTO CALIFICACION (id_perfil, id_contenido, estrellas, fecha_calificacion) VALUES (40, 36, 3, SYSTIMESTAMP - INTERVAL '13' DAY) /

-- Calificaciones de 2 Estrellas (Contenido flojo)
INSERT INTO CALIFICACION (id_perfil, id_contenido, estrellas, fecha_calificacion) VALUES (41, 37, 2, SYSTIMESTAMP - INTERVAL '1' DAY) /
INSERT INTO CALIFICACION (id_perfil, id_contenido, estrellas, fecha_calificacion) VALUES (42, 38, 2, SYSTIMESTAMP - INTERVAL '2' DAY) /
INSERT INTO CALIFICACION (id_perfil, id_contenido, estrellas, fecha_calificacion) VALUES (43, 39, 2, SYSTIMESTAMP - INTERVAL '3' DAY) /
INSERT INTO CALIFICACION (id_perfil, id_contenido, estrellas, fecha_calificacion) VALUES (44, 40, 2, SYSTIMESTAMP - INTERVAL '4' DAY) /
INSERT INTO CALIFICACION (id_perfil, id_contenido, estrellas, fecha_calificacion) VALUES (45, 3, 2, SYSTIMESTAMP - INTERVAL '5' DAY) /
INSERT INTO CALIFICACION (id_perfil, id_contenido, estrellas, fecha_calificacion) VALUES (46, 5, 2, SYSTIMESTAMP - INTERVAL '6' DAY) /
INSERT INTO CALIFICACION (id_perfil, id_contenido, estrellas, fecha_calificacion) VALUES (47, 7, 2, SYSTIMESTAMP - INTERVAL '7' DAY) /
INSERT INTO CALIFICACION (id_perfil, id_contenido, estrellas, fecha_calificacion) VALUES (48, 11, 2, SYSTIMESTAMP - INTERVAL '8' DAY) /
INSERT INTO CALIFICACION (id_perfil, id_contenido, estrellas, fecha_calificacion) VALUES (49, 13, 2, SYSTIMESTAMP - INTERVAL '9' DAY) /
INSERT INTO CALIFICACION (id_perfil, id_contenido, estrellas, fecha_calificacion) VALUES (50, 16, 2, SYSTIMESTAMP - INTERVAL '10' DAY) /

-- Calificaciones de 1 Estrella (Contenido malo o con quejas)
INSERT INTO CALIFICACION (id_perfil, id_contenido, estrellas, fecha_calificacion) VALUES (1, 6, 1, SYSTIMESTAMP - INTERVAL '1' DAY) /
INSERT INTO CALIFICACION (id_perfil, id_contenido, estrellas, fecha_calificacion) VALUES (2, 12, 1, SYSTIMESTAMP - INTERVAL '2' DAY) /
INSERT INTO CALIFICACION (id_perfil, id_contenido, estrellas, fecha_calificacion) VALUES (3, 18, 1, SYSTIMESTAMP - INTERVAL '3' DAY) /
INSERT INTO CALIFICACION (id_perfil, id_contenido, estrellas, fecha_calificacion) VALUES (4, 24, 1, SYSTIMESTAMP - INTERVAL '4' DAY) /
INSERT INTO CALIFICACION (id_perfil, id_contenido, estrellas, fecha_calificacion) VALUES (12, 6, 1, SYSTIMESTAMP - INTERVAL '5' DAY) /
INSERT INTO CALIFICACION (id_perfil, id_contenido, estrellas, fecha_calificacion) VALUES (22, 12, 1, SYSTIMESTAMP - INTERVAL '6' DAY) /
INSERT INTO CALIFICACION (id_perfil, id_contenido, estrellas, fecha_calificacion) VALUES (32, 18, 1, SYSTIMESTAMP - INTERVAL '7' DAY) /
INSERT INTO CALIFICACION (id_perfil, id_contenido, estrellas, fecha_calificacion) VALUES (42, 24, 1, SYSTIMESTAMP - INTERVAL '8' DAY) /
INSERT INTO CALIFICACION (id_perfil, id_contenido, estrellas, fecha_calificacion) VALUES (5, 6, 1, SYSTIMESTAMP - INTERVAL '9' DAY) /
INSERT INTO CALIFICACION (id_perfil, id_contenido, estrellas, fecha_calificacion) VALUES (15, 12, 1, SYSTIMESTAMP - INTERVAL '10' DAY) /

--insertar datos de ejemplo en la tabla REPRODUCCION
-- ==========================================================
-- BLOQUE 1: REPRODUCCIONES EN SMART TV (Registros 1 - 50)
-- Películas, Documentales y Series en curso
-- ==========================================================
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '5' DAY, SYSTIMESTAMP - INTERVAL '5' DAY + INTERVAL '2' HOUR, 'Smart TV', 100.00, 1, 1, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '5' DAY, SYSTIMESTAMP - INTERVAL '5' DAY + INTERVAL '45' MINUTE, 'Smart TV', 100.00, 1, 9, 1) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '5' DAY, SYSTIMESTAMP - INTERVAL '5' DAY + INTERVAL '50' MINUTE, 'Smart TV', 100.00, 1, 9, 2) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '4' DAY, SYSTIMESTAMP - INTERVAL '4' DAY + INTERVAL '30' MINUTE, 'Smart TV', 60.50, 1, 9, 3) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '12' DAY, SYSTIMESTAMP - INTERVAL '12' DAY + INTERVAL '90' MINUTE, 'Smart TV', 100.00, 2, 2, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '11' DAY, SYSTIMESTAMP - INTERVAL '11' DAY + INTERVAL '40' MINUTE, 'Smart TV', 100.00, 2, 10, 8) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '6' DAY, SYSTIMESTAMP - INTERVAL '6' DAY + INTERVAL '110' MINUTE, 'Smart TV', 100.00, 3, 3, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '5' DAY, SYSTIMESTAMP - INTERVAL '5' DAY + INTERVAL '42' MINUTE, 'Smart TV', 100.00, 3, 15, 21) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '2' DAY, SYSTIMESTAMP - INTERVAL '2' DAY + INTERVAL '15' MINUTE, 'Smart TV', 35.00, 4, 4, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '1' DAY, SYSTIMESTAMP - INTERVAL '1' DAY + INTERVAL '120' MINUTE, 'Smart TV', 100.00, 5, 5, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '10' DAY, SYSTIMESTAMP - INTERVAL '10' DAY + INTERVAL '45' MINUTE, 'Smart TV', 100.00, 6, 15, 21) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '10' DAY, SYSTIMESTAMP - INTERVAL '10' DAY + INTERVAL '40' MINUTE, 'Smart TV', 100.00, 6, 15, 22) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '9' DAY, SYSTIMESTAMP - INTERVAL '9' DAY + INTERVAL '10' MINUTE, 'Smart TV', 15.20, 6, 6, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '15' DAY, SYSTIMESTAMP - INTERVAL '15' DAY + INTERVAL '85' MINUTE, 'Smart TV', 100.00, 7, 7, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '4' DAY, SYSTIMESTAMP - INTERVAL '4' DAY + INTERVAL '95' MINUTE, 'Smart TV', 100.00, 8, 8, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '3' DAY, SYSTIMESTAMP - INTERVAL '3' DAY + INTERVAL '50' MINUTE, 'Smart TV', 100.00, 8, 12, 17) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '8' DAY, SYSTIMESTAMP - INTERVAL '8' DAY + INTERVAL '105' MINUTE, 'Smart TV', 100.00, 9, 17, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '2' DAY, SYSTIMESTAMP - INTERVAL '2' DAY + INTERVAL '45' MINUTE, 'Smart TV', 90.00, 10, 11, 14) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '14' DAY, SYSTIMESTAMP - INTERVAL '14' DAY + INTERVAL '60' MINUTE, 'Smart TV', 100.00, 11, 18, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '1' DAY, SYSTIMESTAMP - INTERVAL '1' DAY + INTERVAL '35' MINUTE, 'Smart TV', 80.00, 12, 13, 20) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '7' DAY, SYSTIMESTAMP - INTERVAL '7' DAY + INTERVAL '115' MINUTE, 'Smart TV', 100.00, 13, 19, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '6' DAY, SYSTIMESTAMP - INTERVAL '6' DAY + INTERVAL '45' MINUTE, 'Smart TV', 100.00, 14, 15, 23) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '5' DAY, SYSTIMESTAMP - INTERVAL '5' DAY + INTERVAL '20' MINUTE, 'Smart TV', 45.00, 15, 20, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '20' DAY, SYSTIMESTAMP - INTERVAL '20' DAY + INTERVAL '90' MINUTE, 'Smart TV', 100.00, 16, 21, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '19' DAY, SYSTIMESTAMP - INTERVAL '19' DAY + INTERVAL '80' MINUTE, 'Smart TV', 100.00, 17, 22, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '18' DAY, SYSTIMESTAMP - INTERVAL '18' DAY + INTERVAL '75' MINUTE, 'Smart TV', 100.00, 18, 23, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '3' DAY, SYSTIMESTAMP - INTERVAL '3' DAY + INTERVAL '100' MINUTE, 'Smart TV', 100.00, 19, 24, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '2' DAY, SYSTIMESTAMP - INTERVAL '2' DAY + INTERVAL '40' MINUTE, 'Smart TV', 100.00, 20, 10, 9) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '1' DAY, SYSTIMESTAMP - INTERVAL '1' DAY + INTERVAL '45' MINUTE, 'Smart TV', 100.00, 21, 10, 10) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '1' DAY, SYSTIMESTAMP - INTERVAL '1' DAY + INTERVAL '15' MINUTE, 'Smart TV', 30.00, 21, 10, 11) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '8' DAY, SYSTIMESTAMP - INTERVAL '8' DAY + INTERVAL '55' MINUTE, 'Smart TV', 100.00, 22, 14, 18) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '4' DAY, SYSTIMESTAMP - INTERVAL '4' DAY + INTERVAL '125' MINUTE, 'Smart TV', 100.00, 23, 1, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '11' DAY, SYSTIMESTAMP - INTERVAL '11' DAY + INTERVAL '110' MINUTE, 'Smart TV', 100.00, 24, 2, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '13' DAY, SYSTIMESTAMP - INTERVAL '13' DAY + INTERVAL '105' MINUTE, 'Smart TV', 100.00, 25, 3, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '6' DAY, SYSTIMESTAMP - INTERVAL '6' DAY + INTERVAL '95' MINUTE, 'Smart TV', 100.00, 26, 4, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '2' DAY, SYSTIMESTAMP - INTERVAL '2' DAY + INTERVAL '85' MINUTE, 'Smart TV', 100.00, 27, 5, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '9' DAY, SYSTIMESTAMP - INTERVAL '9' DAY + INTERVAL '90' MINUTE, 'Smart TV', 100.00, 28, 6, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '5' DAY, SYSTIMESTAMP - INTERVAL '5' DAY + INTERVAL '100' MINUTE, 'Smart TV', 100.00, 29, 7, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '12' DAY, SYSTIMESTAMP - INTERVAL '12' DAY + INTERVAL '115' MINUTE, 'Smart TV', 100.00, 30, 8, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '7' DAY, SYSTIMESTAMP - INTERVAL '7' DAY + INTERVAL '45' MINUTE, 'Smart TV', 100.00, 31, 9, 1) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '7' DAY, SYSTIMESTAMP - INTERVAL '7' DAY + INTERVAL '50' MINUTE, 'Smart TV', 100.00, 31, 9, 2) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '1' DAY, SYSTIMESTAMP - INTERVAL '1' DAY + INTERVAL '35' MINUTE, 'Smart TV', 100.00, 32, 10, 8) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '3' DAY, SYSTIMESTAMP - INTERVAL '3' DAY + INTERVAL '40' MINUTE, 'Smart TV', 100.00, 33, 11, 14) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '10' DAY, SYSTIMESTAMP - INTERVAL '10' DAY + INTERVAL '38' MINUTE, 'Smart TV', 100.00, 34, 12, 17) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '8' DAY, SYSTIMESTAMP - INTERVAL '8' DAY + INTERVAL '42' MINUTE, 'Smart TV', 100.00, 35, 13, 20) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '14' DAY, SYSTIMESTAMP - INTERVAL '14' DAY + INTERVAL '45' MINUTE, 'Smart TV', 100.00, 36, 14, 18) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '2' DAY, SYSTIMESTAMP - INTERVAL '2' DAY + INTERVAL '50' MINUTE, 'Smart TV', 100.00, 37, 15, 21) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '4' DAY, SYSTIMESTAMP - INTERVAL '4' DAY + INTERVAL '40' MINUTE, 'Smart TV', 100.00, 38, 9, 3) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '11' DAY, SYSTIMESTAMP - INTERVAL '11' DAY + INTERVAL '45' MINUTE, 'Smart TV', 100.00, 39, 10, 9) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '5' DAY, SYSTIMESTAMP - INTERVAL '5' DAY + INTERVAL '25' MINUTE, 'Smart TV', 50.00, 40, 11, 15) /

-- ==========================================================
-- BLOQUE 2: REPRODUCCIONES EN SMARTPHONE (Registros 51 - 100)
-- Podcasts, Música y Contenido rápido móvil
-- ==========================================================
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '2' DAY, SYSTIMESTAMP - INTERVAL '2' DAY + INTERVAL '30' MINUTE, 'Smartphone', 100.00, 1, 33, 24) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '2' DAY, SYSTIMESTAMP - INTERVAL '2' DAY + INTERVAL '25' MINUTE, 'Smartphone', 100.00, 1, 33, 25) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '1' DAY, SYSTIMESTAMP - INTERVAL '1' DAY + INTERVAL '40' MINUTE, 'Smartphone', 100.00, 2, 34, 27) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '5' DAY, SYSTIMESTAMP - INTERVAL '5' DAY + INTERVAL '35' MINUTE, 'Smartphone', 100.00, 3, 35, 28) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '4' DAY, SYSTIMESTAMP - INTERVAL '4' DAY + INTERVAL '32' MINUTE, 'Smartphone', 100.00, 3, 35, 29) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '10' DAY, SYSTIMESTAMP - INTERVAL '10' DAY + INTERVAL '45' MINUTE, 'Smartphone', 100.00, 4, 36, 30) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '3' DAY, SYSTIMESTAMP - INTERVAL '3' DAY + INTERVAL '28' MINUTE, 'Smartphone', 100.00, 5, 37, 31) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '8' DAY, SYSTIMESTAMP - INTERVAL '8' DAY + INTERVAL '30' MINUTE, 'Smartphone', 100.00, 6, 39, 32) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '12' DAY, SYSTIMESTAMP - INTERVAL '12' DAY + INTERVAL '5' MINUTE, 'Smartphone', 100.00, 7, 25, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '11' DAY, SYSTIMESTAMP - INTERVAL '11' DAY + INTERVAL '6' MINUTE, 'Smartphone', 100.00, 8, 26, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '14' DAY, SYSTIMESTAMP - INTERVAL '14' DAY + INTERVAL '4' MINUTE, 'Smartphone', 100.00, 9, 27, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '1' DAY, SYSTIMESTAMP - INTERVAL '1' DAY + INTERVAL '8' MINUTE, 'Smartphone', 100.00, 10, 28, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '6' DAY, SYSTIMESTAMP - INTERVAL '6' DAY + INTERVAL '5' MINUTE, 'Smartphone', 100.00, 11, 29, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '7' DAY, SYSTIMESTAMP - INTERVAL '7' DAY + INTERVAL '12' MINUTE, 'Smartphone', 40.00, 12, 33, 24) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '9' DAY, SYSTIMESTAMP - INTERVAL '9' DAY + INTERVAL '30' MINUTE, 'Smartphone', 100.00, 13, 34, 27) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '4' DAY, SYSTIMESTAMP - INTERVAL '4' DAY + INTERVAL '22' MINUTE, 'Smartphone', 100.00, 14, 35, 28) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '13' DAY, SYSTIMESTAMP - INTERVAL '13' DAY + INTERVAL '35' MINUTE, 'Smartphone', 100.00, 15, 36, 30) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '2' DAY, SYSTIMESTAMP - INTERVAL '2' DAY + INTERVAL '40' MINUTE, 'Smartphone', 100.00, 16, 37, 31) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '5' DAY, SYSTIMESTAMP - INTERVAL '5' DAY + INTERVAL '15' MINUTE, 'Smartphone', 50.00, 17, 39, 32) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '1' DAY, SYSTIMESTAMP - INTERVAL '1' DAY + INTERVAL '4' MINUTE, 'Smartphone', 100.00, 18, 30, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '3' DAY, SYSTIMESTAMP - INTERVAL '3' DAY + INTERVAL '5' MINUTE, 'Smartphone', 100.00, 19, 31, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '10' DAY, SYSTIMESTAMP - INTERVAL '10' DAY + INTERVAL '6' MINUTE, 'Smartphone', 100.00, 20, 32, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '15' DAY, SYSTIMESTAMP - INTERVAL '15' DAY + INTERVAL '30' MINUTE, 'Smartphone', 100.00, 21, 33, 24) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '8' DAY, SYSTIMESTAMP - INTERVAL '8' DAY + INTERVAL '28' MINUTE, 'Smartphone', 100.00, 22, 34, 27) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '12' DAY, SYSTIMESTAMP - INTERVAL '12' DAY + INTERVAL '35' MINUTE, 'Smartphone', 100.00, 23, 35, 28) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '6' DAY, SYSTIMESTAMP - INTERVAL '6' DAY + INTERVAL '40' MINUTE, 'Smartphone', 100.00, 24, 36, 30) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '2' DAY, SYSTIMESTAMP - INTERVAL '2' DAY + INTERVAL '31' MINUTE, 'Smartphone', 100.00, 25, 37, 31) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '9' DAY, SYSTIMESTAMP - INTERVAL '9' DAY + INTERVAL '30' MINUTE, 'Smartphone', 100.00, 26, 39, 32) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '4' DAY, SYSTIMESTAMP - INTERVAL '4' DAY + INTERVAL '5' MINUTE, 'Smartphone', 100.00, 27, 25, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '11' DAY, SYSTIMESTAMP - INTERVAL '11' DAY + INTERVAL '6' MINUTE, 'Smartphone', 100.00, 28, 26, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '7' DAY, SYSTIMESTAMP - INTERVAL '7' DAY + INTERVAL '4' MINUTE, 'Smartphone', 100.00, 29, 27, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '13' DAY, SYSTIMESTAMP - INTERVAL '13' DAY + INTERVAL '8' MINUTE, 'Smartphone', 100.00, 30, 28, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '5' DAY, SYSTIMESTAMP - INTERVAL '5' DAY + INTERVAL '5' MINUTE, 'Smartphone', 100.00, 31, 29, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '1' DAY, SYSTIMESTAMP - INTERVAL '1' DAY + INTERVAL '30' MINUTE, 'Smartphone', 100.00, 32, 33, 24) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '3' DAY, SYSTIMESTAMP - INTERVAL '3' DAY + INTERVAL '28' MINUTE, 'Smartphone', 100.00, 33, 34, 27) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '10' DAY, SYSTIMESTAMP - INTERVAL '10' DAY + INTERVAL '35' MINUTE, 'Smartphone', 100.00, 34, 35, 28) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '14' DAY, SYSTIMESTAMP - INTERVAL '14' DAY + INTERVAL '40' MINUTE, 'Smartphone', 100.00, 35, 36, 30) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '2' DAY, SYSTIMESTAMP - INTERVAL '2' DAY + INTERVAL '31' MINUTE, 'Smartphone', 100.00, 36, 37, 31) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '8' DAY, SYSTIMESTAMP - INTERVAL '8' DAY + INTERVAL '30' MINUTE, 'Smartphone', 100.00, 37, 39, 32) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '4' DAY, SYSTIMESTAMP - INTERVAL '4' DAY + INTERVAL '5' MINUTE, 'Smartphone', 100.00, 38, 25, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '11' DAY, SYSTIMESTAMP - INTERVAL '11' DAY + INTERVAL '6' MINUTE, 'Smartphone', 100.00, 39, 26, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '6' DAY, SYSTIMESTAMP - INTERVAL '6' DAY + INTERVAL '4' MINUTE, 'Smartphone', 100.00, 40, 27, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '12' DAY, SYSTIMESTAMP - INTERVAL '12' DAY + INTERVAL '8' MINUTE, 'Smartphone', 100.00, 41, 28, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '5' DAY, SYSTIMESTAMP - INTERVAL '5' DAY + INTERVAL '5' MINUTE, 'Smartphone', 100.00, 42, 29, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '1' DAY, SYSTIMESTAMP - INTERVAL '1' DAY + INTERVAL '30' MINUTE, 'Smartphone', 100.00, 43, 33, 24) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '3' DAY, SYSTIMESTAMP - INTERVAL '3' DAY + INTERVAL '28' MINUTE, 'Smartphone', 100.00, 44, 34, 27) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '9' DAY, SYSTIMESTAMP - INTERVAL '9' DAY + INTERVAL '35' MINUTE, 'Smartphone', 100.00, 45, 35, 28) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '13' DAY, SYSTIMESTAMP - INTERVAL '13' DAY + INTERVAL '40' MINUTE, 'Smartphone', 100.00, 46, 36, 30) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '2' DAY, SYSTIMESTAMP - INTERVAL '2' DAY + INTERVAL '31' MINUTE, 'Smartphone', 100.00, 47, 37, 31) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '7' DAY, SYSTIMESTAMP - INTERVAL '7' DAY + INTERVAL '30' MINUTE, 'Smartphone', 100.00, 48, 39, 32) /

-- ==========================================================
-- BLOQUE 3: REPRODUCCIONES EN TABLET (Registros 101 - 150)
-- Variedad de perfiles infantiles y películas familiares
-- ==========================================================
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '4' DAY, SYSTIMESTAMP - INTERVAL '4' DAY + INTERVAL '45' MINUTE, 'Tablet', 100.00, 3, 15, 21) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '4' DAY, SYSTIMESTAMP - INTERVAL '4' DAY + INTERVAL '40' MINUTE, 'Tablet', 100.00, 3, 15, 22) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '3' DAY, SYSTIMESTAMP - INTERVAL '3' DAY + INTERVAL '42' MINUTE, 'Tablet', 100.00, 3, 15, 23) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '2' DAY, SYSTIMESTAMP - INTERVAL '2' DAY + INTERVAL '40' MINUTE, 'Tablet', 100.00, 3, 15, 24) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '10' DAY, SYSTIMESTAMP - INTERVAL '10' DAY + INTERVAL '90' MINUTE, 'Tablet', 85.00, 6, 1, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '5' DAY, SYSTIMESTAMP - INTERVAL '5' DAY + INTERVAL '30' MINUTE, 'Tablet', 100.00, 11, 15, 21) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '5' DAY, SYSTIMESTAMP - INTERVAL '5' DAY + INTERVAL '35' MINUTE, 'Tablet', 100.00, 11, 15, 22) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '1' DAY, SYSTIMESTAMP - INTERVAL '1' DAY + INTERVAL '110' MINUTE, 'Tablet', 100.00, 14, 2, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '7' DAY, SYSTIMESTAMP - INTERVAL '7' DAY + INTERVAL '45' MINUTE, 'Tablet', 100.00, 17, 15, 21) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '8' DAY, SYSTIMESTAMP - INTERVAL '8' DAY + INTERVAL '42' MINUTE, 'Tablet', 100.00, 22, 15, 22) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '14' DAY, SYSTIMESTAMP - INTERVAL '14' DAY + INTERVAL '50' MINUTE, 'Tablet', 100.00, 25, 15, 23) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '2' DAY, SYSTIMESTAMP - INTERVAL '2' DAY + INTERVAL '45' MINUTE, 'Tablet', 100.00, 26, 15, 24) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '4' DAY, SYSTIMESTAMP - INTERVAL '4' DAY + INTERVAL '100' MINUTE, 'Tablet', 100.00, 32, 3, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '11' DAY, SYSTIMESTAMP - INTERVAL '11' DAY + INTERVAL '120' MINUTE, 'Tablet', 100.00, 35, 4, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '6' DAY, SYSTIMESTAMP - INTERVAL '6' DAY + INTERVAL '80' MINUTE, 'Tablet', 100.00, 40, 5, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '12' DAY, SYSTIMESTAMP - INTERVAL '12' DAY + INTERVAL '95' MINUTE, 'Tablet', 100.00, 49, 6, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '5' DAY, SYSTIMESTAMP - INTERVAL '5' DAY + INTERVAL '45' MINUTE, 'Tablet', 100.00, 50, 15, 21) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '1' DAY, SYSTIMESTAMP - INTERVAL '1' DAY + INTERVAL '20' MINUTE, 'Tablet', 45.00, 48, 7, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '3' DAY, SYSTIMESTAMP - INTERVAL '3' DAY + INTERVAL '115' MINUTE, 'Tablet', 100.00, 47, 8, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '10' DAY, SYSTIMESTAMP - INTERVAL '10' DAY + INTERVAL '50' MINUTE, 'Tablet', 100.00, 46, 9, 1) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '15' DAY, SYSTIMESTAMP - INTERVAL '15' DAY + INTERVAL '45' MINUTE, 'Tablet', 100.00, 45, 10, 8) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '8' DAY, SYSTIMESTAMP - INTERVAL '8' DAY + INTERVAL '40' MINUTE, 'Tablet', 100.00, 44, 11, 14) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '12' DAY, SYSTIMESTAMP - INTERVAL '12' DAY + INTERVAL '35' MINUTE, 'Tablet', 100.00, 43, 12, 17) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '6' DAY, SYSTIMESTAMP - INTERVAL '6' DAY + INTERVAL '42' MINUTE, 'Tablet', 100.00, 42, 13, 20) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '2' DAY, SYSTIMESTAMP - INTERVAL '2' DAY + INTERVAL '45' MINUTE, 'Tablet', 100.00, 41, 14, 18) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '9' DAY, SYSTIMESTAMP - INTERVAL '9' DAY + INTERVAL '120' MINUTE, 'Tablet', 100.00, 40, 1, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '4' DAY, SYSTIMESTAMP - INTERVAL '4' DAY + INTERVAL '110' MINUTE, 'Tablet', 100.00, 39, 2, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '11' DAY, SYSTIMESTAMP - INTERVAL '11' DAY + INTERVAL '105' MINUTE, 'Tablet', 100.00, 38, 3, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '7' DAY, SYSTIMESTAMP - INTERVAL '7' DAY + INTERVAL '95' MINUTE, 'Tablet', 100.00, 37, 4, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '13' DAY, SYSTIMESTAMP - INTERVAL '13' DAY + INTERVAL '85' MINUTE, 'Tablet', 100.00, 36, 5, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '5' DAY, SYSTIMESTAMP - INTERVAL '5' DAY + INTERVAL '90' MINUTE, 'Tablet', 100.00, 35, 6, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '1' DAY, SYSTIMESTAMP - INTERVAL '1' DAY + INTERVAL '100' MINUTE, 'Tablet', 100.00, 34, 7, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '3' DAY, SYSTIMESTAMP - INTERVAL '3' DAY + INTERVAL '115' MINUTE, 'Tablet', 100.00, 33, 8, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '10' DAY, SYSTIMESTAMP - INTERVAL '10' DAY + INTERVAL '45' MINUTE, 'Tablet', 100.00, 32, 9, 1) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '14' DAY, SYSTIMESTAMP - INTERVAL '14' DAY + INTERVAL '50' MINUTE, 'Tablet', 100.00, 31, 10, 8) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '2' DAY, SYSTIMESTAMP - INTERVAL '2' DAY + INTERVAL '40' MINUTE, 'Tablet', 100.00, 30, 11, 14) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '8' DAY, SYSTIMESTAMP - INTERVAL '8' DAY + INTERVAL '35' MINUTE, 'Tablet', 100.00, 29, 12, 17) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '4' DAY, SYSTIMESTAMP - INTERVAL '4' DAY + INTERVAL '42' MINUTE, 'Tablet', 100.00, 28, 13, 20) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '11' DAY, SYSTIMESTAMP - INTERVAL '11' DAY + INTERVAL '45' MINUTE, 'Tablet', 100.00, 27, 14, 18) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '6' DAY, SYSTIMESTAMP - INTERVAL '6' DAY + INTERVAL '50' MINUTE, 'Tablet', 100.00, 26, 15, 21) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '12' DAY, SYSTIMESTAMP - INTERVAL '12' DAY + INTERVAL '120' MINUTE, 'Tablet', 100.00, 25, 1, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '5' DAY, SYSTIMESTAMP - INTERVAL '5' DAY + INTERVAL '110' MINUTE, 'Tablet', 100.00, 24, 2, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '1' DAY, SYSTIMESTAMP - INTERVAL '1' DAY + INTERVAL '105' MINUTE, 'Tablet', 100.00, 23, 3, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '3' DAY, SYSTIMESTAMP - INTERVAL '3' DAY + INTERVAL '95' MINUTE, 'Tablet', 100.00, 22, 4, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '10' DAY, SYSTIMESTAMP - INTERVAL '10' DAY + INTERVAL '85' MINUTE, 'Tablet', 100.00, 21, 5, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '15' DAY, SYSTIMESTAMP - INTERVAL '15' DAY + INTERVAL '90' MINUTE, 'Tablet', 100.00, 20, 6, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '8' DAY, SYSTIMESTAMP - INTERVAL '8' DAY + INTERVAL '100' MINUTE, 'Tablet', 100.00, 19, 7, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '12' DAY, SYSTIMESTAMP - INTERVAL '12' DAY + INTERVAL '115' MINUTE, 'Tablet', 100.00, 18, 8, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '6' DAY, SYSTIMESTAMP - INTERVAL '6' DAY + INTERVAL '45' MINUTE, 'Tablet', 100.00, 17, 9, 1) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '2' DAY, SYSTIMESTAMP - INTERVAL '2' DAY + INTERVAL '50' MINUTE, 'Tablet', 100.00, 16, 10, 8) /

-- ==========================================================
-- BLOQUE 4: REPRODUCCIONES EN COMPUTADOR (Registros 151 - 200)
-- Documentales extensos, Series de corrido y finalización
-- ==========================================================
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '4' DAY, SYSTIMESTAMP - INTERVAL '4' DAY + INTERVAL '90' MINUTE, 'Computador', 100.00, 1, 17, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '4' DAY, SYSTIMESTAMP - INTERVAL '4' DAY + INTERVAL '85' MINUTE, 'Computador', 100.00, 1, 19, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '3' DAY, SYSTIMESTAMP - INTERVAL '3' DAY + INTERVAL '105' MINUTE, 'Computador', 100.00, 2, 17, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '2' DAY, SYSTIMESTAMP - INTERVAL '2' DAY + INTERVAL '110' MINUTE, 'Computador', 100.00, 3, 19, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '10' DAY, SYSTIMESTAMP - INTERVAL '10' DAY + INTERVAL '45' MINUTE, 'Computador', 100.00, 5, 11, 14) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '5' DAY, SYSTIMESTAMP - INTERVAL '5' DAY + INTERVAL '40' MINUTE, 'Computador', 100.00, 6, 12, 17) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '5' DAY, SYSTIMESTAMP - INTERVAL '5' DAY + INTERVAL '35' MINUTE, 'Computador', 100.00, 6, 12, 17) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '1' DAY, SYSTIMESTAMP - INTERVAL '1' DAY + INTERVAL '42' MINUTE, 'Computador', 100.00, 8, 13, 20) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '7' DAY, SYSTIMESTAMP - INTERVAL '7' DAY + INTERVAL '45' MINUTE, 'Computador', 100.00, 9, 14, 18) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '8' DAY, SYSTIMESTAMP - INTERVAL '8' DAY + INTERVAL '50' MINUTE, 'Computador', 100.00, 10, 15, 21) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '14' DAY, SYSTIMESTAMP - INTERVAL '14' DAY + INTERVAL '95' MINUTE, 'Computador', 100.00, 12, 17, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '2' DAY, SYSTIMESTAMP - INTERVAL '2' DAY + INTERVAL '100' MINUTE, 'Computador', 100.00, 13, 19, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '4' DAY, SYSTIMESTAMP - INTERVAL '4' DAY + INTERVAL '45' MINUTE, 'Computador', 100.00, 15, 11, 14) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '11' DAY, SYSTIMESTAMP - INTERVAL '11' DAY + INTERVAL '40' MINUTE, 'Computador', 100.00, 16, 12, 17) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '6' DAY, SYSTIMESTAMP - INTERVAL '6' DAY + INTERVAL '35' MINUTE, 'Computador', 100.00, 18, 13, 20) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '12' DAY, SYSTIMESTAMP - INTERVAL '12' DAY + INTERVAL '42' MINUTE, 'Computador', 100.00, 20, 14, 18) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '5' DAY, SYSTIMESTAMP - INTERVAL '5' DAY + INTERVAL '50' MINUTE, 'Computador', 100.00, 21, 15, 21) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '1' DAY, SYSTIMESTAMP - INTERVAL '1' DAY + INTERVAL '90' MINUTE, 'Computador', 100.00, 23, 17, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '3' DAY, SYSTIMESTAMP - INTERVAL '3' DAY + INTERVAL '85' MINUTE, 'Computador', 100.00, 24, 19, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '10' DAY, SYSTIMESTAMP - INTERVAL '10' DAY + INTERVAL '105' MINUTE, 'Computador', 100.00, 25, 17, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '15' DAY, SYSTIMESTAMP - INTERVAL '15' DAY + INTERVAL '110' MINUTE, 'Computador', 100.00, 26, 19, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '8' DAY, SYSTIMESTAMP - INTERVAL '8' DAY + INTERVAL '45' MINUTE, 'Computador', 100.00, 27, 11, 14) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '12' DAY, SYSTIMESTAMP - INTERVAL '12' DAY + INTERVAL '40' MINUTE, 'Computador', 100.00, 28, 12, 17) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '6' DAY, SYSTIMESTAMP - INTERVAL '6' DAY + INTERVAL '35' MINUTE, 'Computador', 100.00, 29, 13, 20) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '2' DAY, SYSTIMESTAMP - INTERVAL '2' DAY + INTERVAL '42' MINUTE, 'Computador', 100.00, 30, 14, 18) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '9' DAY, SYSTIMESTAMP - INTERVAL '9' DAY + INTERVAL '50' MINUTE, 'Computador', 100.00, 31, 15, 21) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '4' DAY, SYSTIMESTAMP - INTERVAL '4' DAY + INTERVAL '90' MINUTE, 'Computador', 100.00, 33, 17, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '11' DAY, SYSTIMESTAMP - INTERVAL '11' DAY + INTERVAL '85' MINUTE, 'Computador', 100.00, 34, 19, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '7' DAY, SYSTIMESTAMP - INTERVAL '7' DAY + INTERVAL '105' MINUTE, 'Computador', 100.00, 35, 17, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '13' DAY, SYSTIMESTAMP - INTERVAL '13' DAY + INTERVAL '110' MINUTE, 'Computador', 100.00, 36, 19, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '5' DAY, SYSTIMESTAMP - INTERVAL '5' DAY + INTERVAL '45' MINUTE, 'Computador', 100.00, 37, 11, 14) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '1' DAY, SYSTIMESTAMP - INTERVAL '1' DAY + INTERVAL '40' MINUTE, 'Computador', 100.00, 38, 12, 17) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '3' DAY, SYSTIMESTAMP - INTERVAL '3' DAY + INTERVAL '35' MINUTE, 'Computador', 100.00, 39, 13, 20) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '10' DAY, SYSTIMESTAMP - INTERVAL '10' DAY + INTERVAL '42' MINUTE, 'Computador', 100.00, 41, 14, 18) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '14' DAY, SYSTIMESTAMP - INTERVAL '14' DAY + INTERVAL '50' MINUTE, 'Computador', 100.00, 42, 15, 21) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '2' DAY, SYSTIMESTAMP - INTERVAL '2' DAY + INTERVAL '90' MINUTE, 'Computador', 100.00, 43, 17, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '8' DAY, SYSTIMESTAMP - INTERVAL '8' DAY + INTERVAL '85' MINUTE, 'Computador', 100.00, 44, 19, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '4' DAY, SYSTIMESTAMP - INTERVAL '4' DAY + INTERVAL '105' MINUTE, 'Computador', 100.00, 45, 17, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '11' DAY, SYSTIMESTAMP - INTERVAL '11' DAY + INTERVAL '110' MINUTE, 'Computador', 100.00, 46, 19, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '6' DAY, SYSTIMESTAMP - INTERVAL '6' DAY + INTERVAL '45' MINUTE, 'Computador', 100.00, 47, 11, 14) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '12' DAY, SYSTIMESTAMP - INTERVAL '12' DAY + INTERVAL '40' MINUTE, 'Computador', 100.00, 48, 12, 17) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '5' DAY, SYSTIMESTAMP - INTERVAL '5' DAY + INTERVAL '35' MINUTE, 'Computador', 100.00, 49, 13, 20) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '1' DAY, SYSTIMESTAMP - INTERVAL '1' DAY + INTERVAL '42' MINUTE, 'Computador', 100.00, 50, 14, 18) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '3' DAY, SYSTIMESTAMP - INTERVAL '3' DAY + INTERVAL '50' MINUTE, 'Computador', 100.00, 1, 15, 21) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '10' DAY, SYSTIMESTAMP - INTERVAL '10' DAY + INTERVAL '90' MINUTE, 'Computador', 100.00, 2, 17, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '14' DAY, SYSTIMESTAMP - INTERVAL '14' DAY + INTERVAL '85' MINUTE, 'Computador', 100.00, 3, 19, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '2' DAY, SYSTIMESTAMP - INTERVAL '2' DAY + INTERVAL '105' MINUTE, 'Computador', 100.00, 5, 17, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '8' DAY, SYSTIMESTAMP - INTERVAL '8' DAY + INTERVAL '110' MINUTE, 'Computador', 100.00, 6, 19, NULL) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '4' DAY, SYSTIMESTAMP - INTERVAL '4' DAY + INTERVAL '45' MINUTE, 'Computador', 100.00, 8, 11, 14) /
INSERT INTO REPRODUCCION (fecha_hora_inicio, fecha_hora_fin, dispositivo, porcentaje_avance, id_perfil, id_contenido, id_episodio) VALUES (SYSTIMESTAMP - INTERVAL '11' DAY, SYSTIMESTAMP - INTERVAL '11' DAY + INTERVAL '40' MINUTE, 'Computador', 100.00, 9, 12, 17) /

COMMIT;/