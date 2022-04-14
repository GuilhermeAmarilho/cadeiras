package aula14;

public class TesteLista {

	public static void main(String[] args) {
		ListaDePalavras lp = new ListaDePalavras();
		
		
		
		lp.adicionarPalavra("Fabio Jose Rodrigues Pinheiro");
		lp.adicionarPalavra("Jose Maria");
		lp.adicionarPalavra("Henrique Pinheiro");
		lp.adicionarPalavra("Jose da Silva");
		lp.adicionarPalavra("Jose dos Santos");
		
		System.out.println(lp.conta("Jose"));
		lp.escreverLista();
		
	}
}
