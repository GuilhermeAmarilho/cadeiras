<?php 
    require('controller/controlador.php');
    $aux = controleDeSessao();
    if($aux == 1){ // Caso tenha sessão ativa, volta para o main
        header("Location: /view/main.php");
    }
    require('index.html');
?>
    <div class="login">
        <form action="/controller/login.php" method="post">
            <h1>LOGIN</h1>
            <input type="text" name="login" id="login" placeholder="Username" required>
            <input type="password" name="password" id="password" placeholder="password" required>
            <div>
                <button type="submit" id="logButton">Log in!</button>
                <button id="cadastroButton"><a href="cadastro.php">Cadastre-se!</a></button>
            </div>
            <?php 
                if(isset($_COOKIE["log"])){
                    if($_COOKIE["log"] == 0){
                        echo "<p>Login ou senha inválidos<p>";
                    }
                    if($_COOKIE["log"] == 3){
                        echo "<p>Sessão expirada<p>";
                    }
                };
            ?>
        </div>
    </form> 
    <script src="../assets/js/script.js"></script>
    </body>
</html>