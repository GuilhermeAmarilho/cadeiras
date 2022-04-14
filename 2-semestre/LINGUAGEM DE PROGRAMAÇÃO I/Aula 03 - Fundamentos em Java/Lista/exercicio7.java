package lista1;
import java.util.Scanner;

//Em um campeonato de futebol existem cinco times e cada um possui 11 jogadores
//Faça um programa que receba a idade, o peso e a altura de cada um dos jogadores, calcule e mostre:
//• a quantidade de jogadores com idade inferior a 18 anos;
//• a média das idades dos jogadores de cada time;
//• a média das alturas de todos os jogadores do campeonato;
//• a porcentagem de jogadores com mais de 80kg entre todos os jogadores do campeonato.


public class exercicio7 {
	public static void main(String[] args) {
        Scanner tec  = new Scanner(System.in);
		int[][] time = new int[22][3];
		int tam = time.length;
		int aux = 1;
		int aux2 = 0;
		int aux3 = 0;
		int sub18 = 0;
		int[] idadeJogadores = new int[2];
		int jogadoresAltura = 0;
		int jogadoresMais80 = 0;
		for (int i = 0;i<tam;i++){
			if (i>=tam/2) { //pura gambiarra, o aux é para ver quando está tratando do primeiro time
				aux = 2; 	//ou do segundo, pois divide pela metade para saber a partir de que ponto
				aux2 = tam/2;//deve começar o segundo time, é apenas visual, não afeta o sistema.
				aux3 = 1;
			}
			System.out.println("Informe a idade do "+(i+1-aux2)+"º jogador do "+aux+" time: ");
			time[i][0] = tec.nextInt(); 
			if (time[i][0]<18) {sub18++;} //caso o jogador seja -18, já conta na variável contadora.
			idadeJogadores[aux3] += time[i][0];  //Acumula a idade dos jogadores de cada time
			System.out.println("Informe a altura do "+(i+1-aux2)+"º jogador do "+aux+" time (em cm): ");
			time[i][1] = tec.nextInt(); 
			jogadoresAltura+=time[i][1];
			System.out.println("Informe o peso do "+(i+1-aux2)+"º jogador do "+aux+" time (em kg): ");
			time[i][2] = tec.nextInt(); 
			if (time[i][2]>80) {jogadoresMais80++;} //caso o jogador tenha +80 kg contará na variavel.
		}
		System.out.println("O total de jogadores com -18 anos de idade é: "+sub18);
		
		System.out.println("A idade média do time 1 é: "+(idadeJogadores[0]/(tam/2)));
		System.out.println("A idade média do time 2 é: "+(idadeJogadores[1]/(tam/2)));
		
		System.out.println("A média de altura dos jogadores é de: "+(jogadoresAltura/tam));
		
		
		System.out.println((jogadoresMais80/20*100)+"% dos jogadores pesam mais que 80Kg");
	}
}
