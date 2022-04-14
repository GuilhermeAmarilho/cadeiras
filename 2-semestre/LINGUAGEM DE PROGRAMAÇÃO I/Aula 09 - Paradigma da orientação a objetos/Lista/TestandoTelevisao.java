package aula9_continuacaopoo;

public class TestandoTelevisao {
	public static void main(String[] args) {
		Televisao televisao1 = new Televisao();
		televisao1.power();
		// testes de canais
		televisao1.setCanal(9);	
		televisao1.setCanal(0); //pega a referência, e não a posição
		televisao1.setCanal(2);	//posicao 3
		// fim dos testes de canais
		
		// testes de decremento
		televisao1.decrementarCanal();
		televisao1.decrementarCanal();
		televisao1.decrementarCanal();
		televisao1.power();		
		// fim testes de decremento
				
		// testes de incremento
		televisao1.incrementarCanal();
		televisao1.power();
		televisao1.incrementarCanal();
		televisao1.incrementarCanal();
		televisao1.incrementarCanal();
		// fim testes de incremento
		
		// testes de volume 
		televisao1.decrementarVolume();
		televisao1.incrementarVolume();
		televisao1.incrementarVolume();
		televisao1.decrementarVolume();
		// fim dos testes de volume
	}
}
