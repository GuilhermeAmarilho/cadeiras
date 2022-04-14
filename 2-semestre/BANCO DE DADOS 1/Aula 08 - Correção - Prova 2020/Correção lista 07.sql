 INSERIR - Leonardo Geremeria

Insert 01:

INSERT INTO usuario(nome, email, senha, telefone, cpf, data_nascimento,tipo_usu) VALUES(‘Carlos Antônio’, ‘antonio@msn.com’, ‘54321’,‘5549985476321’, ‘36596585289’, ‘1991-11-23’, 2);
INSERT INTO caderno(nome, idusuario) VALUES(‘Estudos’, 1);
INSERT INTO nota(titulo,texto,data,idcaderno) VALUES(‘Assuntos para estudar – exame banco’, ‘Dia 01’, NOW(), 1);
Insert 02:

INSERT INTO usuario(nome, email, senha, telefone, cpf, data_nascimento,tipo_usu) VALUES(‘Geraldo Santos’,‘geraldo@gmail.com’,‘12345’,‘5549988523625’,‘25463556985’,‘1986-06-15’,1);
INSERT INTO lembrete (nome, data_criacao, data_alarme, idusuario) VALUES(‘Regar as plantas’, NOW(), CONCAT(DATE_ADD(CURDATE(), INTERVAL 1 MONTHY), ‘07:15:00’), 1);
Listar a quantidade de usuários com cartões que vencerão esse mês - Henrique Martinelli

SELECT count(c.idcartaocredito) FROM usuario as u, cartaocredito as c where u.idusuario=c.car_idusuario AND (mes_vencimento=MONTH(CURDATE()) AND ano_vencimento=YEAR(CURDATE()));
Listar todas as notas que pertençam as categorias com ids entre 5 e 35 - Erick Scur

SELECT n.titulo, nc.idcategoria FROM nota as n, nota_categoria as nc
WHERE nc.idnota = n.idnota
AND nc.idcategoria BETWEEN 5 and 35;
SELECT n.titulo, nc.idcategoria FROM nota as n, nota_categoria as nc
WHERE nc.idnota = n.idnota
AND (nc.idcategoria>= 5 and nc.idcategoria<= 35);
Listar todos os cadernos dos usuários que são premium - Winicius da rocha

SELECT u.nome,u.tipo_usu, c.nome FROM caderno as c, usuario as u WHERE c.idusuario = u.idusuario AND u.tipo_usu = 2;
Apresentar a média de idade dos usuários que possuem notas criadas no último mês e notificações não lidas - Guilherme Amarilho

select avg(idade) from (select u.nome, TIMESTAMPDIFF(YEAR, u.data_nascimento, now()) as idade from usuario as u, caderno as c, nota as nt, notificacao as nf WHERE (u.idusuario=c.cad_idusuario AND c.idcaderno=nt.not_idcaderno AND u.idusuario=nf.not_idusuario) AND (YEAR(nt.data)=YEAR(NOW()) AND MONTH(nt.data)=MONTH(NOW())) AND nf.data_leitura is null GROUP BY u.idusuario) as idade_usu
Apresentar os 10 usuário que tem a maior quantidade de lembretes criados no mês passado - Christian API

SELECT u.nome count(l.idlembrete) from usuario as u, lembrete as l where u.idusuario = l.idusuario and l.data_criacao beteew data_sub(curdate(), interval 2 month) and date_sub(curdate(), interval 1 month) grope by u.nome order by count(l.idlembrete) desc limite 10;
select u.nome, count(l.idlembrete) as quantidade from usuario as u, lembrete as l where u.idusuario=l.lem_idusuario AND (YEAR(l.data_criacao)=YEAR(NOW()) AND MONTH(l.data_criacao)=MONTH(NOW())) GROUP BY u.idusuario order by quantidade desc limit 10
Apresentar o valor médio da quantidade de notas associadas a cada categoria - Julia Schaedler

SELECT AVG(qtd) FROM (SELECT c.nome, count(n.idnota) AS qtd FROM nota AS n, nota_categoria AS nc WHERE n.idnota= nc.idnota GROUP BY nc.idcategoria) AS x
select avg(qtd) from (SELECT not_cat_idcategoria as categoria, count(not_cat_idnota) as qtd FROM evernote.nota_categoria group by not_cat_idcategoria) as quantidade
Substituir de @hotmail.com para @outlook.com em cada usuário que possuir esse tipo de email - Rafael Alan

UPDATE usuario SET email = replace(email, ‘@hotmail.com’, ‘@outlook.com’);
Aumentar uma hora, na data de alarme de todos os lembretes que seriam para despertar no dia 25/12/2019 - Bruno Pergher

UPDATE lembrete SET data_alarme = (DATE_ADD(data_alarme, INTERVAL 1 HOUR)) WHERE DATE_FORMAT(data_alarme, “%Y-%m-%d”)=“2021-11-05”;
Alterar para categoria de id 5 todas as notas criadas pelo usuário de id 22 - Rafael Bressan

UPDATE usuario as u, caderno as c, nota as n, nota_categoria as nc SET nc.not_cat_idcategoria=5 WHERE u.idusuario=c.cad_idusuario and c.idcaderno=n.not_idcaderno and n.idnota=nc.not_cat_idnota and u.idusuario=
Para as assinaturas feitas esse mês sem desconto, atualizar a coluna desconto para 20% e ajustar o valor da coluna valor.

UPDATE assinatura SET desconto=0.2, valor=valor*0.8 WHERE DATE_FORMAT(data_assinatura, “%Y-%m”)=DATE_FORMAT(NOW(), “%Y-%m”)
Deletar todas as notas do usuário de id 7

DELETE n, nt FROM usuario as u, caderno as c, nota as n, nota_categoria as nt WHERE u.idusuario=c.cad_idusuario AND c.idcaderno=n.not_idcaderno AND n.idnota=nt.not_cat_idnota AND u.idusuario=1
Deletar todos os cadernos dos usuários menores de idade

DELETE c FROM usuario as u, caderno as c WHERE u.idusuario=c.cad_idusuario AND TIMESTAMPDIFF(YEAR, u.data_nascimento, now())>=18