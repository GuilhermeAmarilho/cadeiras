# Projeto Final - Linguagem de Programação 2

## Informações do projeto.

### Sistema de apresentação de projetos de forma simples.
- Desenvolvido em PHP
- Usando o padrão MVC
- Projeto Final da disciplina de Linguagens de Programação 2
  - Aluno: Guilherme Amarilho
  - Professor: Fabricio Bizotto
- Modelo ER do projeto [aqui](https://github.com/GuilhermeAmarilho/ProjetoFinal-LP2/blob/master/getStart/ER.png).
- Descrição 
  
### Como iniciar
- Para iniciar o projeto, rode 
  > php -S localhost:80 -t .\Public\
- É necessário fazer a seguinte configuração: 
  - Variáveis do banco, no arquivo Database.php
    - Localizado em /Application/core/Database.php
  - Criar as tabelas no banco de dados
    - Localizado em /getStart/SQL-Script.sql

### Funcionalidades
- Inicio -> rota  = "/";
- Usuarios
  - Listar Usuários -> rota = "/user/index";
  - Adicionar Usuários -> rota = "/user/insert";
  - Buscar Usuários -> rota = "/user/show";
  - Alterar Usuários -> rota = "/user/alter";
- Projetos
  - Listar Projetos -> rota = "/project/index";
  - Adicionar Projetos -> rota = "/project/insert";
  - Buscar Projetos -> rota = "/project/show";
  - Alterar Projetos -> rota = "/project/alter";
