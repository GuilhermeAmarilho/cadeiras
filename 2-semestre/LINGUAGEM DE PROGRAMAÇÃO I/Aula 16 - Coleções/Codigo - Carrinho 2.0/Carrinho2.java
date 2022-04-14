import java.text.NumberFormat;
import java.util.ArrayList;

public class Carrinho2 {

	private ArrayList<Item> itens;
	private Double valorTotal;
	
	public Carrinho2() {
		this.itens = new ArrayList<>();
		this.valorTotal = 0.0;
	}
	
	public void adicionarItem(Produto produto, Integer quantidade) {
		Item item = new Item(produto, quantidade, produto.getPreco()*0.01);
		
		this.itens.add(item);
		System.out.println(">>>>+ " + produto.getNome() + " adicionado");
		System.out.println("\n###########################\n");
	}
	
	public Item getItem(int indice) {
		return this.itens.get(indice);
	}
		
	public void removerItem(Item item) {
		this.itens.remove(item);		
		System.out.println(">>>>- " + item.getProduto().getNome() + " removido");
		System.out.println("\n###########################\n");
	}
	
	public String calcularTotal() {
		for (Item item : itens) {						
			this.valorTotal += item.getProduto().getPreco() * item.getQuantidade() + item.getFrete();
		}
		return NumberFormat.getCurrencyInstance().format(this.valorTotal);		
	}
	
	public void listarItens() {

		System.out.println("Versão 2.0 do Carrinho de Compras");
		for(int i = 0; i < itens.size(); i++) {
			Item item = this.getItem(i);
						
			System.out.println("Índice: " + i);
			System.out.println("Produto: " + item.getProduto().getNome());
			System.out.println("Preço: " + item.getProduto().getPreco());
			System.out.println("Frete: " + item.getFrete());
									
			System.out.println("=====================");			
		}
	
		System.out.println("Total da compra: " + this.calcularTotal());
		System.out.println("\n###########################\n");
	}
	
}
