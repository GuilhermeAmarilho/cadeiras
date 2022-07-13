<main>
    <h1>HISTÓRICO DE COMPRA</h1>
    <table>
        <thead>
            <th>ID</th>
            <th>Categoria</th>
            <th>Nome</th>
            <th>Preço</th>
        </thead>
        <tbody>
            <?php foreach ($data['compras'] as $compra) {?>
            <tr>
                <td><?= $compra['id'] ?></td>
                <td><?= $compra['categoria'] ?></td>
                <td><?= $compra['nome'] ?></td>
                <td><?= "R$: ".$compra['preco'] ?></td>
            </tr>
            <?php }?>
        </tbody>
    </table>
    <?php if($_SESSION['tipo']=='admin' or $_SESSION['tipo']=='vendedor'){ ?>
        <div class="commands">
            <a href="/produto/inserir/">Inserir Produto</a>
            <a href="/produto/removerTodos/">Remover todos os produtos</a>
        </div>
    <?php } ?>
</main>
