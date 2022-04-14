package carrinho_compras;

import java.util.HashMap;

public class Item {
		
	private HashMap<Produto, Integer> item;	
	
	public Item() {
		this.item = new HashMap<>();
	}
	
	public Item(Produto p, int quantidade) {
		this.item = new HashMap<>();
		this.item.put(p, quantidade);		
	}
	
	public void criar(Produto p, int quantidade) {
		this.item.put(p, quantidade);
	}
	
	public HashMap getItem() {
		return this.item;
	}

//	public void remover(Produto p) {
//		this.item.remove(p);
//	}
	
	public boolean existe(Produto p) {
		return item.containsKey(p);
	}
}