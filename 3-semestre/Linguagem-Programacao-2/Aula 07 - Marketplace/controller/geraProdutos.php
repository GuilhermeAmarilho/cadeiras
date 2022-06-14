<?php
    $i = 0;
    $produtos = [];
    $history = "";
    while ($i < 3){
        $category = rand(0,3);
        $product = rand(0,3);
        $rand = strval($category)."-".strval($product).";";
        if(strpos($history, $category.'-'.$product) === false){
            $history = $history.($rand);
            if($category == 0)
                array_push($produtos, ['eletrodomestico',$product]);
            if($category == 1)
                array_push($produtos, ['roupa',$product]);
            if($category == 2)
                array_push($produtos, ['celular',$product]);
            if($category == 3)
                array_push($produtos, ['periferico',$product]);
            $i++;
            }
    }
?>
<main>
    <p class="title">Produtos que podem lhe interessar<p>
    <div class="products">
        <div class="product">
            <h1 class="title"> <?php echo $_SESSION[$produtos[0][0]][$produtos[0][1]]['nome']; ?> </h1>
            <img src="<?php echo $_SESSION[$produtos[0][0]][$produtos[0][1]]['img']; ?>" alt="imagem">
            <p>Valor: <?php echo $_SESSION[$produtos[0][0]][$produtos[0][1]]['valor']; ?> </p>
            <a href="../controller/modificaCookie.php?session=<?php echo $produtos[0][0] ?>">Adicionar</a>
        </div>
        <div class="product">
            <h1 class="title"> <?php echo $_SESSION[$produtos[1][0]][$produtos[1][1]]['nome']; ?> </h1>
            <img src="<?php echo $_SESSION[$produtos[1][0]][$produtos[1][1]]['img']; ?>" alt="imagem">
            <p>Valor: <?php echo $_SESSION[$produtos[1][0]][$produtos[1][1]]['valor']; ?> </p>
            <a href="../controller/modificaCookie.php?session=<?php echo $produtos[1][0] ?>">Adicionar</a>
        </div>
        <div class="product">
            <h1 class="title"> <?php echo $_SESSION[$produtos[2][0]][$produtos[2][1]]['nome']; ?> </h1>
            <img src="<?php echo $_SESSION[$produtos[2][0]][$produtos[2][1]]['img']; ?>" alt="imagem">
            <p>Valor: <?php echo $_SESSION[$produtos[2][0]][$produtos[2][1]]['valor']; ?> </p>
            <a href="../controller/modificaCookie.php?session=<?php echo $produtos[2][0] ?>">Adicionar</a>
        </div>
    </div>
</main>