<?php
    session_start();
    unset($_SESSION['login']);
    unset($_COOKIE['nome']);
    unset($_COOKIE['time']);
    header("Location: /view/login.php");
?>