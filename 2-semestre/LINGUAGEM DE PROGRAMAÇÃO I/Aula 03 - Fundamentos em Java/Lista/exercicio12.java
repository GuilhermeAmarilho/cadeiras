package lista1;
import java.util.Scanner;
import java.lang.Math;

//Fa�a um programa que leia um conjunto n�o determinado de valores, um de cada vez, e
//escreva uma tabela com cabe�alho, que deve ser repetido a cada vinte linhas. A tabela
//dever� conter o valor lido, seu cubo e sua raiz quadrada. Finalize quando a entrada for
//um n�mero negativo ou 0.

public class exercicio12 {
	public static void main(String[] args) {
        Scanner tec  = new Scanner(System.in);
        int num = 1;
        String text = "";
        for (int i = 0; num > 0; i++) {
        	if(i%5==0) {
        		text += "\n Exerc�cio 12 - IFC Videira - Linguagem de programa��o I\n";
        		i++;
        	}
            System.out.println("Informe um valor (0 para sair): ");
            num = tec.nextInt();
            text += "Valor: "+num+", seu cubo: "+Math.pow(num,2)+" e sua raiz quadrada: "+Math.sqrt(num)+"\n";
        }
        System.out.println(text);
	}
}
