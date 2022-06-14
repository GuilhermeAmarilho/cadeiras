<?php
    session_start();
    $i = 0; // caso queira resetar i = 1;
    
    if($i == 1){ // Reset
        unset($_SESSION['eletrodomestico']);
        unset($_SESSION['roupa']);
        unset($_SESSION['celular']);
        unset($_SESSION['periferico']);

        unset($_COOKIE['eletrodomestico']);
        unset($_COOKIE['roupa']);
        unset($_COOKIE['celular']);
        unset($_COOKIE['periferico']);

        unset($_COOKIE['dataeletrodomestico']);
        unset($_COOKIE['dataroupa']);
        unset($_COOKIE['datacelular']);
        unset($_COOKIE['dataperiferico']);
    }
    
    if(!isset($_SESSION['eletrodomestico'])){
        require("model/sessionProdutos.php");
    }
    if(!isset($_COOKIE['eletrodomestico'])){
        require("model/cookieProdutos.php");
    }
    header("Location: view/main.php")
?> 