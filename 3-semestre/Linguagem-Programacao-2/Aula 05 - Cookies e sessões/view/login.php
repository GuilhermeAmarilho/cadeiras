<?php require('index.html')?>
    <div class="login">

        <form action="/controller/login.php" method="post">
            <h1>LOGIN</h1>
            <input type="text" name="login" id="login" placeholder="Username">
            <input type="password" name="password" id="password" placeholder="password">
            <button type="submit" id="logButton">Log in!</button>
            <button id="cadastroButton"><a href="../controller/cadastro.php">Cadastre-se!</a></button>
        </div>
    </form> 
    <script src="../assets/js/script.js"></script>
    </body>
</html>