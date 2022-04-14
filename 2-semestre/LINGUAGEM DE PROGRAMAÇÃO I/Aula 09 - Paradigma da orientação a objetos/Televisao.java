package aula9_continuacaopoo;

import java.util.Arrays;

public class Televisao {
	private boolean ligado = false;
	private int[] canais = new int[8];
	private int canalAtual = 2;
	private int volume = 0;
	private int volumeMax = 100;
	public void power() {
		if(ligado) {
			ligado = false;
			System.out.println("Voc� desligou a televis�o");
		}else {
			inicializarCanais();
			ligado = true;
			System.out.println("Voc� ligou a televis�o");
		}
	}
	public void setCanal(int channel) {
		if(ligado) {
			int aux = Arrays.binarySearch(canais,channel);
			if(aux <=0 || aux>7) {
				System.out.println("Voc� inseriu um canal inexistente");
			}else {
				canalAtual = Arrays.binarySearch(canais,channel);
				//System.out.println(canalAtual);
				System.out.println("Voc� est� sintonizado no canal "+canais[canalAtual]);
			}
		}else {
			System.out.println("A televis�o est� desligada!");		
		}
	}
	private void inicializarCanais() {
		for(int i = 0; i < 8; i++) { 
			canais[i] = i+1;
		}
	}
	public void incrementarCanal() {
		if(ligado) {	
			if(canalAtual+1<canais.length) {			
				canalAtual++;
			}else {
				canalAtual = 0;
			}
			System.out.println("Voc� subiu um canal, agora est� sintonizado no canal "+canais[canalAtual]);
		}else {
			System.out.println("A televis�o est� desligada!");		
		}
	}
	public void decrementarCanal() {
		if(ligado) {
			if((canalAtual-1)>=0) {			
				canalAtual--;
			}else {
				canalAtual = canais.length - 1;
			}
			System.out.println("Voc� desceu um canal, agora est� sintonizado no canal "+canais[canalAtual]);
		}else {
			System.out.println("A televis�o est� desligada!");		
		}
	}
	public void incrementarVolume() {
		if(ligado) {
			if(volume+1<100) {			
				volume++;
				System.out.println("Voc� aumentou o volume para "+volume+"%");				
			}else {
				System.out.println("Volume m�ximo j� atingido");
			}
		}else {
			System.out.println("A televis�o est� desligada!");		
		}
	}
	public void decrementarVolume() {
		if(ligado) {
			if(volume-1>0) {			
				volume--;
				System.out.println("Voc� diminuiu o volume para "+volume+"%");
			}else {
				System.out.println("Volume m�nimo j� atingido");
			}
		}else {
			System.out.println("A televis�o est� desligada!");		
		}
	}
	
}
