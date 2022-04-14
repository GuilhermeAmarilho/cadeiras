package aula27.folhapagamento;

public class ComissionadoEfetivo extends Comissionado{
	private Double salarioFixo;
	
	public ComissionadoEfetivo(String nome, String cpf, Double percentual, Double fixo) {
		super(nome, cpf, percentual);
		this.salarioFixo = fixo;
	}
	
	@Override
	public double getSalario() {	
		return super.getSalario() + this.salarioFixo;
	}

	public Double getSalarioFixo() {
		return salarioFixo;
	}

	public void setSalarioFixo(Double salarioFixo) {
		this.salarioFixo = salarioFixo;
	}		
}
