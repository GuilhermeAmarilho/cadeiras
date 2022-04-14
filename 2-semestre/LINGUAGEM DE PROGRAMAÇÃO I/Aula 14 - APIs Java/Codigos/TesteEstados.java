package aula14;

public class TesteEstados {
	public static void main(String[] args) {
		Estados est = new Estados();
					
		est.inserirEstado("AC", "Acre");
		est.inserirEstado("AL", "Alagoas");
		est.inserirEstado("BA", "Bahia");
		est.inserirEstado("PR", "Paraná");
		est.inserirEstado("SC", "Santa Catarina");
		est.inserirEstado("RS", "Rio Grande do Sul");
		est.inserirEstado("PA", "Pará");
		
		est.imprimir();
		
		System.out.println(est.getSigla("Alagoas"));
	}
}
