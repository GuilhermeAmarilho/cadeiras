<main>
    <h1>
        Olá <?php echo $data['user'][0]['nome'] ?> 
    </h1>
    <h2>
        Seu painél de controle
    </h2>
    <form action="/usuario/update/" method="post">
        <label for="id">ID</label>
        <input type="text" name="id" value="<?php echo($data['user'][0]['id']);?>" readonly>

        <label for="nome">Nome</label>
        <input type="text" name="nome" value="<?php echo($data['user'][0]['nome']);?>" required>

        <label for="email">Email</label>
        <input type="text" name="email" value="<?php echo($data['user'][0]['email']);?>" required>

        <label for="cargo">Cargo</label>
        <input type="text" name="cargo" value="<?php echo($data['user'][0]['tipo']);?>" readonly>
        <?php if($data['user'][0]['tipo'] == "cliente"){ ?>
        <label for="saldo">Saldo</label>
        <input type="text" name="saldo" value="<?php echo($data['user'][0]['saldo']." R$");?>" readonly>
        <?php } ?>
        <div class="opcoes">
            <?php if($data['user'][0]['tipo'] == "cliente"){ ?>
                <a href="/usuario/inserirSaldo">Adicionar saldo</a>
            <?php } ?>
            <a href="/usuario/alterarSenha">Alterar senha</a>
        </div>
        <button type="submit">Alterar dados</button>
    </form>        


</main>