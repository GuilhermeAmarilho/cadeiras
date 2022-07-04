# Projeto 3 - LP2

## Enunciado do projeto

> Utilize o artigo [Construindo um simples framework MVC com PHP](https://medium.com/@jardelgoncalves/construindo-um-simples-framework-mvc-com-php-349e9cacbeb1) para criar o seu próprio Framework MVC.
> 
> Parte teórica: O aluno precisa escrever um texto explicando o que cada arquivo/classe faz e quais os benefícios e problemas o framework criado pelo autor possui.
>
> Parte prática: O aluno precisa desenvolver o seu framework, conforme as orientações presentes no artigo. Em seguida:
>
> - Criar outra tabela no banco de dados (ex: lista de tarefas)
> - Criar os arquivos necessários para listar as tarefas, seguindo o padrão MVC
> - (opcional) Criar um formulário para cadastrar as os dados no banco de dados
>
> Publique seu trabalho (parte prática) no GITHUB e envie o link do repositório nesta tarefa.

### Projeto MVC

#### Este projeto possui a divisão em duas pastas distintas.

- Public

    A Public é a pasta que o usuário tem acesso, nela que está o arquivo `index.php` que inicia a aplicação `App()`, e também possui os arquivos que tem comunicação direta com o navegador, que são as imagens e o arquivo `style.css`

- Application

    Na application temos os arquivos do programa que serão executados com base na rota do navegador.

    Dentro do Application temos o `Autoload.php` que faz a importação de códigos de forma fácil, usando `namespace` para definir o nome que será chamado um arquivo em `use` para utilizar este arquivo em outro arquivo. 

#### Além disso, a Application é dividída em quatro partes fundamentais onde estão os arquivos, que são:

- Core

    No Core, temos os arquivos que serão rodados no começo da aplicação, que são:

  - Database.php

    Aqui é definido os parâmetros que serão utilizados para fazer a conexão com o banco de dados, além de definir a principal função que será extendida nas Models, que é o comando executeQuery, que irá mandar ao banco a query criada. Neste projeto foi utilizado o banco de dados PostgreSQL.

  - Controller.php
    
    O arquivo Controller.php é a classe criada apenas para instanciar os métodos em comuns para os Controllers das classes, estes possuem os métodos `Classe->Model` e `Classe->View`, que irão trazer as respectivas Models e Views necessárias.

  - App.php

    Este arquivo traça os controles, metodos e parâmetros que serão utilizados com base na URL do programa. e com isso chama o controller necessário.

- Model

    Neste arquivo fica as Queryes que serão executadas no banco, além de definir os parâmetros que serão necessários para roda-las.

- View 

    Onde estão armazenados frames de códigos html em conjunto com informações que virão de Controller, para criar a parte visual para o Usuário.

    A view é dividida em pastas, que representam cada uma das controllers/models.
    
- Controller

    Aqui ficam os arquivos que definem o que deve acontecer quando é acessada determinada rota. Também é responsável por fazer a comunicação com a Model, e levar os resultados da mesma para ser exibida na View.

    No controller, temos as seguintes operações: 

    - Index
  
        No Index é listado todas as linhas da tabela em questão.

    - Delete
  
        O Delete é passado com um parâmetro como base, que é o id a ser removido, após a remoção, ele retorna para a lista de itens. Além disso, o método utilizado para passar o parâmetro é o GET.

    - Find, Insert e Update
  
        Estes métodos foram feitos apenas para chamar uma view com um formulário,.que definirá dados que irá ser posteriormente serão repassados ao banco

    - Show, InsertValue e UpdateValue

        Já estes métodos são responsáveis por inserir os dados que vieram do formulário na tabela, e caso condizente, retornar alguma coisa.

    - RemoverTodos

        E por fim, temos um comando que limpa a tabela.

## Informações do projeto.

### Sistema de apresentação de projetos de forma simples.
- Desenvolvido em PHP
- Usando o padrão MVC
- [Projeto](https://medium.com/@jardelgoncalves/construindo-um-simples-framework-mvc-com-php-349e9cacbeb1) baseado em um sistema MVC criado por Jardel Gonçalves.

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

### Como iniciar
- Para iniciar o projeto, rode 
  > php -S localhost:80 -t .\Public\
- É necessário fazer a seguinte configuração: 
  - Variáveis do banco, no arquivo Database.php
    - Localizado em /Application/core/Database.php
  - Criar as tabelas no banco de dados
    - Localizado em /getStart/SQL-Script.sql