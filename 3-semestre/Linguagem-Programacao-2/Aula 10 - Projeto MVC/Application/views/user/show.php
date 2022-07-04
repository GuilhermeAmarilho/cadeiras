<main>
    <h1>LISTA DE USUÁRIOS</h1>
    <table>
        <thead>
            <th>ID</th>
            <th>Nome</th>
            <th>Cargo</th>
        </thead>
        <tbody>
            <?php 
            foreach ($data['users'] as $user) { ?>
            <tr>
                <td><?= $user['id'] ?></td>
                <td><?= $user['nome'] ?></td>
                <td><?= $user['cargo'] ?></td>
                <td><a href=<?php echo ("/user/update/".$user['id']);?> >Alterar</a></td>
                <td><a href=<?php echo ("/user/delete/".$user['id']);?> >Excluir</a></td>
            </tr>
            <?php }?>
        </tbody>
    </table>
</main>
