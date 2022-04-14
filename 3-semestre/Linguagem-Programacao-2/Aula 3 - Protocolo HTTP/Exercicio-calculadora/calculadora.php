<?php
    $first = $_POST['first'];
    $second = $_POST['second'];
    $operation = $_POST['operation'];
    $result;
    switch($operation){
        case '+': $result = intval($first) + intval($second);break;
        case '-': $result = intval($first) - intval($second);break;
        case 'x': $result = intval($first) * intval($second);break;
        case ':': $result = intval($first) / intval($second);break; 
    }
    $string = " ".$first." ".$operation." ".$second." = ".$result." ";
    header('Location: http://localhost:80/index.php?string='.$string);
?>