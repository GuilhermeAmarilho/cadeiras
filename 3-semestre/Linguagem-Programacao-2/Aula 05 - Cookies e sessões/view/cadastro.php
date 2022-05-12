<?php
    require('index.html');
?>
    <div class="login">
        <form action="/controller/cadastro.php" method="post">
            <h1>Cadastre-se</h1>
            <input type="text" name="nome" id="nome" placeholder="Nome: " required>
            <input type="text" name="login" id="login" placeholder="Username: " required>
            <input type="password" name="password" id="password" placeholder="Senha: " required>
            <div>
                <button type="submit" id="logButton">Cadastrar!</button>
            </div>
            <?php 
                if(isset($_COOKIE["log"])){
                    if($_COOKIE["log"] == 1){
                        echo "<p>Email já cadastrado<p>";
                    }
                };
            ?>
        </div>
    </form> 
    <script src="../assets/js/script.js"></script>
    </body>
</html>