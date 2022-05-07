<?php
    session_start();
    if(!isset($_COOKIE['time'])){
        unset($_SESSION['login"']);
    }
    echo "login feito!";
    print_r($_COOKIE);
    print_r($_SESSION["login"]." = login feito");
?>