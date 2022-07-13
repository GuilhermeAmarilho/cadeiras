<main>
    <h1>LISTA DE USUÁRIOS</h1>
    <table>
        <thead>
            <th>ID</th>
            <th>Nome</th>
            <th>Email</th>
            <th>Tipo</th>
        </thead>
        <tbody>
            <?php foreach ($data['users'] as $user) { ?>
            <tr>
                <td><?= $user['id'] ?></td>
                <td><?= $user['nome'] ?></td>
                <td><?= $user['email'] ?></td>
                <td><?= $user['tipo'] ?></td>
                <td>
                    <a href=<?php echo ("/usuario/delete/".$user['id']);?> >Excluir</a>
                </td>
            </tr>
            <?php }?>
        </tbody>
    </table>
    <div class="commands">
        <a href="/usuario/find/">Buscar usuário</a>
        <a href="/usuario/removerTodos/">Remover todos os usuários</a>
    </div>
</main>
