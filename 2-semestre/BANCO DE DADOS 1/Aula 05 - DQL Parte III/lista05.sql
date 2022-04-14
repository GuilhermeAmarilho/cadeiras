-- exercicio 1
SELECT * 
    FROM usuario AS u, amizade AS a 
        WHERE (u.idusuario = a.idsolicitante or u.idusuario = a.iddestinatario) 
            AND a.idstatus = 2 
            AND u.idusuario = 5 
        order by u.idusuario;

-- exercicio 2
SELECT u.idusuario, u.nome, a.idstatus, count(u.idusuario) AS solicitacoes 
    FROM usuario AS u, amizade AS a 
        WHERE u.idusuario = a.idsolicitante 
            AND a.idstatus = 1 
        GROUP by u.idusuario 
        ORDER by solicitacoes DESC

-- exercicio 3 
SELECT COUNT(est.nome) AS User_Estado, est.nome 
    FROM usuario AS u, endereco AS end, cidade AS c, estado AS est
	    WHERE u.idendereco = end.idendereco 
    	    AND end.idcidade = c.idcidade 
            AND c.idestado = est.idestado
        GROUP BY est.idestado

-- exercicio 4
SELECT AVG( TIMESTAMPDIFF(YEAR,u.datanascimento, NOW()) ) AS Idade, c.nome 
    FROM usuario AS u, endereco AS end, cidade AS c
	    WHERE u.idendereco = end.idendereco 
    	    AND end.idcidade = c.idcidade 
        GROUP BY c.idcidade

-- exercicio 5
SELECT AVG( TIMESTAMPDIFF(YEAR,u.datanascimento, NOW()) ) AS Idade  
    FROM usuario AS u, endereco AS end, cidade AS c
	    WHERE u.idendereco = end.idendereco 
    	    AND end.idcidade = c.idcidade 
            AND c.nome = "fraiburgo"
        GROUP BY c.idcidade

-- exercicio 6
SELECT u.nome
    FROM usuario AS u, amizade AS a
    	WHERE u.idusuario = a.iddestinatario 
            AND a.idstatus = 1 
            AND a.idsolicitante = 4

-- exercicio 7
SELECT COUNT(a.idstatus) as Total_Amigos, u.nome
    FROM usuario AS u, amizade AS a
    	WHERE u.idusuario = a.idsolicitante 
        	AND a.idstatus = 2
        GROUP BY a.idsolicitante
        LIMIT 3
        ORDER BY Total_Amigos DESC


-- exercicio 8
SELECT COUNT(c.nome) AS UserPorCidade, c.nome
    FROM usuario AS u, endereco AS end, cidade AS c
	    WHERE u.idendereco = end.idendereco 
    	    AND end.idcidade = c.idcidade  
        	AND TIMESTAMPDIFF(YEAR,u.datanascimento, NOW()) >= 18
        GROUP BY c.nome
        ORDER BY UserPorCidade DESC

-- exercicio 9
SELECT est.nome
	FROM usuario AS u, endereco AS end, cidade AS c, estado AS est
    	WHERE u.idendereco = end.idendereco
        	AND end.idcidade = c.idcidade
            AND c.idestado = est.idestado
        ORDER BY TIMESTAMPDIFF(YEAR,u.datanascimento, NOW()) DESC
        LIMIT 1;

-- exercicio 10
SELECT est.nome, COUNT(est.nome) as SolicitacoesPendentes
	FROM usuario AS u, amizade AS a, endereco AS end, cidade AS c, estado AS est
    	WHERE u.idusuario = a.idsolicitante
        	AND u.idendereco = end.idendereco
            AND end.idcidade = c.idcidade 
            AND c.idestado = est.idestado
            AND a.idstatus = 1     
       	GROUP BY est.nome
        ORDER BY SolicitacoesPendentes DESC
        LIMIT 1

-- adicional c 2 tabelas - apresente os dados completos dos usuários
SELECT u.nome, TIMESTAMPDIFF(YEAR,u.datanascimento, NOW()) AS Idade, end.logradouro, end.numero, end.cep, end.bairro
	FROM usuario AS u, endereco as end
    	WHERE u.idendereco = end.idendereco;


-- adicional c 3 tabelas - listar os usuarios com + 40 anos que moram em videira
SELECT u.nome
	FROM usuario AS u, endereco as end, cidade as c
    	WHERE u.idendereco = end.idendereco
        	AND end.idcidade = c.idcidade
            AND (TIMESTAMPDIFF(YEAR,u.datanascimento, NOW()) > 40)
            AND c.nome = "videira"


-- adicional com 5 tabelas - 
SELECT u.nome, TIMESTAMPDIFF(YEAR,u.datanascimento, NOW()) AS Idade, end.logradouro, end.numero, end.cep, c.nome as cidade,
	est.nome as estado, est.uf, COUNT(a.idsolicitante) as Amigos
	FROM usuario AS u, endereco AS end, cidade AS c, estado AS est, amizade as a
		WHERE u.idusuario = end.idendereco
        	AND end.idcidade = c.idcidade
            AND c.idestado = est.idestado
            AND u.idusuario = a.idsolicitante
			AND a.idstatus = 2
            GROUP BY a.idsolicitante
            ORDER BY Amigos DESC;