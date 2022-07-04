<?php

use Application\core\Controller;

class Project extends Controller{
    public function index(){
        $prjects = $this->model('Projects');
        $data = $prjects::findAll();
        $this->view('project/index', ['projects' => $data]);
    }
    public function find(){
        $this->view('project/find');
    }
    public function show(){
        $prjects = $this->model('Projects');
        $data = $prjects::findById($_POST['id']);
        if(count($data) > 0)
            $this->view('project/show', ['projects' => $data]);
        else
            $this->pageNotFound();
    }
    public function delete($id){
        if (is_numeric($id)) {
            $projects = $this->model('Projects');
            $projects::removeById($id);
            $data = $projects::findAll();
            $this->view('project/index', ['projects' => $data]);
        } else {
            $this->pageNotFound();
        }
    }
    public function insert(){
        $this->view('project/insert');
    }
    public function insertValue(){
        $projects = $this->model('Projects');
        $projects::insertValue($_POST['titulo'],$_POST['descricao']);
        $data = $projects::findAll();
        $this->view('project/index', ['projects' => $data]);
    }
    public function update($id){
        if (is_numeric($id)) {
            $projects =$this->model('Projects');
            $data = $projects::findById($id);
            $this->view('project/update', ['projects' => $data]);
        } else {
            $this->pageNotFound();
        }
    }
    public function updateValue(){
        $projects =$this->model('Projects');
        $projects::updateValue($_POST['id'],$_POST['titulo'],$_POST['descricao']);
        $data = $projects::findAll();
        $this->view('project/index', ['projects' => $data]);
    }
    public function removerTodos(){
        $prjects = $this->model('Projects');
        $prjects::removeAll();
        $data = $prjects::findAll();
        $this->view('project/index', ['projects' => $data]);   
    }
}
