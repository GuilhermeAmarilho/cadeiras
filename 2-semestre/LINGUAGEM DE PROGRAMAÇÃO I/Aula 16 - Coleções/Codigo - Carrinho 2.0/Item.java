
public class Item {
	
	private Produto produto;
	private Integer quantidade;
	private Double frete;
	private boolean garantia;
	private boolean presente;
	
	public Item(Produto p, Integer q, Double f) {
		this.produto = p;
		this.quantidade = q;
		this.frete = f;
	}
	
	public Produto getProduto() {
		return produto;
	}
	
	public Integer getQuantidade() {
		return quantidade;
	}
	
	public Double getFrete() {
		return frete;
	}

}
