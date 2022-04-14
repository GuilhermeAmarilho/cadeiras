<?php
    //  Escreva um programa para imprimir os números inteiros entre 1 e 10 na mesma linha, primeiro em ordem crescente e depois em ordem decrescente.

    function crescente(int $tam){
        for($i = 1; $i <= $tam; $i++){
            echo $i;
            echo '<br>';
        }
        echo '<br>';
    }
    function decrescente(int $tam){
        for($i = $tam; $i > 0; $i--){
            echo $i;
            echo '<br>';
        }
        echo '<br>';
    }
    crescente(5);
    decrescente(10);
?>