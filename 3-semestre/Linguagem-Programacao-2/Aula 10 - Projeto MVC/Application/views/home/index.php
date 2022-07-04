<main>
    <h1>
        Projeto 3 - LP2
    </h1>
    <div class="content">
        <h2>
            Sistema de gerenciamento básico de projetos
        </h2>
        <ul>
            <li>
                Desenvolvido em PHP
            </li>
            <li>
                Usando o padrão MVC
            </li>
            <li>
                <strong><a href="https://alexandrebbarbosa.wordpress.com/2018/06/28/phpcrud-com-mvc/">Projeto</a></strong> baseado em um sistema MVC criado por Alexandre B Barbosa.
            </li>
        </ul>
    </div>
    <div class="content">
        <h2>Como funciona</h2>
        <ul>
            <li>
                Inicio 	&#8594 rota : "/"
            </li>
            <li>Usuários</li>    
            <li>
                <ul>
                    <li>
                            Listar Usuários &#8594 rota: "/user/index"
                    </li>
                    <li>
                        Adicionar Usuários &#8594 rota: "/user/insert"
                    </li>
                    <li>
                        Buscar Usuários &#8594 rota: "/user/show"
                    </li>
                    <li>
                        Alterar Usuários &#8594 rota: "/user/alter"
                    </li>
                </ul>
            </li>
            <li>Projetos</li>
            <li>
                <ul>
                    <li>
                        Listar Projetos &#8594 rota: "/project/index"
                    </li>
                    <li>
                        Adicionar Projetos &#8594 rota: "/project/insert"
                    </li>
                    <li>
                        Buscar Projetos &#8594 rota: "/project/show"
                    </li>
                    <li>
                        Alterar Projetos &#8594 rota: "/project/alter"
                    </li>
                </ul>
            </li>
        </ul>
    </div>
    <div class="content">
        <h2>Como iniciar</h2>
        <ul>
            <li>
                Para iniciar o projeto, rode : 
                <strong>
                    php -S localhost:80 -t .\Public\
                </strong>
            </li>
            <li>
                É necessário fazer a seguinte configuração: 
            </li>
            <li>
                Variáveis do banco, no arquivo Database.php
                <strong>
                    Localizado em /Application/core/Database.php
                </strong>
            </li>
            <li>
                Criar as tabelas no banco de dados
                <strong>
                    Localizado em /getStart/SQL-Script.sql
                </strong>
            </li>
        </ul>
    </div>


</main>