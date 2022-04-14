package aula27.folhapagamento;

public class Gerente extends MensalFixo {

	private Double bonificacao;
	
	public Gerente(String nome, String cpf, Double fixo, Double bonificacao) {
		super(nome, cpf, fixo);
		this.bonificacao = bonificacao;
	}
	
	@Override
	public double getSalario() {
	
		return super.getSalario() + this.bonificacao;
	}
	
	public Double getBonificacao() {
		return bonificacao;
	}
	
	public void setBonificacao(Double bonificacao) {
		this.bonificacao = bonificacao;
	}
}
