package lista04;

public class TesteQuadradoMagico {
	public static void main(String[] args) {
		int[][] a = {{1,2,3},{1,2,4},{1,2,5}};
		int[][] b = {{2,7,6},{9,5,1},{4,3,8}};
		
		QuadradoMagico qm = new QuadradoMagico(a);
		System.out.println(qm.testeQuadradoMagico());  //true
		
		
		QuadradoMagico qm1 = new QuadradoMagico(b);
		System.out.println(qm1.testeQuadradoMagico());  //true
		
	}
}
