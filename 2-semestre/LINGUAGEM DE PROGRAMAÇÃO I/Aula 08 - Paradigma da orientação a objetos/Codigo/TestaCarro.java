package aula08;

public class TestaCarro {
	public static void main(String[] args) {
		
		Carro fusca = new Carro();
		Carro chevete = new Carro();
		Carro celta = new Carro();
		Carro up = new Carro();
		
		fusca.marca = "VW";
		fusca.modelo = "Fusca";
		celta.marca = "GM";
		celta.modelo = "Celta CL";
		
		fusca.acionarIgnicao();
		celta.acionarIgnicao();
				
		fusca.acelerar(20);
		fusca.acelerar(30);
		
		fusca.acionarIgnicao();
		
		//System.out.println("Velocidade do fusca: " + fusca.obterVelocidade());
		
		fusca.frear(40);		
		//System.out.println("Velocidade do fusca: " + fusca.obterVelocidade());
		
		celta.acelerar(100);
		//System.out.println("Velocidade do celta: " + celta.obterVelocidade());
				
				
		
	}
}