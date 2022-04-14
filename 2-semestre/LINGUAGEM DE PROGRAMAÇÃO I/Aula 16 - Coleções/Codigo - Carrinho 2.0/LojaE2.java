public class LojaE2 {

	public static void main(String[] args) {
		Carrinho2 carrinho = new Carrinho2();
		
		Produto p1 = new Produto(1, "Iphone 13", 15000);
		Produto p2 = new Produto(2, "Programando em C", 80);
		Produto p3 = new Produto(3, "Tênis X", 100);
		Produto p4 = new Produto(4, "Notebook HP EliteBook", 3500);
		Produto p5 = new Produto(5, "Mochila para Notebook", 130);
		
		carrinho.adicionarItem(p3, 1);
		carrinho.adicionarItem(p2, 10);
		carrinho.adicionarItem(p5, 2);
		
		carrinho.listarItens();
		
		Item item = carrinho.getItem(1);
		carrinho.removerItem(item);
		
		carrinho.listarItens();

	}
}
