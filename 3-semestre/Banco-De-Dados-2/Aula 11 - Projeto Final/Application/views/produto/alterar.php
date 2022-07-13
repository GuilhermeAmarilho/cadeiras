<main>
    <h2>
        Alterar Produto
    </h2>
    <form action="/produto/updateValue/" method="post">
        <label for="id">ID</label>
        <input type="text" name="id" value="<?php echo($data['products'][0]['id']);?>" readonly>

        <label for="nome">Nome</label>
        <input type="text" name="nome" value="<?php echo($data['products'][0]['nome']);?>" required>

        <label for="preco">Preço</label>
        <input type="text" name="preco" value="<?php echo($data['products'][0]['preco']);?>" required>

        <label for="categoria">Categoria</label>
        <input type="text" name="categoria" value="<?php echo($data['products'][0]['categoria']);?>" readonly>

        <button type="submit">Alterar dados</button>
    </form>        


</main>