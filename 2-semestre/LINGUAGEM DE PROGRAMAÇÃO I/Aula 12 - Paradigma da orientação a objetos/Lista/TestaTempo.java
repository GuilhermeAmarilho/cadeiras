package lista04;

public class TestaTempo {
	public static void main(String[] args) {
		// TESTE 1
		Tempo tempo = new Tempo(12, 55, 15);
		// TESTE DAS FUNÇÕES TO...
		System.out.println("To String: "+tempo.toString());
		System.out.println("To Second: "+tempo.toSecond());
		// CRIANDO TEMPOS PARA O TIMEDIFF
		Tempo tempo1 = new Tempo(12, 55, -1);
		Tempo tempo2 = new Tempo(11, 56, 20);
		Tempo tempo3 = new Tempo(00, 00, 00);
		Tempo tempo4 = new Tempo(11, 54, 14);
		Tempo tempo5 = new Tempo(12, 56, 16);
		System.out.println(tempo2);
		System.out.println(tempo3);
		// TIMEDIFF
		System.out.println("Teste 1 = "+tempo.timeDiff(tempo1)); // 12:55:15 - 00:00:00 = 12:55:15
		System.out.println("Teste 2 = "+tempo.timeDiff(tempo2)); // 12:55:15 - 11:56:20 = 00:48:48
		System.out.println("Teste 3 = "+tempo.timeDiff(tempo3)); // 12:55:15 - 00:00:00 = 12:55:15
		System.out.println("Teste 4 = "+tempo.timeDiff(tempo4)); // 12:55:15 - 11-54-14 = 01-01-01
		System.out.println("Teste 5 = "+tempo.timeDiff(tempo5)); // 12:55:15 - 12:56:16 = -1:58:59
		
	}
}
