package Filmes;

public class Bombonier {
	public static void main(String[] args) {
		Cinema c = new Cinema();

		Sala s = new Sala(1,2);
		Sala s2 = new Sala(3,8);
		Sala s3 = new Sala(5,32);

		Filmes f1 = new Filmes("Filme1", "Genero1", 2021, "Diretor1", s);
		Filmes f2 = new Filmes("Filme2", "Genero2", 2021, "Diretor2", s2);
		Filmes f3 = new Filmes("Filme3", "Genero3", 2021, "Diretor3", s3);

		f1.setValorIngresso(12.5);
		f2.setValorIngresso(23.75);
		f3.setValorIngresso(1.25);
		
		c.inserirSala(s);
		c.inserirSala(s2);
		c.inserirSala(s3);
		
		c.inserirFilme(f1);
		c.inserirFilme(f2);
		c.inserirFilme(f3);
		
		c.filmesExibicao();
		
		c.comprarIngresso(f2, 9); //não vai dar
		c.comprarIngresso(f2, 8); //esgotou os ingressos, gastei 190 reais
		
		c.valorTotal();
		
	}	
}
