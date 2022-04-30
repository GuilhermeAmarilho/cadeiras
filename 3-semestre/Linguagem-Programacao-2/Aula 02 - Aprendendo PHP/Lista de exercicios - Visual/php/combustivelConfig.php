<?php

use Alcool as GlobalAlcool;
use Gasolina as GlobalGasolina;
    class Combustivel{
        private float $preco;
        private float $kmLitro;
        public function __construct(float $preco, float $kmlitro){
            $this->preco = $preco;
            $this->kmLitro = $kmlitro;
        }
        public function getPreco() : float { 
            return $this->preco;
        }
        public function getKmLitro() : float { 
            return $this->kmLitro;
        }
    }    
    class Gasolina extends Combustivel{
        public function __toString() :String
        {
            return "Gasolina";
        }
    }
    class Alcool extends Combustivel{
        public function __toString() :String
        {
            return "Alcool";
        }
    }
    interface ICalculator {
        public function calcularRendimento() : float;
        public function calcularDiferencaPreco() : float;
        public function imprimir() : string;
    }
    class Calculator implements ICalculator{
        private Alcool $alcool;
        private Gasolina $gasolina;
        public function __construct(Alcool $alcool, Gasolina $gasolina){
            $this->alcool = $alcool;
            $this->gasolina = $gasolina;
        }
        public function calcularRendimento(): float{
            return $this->alcool->getKmLitro() / $this->gasolina->getKmLitro();
        }
        public function calcularDiferencaPreco(): float{ 
            return $this->alcool->getPreco() / $this->gasolina->getPreco();
        }
        public function imprimir(): string{
            if($this->calcularDiferencaPreco() < $this->calcularRendimento()){
                return '1';
            }else{
                return '2';
            }
        }
    }
    $gasolina = new Gasolina($_POST['gasolinaValor'], $_POST['gasolinaRendimento']);
    $alcool = new Alcool($_POST['alcoolValor'], $_POST['alcoolRendimento']);
    $calculator = new Calculator($alcool, $gasolina);
    echo '<script>window.location = "//localhost/combustivel.php?result='.$calculator->imprimir().'"</script>';


?>