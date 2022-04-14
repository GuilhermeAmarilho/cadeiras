<?php
    //Escreva um programa que leia n números (sendo n introduzido pelo utilizador) e indique se os números são todos iguais.

    $inicial = readline("Informe o valor inicial: ");
    $qt = readline("Total de vezes: ");
    $igualdade = true;
    for($i = 0; $i < $qt; $i++){
        $aux = readline("Informe o próximo valor: ");
        if($aux != $inicial){
            $igualdade = false;
        }
    }
    if($igualdade){
        echo "Os valores informados são todos iguais";
    }else{
        echo "Dentre os valores informados, há valores diferentes";
    }
?>