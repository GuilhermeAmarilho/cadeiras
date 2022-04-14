package Aula22;

public class PrincipalEr {
	public static void main(String[] args) {
		String email = "guilherme.amarilho@pereira.com.br";
		if (Utils.validarEmail(email))
			System.out.println("Email válido");
		else
			System.out.println("Email invalido");
	}
}
