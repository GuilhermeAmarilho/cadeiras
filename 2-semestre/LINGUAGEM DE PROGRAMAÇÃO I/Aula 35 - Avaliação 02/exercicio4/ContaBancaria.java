package exercicio4;

public class ContaBancaria {
	private String nConta;
	private String agencia;
	private String titular;
	private String senha;
	private Double saldo;
	public ContaBancaria() {
		this.nConta = null;
		this.agencia = null;
		this.titular = null;
		this.senha = null;
		this.saldo = 0.0;
	}
	public ContaBancaria(String nConta, String agencia, String titular, String senha, Double saldo) {
		this.nConta = nConta;
		this.agencia = agencia;
		this.titular = titular;
		this.senha = senha;
		this.saldo = saldo;
	}
	public void sacarValor(double valor) {
		if (saldo>valor) {			
			System.out.println("Você sacou "+valor+" Reais");
			this.saldo -= valor;
		}else 
			System.out.println("Saldo insuficiente");
	}
	public void consultarSaldo() {
		System.out.println("Seu saldo é de: "+this.saldo+" Reais");
	}
	public void depositarValor(double valor) {
		this.saldo += valor;
		System.out.println("Você depositou "+valor+" Reais");
	}
	public void transferenciaValor(ContaBancaria cRecebe, ContaBancaria cManda, double valor) {
		if (cManda.getSaldo() > valor) {
			cManda.sacarValor(valor);
			cRecebe.depositarValor(valor);
			System.out.println("Operação realizada com sucesso!");
		}else {
			System.out.println("Saldo insuficiente");
		}
		
	}
	public String getnConta() {
		return nConta;
	}
	public void setnConta(String nConta) {
		this.nConta = nConta;
	}
	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	public String getTitular() {
		return titular;
	}
	public void setTitular(String titular) {
		this.titular = titular;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	} 
}
