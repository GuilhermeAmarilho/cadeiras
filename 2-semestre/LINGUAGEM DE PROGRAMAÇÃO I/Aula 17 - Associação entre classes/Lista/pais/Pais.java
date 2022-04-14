package pais;

import java.util.ArrayList;

public class Pais {
	private String codigo;
	private String nome;
	private Integer populacao;
	private Integer dimencao;
	private ArrayList<Pais> fronteiras;
	
	public Pais(String codigo, String nome, Integer populacao, Integer dimencao) {
		this.codigo = codigo;
		this.nome = nome;
		this.populacao = populacao;
		this.dimencao = dimencao;
		this.fronteiras = new ArrayList<>();
	}
	
	// ============ GET ============
		
	public String getCodigo() {
		return codigo;
	}
	public String getNome() {
		return nome;
	}
	public Integer getPopulacao() {
		return populacao;
	}
	public Integer getDimencao() {
		return dimencao;
	}
	public ArrayList<Pais> getFronteiras() {
		return this.fronteiras;
	}
	
	// ============ SET ============

	public void setDimencao(Integer dimencao) {
		this.dimencao = dimencao;
	}
	public void setPopulacao(Integer populacao) {
		this.populacao = populacao;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	// ============ Fronteiras ============
	
	public void ListarFronteira() {
		System.out.println("============ Fronteiras "+this.nome+" ============");
		for(Pais pais : this.fronteiras) {
			System.out.println("Nome: "+pais.getNome()+", Codigo: "+pais.getCodigo());
		}
		System.out.println();
	}
	public void InsertFronteira(Pais pais) {
		if(this!=pais) {			
			if(!this.fronteiras.contains(pais)) {			
				this.fronteiras.add(pais);
				pais.InsertFronteira(this);
			}
		}
	}
	public boolean IsFronteira(Pais pais) {
		if(this.fronteiras.contains(pais)) {
			return true;
		}else {
			return false;
		}		
	}
	public ArrayList<Pais> FronteirasComum(Pais pais) {
		ArrayList<Pais> fronteirasComum = new ArrayList<>();
		for(Pais fronteira : pais.getFronteiras()) {
			if(this.fronteiras.contains(fronteira)) {
				fronteirasComum.add(fronteira);
			}
		}
		return fronteirasComum;
	}
	
	// ============ Populacao ============
	
	public double DensidadePopulacional() {
		return this.populacao/this.dimencao;
	}
}
