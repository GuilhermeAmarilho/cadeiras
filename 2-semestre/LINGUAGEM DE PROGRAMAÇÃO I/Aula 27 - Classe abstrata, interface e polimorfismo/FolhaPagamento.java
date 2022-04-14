package aula27.folhapagamento;

import java.util.List;

public class FolhaPagamento {
	
	public static Double calcularFolha(List<Funcionario> funcionarios) {

		double totalFolha = 0;
		for (Funcionario f : funcionarios) {
			totalFolha += f.getSalario();			
		}
		
		return totalFolha;
	}

}
