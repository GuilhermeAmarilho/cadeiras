<?php

namespace Application\models;

use Application\core\Database;
use PDO;
class Projects{
    public static function findAll(){
        $conn = new Database();
        $result = $conn->executeQuery('SELECT * FROM projects');
        return $result->fetchAll(PDO::FETCH_ASSOC);
    }
    public static function findById(int $id){
        $conn = new Database();
        $result = $conn->executeQuery('SELECT * FROM projects WHERE id = :ID LIMIT 1', array(
            ':ID' => $id
        ));
        return $result->fetchAll(PDO::FETCH_ASSOC);
    }
    public static function removeById(int $id){
        $conn = new Database();
        $result = $conn->executeQuery('Delete FROM projects WHERE id = :ID', array(
            ':ID' => $id
        ));
    }
    public static function insertValue($titulo, $descricao){
        $conn = new Database();
        $result = $conn->executeQuery('Insert INTO projects (titulo, descricao) VALUES (:TITULO,:DESCRICAO)', array(
            ':TITULO' => $titulo, ':DESCRICAO' => $descricao
        ));
    }
    public static function updateValue($id,$titulo, $descricao){
        $conn = new Database();
        $result = $conn->executeQuery('Update projects SET titulo = :TITULO, descricao = :DESCRICAO where id = :ID', array(
            ':TITULO' => $titulo, ':DESCRICAO' => $descricao, ':ID' => $id
        ));
    }
    public static function removeAll(){
        $conn = new Database();
        $result = $conn->executeQuery('Delete FROM projects');
    }
}
  