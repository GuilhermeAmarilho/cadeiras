<?php
use Application\core\Controller;

class Compra extends Controller{
    public function index(){
        if (empty($_SESSION['cart'])) {
            $_SESSION['cart'] = [];
            if(isset($_COOKIE['erro'])){
                if($_COOKIE['erro']==4){
                    $this->view('compra/index');
                }
            }
            $this->view('erro404');
        }else{
            $total = 0;
            foreach ($_SESSION['cart'] as $product){
                $total+= doubleval($product['preco']);
            }
            $this->view('compra/index',['cart' => $_SESSION['cart'],'total' => $total ]);
        }

    }
    public function inserir($id){
        if (empty($_SESSION['cart'])) {
            $_SESSION['cart'] = [];
        }
        $Products = $this->model('Produtos');
        $data = $Products::findById($id);
        array_push($_SESSION['cart'], $data[0]);
        header("Location: /compra/index");
    }
    public function removerTodos(){
        $_SESSION['cart'] = [];
        header("Location: /produto/index");
    }
    public function remover($id){
        print_r($_SESSION['cart']);
        $i = 0;
        foreach ($_SESSION['cart'] as $product){
            if($product['id'] == $id){
                unset($_SESSION['cart'][$i]);
            }
            $i++;
        }
        header("Location: /produto/index");
    }
    public function comprar(){
        $total = 0;
        $Users = $this->model('Usuarios'); 
        $Compras = $this->model('Compras'); 
        $saldo = doubleval($Users::findById($_SESSION['id'])[0]['saldo']);
        foreach ($_SESSION['cart'] as $product){
            $total+= doubleval($product['preco']);
        }
        if($saldo >= $total){
            $validacao = $Compras::inserir($_SESSION['cart'], $_SESSION['id']);
            print_r($validacao);
            if($validacao==0){ // Problemas ao inserir
                $_SESSION['cart'] = [];
                $this->view("erro404");
            }else // Deu certo
                $Users::alterarSaldo( ($saldo - $total), $_SESSION['id']);
                header("Location: /compra/history");
        }else{
            setcookie('erro', 3, time()+30, '/');
            header("Location: /compra/index");
        }
    }
    public function history(){
        $Compras = $this->model('Compras'); 
        $data = $Compras::history($_SESSION['id']);
        $this->view('compra/history', ['compras' => $data]);        
    }
}
