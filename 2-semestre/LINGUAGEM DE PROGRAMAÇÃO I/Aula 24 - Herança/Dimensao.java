package heranca;

public class Dimensao {
	private double altura;
	private double largura;
	private double profundidade;
	
	public Dimensao(double a, double l, double p) {
		this.altura = a;
		this.largura = l;
		this.profundidade = p;
	}
	
	public void imprimirDados() {
		System.out.println("Altura: " + this.altura);
		System.out.println("Largura: " + this.largura);
		System.out.println("Profundidade " + this.profundidade);
	}
	
	public double calcularVolume() {
		return 0;
	}
}
