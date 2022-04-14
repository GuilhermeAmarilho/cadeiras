1)
SELECT * FROM produto WHERE categoria in ('cereais','biscoitos'); 

2)
SELECT * FROM produto WHERE data_cadastro in ('2018-03-12','2018-03-17'); 

3)
SELECT * FROM produto ORDER BY valor_venda DESC LIMIT 2;

4)
SELECT valor_venda FROM produto WHERE categoria = 'cereais' ORDER BY valor_venda DESC LIMIT 2,1;

5)
SELECT * FROM produto ORDER BY data_cadastro LIMIT 1;

6)
SELECT * FROM produto ORDER BY valor_venda DESC LIMIT 3;

7)
SELECT * FROM produto ORDER BY data_vencimento ASC LIMIT 1;

8)
SELECT sum(estoque) as Estoque_Total FROM produto WHERE categoria = 'biscoitos';

9)
SELECT SUM(estoque) as Estoque_Total FROM produto WHERE nome LIKE 'Margarina%';

10)
SELECT AVG(valor_venda) AS Media_valor FROM produto WHERE nome LIKE '%aveia%';

11)
SELECT AVG(valor_venda) AS Media_valor FROM produto WHERE categoria = 'laticinios';