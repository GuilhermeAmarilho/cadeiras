package Batalhas;

public abstract class Personagem {
	private int id;
	private String nome;
	public Personagem(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public String obterNome() {
		return this.nome;
	}
	
	public void imprimirDados() {
		System.out.println("Id: "+this.id + ", Nome: "+this.nome);
	}
	
	public abstract void atacar(float intensidade);
}
