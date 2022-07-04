<?php

use Application\core\Controller;

class User extends Controller{
    public function index(){
        $Users = $this->model('Users'); // é retornado o model Users()
        $data = $Users::findAll();
        $this->view('user/index', ['users' => $data]);
    }
    public function find(){
        $this->view('user/find');
    }
    public function show(){
        $Users = $this->model('Users');
        $data = $Users::findById($_POST['id']);
        if(count($data) > 0)
            $this->view('user/show', ['users' => $data]);
        else
            $this->pageNotFound();
    }
    public function delete($id){
        if (is_numeric($id)) {
            $Users = $this->model('Users');
            $Users::removeById($id);
            $data = $Users::findAll();
            $this->view('user/index', ['users' => $data]);
        } else {
            $this->pageNotFound();
        }
    }
    public function insert(){
        $this->view('user/insert');
    }
    public function insertValue(){
        $Users = $this->model('Users');
        $Users::insertValue($_POST['nome'],$_POST['cargo']);
        $data = $Users::findAll();
        $this->view('user/index', ['users' => $data]);
    }
    public function update($id){
        if (is_numeric($id)) {
            $Users = $this->model('Users');
            $data = $Users::findById($id);
            $this->view('user/update', ['user' => $data]);
        } else {
            $this->pageNotFound();
        }
    }
    public function updateValue(){
        $Users = $this->model('Users');
        $Users::updateValue($_POST['id'],$_POST['nome'],$_POST['cargo']);
        $data = $Users::findAll();
        $this->view('user/index', ['users' => $data]);
    }
    public function removerTodos(){
        $Users = $this->model('Users');
        $Users::removeAll();
        $data = $Users::findAll();
        $this->view('user/index', ['users' => $data]);   
    }
}
