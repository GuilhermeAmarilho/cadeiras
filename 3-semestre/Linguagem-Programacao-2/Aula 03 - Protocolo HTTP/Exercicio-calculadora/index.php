<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="stylesheet" href="assets/style.css"">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Calculadora</title>
</head>
<body>
    <main>
        <form action="calculadora.php" method="post">
            <h2>
                <?php
                    if(isset($_GET['string'])){
                        echo($_GET['string']);
                    }
                ?>
            </h2>
            <div class="buttons">
                <div class="numeros">
                    <p id="v1">1</p>
                    <p id="v2">2</p>
                    <p id="v3">3</p>
                    <p id="v4">4</p>
                    <p id="v5">5</p>
                    <p id="v6">6</p>
                    <p id="v7">7</p>
                    <p id="v8">8</p>
                    <p id="v9">9</p>
                </div>
                <div class="operadores">
                    <p id="sum">+</p>
                    <p id="sub">-</p>
                    <p id="mul">x</p>
                    <p id="div">:</p>
                    <p id="clear">Limpar</p>
                    <p id="enviar">Enviar</p>
                </div>
            </div>
            <input type="hidden" id="first" name="first" class="hidden">
            <input type="hidden" id="second" name="second" class="hidden">
            <input type="hidden" id="operation" name="operation" class="hidden">

        </form>
    </main>
    <script src="assets/main.js"></script>
</body>
</html>