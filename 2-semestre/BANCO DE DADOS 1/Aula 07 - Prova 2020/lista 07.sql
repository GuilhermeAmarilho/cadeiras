-- questão 1
INSERT INTO usuario(idusuario, nome, email, senha, telefone, cpf, data_nascimento, tipo_usuario) VALUES 
(1,"Carlos Antônio", "antonio@msn.com", "54321", "49 9 85476321", "365.965.852-89","1991-11-23",2);

INSERT INTO caderno(idcaderno, nome, idusuario) VALUES 
(1,"Estudos",1);

INSERT INTO nota(idnota, titulo, texto, data, idcaderno) VALUES 
(1,"Nota de estudo", "Banco de dados - Dia 1", NOW(), 1);

-- --------------------------------------------------- --

INSERT INTO usuario(idusuario, nome, email, senha, telefone, cpf, data_nascimento, tipo_usuario) VALUES 
(2, "Geraldo Santos", "geraldo@gmail.com", "12345", "49 9 88523625", "254.635.569-85", "1986-06-15", 1);

INSERT INTO lembrete(idlembrete, nome, descricao, data_criacao, data_alarme, idusuario) VALUES 
(1, "Regar as plantas", "", NOW(), CONCAT( (date_add(CURDATE(), interval 1 day)) ," ", "07:15:00"), 2);


-- questão 2 - Listar a quantidade de usuários com cartões que vencerão esse mês
SELECT * FROM usuario AS u, cartaocredito AS c
	WHERE u.idusuario = c.idusuario 
    AND c.anovencimento = YEAR(CURRENT_DATE()) 
    AND c.mesvencimento = MONTH(CURRENT_DATE());

-- questão 3 - Listar todas as notas que pertençam as categorias com ids entre 5 e 35
SELECT n.idnota, n.titulo, n.texto, n.data, n.idcaderno FROM nota AS n, categoria as c, notacategoria as nc
	WHERE n.idnota = nc.idnota
    AND	nc.idcategoria = c.idcategoria 
    AND c.idcategoria BETWEEN 5 AND 35;

-- questão 4 - Listar todas os cadernos dos usuários que são premium
SELECT c.idcaderno, c.nome, c.idusuario FROM caderno AS c, usuario AS u
	WHERE c.idusuario = u.idusuario
    AND u.tipo_usuario = 1;

-- questão 5 - Apresentar a média de idade dos usuários que possuem notas criadas no último mês e notificações não lidas
SELECT AVG(TIMESTAMPDIFF(YEAR,u.data_nascimento,NOW())) AS MediaIdade FROM 
	usuario AS u, nota AS n, caderno as c, notificacao as noti
        WHERE u.idusuario = c.idusuario
        AND n.idcaderno = c.idcaderno
        AND noti.idusuario = u.idusuario
        AND YEAR(n.data) = year(NOW())
        AND MONTH(n.data) >= (MONTH(NOW())-1)
    	AND noti.data_leitura = NULL
 
-- questão 6 - Apresentar os 10 usuário que tem a maior quantidade de lembretes criados no mes passado
SELECT COUNT(l.idusuario) AS quantidadeLembretes FROM 
	usuario AS u, lembrete as l
    	WHERE u.idusuario = l.idusuario
            AND YEAR(l.data_criacao) = year(NOW())
            AND MONTH(l.data_criacao) = (MONTH(NOW())-1)
    	GROUP BY l.idusuario
        LIMIT 10;
        
-- questão 7 - Apresentar o valor médio da quantidade de notas associadas a cada categoria
SELECT (COUNT(n.idnota) FROM 
	nota AS n, categoria AS c, notacategoria AS nc
    WHERE n.idnota = nc.idnota
    	AND nc.idcategoria = c.idcategoria
        GROUP BY nc.idcategoria;
        
SELECT avg(qtd) FROM (
SELECT c.nome, COUNT(n.idnota) as qtd FROM 
	nota AS n, categoria AS c, notacategoria AS nc
    WHERE n.idnota = nc.idnota
    	AND nc.idcategoria = c.idcategoria
        GROUP BY nc.idcategoria) as mediaNotas;


-- questão 8 - Substituir de @hotmail.com para @outlook.com em cada usuário que possuir esse tipo de email
UPDATE usuario	
	SET email = REPLACE(email, '@hotmail.com', '@outlook.com')
		WHERE email LIKE '%@outlook.com%';

-- questão 9 - Aumentar uma hora, na data de alarme de todos os lembretes que seriam para despertar no dia 25/12/2019
UPDATE lembrete SET data_alarme = DATE_ADD(data_alarme, interval 1 hour) 
	WHERE DATE(data_alarme) = "2019-12-25";

-- questão 10 - Alterar para categoria de id 5 todas as notas criadas pelo usuário de id 22
UPDATE notacategoria AS nc, usuario as u, caderno as c, categoria as cat, nota as n SET nc.idcategoria = 5
	WHERE u.idusuario = c.idcaderno
        AND c.idcaderno = n.idcaderno
        AND n.idnota = nc.idnota
        AND u.idusuario = 22

-- questão 11 - Para as assinaturas feitas esse mês sem desconto, atualizar a coluna desconto para 20% e ajustar o valor da coluna valor.
UPDATE assinatura as a SET desconto = 0.2 AND valor = valor*(0.8) 
	WHERE desconto = 0 
        AND c.anovencimento = YEAR(CURRENT_DATE()) 
        AND c.mesvencimento = MONTH(CURRENT_DATE());

-- questao 12 - Deletar todas as notas do usuário de id 7
DELETE n FROM nota AS n, caderno AS c, usuario AS u
	WHERE n.idcaderno = c.idcaderno 
    AND c.idusuario = u.idusuario
	AND u.idusuario = 7;

-- questao 13 - Deletar todos os cadernos dos usuários menores de idade
-- questao 13 - Deletar todos os cadernos dos usuários menores de idade
DELETE c FROM caderno AS c, usuario AS u
	WHERE c.idusuario = u.idusuario
    AND TIMESTAMPDIFF(YEAR,u.data_nascimento,NOW()) < 18;