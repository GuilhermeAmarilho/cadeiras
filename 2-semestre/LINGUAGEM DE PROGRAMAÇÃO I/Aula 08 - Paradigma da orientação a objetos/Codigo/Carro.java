package aula08;

public class Carro {

	//atributos
	public double velocidade = 0;
	public String marca;
	public String modelo;
	public boolean ligado = false;
	
	public void acionarIgnicao() {
		if (!ligado) {
			System.out.println("Ligando o " + modelo);
			ligado = true;
		}else {
			System.out.println("Desligando o " + modelo);
			ligado = false;
		}						
	}
	
	public void acelerar(double aceleracao) {
		if (ligado) {
			System.out.println("O " + modelo + " acelerou a " + aceleracao + " km/h");
			velocidade = velocidade + aceleracao;
			System.out.println("E chegou a velocidade de " + velocidade + "km/h");
		}else
			System.out.println("O " + modelo + " está desligado");
	}
	
	public void frear(double desaceleracao) {
		if (ligado) {
			System.out.println("O " + modelo + " desacelerou em " + desaceleracao + " km/h");		
			if (desaceleracao >= velocidade) {
				velocidade = 0;
				System.out.println("O carro parou!");
			}else {
				velocidade = velocidade - desaceleracao;
				System.out.println("E chegou a velocidade de " + velocidade + "km/h");
			}			
		}else
			System.out.println("O " + modelo + " está desligado");
	}
	
	public void imprimirDados() {
		System.out.println("Marca: " + marca);
		System.out.println("Modelo: " + modelo);		
	}
	
	public double obterVelocidade() {
		return velocidade;
	}	
}