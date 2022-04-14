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
			System.out.println("Você desligou a televisão");
		}else {
			inicializarCanais();
			ligado = true;
			System.out.println("Você ligou a televisão");
		}
	}
	public void setCanal(int channel) {
		if(ligado) {
			int aux = Arrays.binarySearch(canais,channel);
			if(aux <=0 || aux>7) {
				System.out.println("Você inseriu um canal inexistente");
			}else {
				canalAtual = Arrays.binarySearch(canais,channel);
				//System.out.println(canalAtual);
				System.out.println("Você está sintonizado no canal "+canais[canalAtual]);
			}
		}else {
			System.out.println("A televisão está desligada!");		
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
			System.out.println("Você subiu um canal, agora está sintonizado no canal "+canais[canalAtual]);
		}else {
			System.out.println("A televisão está desligada!");		
		}
	}
	public void decrementarCanal() {
		if(ligado) {
			if((canalAtual-1)>=0) {			
				canalAtual--;
			}else {
				canalAtual = canais.length - 1;
			}
			System.out.println("Você desceu um canal, agora está sintonizado no canal "+canais[canalAtual]);
		}else {
			System.out.println("A televisão está desligada!");		
		}
	}
	public void incrementarVolume() {
		if(ligado) {
			if(volume+1<100) {			
				volume++;
				System.out.println("Você aumentou o volume para "+volume+"%");				
			}else {
				System.out.println("Volume máximo já atingido");
			}
		}else {
			System.out.println("A televisão está desligada!");		
		}
	}
	public void decrementarVolume() {
		if(ligado) {
			if(volume-1>0) {			
				volume--;
				System.out.println("Você diminuiu o volume para "+volume+"%");
			}else {
				System.out.println("Volume mínimo já atingido");
			}
		}else {
			System.out.println("A televisão está desligada!");		
		}
	}
	
}
