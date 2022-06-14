<?php
    $i = 0;
    $produtos = [];
    $history = "";
    while ($i < 3){
        $category = rand(0,3);
        $product = rand(0,3);
        $rand = strval($category)."-".strval($product)." ";
        if(strpos($history, $rand) == false){
            $history = $history.($rand);
            if($category == 0)
                array_push($produtos, ['eletrodomestico',$product]);
            if($category == 1)
                array_push($produtos, ['roupa',$product]);
            if($category == 2)
                array_push($produtos, ['celular',$product]);
            if($category == 3)
                array_push($produtos, ['periferico',$product]);
        }
        $i++;
    }
?>