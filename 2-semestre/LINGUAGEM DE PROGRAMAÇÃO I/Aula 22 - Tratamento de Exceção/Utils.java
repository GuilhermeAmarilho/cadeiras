package Aula22;

public class Utils {
	public static boolean validarEmail(String email) {
		// Testando emal na própria string
		String emailER = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
		if(email.matches(emailER))
			return true;
		else
			return false;
	}	
}
