<?php
    $visita = [$_COOKIE['eletrodomestico'],$_COOKIE['roupa'],$_COOKIE['celular'],$_COOKIE['periferico']];
    $setor = ['eletrodomestico','roupa','celular','periferico'];
    $i = 0;
    $maior = 0;
    $indice = 0;
    while($i < 4){
        if($visita[$i] > $maior){
            $maior = $visita[$i];
            $indice = $i;
        }
        $i++;
    }
    $produto = [$setor[$indice],rand(0,3)];
?>
<main>
<p class="title">Oferta mais interessante<p>
    <div class="products">
        <div class="product">
            <h1 class="title"> <?php echo $_SESSION[ $produto[0] ][ $produto[1] ]['nome']; ?> </h1>
            <img src="<?php echo $_SESSION[$produto[0]][$produto[1]]['img']; ?>" alt="imagem">
            <p>Valor: <?php echo $_SESSION[$produto[0]][$produto[1]]['valor']; ?> </p>
            <a href="../controller/modificaCookie.php?session=<?php echo $produto[0] ?>">Adicionar</a>
        </div>
    </div>
</main>