--CONSULTAS DE EJEMPLO

--EJEMPLO DE INSERCION DE MODALIDADES:
INSERT INTO modalidad (NOM_MOD)
VALUES ('Motocross');

--EJEMPLO DE INSERCION DE MARCAS:
INSERT INTO marca (NOM_MAR, INF_MAR)
VALUES ('SYM', 'Traducción del inglés-Sanyang Motor Co., Ltd. fue fundada en Taipei en 1954 por Huang Chi-Chun y Chang Kuo An. La sede de la empresa está establecida en el condado de Hsinchu, Taiwán y vende sus productos de dos ruedas con el nombre de marca SYM. Las tres principales bases de producción de Sanyang están en Taiwán, China y Vietnam.');

--EJEMPLO DE INSERCION DE MOTOS:
INSERT INTO motos (ID_MAR, ID_MOD, NOM_MOT, IMG_MOT, CIL_MOT, CIC_MOT, REF_MOT, TRN_MOT, NMAR_MOT, CHA_MOT, FRD_MOT, FRT_MOT, RUD_MOT, RUT_MOT, PES_MOT)
VALUES (2, 5, 'Integra', 'https://www.motofichas.com/images/phocagallery/Honda/integra-750-2018/03-honda-integra-750-2018-perfil-plata-alpha.jpg', 
   '745cc', '4 Tiempos', 'Liquida', 'Cadena', 'Automatica', 'Diamante en tubo de acero', 'Disco', 'Disco', '17', '17', '238 Kg');

--EJEMPLO DE INSERCION DE USUARIOS:
INSERT INTO usuario (NICK_USU, NOM_USU, APE_USU, CON_USU, COR_USU, COL_USU)
VALUES ('prueba', 'prueba', 'prueba', 'prueba', 'prueba', 'prueba');