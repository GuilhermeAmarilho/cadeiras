package Lista;
public class Telefone {
	private String numero;
	private String rotulo;
	public Telefone(String numero, String rotulo) {
		if(this.validarNumero(numero)) {			
			this.numero = numero;
			this.rotulo = rotulo;
			System.out.println("Número cadastrado com sucesso!");
		}else
			System.out.println("Número informado incorretamente!\nFormato: '+XX XX X XXXX-XXXX';");
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getRotulo() {
		return rotulo;
	}
	public void setRotulo(String rotulo) {
		this.rotulo = rotulo;
	}
	public boolean validarNumero(String numero) {
		// "+55_49_9_9999-9999" = 18 letras
		if(numero.indexOf("+") != -1 && numero.indexOf("-") != -1 && numero.length() == 18)
			return true;
		return false;
	}
}