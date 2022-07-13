<?php

use Application\core\Controller;

class Usuario extends Controller{
    public function index(){
        $Users = $this->model('Usuarios'); 
        $data = $Users::findAll();
        $this->view('usuario/index', ['users' => $data]);
    }
    public function update(){
        $Users = $this->model('Usuarios');
        $data = $Users::update($_SESSION['id'], $_POST['nome'], $_POST['email']);
        header("Location: /");
    }
    public function inserirSaldo(){
        $this->view('usuario/inserirSaldo');
    }
    public function insertValue(){
        $Users = $this->model('Usuarios'); 
        $data = $Users::findById($_SESSION['id']);
        $saldo = $data[0]['saldo'] + $_POST['valor'];
        $Users::insertValue($saldo, $_SESSION['id']);
        header("Location: /");
    }
    public function alterarSenha(){
        $this->view('usuario/alterarSenha');
    }
    public function alterarSenhaValor(){
        $Users = $this->model('Usuarios'); 
        $data = $Users::findById($_SESSION['id']);
        if( 
            ($_POST['nova1'] == $_POST['nova2']) and 
            ($data[0]['senha'] == md5($_POST['antiga'])) 
        ){
            $Users::alterarSenha($_POST['antiga'], $_SESSION['id']);
            header("Location: /");
        }else{
            setcookie('erro',2,time()+30,'/'); // 30 seg de erro
            $this->alterarSenha();
        }
    }
    public  function find(){
        $this->view('usuario/find');
    }
    public  function searchUser(){
        $Users = $this->model('Usuarios'); 
        $data = $Users::findById($_POST['id']);
        if(count($data) != 0){
            $this->view('usuario/show', ['users' => $data]);
        }else{
            $this->view('erro404');
        }
        
    }
    public  function create(){
        $Users = $this->model('Usuarios');
        $Users::create($_POST['nome'], $_POST['email'], $_POST['senha'], $_POST['tipo']);
        header("Location: /");
    }
    public function delete($id){
        $Users = $this->model('Usuarios');
        if($id == $_SESSION['id']){
            unset($_SESSION['id']);
            unset($_SESSION['nome']);
            unset($_SESSION['tipo']);
        }
        $Users::delete($id);
        header("Location: /");        
    }
    public function removerTodos(){
      $Users = $this->model('Usuarios');
      $Users::removerTodos();
      unset($_SESSION['id']);
      unset($_SESSION['nome']);
      unset($_SESSION['tipo']);
      header("Location: /");
    }
}
