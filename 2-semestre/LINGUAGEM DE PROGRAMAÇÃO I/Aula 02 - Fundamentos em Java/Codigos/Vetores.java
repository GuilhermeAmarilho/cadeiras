package aula03;

import java.util.Iterator;

public class Vetores {

	public static void main(String[] args) {
		
		int[] numeros = new int[10];
		
		String[] n2 = {"aaa", "nbbbb", "cvcvcvc", "dedede"};	
		
		for (int i = 0; i < n2.length; i++) {
			System.out.println(n2[i]);
		}
		
		for (String s : n2) {
			
			System.out.println(s);
			
		}
		
		
		
	}
}
