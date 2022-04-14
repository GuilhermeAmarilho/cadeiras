package aula23;

public class PrincipalExercicioExcecao {

	public static void main(String[] args) {
		ExercicioExcecao ee = new ExercicioExcecao();
		
		int num = ee.lerNumero();
		
		System.out.println("Número: " + num);
		
		double resp = 0;
		
		try {
			resp = ee.divisao(10, num);
		}catch (ArithmeticException e) {
			System.err.println("Você não pode dividir um número por zero");
		}
		
		System.out.println("Resultado: " + resp);
	}
	
	
}
