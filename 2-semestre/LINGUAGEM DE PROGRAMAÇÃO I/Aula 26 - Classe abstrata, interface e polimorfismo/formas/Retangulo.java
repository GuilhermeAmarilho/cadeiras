package formas;

public abstract class Retangulo extends FormaGeometrica{
	public Ponto ponto;
	
	public Retangulo(int x, int y) {
		this.ponto = new Ponto(x,y);
	}
	
	public void fazerDesenho() {
		System.out.println("Gerando retangulo");
		this.ponto.desenhar();
	}
}
