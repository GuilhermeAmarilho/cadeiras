package lista04;

public class QuadradoMagico {
	static int[][] matriz = new int[3][3];
	
	public QuadradoMagico(int[][] matriz) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				this.matriz[i][j] = matriz[i][j];
			}
		}
	}
	
	// ========== GETTER ==========
	
	public int[][] getQuadradoMagico() {
		return this.matriz;
	}
	
	public void lerQuadradoMagico() {
		for (int i = 0; i<3; i++) {
			System.out.println("["+this.matriz[i][0]+"]["+this.matriz[i][1]+"]["+this.matriz[i][2]+"]");
		}
	}
		
	// ========== TESTE QUADRÁDO MÁGICO
	
	public static boolean testeQuadradoMagico() {
		boolean condicao = true;
		int[] soma = new int[8];
		
		// soma linha
		
		for (int i = 0; i<3; i++) {
			soma[i] = matriz[i][0] + matriz[i][1] + matriz[i][2]; 
		}
		
		// soma coluna
		
		for (int i = 0; i<3; i++) {
			soma[(i+3)] = matriz[0][i] + matriz[1][i] + matriz[2][i]; 
		}
		
		// soma diagonal
		
		soma[6] = matriz[0][0] + matriz[1][1] + matriz[2][2];
		
		// soma diagonal oposta
		
		soma[7] = matriz[0][2] + matriz[1][1] + matriz[2][0];
		
		// teste das somas
		
		for (int i = 1; i < 8; i++) {
			if (soma[0] != soma[i]) {
				condicao = false;
			}
		}
		
		// teste de elementos repitidos
		
		for (int i = 0; i<3; i++) {					//seleciono a linha a ser usada como base
			for (int j = 0; j<3; j++) {				//seleciono o elemento a ser usado como base
				for (int k = 0; k<3; k++) {			//linha atual de teste
					for (int l = 0; l<3; l++) {		//elemento atual de teste
						if( (matriz[i][j] == matriz[k][l]) && (j!=l || i!=k) ) {
							condicao = false;
						}
					}
				}
			}
		}
		return condicao;
	}
		
}