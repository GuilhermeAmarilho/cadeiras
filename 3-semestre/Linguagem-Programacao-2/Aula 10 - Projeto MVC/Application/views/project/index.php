<main>
    <h1>LISTA DE PROJETOS</h1>
    <table>
        <thead>
          <th scope="col">ID</th>
          <th scope="col">Titulo</th>
          <th scope="col">Descrição</th>
        </thead>
        <tbody>
            <?php foreach ($data['projects'] as $project) { ?>
            <tr>
                <td><?= $project['id'] ?></td> 
                <td><?= $project['titulo'] ?></td>
                <td><?= $project['descricao'] ?></td>
                <td><a href=<?php echo ("/project/update/".$project['id']);?> >Alterar</a></td>
                <td><a href=<?php echo ("/project/delete/".$project['id']);?> >Excluir</a></td> 
            </tr>
            <?php }?>
        </tbody>
    </table>
    <div class="commands">
        <a href="/project/insert/">Adicionar novo projeto</a>
        <a href="/project/find/">Buscar projeto</a>
        <a href="/project/removerTodos/">Remover todos os projetos</a>
    </div>
</main>