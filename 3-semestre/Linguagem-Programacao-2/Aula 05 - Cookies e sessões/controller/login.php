<?php
    session_start();
    $arquivo= fopen("usertxt.txt", "r+");
    if(isset($_SESSION["login"])){  // Caso ele feche o navegador e volte antes do fim da sessão
        while(! feof($arquivo)) {
            $line = fgets($arquivo);
            $dados = explode(";",$line);
            if ($dados[0] == $_SESSION['login']){
                setcookie("time",1,time() + 30, "/"); // 30 seg de sessao
                setcookie("nome",strtolower($dados[2]), time() + 30, "/");
                header("Location: /view/main.php");
                exit;        
            }
        }
    }else{
        while(! feof($arquivo)) {
            $line = fgets($arquivo);
            $dados = explode(";",$line);
            if (($dados[0] == $_POST['login']) and ($dados[1] == $_POST['password'])){
                $_SESSION["login"] = $_POST['login'];
                setcookie("time",1,time() + 30, "/"); // 5 minutos de sessao
                setcookie("nome",strtolower($dados[2]), time() + 30, "/");
                header("Location: /view/main.php");
                exit;        
            }
        }
        setcookie("log",0,time() + 60, "/");
        header("Location: /view/login.php");
    }
?>