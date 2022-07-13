<main>
    <h1>
        Cadastro de usuário
    </h1>
    <form action="/usuario/create/" method="post">
        <label for="nome">Nome</label>
        <input type="text" name="nome" required>

        <label for="email">Email</label>
        <input type="text" name="email" required>

        <label for="senha">Senha</label>
        <input type="password" name="senha" required>

        <label for="tipo">Tipo</label>
        <select name="tipo" id="tipo">
            <option value="cliente" selected>Cliente</option>
            <option value="vendedor">Vendedor</option>
        </select>
        <button type="submit">Enviar</button>
    </form>        
</main>