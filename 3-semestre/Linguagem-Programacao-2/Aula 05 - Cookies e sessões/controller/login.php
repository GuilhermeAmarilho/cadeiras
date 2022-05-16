<?php
    session_start();
    $arquivo= fopen("usertxt.txt", "r+");
    if(isset($_SESSION["login"])){  // Caso ele feche o navegador e volte antes do fim da sessão
        while(! feof($arquivo)) {
            $line = fgets($arquivo);
            $dados = explode(";",$line);
            if ($dados[0] == $_SESSION['login']){
                setcookie("time",1,time() + 300, "/"); // 5 min de sessao
                setcookie("nome",strtolower($dados[2]), time() + 300, "/");
                header("Location: /view/main.php");
                exit;        
            }
        }
    }else{
        // Caso ele fez login primeiramente
        while(! feof($arquivo)) {
            $line = fgets($arquivo);
            $dados = explode(";",$line);
            if (($dados[0] == $_POST['login']) and ($dados[1] == $_POST['password'])){
                $_SESSION["login"] = $_POST['login'];
                setcookie("time",1,time() + 300, "/"); // 5 minutos de sessao
                setcookie("nome",strtolower($dados[2]), time() + 300, "/");
                header("Location: /view/main.php");  // Caso ele possua login e senha válidos, seta a sessão dele, e os cookies
                exit;        
            }
        }
        // Caso tenha errado senha ou login
        setcookie("log",0,time() + 60, "/");
        header("Location: /view/login.php");
    }
?>