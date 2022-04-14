package carrinho_compras;

import java.util.HashMap;
import java.util.Map.Entry;

public class Carrinho {
	
	private HashMap<Produto, Integer> itens;	
	
	
	public Carrinho() {
		this.itens = new HashMap<>();
	}
	
	public void adicionarItem(Produto produto, Integer quantidade) {
		//se produto ainda não existe na lista de itens, adiciona
		if (!this.itens.containsKey(produto)) {
			this.itens.put(produto, quantidade);		
		}else {//se já existe, incrementa na quantidade atual
			Integer quantidadeAtual = this.itens.get(produto);
			this.itens.put(produto, quantidadeAtual + quantidade);			
		}
		System.out.println(">>>>+ " + produto.getNome() + " adicionado");
		System.out.println("\n###########################\n");
	}

	public void removerItem(Produto produto) {
		this.itens.remove(produto);
		System.out.println(">>>>- " + produto.getNome() + " removido");
		System.out.println("\n###########################\n");
	}
	
	public void listarItens() {
		System.out.println("Seu carrinho de compras:");
		
		double valorTotal = 0;
		
		for (Entry<Produto, Integer> item: this.itens.entrySet()) {
			
//			Produto p = item.getKey();
//			Integer qtd = item.getValue();
			
//			valorTotal += qtd*p.getPreco();
			
			valorTotal += item.getValue()*item.getKey().getPreco();
			
//			System.out.println("Produto: " + p.getNome());
			System.out.println("Produto: " + item.getKey().getNome());
//			System.out.println("Preço: " + p.getPreco());
			System.out.println("Preço: " + item.getKey().getPreco());
//			System.out.println("Quantidade: " + qtd);
			System.out.println("Quantidade: " + item.getValue());
			
			System.out.println("=====================");			
		}
		
		System.out.println("Total da compra: R$ " + valorTotal);
		System.out.println("\n###########################\n");
	}
	
	
	
	
	
	
	
	
	
	
}
