package aula27.folhapagamento;


public class Horista extends MensalFixo {

	private Double valorHora;
	private int quantidadeHorasTrabalhadas;
	
	public Horista(String nome, String cpf, Double salarioBase, Double valorHora) {
		super(nome, cpf, salarioBase);
		this.quantidadeHorasTrabalhadas = 0;
		this.valorHora = valorHora;
	}
	
	@Override
	public double getSalario() {		
		return super.getSalario() + this.valorHora*this.quantidadeHorasTrabalhadas;
	}

	public Double getValorHora() {
		return valorHora;
	}

	public void setValorHora(Double valorHora) {
		this.valorHora = valorHora;
	}

	public int getQuantidadeHorasTrabalhadas() {
		return quantidadeHorasTrabalhadas;
	}

	public void setQuantidadeHorasTrabalhadas(int quantidadeHorasTrabalhadas) {
		this.quantidadeHorasTrabalhadas = quantidadeHorasTrabalhadas;
	}		
}
