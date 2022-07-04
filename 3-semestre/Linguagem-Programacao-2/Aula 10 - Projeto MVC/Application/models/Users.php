<?php

namespace Application\models;

use Application\core\Database;
use PDO;
class Users{
  public static function findAll(){
    $conn = new Database();
    $result = $conn->executeQuery('SELECT * FROM users');
    return $result->fetchAll(PDO::FETCH_ASSOC);
  }
  public static function findById(int $id){
    $conn = new Database();
    $result = $conn->executeQuery('SELECT * FROM users WHERE id = :ID LIMIT 1', array(
      ':ID' => $id
    ));
    return $result->fetchAll(PDO::FETCH_ASSOC);
  }
  public static function removeById(int $id){
    $conn = new Database();
    $result = $conn->executeQuery('Delete FROM users WHERE id = :ID', array(
      ':ID' => $id
    ));
  }
  public static function insertValue($nome, $cargo){
    $conn = new Database();
    $result = $conn->executeQuery('Insert INTO users (nome, cargo) VALUES (:NOME,:CARGO)', array(
      ':NOME' => $nome, ':CARGO' => $cargo
    ));
  }
  public static function updateValue($id,$nome, $cargo){
    $conn = new Database();
    $result = $conn->executeQuery('Update users SET nome = :NOME, cargo = :CARGO where id = :ID', array(
      ':NOME' => $nome, ':CARGO' => $cargo, ':ID' => $id
    ));
  }
  public static function removeAll(){
    $conn = new Database();
    $result = $conn->executeQuery('Delete FROM users');
  }
}
