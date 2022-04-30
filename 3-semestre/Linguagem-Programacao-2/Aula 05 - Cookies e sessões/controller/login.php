<?php
    
    // $_COOKIE['login'] = $_POST['login'];

    setcookie("login", $_POST['login'], time()+3600);

    $login = $_COOKIE['login'];

    print_r($login);
?>