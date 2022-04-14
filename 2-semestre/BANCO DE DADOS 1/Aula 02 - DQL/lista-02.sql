1)
SELECT * FROM `produto` WHERE 1;

2)
SELECT * FROM `produto` WHERE categoria = 'cereais';

3)
SELECT * FROM `produto` WHERE estoque < 1;

4)
SELECT * FROM `produto` WHERE idproduto % 2 = 0

5)
SELECT * FROM `produto` WHERE estoque > 1 and valor_venda > 17;

6)
SELECT * FROM `produto` WHERE ( valor_compra > 8 and valor_compra <10);

SELECT * FROM `produto` WHERE valor_compra BETWEEN 8 
and 10;

7)
SELECT * FROM `produto` WHERE (categoria = 'cereais' or categoria = 'biscoitos') and (valor_venda BETWEEN 20 and 30);

8)
SELECT * FROM `produto` WHERE nome LIKE '%chocolate'

9)
SELECT * FROM `produto` WHERE nome LIKE '%Margarina%' and estoque > 0;

10)
SELECT * FROM `produto` WHERE data_cadastro >= '2018-03-17' and data_cadastro <= '2018-03-25';

SELECT * FROM `produto` WHERE data_cadastro BETWEEN '2018-03-17' and '2018-03-25';

11)
SELECT categoria FROM `produto` WHERE 1;

12)
SELECT * FROM `produto` WHERE (valor_venda * 0.5) > 15;

13)
SELECT * FROM `produto` WHERE data_cadastro = '2018-03-18';

14)
SELECT * FROM `produto` WHERE (estoque + 2) > 8;

15)
SELECT * FROM `produto` WHERE categoria = 'cereais' or estoque < 1;

