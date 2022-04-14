<?php
    $valor = 1;
    $fat = readline("Informe o fatorial: ");

    for($i = 1; $i <= $fat; $i++){
        $valor = $valor * $i;
    }
    
    echo "O fatorial de ".$fat." é: ".$valor;

?>