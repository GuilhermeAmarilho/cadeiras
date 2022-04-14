<!-- 

Protocolo HTTP: https://developer.mozilla.org/pt-BR/docs/Web/HTTP/Overview
Wikipedia: https://pt.wikipedia.org/wiki/Hypertext_Transfer_Protocol
Exemplo: http://luciano-ti.blogspot.com/2010/04/protocolo-http.html

-->

<!-- Informações do servidor web -->

<?php // phpinfo() ?>
<?php

// var_dump($_SERVER);
// foreach ($_SERVER as $key => $value) {
//     echo $key . '=>' . $value, '<br />';
// }

?>
<!-- ********************************************* -->
<?php
// HTTP -> GET

// $nome = $_GET['nome'];
// $email = $_REQUEST['email'];
// echo $nome, ' - ', $email;

?>
<!-- ********************************************* -->
<?php
// HTTP -> POST
    // $nome = $_REQUEST['nome'];
    // $email = $_REQUEST['email'];
    // echo $nome, ' - ', $email;
?>
<!-- <hr>
<form action="index.php?x=10" method="POST">
    <div>
        <label for="nome">Nome: </label>
        <input type="text" name="nome" id="nome" placeholder="Nome" value="<?= $nome ?>">
        <label for="email">E-mail: </label>
        <input type="text" name="email" id="email" placeholder="E-mail" value="<?= $email ?>">
        <input type="submit" value="Enviar">
    </div>

</form> -->