package exercicio4;

import java.util.Date;

public class ContaPoupanca extends ContaBancaria{
	private Date dataCriacao;

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public ContaPoupanca() {
		super();
	}

	public ContaPoupanca(String nConta, String agencia, String titular, String senha, Double saldo, Date dataCriacao) {
		super(nConta, agencia, titular, senha, saldo);
		this.dataCriacao = dataCriacao;
	}
	
}
