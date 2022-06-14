<?php
    $date = new DateTime("now", new DateTimeZone('America/Sao_Paulo') );
    $produto = $_GET['session'];
    setcookie($produto, ($_COOKIE[$produto][0] + 1), time()+3600*24, "/");
    setcookie('data'.$produto, $date->format('d/m/y H:i'), time()+3600*24, "/");
    header("Location: ../view/main.php");
?>