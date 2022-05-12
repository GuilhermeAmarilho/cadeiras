<?php
    session_start();
    if(!isset($_COOKIE['time'])){
        unset($_SESSION['login"']);
        unset($_COOKIE["nome"]);
        header("Location: /view/login.php");
        exit;
    }
    require('index.html');
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
