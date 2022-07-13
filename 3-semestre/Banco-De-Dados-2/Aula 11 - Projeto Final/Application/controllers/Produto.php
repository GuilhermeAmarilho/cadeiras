<?php
use Application\core\Controller;

class Produto extends Controller{
  public function index(){
    $Products = $this->model('Produtos');
    $data = $Products::findAll();
    $this->view('produto/index', ['products' => $data]);
  }
  public function delete($id){
    $Products = $this->model('Produtos');
    $data = $Products::delete($id);
    header("Location: /produto/index");    
  }
  public function inserir(){
    $this->view('produto/inserir');
  }
  public function insertValue(){
    $Products = $this->model('Produtos');
    $data = $Products::inserir($_POST['nome'], $_POST['preco'], $_POST['categoria']);
    header("Location: /produto/index");
  }
  public function update($id){
    $Products = $this->model('Produtos');
    $data = $Products::findById($id);
    $this->view('produto/alterar', ['products' => $data]);
  }
  public function updateValue(){
    $Products = $this->model('Produtos');
    $data = $Products::update($_POST['nome'], $_POST['preco'], $_POST['id']);
    header("Location: /produto/index");
  }
  public function removerTodos(){
    $Products = $this->model('Produtos');
    $Products::removerTodos();
    header("Location: /usuario/index");
  }
}
