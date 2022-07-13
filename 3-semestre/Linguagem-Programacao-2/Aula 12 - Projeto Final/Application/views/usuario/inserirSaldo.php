<main>
  <h1>INSIRA SALDO NA SUA CONTA</h1>
  <form action="/usuario/insertValue/" method="post">
    <h2>Insira os dados do seu cartão de crétido</h2>
    <label for="numero">Número</label>
    <input type="number" name="numero" id="numero">
    <label for="cvv">Código de verificação</label>
    <input type="number" name="cvv" id="cvv">
    <label for="validade">Validade</label>
    <input type="text" name="validade" id="validade">
    <label for="valor">Valor a adicionar</label>
    <input type="number" name="valor" id="valor" required>
    <button type="submit">Enviar</button>
  </form>        
</main>
