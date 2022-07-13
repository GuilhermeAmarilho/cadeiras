<?php

namespace Application\models;

use Application\core\Database;
use PDO;
class Produtos{
  public static function findAll(){
      $conn = new Database();
      $result = $conn->executeQuery('SELECT p.id, p.nome, p.preco, c.nome as categoria FROM produto as p, categoria as c where p.categoria = c.id');
      return $result->fetchAll(PDO::FETCH_ASSOC);
    }
    public static function findById(int $id){
      $conn = new Database();
      $result = $conn->executeQuery('SELECT p.id, p.nome, p.preco, c.nome as categoria FROM produto as p, categoria as c WHERE p.id = :ID and p.categoria = c.id LIMIT 1', array(
        ':ID' => $id
      ));
      return $result->fetchAll(PDO::FETCH_ASSOC);
    }
    public static function update($nome, $preco, $id){
      $conn = new Database();
      $result = $conn->executeQuery('UPDATE produto SET nome = :NOME, preco = :PRECO WHERE id = :ID', array(
        ':NOME' => $nome,
        ':PRECO' => $preco,
        ':ID' => $id
      ));
    }
    public static function inserir($nome, $preco, $categoria){
      $conn = new Database();
      switch($categoria){
        case "1": $cat = 1;break;
        case "2": $cat = 2;break;
        case "3": $cat = 3;break;
        case "4": $cat = 4;break;
      }
      $result = $conn->executeQuery('INSERT INTO produto (nome, preco, categoria) VALUES (:NOME,:PRECO,:CATEGORIA)', array(
        ':NOME' => $nome,
        ':PRECO' => $preco,
        ':CATEGORIA' => $cat
      ));
    }
    public static function delete($id){
      $conn = new Database();
      $result = $conn->executeQuery('DELETE FROM produto WHERE id = :ID', array(
        ':ID' => $id
      ));
    }
    public static function removerTodos(){
      $conn = new Database();
      $result = $conn->executeQuery('DELETE FROM produto');
    }
}