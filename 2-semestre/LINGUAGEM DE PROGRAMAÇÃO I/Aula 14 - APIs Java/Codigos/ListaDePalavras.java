package aula14;

import java.util.ArrayList;

public class ListaDePalavras {
	
	private ArrayList<String> palavras = new ArrayList<>();
	
	
	public void adicionarPalavra(String nomeCompleto) {		
		//FABIO JOSE RODRIGUES PINHEIRO
		//NOME[] = {"FABIO", "JOSE", "RODRIGUES", "PINHEIRO"};
		String[] nome = nomeCompleto.split(" ");
		
		String primeiroNome = nome[0];
		//String ultimoNome = nome[nome.length-1];
		
		this.palavras.add(primeiroNome);
		//this.palavras.add(ultimoNome);			
	}
	
	public void escreverLista() {
				
		for (String p : palavras) {
			System.out.println(p);
		}
	}
	
	
	public int conta(String nome) {
		int qtd = 0;
		
		for (String palavra : palavras) {
			if (palavra.equals(nome))
				qtd++;
		}		
		return qtd;
	}

}