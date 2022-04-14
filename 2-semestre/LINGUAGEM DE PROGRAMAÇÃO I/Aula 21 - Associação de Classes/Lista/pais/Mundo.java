package pais;

public class Mundo {
	public static void main(String[] args) {
		Pais br = new Pais("BR", "Brasil", 500, 400);
		Pais ar = new Pais("AR", "Argentina", 500, 400);
		Pais uy = new Pais("UY", "Uruguai", 500, 400);
		Pais eq = new Pais("EQ", "Equador", 500, 400);
		Pais t1 = new Pais("T1", "Teste 1", 500, 400);
		Pais t2 = new Pais("T2", "Teste 2", 500, 400);
		Pais t3 = new Pais("T3", "Teste 3", 500, 400);
		Pais t4 = new Pais("T4", "Teste 4", 500, 400);

		br.InsertFronteira(ar);
		br.InsertFronteira(uy);
		br.InsertFronteira(t1);
		br.InsertFronteira(t2);
		br.InsertFronteira(t2); //não insere duas vezes
		//br.ListFronteira(); // AR, UY, T1, T2

		eq.InsertFronteira(t1);
		eq.InsertFronteira(t3);
		eq.InsertFronteira(t4);
		eq.InsertFronteira(ar); 
		eq.InsertFronteira(eq); //não insere ele mesmo
		
		//eq.ListarFronteira(); // T1, T3, T4, AR
		
		//t1.ListarFronteira(); // BR, EQ, ele adiciona automáticamente

		br.IsFronteira(ar); // True
		br.IsFronteira(eq); // False
				
		br.DensidadePopulacional(); // DensidadePopulacional = 1
		
		br.FronteirasComum(eq); // AR, T1
	}
}
