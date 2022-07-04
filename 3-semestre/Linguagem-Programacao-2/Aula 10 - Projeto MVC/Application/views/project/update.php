<main>
    <h1>ALTERAÇÃO DE PROJETOS</h1>
    <form action="/project/updateValue/" method="post">
        <label for="id">ID</label>
        <input type="text" name="id" value="<?php echo($data['projects'][0]['id']);?>" required>
        <label for="titulo">Titulo</label>
        <input type="text" name="titulo" value="<?php echo($data['projects'][0]['titulo']);?>" required>
        <label for="descricao">Descrição</label>
        <textarea name="descricao" id="descricao" rows="5" style="resize: none"><?php 
        echo (($data['projects'][0]['descricao'])); ?></textarea>
        <button type="submit">Enviar</button>
    </form>        
</main>