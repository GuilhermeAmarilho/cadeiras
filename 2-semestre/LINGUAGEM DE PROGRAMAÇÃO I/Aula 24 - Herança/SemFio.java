package heranca;

public class SemFio extends Telefone{
	
	private float frequencia;
	private int canais;
	private float distancia;
	
	public SemFio(int cod, String numS, String mod, float p, Dimensao dim, float f, int c, float dist) {
		super(cod, numS, mod, p, dim);		
		this.frequencia = f;
		this.canais = c;
		this.distancia = dist;
	}

	public float getFrequencia() {
		return frequencia;
	}

	public void setFrequencia(float frequencia) {
		this.frequencia = frequencia;
	}

	public int getCanais() {
		return canais;
	}

	public void setCanais(int canais) {
		this.canais = canais;
	}

	public float getDistancia() {
		return distancia;
	}

	public void setDistancia(float distancia) {
		this.distancia = distancia;
	}

	public void imprimirDados() {
		super.imprimirDados();
		System.out.println("Frequência: " + this.frequencia);
		System.out.println("Quantidade de canais: " + this.canais);
		System.out.println("Distância alcançada: " + this.distancia);
		
	}
}