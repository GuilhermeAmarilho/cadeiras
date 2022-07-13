<main>
    <h1>
        Alterar senha
    </h1>
    <form action="/usuario/alterarSenhaValor/" method="post">
        <label for="antiga">Informe sua senha antiga</label>
        <input type="password" name="antiga" required>

        <label for="nova1">Informe sua nova senha</label>
        <input type="password" name="nova1" required>

        <label for="nova2">Confirme sua nova senha</label>
        <input type="password" name="nova2" required>
        
        <?php if ( isset ( $_COOKIE['erro'])){ 
            if($_COOKIE['erro'] == 2){?>
            <p class="errorPassword" >Falha ao alterar a senha!</p>
        <?php }} ?>
        <button type="submit">Enviar</button>
    </form>        
</main>