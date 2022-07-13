<?php

namespace Application\models;

use Application\core\Database;
use PDO;
class Compras{
  public static function inserir($data, $idusuario){
    $conn = new Database();
    try{
      $conn->begin();
      foreach($data as $product){
        $result = $conn->executeQuery('INSERT INTO compra (usuario, produto) VALUES (:USUARIO, :PRODUTO)', array(
          ':USUARIO' => $idusuario, 
          ':PRODUTO' => $product['id']
        ));
      }
      $conn->commit();
      return 1;
    }catch (\PDOException $e) {
      $conn->rollback();
      return 0;
    }
  }
  public static function history($idusuario){
    $conn = new Database();
    $result = $conn->executeQuery('SELECT c.id, ca.nome as categoria, p.nome, p.preco FROM compra AS c, usuario AS u, produto AS p, categoria AS ca 
    WHERE c.usuario = u.id AND c.produto = p.id and ca.id = p.categoria and c.usuario = :ID', 
        array(':ID' => $idusuario)
    );
    return $result->fetchAll(PDO::FETCH_ASSOC);
  }
}
