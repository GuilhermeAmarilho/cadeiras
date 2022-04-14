package Lista;
public class Email {
	private String email;
	private String rotulo;
	public Email(String email, String rotulo) {
		if (this.validarEmail(email)) {			
			this.email = email;
			this.rotulo = rotulo;
			System.out.println("Email Cadastrado com sucesso");
		}else
			System.out.println("Email informado incorretamente");		
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRotulo() {
		return rotulo;
	}
	public void setRotulo(String rotulo) {
		this.rotulo = rotulo;
	}
	public boolean validarEmail(String email) {
		if(email.indexOf("@") != -1 && email.indexOf(".com") != -1)
			return true;
		return false;
	}
}
