<?php 
    session_start();
    if(!isset($_COOKIE['time'])){
        unset($_SESSION['login"']);
        unset($_COOKIE["nome"]);
    }else{
        if(isset($_SESSION["login"])){
            header("Location: /controller/login.php");  // Caso exista sessão, manda para o tratamento de login no controller
            echo "nao tem login";
        }
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
                };
            ?>
        </div>
    </form> 
    <script src="../assets/js/script.js"></script>
    </body>
</html>