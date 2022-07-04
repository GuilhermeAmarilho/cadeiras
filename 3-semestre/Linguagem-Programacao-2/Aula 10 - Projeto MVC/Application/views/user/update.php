<main>
    <h1>ALTERAÇÃO DE USUÁRIO</h1>
    <form action="/user/updateValue/" method="post">
        <label for="id">ID</label>
        <input type="text" name="id" value="<?php echo($data['user'][0]['id']);?>" readonly>
        <label for="nome">Nome</label>
        <input type="text" name="nome" value="<?php echo($data['user'][0]['nome']);?>" required>
        <label for="cargo">Cargo</label>
        <input type="text" name="cargo" value="<?php echo($data['user'][0]['cargo']);?>" required>
        <button type="submit">Enviar</button>
    </form>        
</main>