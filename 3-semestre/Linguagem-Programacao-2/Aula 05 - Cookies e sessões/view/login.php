<?php require('index.html');
    if(isset($_COOKIE["log"])){
        if($_COOKIE["log"] == 0){
            echo "ERROU!";
        }
    };
?>
    <div class="login">

        <form action="/controller/login.php" method="post">
            <h1>LOGIN</h1>
            <input type="text" name="login" id="login" placeholder="Username">
            <input type="password" name="password" id="password" placeholder="password">
            <div>
                <button type="submit" id="logButton">Log in!</button>
                <button id="cadastroButton"><a href="../controller/cadastro.php">Cadastre-se!</a></button>
            </div>
            <label for="salvar">Manter logado</label>
            <input type="checkbox" name="salvar" id="salvar">
        </div>
    </form> 
    <script src="../assets/js/script.js"></script>
    </body>
</html>