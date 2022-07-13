<?php

namespace Application\models;

use Application\core\Database;
use PDO;
class Usuarios{
  public static function login($email, $senha){
    $conn = new Database();
    $result = $conn->executeQuery('SELECT * FROM usuario WHERE email = :EMAIL and senha = :SENHA', array(
      ':EMAIL' => $email, ':SENHA' => md5($senha)
    ));
    return $result->fetchAll(PDO::FETCH_ASSOC);
  }
  public static function findAll(){
    $conn = new Database();
    $result = $conn->executeQuery('SELECT * FROM usuario');
    return $result->fetchAll(PDO::FETCH_ASSOC);
  }
  public static function findById(int $id){
    $conn = new Database();
    $result = $conn->executeQuery('SELECT * FROM usuario WHERE id = :ID LIMIT 1', array(
      ':ID' => $id
    ));
    return $result->fetchAll(PDO::FETCH_ASSOC);
  }
  public static function update($id, $nome, $email){
    $conn = new Database();
    $result = $conn->executeQuery('Update usuario SET nome = :NOME, email = :EMAIL where id = :ID', array(
      ':NOME' => $nome, ':EMAIL' => $email, ':ID' => $id
    ));
  }
  public static function create($nome, $email, $senha, $tipo){
    $conn = new Database();
    $result = $conn->executeQuery('INSERT INTO usuario (nome, email, senha, tipo, saldo) VALUES (:NOME, :EMAIL, :SENHA, :TIPO, 0)', array(
      ':NOME' => $nome, 
      ':EMAIL' => $email, 
      ':SENHA' => md5($senha),
      ':TIPO' => $tipo
    ));
  }
  public static function insertValue($saldo, $id){
    $conn = new Database();
    $result = $conn->executeQuery('UPDATE usuario SET saldo = :SALDO WHERE id = :ID', array(
      ':SALDO' => $saldo, ':ID' => $id
    ));
  }
  public static function alterarSenha($senha, $id){
    $conn = new Database();
    $result = $conn->executeQuery('UPDATE usuario SET senha = :SENHA WHERE id = :ID', array(
      ':SENHA' => md5($senha), ':ID' => $id
    ));
  }
  public static function delete($id){
    $conn = new Database();
    $result = $conn->executeQuery('DELETE FROM usuario WHERE id = :ID', array(
      ':ID' => $id
    ));
  }
  public static function removerTodos(){
    $conn = new Database();
    $result = $conn->executeQuery('DELETE FROM usuario');
  }
  public static function alterarSaldo($saldo, $id){
    $conn = new Database();
    $result = $conn->executeQuery('UPDATE usuario SET saldo = :SALDO WHERE id = :ID', array(
      ':SALDO' => $saldo, ':ID' => $id
    ));
  }
}
