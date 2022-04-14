package aula27.folhapagamento;

public class Comissionado extends Funcionario {

	private Double percentualComissao;
	private Double totalVendas;
	
	
	public Comissionado(String nome, String cpf, Double percentual) {
		super(nome, cpf);
		this.percentualComissao = percentual;
		this.totalVendas = 0.0;
	}
	
	@Override
	public double getSalario() {		
		return this.totalVendas*this.percentualComissao;
	}

	public Double getPercentualComissao() {
		return percentualComissao;
	}

	public void setPercentualComissao(Double percentualComissao) {
		this.percentualComissao = percentualComissao;
	}

	public Double getTotalVendas() {
		return totalVendas;
	}

	public void setTotalVendas(Double totalVendas) {
		this.totalVendas = totalVendas;
	}		

}
