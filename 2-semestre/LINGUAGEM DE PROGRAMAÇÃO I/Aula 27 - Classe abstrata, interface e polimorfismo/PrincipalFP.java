package aula27.folhapagamento;

import java.util.ArrayList;
import java.util.List;

public class PrincipalFP {

	public static void main(String[] args) {

		MensalFixo f1 = new MensalFixo("Fabio", "111", 3500.0);
		
		Horista f2 = new Horista("Henrique", "222", 3500.0, 100.0);
		f2.setQuantidadeHorasTrabalhadas(20);

		Comissionado f3 = new Comissionado("Mikenson", "333", 0.15);
		f3.setTotalVendas(100000.0);
		
		MensalFixo f4 = new MensalFixo("José", "444", 4000.0);
		
		ComissionadoEfetivo f5 = new ComissionadoEfetivo("Vinicius", "888", 0.15, 1000.0);
		f5.setTotalVendas(10000.0);
		ComissionadoEfetivo f6 = new ComissionadoEfetivo("Gabriel", "666", 0.15, 3000.0);
		f6.setTotalVendas(20000.0);
		
		MensalFixo f7 = new MensalFixo("Rodrigues", "777", 2000.0);
		
		Gerente f8 = new Gerente("Gabrielle", "555", 4000.0, 10000.0);
		
		List<Funcionario> funcionarios = new ArrayList<>();
		
		funcionarios.add(f1);
		funcionarios.add(f2);
		funcionarios.add(f3);
		funcionarios.add(f4);
		funcionarios.add(f5);
		funcionarios.add(f6);
		funcionarios.add(f7);
		funcionarios.add(f8);
		
				
		Double totalFolha = FolhaPagamento.calcularFolha(funcionarios);
		
		System.out.println("Total da Folha de Pagamento R$: " + totalFolha);
		
	
		//criar 04 vetores
		//vetor MensalFixo
		//vetor Horista
		//vetor Comissionado
		//vetor ComissionadoEfetivo
		
		//calcular folha p cada tipo
		//fp.calcularFolhaMensalFixo(vetor de mensal fixo)
		//fp.calcularFolhaHorista(vetor de horistas)
		//fp.calcularFolhaComissionado(vetor de comissionados)
		//fp.calcularFolhaComissionadoEfetivo(vetor de comissionados efetivos)
		
		//somar os totais
						
		
	}
}
