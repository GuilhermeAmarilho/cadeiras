<?php
    // Escreva um programa para imprimir todos os números inteiros entre dois valores introduzidos pelo utilizador. O programa deverá verificar qual dos dois valores é o maior.

    $maior = readline("Informe o primeiro valor: ");
    $aux = readline("Informe o segundo valor: ");
    if($maior >= $aux){
        $menor = $aux;
    }else{
        $menor = $maior;
        $maior = $aux;
    }
    for ($i = $menor; $i <= $maior; $i++){
        if($i%2==0){
            echo $i." é um valor que está entre ".$menor." e ".$maior."\n";
        }
    }
    
?>