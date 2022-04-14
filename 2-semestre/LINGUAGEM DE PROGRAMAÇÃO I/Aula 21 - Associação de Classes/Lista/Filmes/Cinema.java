package Filmes;

import java.text.NumberFormat;
import java.util.ArrayList;

import pais.Pais;

public class Cinema {
	private ArrayList<Filmes> filmes;
	private ArrayList<Sala> salas;
	private Double totalGasto;
	
	public Cinema() {
		this.filmes = new ArrayList<>();
		this.salas = new ArrayList<>();
		this.totalGasto = 0.0;
	}
	
	// Inserir
	
	public boolean inserirSala(Sala sala) {
		if(!this.salas.contains(sala)) {					
			this.salas.add(sala);
			return true;
		}else {			
			return false;
		}
	}
	
	public boolean inserirFilme(Filmes filme) {
		if(!this.filmes.contains(filme)) {					
			this.filmes.add(filme);
			return true;
		}else {			
			return false;
		}
	}
	
	// end
	
	public void filmesExibicao() {
		System.out.println("##### Filmes em exibição #####");
		System.out.println();
		for (Filmes filme : this.filmes) {			
			System.out.println("Titulo: "+filme.getTitulo()+", Genero: "+filme.getGenero()+", Ano: "+filme.getAno());
			System.out.println("Diretor: "+filme.getDiretor()+", Sala: "+filme.getSala().getNumero()+", Valor Ingresso: "+filme.getValorIngresso());
			System.out.println();			
		}
		System.out.println("------------------------------");		
	}
	
	public boolean comprarIngresso(Filmes filme, Integer qtd) {
		if(this.filmes.contains(filme)) {
			if(filme.getSala().getCapacidade() >= qtd) {
				this.totalGasto += filme.getValorIngresso() * qtd;
				filme.getSala().setCapacidade( (filme.getSala().getCapacidade() - qtd) );
				return true;
			}else {
				System.out.println("Ingressos esgotados");
			}
		} 
		return false;
	}
	
	public void valorTotal() {
		String valorTotal = NumberFormat.getCurrencyInstance().format(this.totalGasto);	
		System.out.println("O valor total foi de: "+valorTotal);
	}
}
