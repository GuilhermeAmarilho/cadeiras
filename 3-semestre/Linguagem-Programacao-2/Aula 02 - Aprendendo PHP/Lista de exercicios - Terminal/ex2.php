<?php
    //Escreva um programa que peça ao utilizador um nome e um número inteiro (entre 1 e 20). Deverá mostrar esse nome um número de vezes igual a esse valor inteiro.
    $nome = readline("Informe o nome: ");
    $qt = readline("Quantidade de vezes: ");

    for ($i = 0; $i < $qt; $i++){
        echo($nome."\n");
    }
?>