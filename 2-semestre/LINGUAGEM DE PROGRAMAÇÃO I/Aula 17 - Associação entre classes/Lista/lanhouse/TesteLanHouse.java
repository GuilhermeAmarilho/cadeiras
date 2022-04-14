package lanhouse;

public class TesteLanHouse {
	public static void main(String[] args) {
		Computador c1 = new Computador(1,0,"Dell",16,"GTX 1050 TI","Ryzen 5 3600x");
		Computador c2 = new Computador(2,0,"Positivo",2,"HD Graphics 2000","Intel Celeron (tm)");
		Computador c3 = new Computador(3,0,"Aorus",12,"GT 730","Intel Pentium 460x");
		Computador c4 = new Computador(4,0,"Asus",64,"RTX 3080 TI","Ryzen 9 5600X");
		
		LanHouse lh = new LanHouse();
		
		lh.inserirComputador(c1);
		lh.inserirComputador(c3);
		lh.inserirComputador(c4);
		
		//lh.listarPorMemoria(11); // c1, c3, c4
		
		lh.removerComputador(c4);
		
		//lh.listarPorMemoria(11); // c1, c3
		lh.alugarComputador(c1, 4);
		//c1.imprimir(); //alterou para 1
		lh.computadorDefeituoso(c4, "22-05-2021", "Liguei no 220 Volts");
	}
}
