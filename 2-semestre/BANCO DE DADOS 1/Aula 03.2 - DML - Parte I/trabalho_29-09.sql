1)
a)
INSERT INTO `produto`(`idproduto`, `nome`, `categoria`, `valor_compra`, `valor_venda`, `estoque`, `data_cadastro`, `data_vencimento`, `fabricante`) VALUES (9, 'Bolacha água e sal', 'biscoitos', 2.8, 3.8, 5, '2018-07-06', '2019-06-11', 'Mabel');
b)
INSERT INTO `produto`(`idproduto`, `nome`, `categoria`, `valor_compra`, `valor_venda`, `estoque`, `data_cadastro`, `data_vencimento`, `fabricante`) VALUES (10, 'Suco de uva integral', 'bebidas', 7, 9.7, 8, '2018-05-16', '2020-03-02', 'Serra');
c)
INSERT INTO `produto`(`idproduto`, `nome`, `categoria`, `valor_compra`, `valor_venda`, `estoque`, `data_cadastro`, `data_vencimento`, `fabricante`) VALUES (11, 'Café torrado', 'bebidas', 4, 5.5, 12, '2018-08-21', '2021-03-12', 'Pilão');
d)
INSERT INTO `produto`(`idproduto`, `nome`, `categoria`, `valor_compra`, `valor_venda`, `estoque`, `data_cadastro`, `data_vencimento`, `fabricante`) VALUES (12, 'Cha mate torrado', 'bebidas', 1.6, 2.5, 6, '2018-08-04', '2020-06-25', 'Otto');
e)
INSERT INTO `produto`(`idproduto`, `nome`, `categoria`, `valor_compra`, `valor_venda`, `estoque`, `data_cadastro`, `data_vencimento`, `fabricante`) VALUES (13, 'Páprica doce', 'temperos vermelhos', 1.2, 2.1, 3, '2018-10-08', '2020-05-08', 'Ilfo');
f)
INSERT INTO `produto`(`idproduto`, `nome`, `categoria`, `valor_compra`, `valor_venda`, `estoque`, `data_cadastro`, `data_vencimento`, `fabricante`) VALUES (14, 'Açafrão', 'temperos amarelos', 2.7, 3.5, 3, '2018-08-04', '2019-12-12', 'Ilfo');

2)
UPDATE `produto` SET valor_compra = 4.99 where valor_compra = 5;

3)
UPDATE `produto` SET valor_venda = (valor_venda - valor_venda * 0.15) where valor_compra < 10;

4)
UPDATE `produto` SET estoque = 3 where idproduto = 10;

5)
UPDATE `produto` SET estoque = 3, data_cadastro = CURDATE(), data_vencimento = date_add(CURDATE(), interval 2 year) WHERE estoque = 3;

6)
UPDATE `produto` SET categoria = 'derivados de leite' WHERE categoria = 'laticinios';

7)
SELECT REPLACE(nome,'ã','á') FROM produto WHERE idproduto = 9 OR idproduto = 12;


8)
UPDATE `produto` SET categoria = 'temperos' WHERE categoria LIKE "%temperos%";

9)
SELECT REPLACE (nome, 'integral', 'natural') FROM produto;

10)
UPDATE `produto` SET data_cadastro = date_add(data_cadastro, interval 1 month) WHERE (DAY(data_cadastro) = '04' AND MONTH(data_cadastro) = '08');

11)
SELECT REPLACE (fabricante, 'Ilfo', 'Elfo') FROM produto;

12)
DELETE FROM `produto` WHERE categoria = 'bebidas';

13)
DELETE FROM `produto` WHERE data_cadastro > '2018-03-15' AND categoria = 'biscoitos';

14)
DELETE FROM `produto` WHERE fabricante = 'Nestle' OR fabricante = 'Yoki';
