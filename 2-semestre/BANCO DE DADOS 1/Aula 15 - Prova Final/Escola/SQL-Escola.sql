-- 1 - Inserir os registros abaixo
-- Maria da Silva, mariasilva@gmail.com, 25/09/1992, 016.453.123_89 participante da turma de nome CC-1-Fase do ano de 2019 do curso de Bacharelado em Ciência da Computação
-- Inserir para a aluna Maria da Silva a nota 8.7 na avaliação chamada Prova Final na disciplina de Banco de Dados I do curso Bacharelado em Ciência da Computação

insert into tipocurso (nome) values ("bacharelado");
insert into curso (nome, idtipocurso) values ("Ciência da Computação", 1);
insert into turma (nome, ano, idcurso) values ("CC-1-Fase", 2019, 1);
insert into aluno (nome, email, data_nascimento, cpf, idturma) values ("Maria da Silva", "mariasilva@gmail.com", "1992-09-25", "016.453.123_89", 1);

insert into disciplina (nome, idturma, qtdavaliacoes) values ("Banco de Dados 1", 1, 10);
insert into avalicao (nome, iddisciplina, data) values ("Prova Final", 1, current_date());
insert into nota (idaluno, idavaliacao, valor) values (1,1,8.7);

-- 2 - Selecionar todos os alunos do curso de Ciência da computação

SELECT * FROM aluno a, turma t, curso c where a.idturma = t.idturma and t.idcurso = c.idcurso and c.nome = "Ciência da computação";

-- 3 - Selecione todos os alunos que estejam matriculados em cursos técnicos de nível médio e sejam maiores de idade

SELECT * FROM aluno a, turma t, curso c, tipocurso tc
where a.idturma = t.idturma 
	and t.idcurso = c.idcurso 
    and c.idtipocurso = tc.idtipocurso
    and tc.nome = "técnicos de nível médio"
    and timestampdiff(YEAR, a.data_nascimento, now()) > 17;

-- 4 - Apresentar as notas obtidas pelo aluno de id 3 na disciplina de linguagem de programação II

SELECT valor FROM aluno a, turma t, disciplina d, avalicao av, nota n
where a.idturma = t.idturma 
	and t.idturma = d.idturma
    and d.iddisciplina = av.iddisciplina 
    and av.idavalicao = n.idavaliacao
    and d.nome = "linguagem de programação II"
    and a.idaluno = 3;

-- 5 -  Calcular a média das notas cadastradas para os alunos matriculados na disciplina de Web Design, excluindo a nota obtida no exame

SELECT avg(valor) FROM aluno a, turma t, disciplina d, avalicao av, nota n
where a.idturma = t.idturma 
	and t.idturma = d.idturma
    and d.iddisciplina = av.iddisciplina 
    and av.idavalicao = n.idavaliacao
	and d.nome = "Web Design"
	and av.nome != "exame";

-- 6 - Apresentar os alunos que possuem as três maiores médias na disciplina de web design

SELECT a.nome , avg(n.valor) as media FROM aluno a, turma t, disciplina d, avalicao av, nota n
where a.idturma = t.idturma 
	and t.idturma = d.idturma
    and d.iddisciplina = av.iddisciplina 
    and av.idavalicao = n.idavaliacao
    and n.idaluno = a.idaluno
	and d.nome = "Web Design"
    group by n.idaluno
    order by n.valor desc
    limit 3;

-- 7 - Listar os 3 alunos que obtiveram as maiores notas na avaliação de id 5

SELECT * FROM aluno a, turma t, disciplina d, avalicao av, nota n
where a.idturma = t.idturma 
	and t.idturma = d.idturma
    and d.iddisciplina = av.iddisciplina 
    and av.idavalicao = n.idavaliacao
    and n.idaluno = a.idaluno
    and av.idavalicao = 5
    order by n.valor desc
    limit 3;

-- 8 - Apresentar as turmas com maior quantidade de alunos com notas abaixo de 7

SELECT t.nome ,count(t.nome) as numeroAlunos FROM aluno a, avalicao av, nota n, disciplina d, turma t, curso c
where a.idaluno = n.idaluno
and av.idavalicao = n.idavaliacao
and d.iddisciplina = av.iddisciplina
and d.idturma = t.idturma
and c.idcurso = t.idcurso
and n.valor < 7
group by t.idturma
order by numeroAlunos desc;

-- 9 -  A apresentar a média da quantidade de notificações não lida (utilizar valor NULL como referência) que cada aluno tem no sistema

SELECT avg(count(a.idaluno)) as MediaNotificacoesTurma FROM aluno a, notificacao n
where a.idaluno = n.idaluno
and n.data_leitura = NULL
group by a.idaluno;

-- 10 - Listar as 5 disciplinas com média de nota mais alta

SELECT d.nome , avg(n.valor) as Notas FROM avalicao a, nota n, disciplina d
where d.iddisciplina = a.iddisciplina and a.idavalicao = n.idavaliacao
group by d.iddisciplina
order by Notas desc
limit 5;

-- 11 - Deletar todas as notas obtidas em exames pelo aluno de id 4

DELETE n FROM nota n 
INNER JOIN avalicao av 
    ON n.idavaliacao = av.idavalicao
WHERE av.nome = "exame" 
    AND n.idaluno = 4; 

-- 12 -  Excluir todos os usuários que pertençam a turma CC-4-FASE

DELETE a FROM aluno a 
INNER JOIN turma t 
    ON a.idturma = t.idturma 
WHERE t.nome = "CC-4-FASE";

-- 13 - Alterar todas as notas obtidas nos exames de 5.9 para 6

UPDATE nota n 
INNER JOIN avalicao a 
	ON n.idavaliacao = a.idavalicao 
SET n.valor = 6 
WHERE n.valor = 5.9 
AND a.nome = "exame"; 

-- 14 - Alterar o nome da turma do aluno de id 1 para CC-1-FASE

UPDATE turma t 
INNER JOIN aluno a 
    ON t.idturma = a.idturma
SET t.nome = " CC-1-FASEEEE"
WHERE a.idaluno = 1

-- 15 - Alterar os cpf que foram cadastrados com _ (underline) para traço

UPDATE aluno a SET a.cpf = Replace(a.cpf,"_","-");
