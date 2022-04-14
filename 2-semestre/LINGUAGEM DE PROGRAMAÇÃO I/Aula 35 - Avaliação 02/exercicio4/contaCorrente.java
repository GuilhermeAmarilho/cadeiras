package exercicio4;

public class contaCorrente extends ContaBancaria{
	private double chequeEspecial;

	public contaCorrente() {
		super();
		this.chequeEspecial = 0.0;
	}

	public contaCorrente(String nConta, String agencia, String titular, String senha, Double saldo, double chequeEspecial) {
		super(nConta, agencia, titular, senha, saldo);
		this.chequeEspecial = chequeEspecial;
	}
	public void sacarValor(double valor) {
		if((this.chequeEspecial+this.getSaldo()+1)>valor) {
			if(valor>this.getSaldo()+1) {
				this.setSaldo(0.0);
				this.chequeEspecial -= this.getSaldo() + 1 - valor;
			}else
				this.sacarValor(valor+1);
			System.out.println("Operação realizada com sucesso");
		}else 
			System.out.println("Saldo insuficiente");
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
	public Double getSaldo() {
		return this.chequeEspecial + super.getSaldo();
	}
}
