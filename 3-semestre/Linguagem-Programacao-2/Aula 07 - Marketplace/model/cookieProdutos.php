<?php
    $date = new DateTime("now", new DateTimeZone('America/Sao_Paulo') );
    setcookie("eletrodomestico", 0, time()+3600*24, "/");
    setcookie("roupa", 0, time()+3600*24, "/");
    setcookie("celular", 0, time()+3600*24, "/");
    setcookie("periferico", 0, time()+3600*24, "/");

    setcookie("dataeletrodomestico", $date->format('d/m/y H:i'), time()+3600*24, "/");
    setcookie("dataroupa", $date->format('d/m/y H:i'), time()+3600*24, "/");
    setcookie("datacelular", $date->format('d/m/y H:i'), time()+3600*24, "/");
    setcookie("dataperiferico", $date->format('d/m/y H:i'), time()+3600*24, "/");
?>