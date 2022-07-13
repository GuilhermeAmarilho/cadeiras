<main>
    <h1>CARRINHO DE COMPRAS</h1>
    <table>
        <thead>
            <th>Nome</th>
            <th>Preço</th>
        </thead>
        <tbody>
            <?php 
            foreach ($data['cart'] as $product) { ?>
            <tr>
                <td><?= $product['nome'] ?></td>
                <td><?= "R$: ".$product['preco'] ?></td>
                <td><a href=<?php echo ("/compra/remover/".$product['id'] ); ?> >Remover</a></td>
            </tr>
            <?php }?>
            <tr>
                <td>Total:</td>
                <td></td>
                <td><?= $data['total'] ?></td>
            </tr>
        </tbody>
    </table>
        <div class="commands">
            <a href="/compra/comprar/">Finalizar compra</a>
            <a href="/compra/removerTodos/">Limpar carrinho</a>
        </div>
    <?php
        if ( isset ( $_COOKIE['erro'])){ 
            if($_COOKIE['erro'] == 3){
    ?>
                <p class="saldoInsuficiente">Saldo insuficiente!</p>
    <?php   }
        }
    ?>
</main>
