<?php
    require('controller/controlador.php');
    $aux = controleDeSessao();
    if($aux != 1){ // Caso N Ã O tenha sessão ativa, volta para o main
        header("Location: /view/login.php");        
        setcookie("log",3,time() + 60, "/"); 
    }
    require("index.html");
    ?>
    <main>
        <h1> Bem vindo  
            <?php   
                echo strtoupper($_COOKIE["nome"]);
            ?>
        </h1>
        <h2>
            Projeto de Linguagens de programação
        </h2>
        <p> Cookies e Sessões </p>
        <p>Neste momento você possui uma sessions aberta com seu email</p>
        <p>E também, dois cookies abertos, com o tempo limite de login e seu nome</p>
        <a href="/controller/sair.php">Finalizar sessão</a>
    </main>
    </body>
</html>
