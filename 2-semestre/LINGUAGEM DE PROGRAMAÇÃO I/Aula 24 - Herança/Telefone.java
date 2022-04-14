package heranca;

public class Telefone {
	private int codigo;
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNumSerie() {
		return numSerie;
	}

	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public Dimensao getDim() {
		return dim;
	}

	public void setDim(Dimensao dim) {
		this.dim = dim;
	}

	private String numSerie;
	private String modelo;
	private float peso;
	private Dimensao dim;
	
	public Telefone(int cod, String numS, String mod, float p, Dimensao dim) {
		this.codigo = cod;
		this.numSerie = numS;
		this.modelo = mod;
		this.peso = p;
		this.dim = dim;		
	}
	
	public void imprimirDados() {
		System.out.println("Código: " + this.codigo);
		System.out.println("Número de série: " + this.numSerie);
		System.out.println("Modelo: " + this.modelo);
		System.out.println("Peso: " + this.peso);
		this.dim.imprimirDados();
	}
	
	public void conectarRedeTelefonia() {
		System.out.println("Conectando rede telefonia...");
	}
}
