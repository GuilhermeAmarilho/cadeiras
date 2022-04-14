-- Questão 1

INSERT INTO montadora(idmontadora,nome) VALUES 
    (1, "Fiat");
INSERT INTO modelo(idmodelo, nome, idmontadora) VALUES 
    (1,"Pálio",1);
INSERT INTO estado(idestado, nome) VALUES 
    (1, "Bahia");
INSERT INTO cidade(idcidade, nome, idestado) VALUES 
    (1, "Feira de Santana", 1);
INSERT INTO endereco(idendereco, logradouro, numero, bairro, cep, idcidade) VALUES 
    (1, "Travessa Branca", "801", "Lajeado", "44040-175", 1);
INSERT INTO usuario(idusuario, nome, cpf, telefone, senha, datanascimento, idendereco, idtipo) VALUES 
    (1,"Marina Carvalho Barros", "12343223444", "53986574856", "12345", "1973-06-01", 1, 1);
INSERT INTO carro(idcarro, idmodelo, idusuario, ano, placa, chassi) VALUES 
    (1, 1, 1, 2020, "XLD 3454", "9BW ZZZ377 VT 004251");


INSERT INTO estado(idestado, nome) VALUES 
    (2, "São paulo");
INSERT INTO cidade(idcidade, nome, idestado) VALUES 
    (2, "Bragança Paulista", 2);
INSERT INTO endereco(idendereco, logradouro, numero, bairro, cep, idcidade) VALUES 
    (2, "Paulo de Tarso Franco Rodrigues", "1188", "Centro", "12906-790", 2);
INSERT INTO usuario(idusuario, nome, cpf, telefone, senha, datanascimento, idendereco, idtipo) VALUES 
    (2,"Alex Dias Costa", "181818182", "11986750934", "123456", "1985-01-11", 2, 2);
INSERT INTO `corrida`(`idcorrida`, `idusario_motorista`, `idusuario_passageiro`, `data`, `hora_inicio`, `hora_termino`, `valor`, `idformapagamento`) 
    VALUES (1, 1, 2, SUBDATE(NOW(), 1), "09:00:00", "10:00:00", 7.50, 1);

-- Questão 2

SELECT COUNT(c.idusario_motorista) AS NumCorridas FROM corrida AS c , usuario AS u
	WHERE c.idusario_motorista = u.idusuario
    AND u.idusuario = 7
    GROUP BY c.idusario_motorista;

-- Questão 3

SELECT * FROM corrida AS c
	WHERE c.idformapagamento = 1
    AND c.valor BETWEEN 7 AND 10;

-- Questão 4

SELECT * FROM corrida AS cor, usuario AS u, carro AS c, modelo AS mo, montadora AS mon
	WHERE cor.idusario_motorista = u.idusuario
    AND u.idusuario = c.idusuario 
    AND c.idmodelo = mo.idmodelo
    AND mo.idmontadora = mon.idmontadora
    AND mon.nome = "Fiat"
    AND MONTH(cor.data) =  (MONTH(NOW()) - 1) -- mes passado
    AND YEAR(cor.data) = YEAR(NOW());

-- Questão 5

SELECT AVG(TIMESTAMPDIFF (YEAR,u.datanascimento, NOW())) AS MediaIdade FROM corrida AS c, usuario AS u 
	WHERE c.idusario_motorista = u.idusuario
    AND u.idtipo = 1
    AND c.valor > 100
    GROUP BY u.idtipo -- pega todos
        

-- Questao 6

SELECT SUM(c.valor) AS MontanteCorridas FROM usuario AS u, corrida as c
	WHERE u.idusuario = c.idusario_motorista
    GROUP BY u.idusuario
    ORDER BY DESC
    LIMIT 10;

-- Questão 7

SELECT AVG(c.valor) AS MediaValor FROM corrida AS c, usuario AS u, endereco AS en, cidade as ci, estado as e
	WHERE c.idusario_motorista = u.idusuario
    AND u.idendereco = en.idendereco
    AND en.idcidade = ci.idcidade
    AND ci.idestado = e.idestado
    AND e.nome = "São Paulo"
	GROUP BY e.nome;

-- Questão 8

UPDATE endereco as en, cidade as c 
    SET logradouro = "Rua Alperneiros" 
    WHERE en.bairro = " Santa Cruz"
    AND c.nome = "Luzia"
    -- AND c.idcidade = 8  como não está cadastrado este código, coloquei pelo nome que dá no mesmo
	AND en.logradouro = "Rua Alpender";

-- Questão 9

UPDATE corrida 
    SET hora_inicio = date_add(hora_inicio, INTERVAL 1 HOUR), 
        hora_termino = date_add(hora_termino, INTERVAL 1 HOUR)
    WHERE corrida.data BETWEEN "2018-11-04" AND "2019-02-16";

-- Questão 10

UPDATE corrida AS c, usuario AS u, endereco AS e, cidade AS ci
	SET c.idformapagamento = 3
    WHERE c.idusario_motorista = u.idusuario
    AND u.idendereco = e.idendereco
    AND e.idcidade = ci.idcidade -- se colocar = 10 ja serve
    AND ci.nome = "Videira"

-- Questão 11

UPDATE corrida AS c, usuario AS u, carro as ca
	SET c.valor = c.valor*0.8
    WHERE c.idusario_motorista = u.idusuario
    AND u.idusuario = ca.idusuario
    AND YEAR(ca.ano) = "2014";
    

-- Questão 12

DELETE c FROM cidade AS c, endereco AS e, usuario AS u 
	WHERE c.idcidade = e.idcidade 
    AND e.idendereco = u.idendereco
    AND u.idusuario = 7;

-- Questão 13

DELETE c FROM corrida AS c, usuario AS u
	WHERE c.idusario_motorista = u.idusuario
    AND TIMESTAMPDIFF(YEAR, u.datanascimento, now())<18