<?php
    // 0 = Tempo de sessão exgotado
    // 1 = Em sessão ativa
    // 2 = Sem sessão ativa
    session_start();
    function controleDeSessao(){
        if(isset($_SESSION["login"])){ // Caso exista sessão, manda para o tratamento de login no controller
            if(!isset($_COOKIE["time"])){ // Caso tenha expirado tempo limite
                unset($_SESSION["login"]);
                unset($_COOKIE["time"]);
                return 0;
            }else{
                return 1;
            }
        }else{
            unset($_COOKIE["nome"]);
            unset($_COOKIE["time"]);
            return 2;
        }
    }
?>