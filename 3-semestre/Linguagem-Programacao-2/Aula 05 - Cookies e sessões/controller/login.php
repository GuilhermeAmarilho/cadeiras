<?php
    session_start();
    $arquivo= fopen("usertxt.txt", "rw");
    while(! feof($arquivo)) {
        $line = fgets($arquivo);
        $dados = explode(";",$line);
        if (($dados[0] == $_POST['login']) and ($dados[1] == $_POST['password'])){
            
        
            $_SESSION["login"] = $_POST['login'];
            setcookie("time",1,time() + 10, "/");
            
            header("Location: /view/main.php");
            exit;        
        }
    }

    
    setcookie("log",0,time() + 3600, "/");
    header("Location: /view/login.php");
    

    $_COOKIE['login'] = $_POST['login'];
    setcookie("login", $_POST['login'], time()+3600);

    $login = $_COOKIE['login'];

?>