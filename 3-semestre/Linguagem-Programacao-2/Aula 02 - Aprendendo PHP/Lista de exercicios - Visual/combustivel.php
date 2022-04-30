<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style.css">
    <title>Combustivel</title>
</head>
<body>
    <header>
        <div class="logo">
            <img src="img/logo_white.png" alt="" class="nav__logo-img">
            <a href="index.html">Amarilho's</a>
        </div>
        <nav>
            <ul>
                <li><a href="combustivel.php">Combustivel</a></li>
                <li><a href="exercicio1.php">Exercicio 1</a></li>
                <li><a href="exercicio2.php"">Exercicio 2</a></li>
                <li><a href="exercicio3.php"">Exercicio 3</a></li>
                <li><a href="exercicio4.php"">Exercicio 4</a></li>
                <li><a href="exercicio5.php"">Exercicio 5</a></li>
            </ul>
        </nav>
    </header>
    <form action="php/combustivelConfig.php" class="form" method="POST">
        <h1 class="form">Dados dos combustiveis</h1>
        <label for="gasolinaValor" class="form">Informe o valor da gasolina</label>
        <input type="number" name="gasolinaValor" required class="form">
        <label for="gasolinaRendimento" class="form">Informe o rendimento da gasolina</label>
        <input type="number" name="gasolinaRendimento" required class="form">
        <label for="alcoolValor" class="form">Informe o valor do alcool</label>
        <input type="number" name="alcoolValor" required class="form">
        <label for="alcoolRendimento" class="form">Informe o rendimento do alcool</label>
        <input type="number" name="alcoolRendimento" required class="form">   
        <button type="submit" class="form">Enviar!</button>
    </form>
    <?php
        if(isset($_GET['result'])){
            
        }
    ?>
</body>
</html>