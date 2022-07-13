<main>
    <br><br><br><br>
    <h1>LOGIN DE USUÁRIO</h1>
    <form action="/home/loginValue/" method="post">
        <label for="email">Email:</label>
        <input name="email" id="email" required>
        <label for="senha">Senha:</label>
        <input type="password" name="senha" id="senha" required>
        <a href="home/cadastro">Criar conta</a>
        <button type="submit">Enviar</button>
        <?php if ( isset ( $_COOKIE['erro'])){ 
            if($_COOKIE['erro'] == 1){?>
            <p class="errorPassword" >Email ou senha incorretos!</p>
        <?php }} ?>
    </form>        
</main>
