<?php
    session_start();
    $arquivo= fopen("usertxt.txt", "a+");
    $aux = 0; // Caso vire 1, significa que já tem esse email cadastrado
    while(! feof($arquivo)) {
        $line = fgets($arquivo);
        $dados = explode(";",$line);
        if (($dados[0] == $_POST['login'])){
            $aux = 1;
            setcookie("log",1,time() + 60, "/"); // 60 seg ativa a msg
            header("Location: /view/cadastro.php");
        }
    }
    if( $aux == 0){ // Caso não exista ainda, ele insere no arquivo
        $str = strtolower($_POST['login']).";".strtolower($_POST['password']).";".strtolower($_POST['nome']); // Armazena no formato - login;password;name
        fwrite($arquivo, $str."\n");
        $_SESSION["login"] = $_POST['login'];
        setcookie("time",1,time() + 300, "/"); // fica on por 5 min
        setcookie("nome",strtolower($_POST['nome']), time() + 300, "/");
        header("Location: /view/cadastro.php");
    }
?>