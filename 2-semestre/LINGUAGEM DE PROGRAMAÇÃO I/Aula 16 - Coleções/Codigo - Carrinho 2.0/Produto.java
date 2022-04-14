

public class Produto {

	private int codigo;
	private String nome;
	private double preco;
	
	public Produto(int cod, String nome, double preco) {		
		this.codigo = cod;
		this.nome = nome;
		this.preco = preco;
	}
	
	public int getCodigo() {
		return this.codigo;
	}	
	
	public String getNome() {
		return this.nome;		
	}
	
	public double getPreco() {
		return this.preco;
	}
}
