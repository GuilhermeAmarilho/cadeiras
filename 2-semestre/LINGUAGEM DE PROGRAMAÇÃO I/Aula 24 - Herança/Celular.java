package heranca;

public class Celular extends SemFio{
	
	private String processador;
	private double memoria;
	
	public Celular(int cod, String numS, String mod, float p, Dimensao dim, float f, int c, float dist, String proc, double mem) {
		super(cod, numS, mod, p, dim, f, c, dist);
		this.processador = proc;
		this.memoria = mem;		
	}

	public String getProcessador() {
		return processador;
	}

	public void setProcessador(String processador) {
		this.processador = processador;
	}

	public double getMemoria() {
		return memoria;
	}

	public void setMemoria(double memoria) {
		this.memoria = memoria;
	}
	
	public void imprimirDados() {
		super.imprimirDados();
		System.out.println("Processador: " + this.processador);
		System.out.println("Memória: " + this.memoria);
	}
	
	public void conectarWifi() {
		System.out.println("conectando ao wifi");
	}

}
