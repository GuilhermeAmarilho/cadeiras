package aula05;

import java.util.Scanner;

public class Vetores {

	public static void main(String[] args) {
				
		int v[] = new int[5];
		String[] alunos = new String[27];
		
		for (int i = 0; i < alunos.length; i++) {
			alunos[i] = new String();
		}
		
		alunos[0] = "Angelo";
		alunos[1] = "Bruno Pergher";
		alunos[26] = "Winicios";
		
		for (int i = 0; i < alunos.length; i++) {
			System.out.println(i + " " + alunos[i]);
		}
		
	}
}
