<main>
    <h2>
        Inserir Produto
    </h2>
    <form action="/produto/insertValue/" method="post">
        <label for="nome">Nome</label>
        <input type="text" name="nome" required>
        <label for="preco">Preço</label>
        <input type="text" name="preco" required>
        <select name="categoria" id="categoria">
            <option value="1" selected>Salgado</option>
            <option value="2">Doces</option>
            <option value="3">Lanche</option>
            <option value="4">Refeição</option>
        </select>
        <button type="submit">Inserir</button>
    </form>        


</main>