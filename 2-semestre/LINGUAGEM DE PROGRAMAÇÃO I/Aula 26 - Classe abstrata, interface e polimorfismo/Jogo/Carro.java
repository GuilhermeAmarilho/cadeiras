package Jogo;

public interface Carro {
	public static final String nome = "Carro";
	
	void frear(int intensidade);

	default void desligar() {
		System.out.println("Desligando carro.");
	}

}
