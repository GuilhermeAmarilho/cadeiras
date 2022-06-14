<?php
    session_start();
    require('index.html');
    $produto = $_GET['produto'];
?>
<main>
    <p class="title"><?php echo $produto ?><p>
    <div class="products">
        <div class="product">
            <h1 class="title"> <?php echo $_SESSION[$produto][0]['nome']; ?> </h1>
            <img src="<?php echo $_SESSION[$produto][0]['img']; ?>" alt="imagem">
            <p>Valor: <?php echo $_SESSION[$produto][0]['valor']; ?> </p>
            <a href="../controller/modificaCookie.php?session=<?php echo $produto; ?>">Adicionar</a>
        </div>
        <div class="product">
            <h1 class="title"> <?php echo $_SESSION[$produto][1]['nome']; ?> </h1>
            <img src="<?php echo $_SESSION[$produto][1]['img']; ?>" alt="imagem">
            <p>Valor: <?php echo $_SESSION[$produto][1]['valor']; ?> </p>
            <a href="../controller/modificaCookie.php?session=<?php echo $produto; ?>">Adicionar</a>
        </div>
        <div class="product">
            <h1 class="title"> <?php echo $_SESSION[$produto][2]['nome']; ?> </h1>
            <img src="<?php echo $_SESSION[$produto][2]['img']; ?>" alt="imagem">
            <p>Valor: <?php echo $_SESSION[$produto][2]['valor']; ?> </p>
            <a href="../controller/modificaCookie.php?session=<?php echo $produto; ?>">Adicionar</a>
        </div>
        <div class="product">
            <h1 class="title"> <?php echo $_SESSION[$produto][3]['nome']; ?> </h1>
            <img src="<?php echo $_SESSION[$produto][3]['img']; ?>" alt="imagem">
            <p>Valor: <?php echo $_SESSION[$produto][3]['valor']; ?> </p>
            <a href="../controller/modificaCookie.php?session=<?php echo $produto; ?>">Adicionar</a>
        </div>
    </div>
</main>
<?php
    require("footer.html");
?>