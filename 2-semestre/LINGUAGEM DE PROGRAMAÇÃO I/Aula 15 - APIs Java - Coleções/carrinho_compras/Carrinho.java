package carrinho_compras;

import java.util.ArrayList;
import java.util.Map.Entry;


public class Carrinho {
	
	private ArrayList<Item> itens;
	
	public Carrinho() {
		 this.itens = new ArrayList<>();
	}
	
	public void adicionarItem(Produto p, int quantidade) {
		
		if (quantidade >= 1) {
			Item item = new Item();
			item.criar(p, quantidade);
			
			this.itens.add(item);
		}		
	}
	
	public void removerItem(Produto p) {
		for(Item item: this.itens) {
			if (item.existe(p))
				itens.remove(item);			
		}		
	}
	
	public void mostrarCarrinho() {
		
		for(Item item: this.itens) {
			
			
		}
	}

}
