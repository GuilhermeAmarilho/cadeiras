CREATE TABLE SEXO(
ID         INTEGER,
DESCRICAO  VARCHAR(30),
PRIMARY KEY (ID)
);
  


CREATE TABLE ANO_ENTRADA(
ID         INTEGER,
DESCRICAO  VARCHAR(30),
PRIMARY KEY (ID)
);


CREATE TABLE CIDADE(
ID         INTEGER,
DESCRICAO  VARCHAR(30),
PRIMARY KEY (ID)
);


CREATE TABLE SITUACAO(
ID         INTEGER,
DESCRICAO  VARCHAR(30),
PRIMARY KEY (ID)
);


CREATE TABLE CURSO(
ID         INTEGER,  
DESCRICAO  VARCHAR(30),   
PRIMARY KEY (ID)
);



INSERT INTO SEXO (ID, DESCRICAO) VALUES (1,'Feminino');
INSERT INTO SEXO (ID, DESCRICAO) VALUES (2, 'Masculino');   


INSERT INTO ANO_ENTRADA (ID, DESCRICAO) VALUES (1,'2014');
INSERT INTO ANO_ENTRADA (ID, DESCRICAO) VALUES (2,'2015');
INSERT INTO ANO_ENTRADA (ID, DESCRICAO) VALUES (3,'2016');
INSERT INTO ANO_ENTRADA (ID, DESCRICAO) VALUES (4,'2017');
INSERT INTO ANO_ENTRADA (ID, DESCRICAO) VALUES (5,'2018');
INSERT INTO ANO_ENTRADA (ID, DESCRICAO) VALUES (6,'2019');
       
    
INSERT INTO CIDADE (ID, DESCRICAO) VALUES (1,'Videira');  
INSERT INTO CIDADE (ID, DESCRICAO) VALUES (2,'Pinheiro_Preto');
INSERT INTO CIDADE (ID, DESCRICAO) VALUES (3,'Tangara');
INSERT INTO CIDADE (ID, DESCRICAO) VALUES (4,'Iomere'); 
INSERT INTO CIDADE (ID, DESCRICAO) VALUES (5,'Arroio_Trinta');
INSERT INTO CIDADE (ID, DESCRICAO) VALUES (6,'Salto_Veloso');
INSERT INTO CIDADE (ID, DESCRICAO) VALUES (7,'Fraiburgo');
INSERT INTO CIDADE (ID, DESCRICAO) VALUES (8,'Cacador');
INSERT INTO CIDADE (ID, DESCRICAO) VALUES (9,'Rio_das_Antas');


INSERT INTO SITUACAO (ID, DESCRICAO) VALUES (1,'Andamento');
INSERT INTO SITUACAO (ID, DESCRICAO) VALUES (2,'Desistente');
INSERT INTO SITUACAO (ID, DESCRICAO) VALUES (3,'Outro');



INSERT INTO CURSO (ID, DESCRICAO) VALUES (1,'Informatica_Integrado');
INSERT INTO CURSO (ID, DESCRICAO) VALUES (2,'Agropecuaria_Integrado');
INSERT INTO CURSO (ID, DESCRICAO) VALUES (3,'Eletroeletronica_Integrado');
INSERT INTO CURSO (ID, DESCRICAO) VALUES (4,'Ciencia_da_Computacao');
INSERT INTO CURSO (ID, DESCRICAO) VALUES (5,'Agropecuaria_Subsequente');


CREATE TABLE FATO(  
ID                        INTEGER,
SEXO    	          INTEGER,
ANO_ENTRADA		  INTEGER,
CIDADE			  INTEGER,
SITUACAO		  INTEGER,
CURSO                     INTEGER,

CONSTRAINT FATOS_PK PRIMARY KEY (ID,SEXO,ANO_ENTRADA,CIDADE,SITUACAO,CURSO),
CONSTRAINT SEXO_FK FOREIGN KEY(SEXO) REFERENCES SEXO(ID),
CONSTRAINT ANO_ENTRADA_FK FOREIGN KEY(ANO_ENTRADA) REFERENCES ANO_ENTRADA(ID),
CONSTRAINT CIDADE_FK FOREIGN KEY(CIDADE) REFERENCES CIDADE(ID),
CONSTRAINT SITUACAO_FK FOREIGN KEY(SITUACAO) REFERENCES SITUACAO(ID),
CONSTRAINT CURSO_FK FOREIGN KEY(CURSO) REFERENCES CURSO(ID) 
); 


insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (1,2,1,4,3,2);   
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (2,2,1,1,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (3,2,1,1,3,3);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (4,2,1,7,3,1);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (5,2,1,3,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (6,2,1,1,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (7,2,1,1,3,1);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (8,2,1,1,3,3);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (9,2,1,8,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (10,2,1,1,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (11,2,1,1,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (12,1,1,1,3,2); 
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (13,2,1,1,3,4);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (14,2,1,1,3,3);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (15,2,1,1,3,1);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (16,2,1,3,3,1);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (17,2,1,4,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (18,2,1,1,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (19,2,1,1,3,3);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (20,1,1,1,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (21,1,1,1,3,1);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (22,1,1,1,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (23,1,1,8,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (24,1,1,3,3,1);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (25,1,1,1,3,1);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (26,1,1,3,3,1);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (27,1,1,1,3,1);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (28,1,1,1,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (29,1,1,1,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (30,1,1,3,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (31,1,1,1,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (32,1,1,1,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (33,1,1,1,3,1);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (34,1,1,1,3,1);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (35,1,1,1,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (36,1,1,9,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (37,1,1,1,3,1);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (38,1,1,1,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (39,1,1,1,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (40,1,1,1,3,1);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (41,1,1,1,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (42,1,1,1,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (43,1,1,1,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (44,1,1,1,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (45,1,1,1,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (46,1,1,1,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (47,1,1,9,3,3);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (48,2,2,4,3,2);   
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (49,2,2,1,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (50,2,2,1,3,3);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (51,2,2,7,3,1);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (52,2,2,3,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (53,2,2,1,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (54,2,2,1,3,1);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (55,2,2,1,3,3);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (56,2,2,8,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (57,2,2,1,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (58,2,2,1,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (59,1,2,1,3,2); 
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (60,2,2,1,3,4);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (61,2,2,1,3,3);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (62,2,2,1,3,1);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (63,2,2,3,3,1);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (64,2,2,4,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (65,2,2,1,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (66,2,2,1,3,3);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (67,1,2,1,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (68,1,2,1,3,1);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (69,1,2,1,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (70,1,2,8,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (71,1,2,3,3,1);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (72,1,2,1,3,1);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (73,1,2,3,3,1);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (74,1,2,1,3,1);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (75,1,2,1,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (76,1,2,1,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (77,1,2,3,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (78,1,2,1,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (79,1,2,1,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (80,1,2,1,3,1);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (81,1,2,1,3,1);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (82,1,2,1,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (83,1,2,9,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (84,1,2,1,3,1);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (85,1,2,1,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (86,1,2,1,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (87,1,2,1,3,1);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (88,1,2,1,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (89,1,2,1,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (90,1,2,1,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (91,1,2,1,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (92,1,2,1,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (93,1,2,1,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (94,1,2,9,3,3);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (95,1,2,1,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (96,1,2,1,3,3);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (97,1,2,1,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (98,1,3,1,3,2);        
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (99,2,3,1,3,3);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (100,1,3,1,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (101,1,3,9,3,3);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (102,2,3,4,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (103,2,3,1,3,2); 
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (104,2,3,1,3,1);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (105,1,3,5,3,3);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (106,1,3,1,3,3);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (107,1,3,1,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (108,1,3,1,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (109,2,3,1,3,1);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (110,2,3,1,3,1);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (111,1,3,1,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (112,1,3,1,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (113,2,3,9,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (114,1,3,1,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (115,1,3,1,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (116,1,3,1,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (117,2,3,9,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (118,2,3,1,3,3);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (119,1,3,2,3,1);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (120,1,3,1,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (121,1,3,3,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (122,1,3,1,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (123,2,3,2,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (124,2,3,1,1,2); 
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (125,2,3,1,3,2); 
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (126,2,3,1,1,3);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (127,1,3,1,3,2);              
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (128,2,4,1,1,4);     
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (129,2,4,1,3,2);  
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (130,1,4,1,3,3);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (131,1,4,5,3,3);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (132,2,4,1,1,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (133,1,4,1,3,2); 
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (134,1,4,9,3,1);    
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (135,1,4,1,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (136,2,4,9,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (137,2,4,2,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (138,2,4,1,1,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (139,2,4,1,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (140,2,4,1,1,3);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (141,1,4,5,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (142,2,4,1,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (143,1,4,1,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (144,1,4,1,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (145,1,4,1,3,3);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (146,2,4,1,3,1);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (147,1,4,1,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (148,2,4,1,1,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (149,1,4,1,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (150,2,4,7,1,3);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (151,2,4,1,3,3);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (152,1,4,2,3,1);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (153,2,4,3,1,3);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (154,2,4,1,1,2);     
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (155,2,4,1,3,2); 
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (156,2,4,1,3,3);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (157,2,4,1,1,2);              
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (158,2,4,1,3,2);       
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (159,1,4,3,3,2);  
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (160,1,4,9,1,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (161,2,4,1,3,5);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (162,1,4,1,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (163,1,4,1,1,2); 
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (164,1,4,1,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (165,1,4,1,1,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (166,1,4,1,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (167,1,4,1,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (168,1,4,9,3,1);    
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (169,1,5,1,1,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (170,1,5,1,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (171,1,5,1,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (172,1,5,1,1,1);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (173,1,5,1,1,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (174,1,5,9,1,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (175,1,5,1,3,3);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (176,1,5,4,1,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (177,1,5,4,1,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (178,1,5,4,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (179,1,5,4,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (180,1,5,4,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (181,1,5,4,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (182,1,5,4,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (183,1,5,4,1,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (184,1,5,4,3,2);   
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (185,1,5,4,3,2); 
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (186,1,5,4,1,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (187,1,5,4,3,3); 
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (188,2,5,3,1,3);     
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (189,2,5,9,3,2);  
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (190,2,5,2,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (191,2,5,1,3,3);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (192,2,5,3,1,3);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (193,2,5,3,3,3); 
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (194,2,5,1,1,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (195,2,5,1,1,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (196,2,5,1,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (197,2,5,1,1,3);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (198,2,5,1,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (199,2,5,3,3,3);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (200,2,5,3,1,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (201,2,5,5,3,2);  
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (202,1,6,1,1,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (203,1,6,1,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (204,1,6,1,1,1);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (205,1,6,1,1,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (206,1,6,1,1,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (207,1,6,9,1,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (208,1,6,1,1,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (209,1,6,1,1,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (210,1,6,4,1,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (211,1,6,1,1,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (212,1,6,1,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (213,1,6,1,1,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (214,1,6,1,1,2);   
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (215,1,6,1,3,2); 
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (216,1,6,1,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (217,1,6,1,1,2);               
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (218,1,6,1,3,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (219,1,6,1,1,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (220,2,6,3,1,3);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (221,2,6,1,3,3);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (222,2,6,3,1,3);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (223,2,6,1,1,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (224,2,6,1,1,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (225,2,6,1,3,3);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (226,2,6,1,1,3);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (227,2,6,1,1,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (228,2,6,1,1,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (229,2,6,1,1,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (230,2,6,1,1,4);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (231,2,6,1,1,1);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (232,2,6,1,1,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (233,2,6,1,1,2);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (234,2,6,7,1,3);
insert into fato (id,sexo,ano_entrada,cidade,situacao,curso) values (235,2,6,7,1,2);               