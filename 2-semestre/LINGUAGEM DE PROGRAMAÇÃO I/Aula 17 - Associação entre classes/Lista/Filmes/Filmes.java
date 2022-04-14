package Filmes;

public class Filmes {
	private String titulo;
	private String genero;
	private Integer ano;
	private String diretor;
	private Sala sala;
	private Double valorIngresso; // não soube onde colocar o valor ingresso;
	
	public Filmes(String titulo, String genero, Integer ano, String diretor, Sala sala) {
		this.titulo = titulo;
		this.genero = genero;
		this.ano = ano;
		this.diretor = diretor;
		this.sala = sala;
		this.valorIngresso = 0.0;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getDiretor() {
		return diretor;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public Double getValorIngresso() {
		return valorIngresso;
	}

	public void setValorIngresso(Double valorIngresso) {
		this.valorIngresso = valorIngresso;
	}
	
}
