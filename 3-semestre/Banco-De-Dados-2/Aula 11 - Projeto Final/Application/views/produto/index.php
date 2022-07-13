<main>
    <h1>LISTA DE COMIDAS</h1>
    <table>
        <thead>
            <th>Nome</th>
            <th>Preço</th>
            <th>Categoria</th>
        </thead>
        <tbody>
            <?php foreach ($data['products'] as $product) { ?>
            <tr>
                <td><?= $product['nome'] ?></td>
                <td><?= "R$: ".$product['preco'] ?></td>
                <td><?= $product['categoria'] ?></td>
                <?php if($_SESSION['tipo']=='admin' or $_SESSION['tipo']=='vendedor'){ ?>
                    <td><a href=<?php echo ("/produto/update/".$product['id']);?> >Alterar</a>
                    <br>
                    <a href=<?php echo ("/produto/delete/".$product['id']);?> >Excluir</a></td>
                <?php }else{ ?>
                    <td><a href=<?php echo ("/compra/inserir/".$product['id'] ); ?> >Comprar</a></td>
                <?php } ?>     
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
