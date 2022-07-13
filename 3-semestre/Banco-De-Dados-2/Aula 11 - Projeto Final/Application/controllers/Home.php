<?php
use Application\core\Controller;

class Home extends Controller{
  public function index(){
    if (isset($_SESSION['id'])){
      $Users = $this->model('Usuarios');
      $data = $Users::findById($_SESSION['id']);
      $this->view('home/index', ['user' => $data]);
    }
    else  
      $this->view('home/login');
  }
  public function login(){
    $this->view('home/login');
  }
  public function loginValue(){
    $Users = $this->model('Usuarios');
    $data = $Users::login($_POST['email'], $_POST['senha']);
    print_r($data);
    if(isset($_SESSION['id'])){
      $data = $Users::findById($_SESSION['id']);
      $this->view('home/index', ['user' => $data]);
    }else{
      if(count($data) == 1){
        $_SESSION['id'] = $data[0]['id'];
        $_SESSION['nome'] = $data[0]['nome'];
        $_SESSION['tipo'] = $data[0]['tipo'];
      }else
        setcookie("erro", 1, time() + 30,"/");
      }
      header('Location: /');
  }
  public function cadastro(){
    $this->view('usuario/cadastro');
  }
  public function logout(){
    unset($_SESSION['id']);
    unset($_SESSION['nome']);
    unset($_SESSION['tipo']);  
    unset($_SESSION['cart']);
    header("Location: /");     
  }
}
