package aula03;

import javax.swing.JOptionPane;

public class Tela {
	
	public static void main(String[] args) {
		String s = JOptionPane.showInputDialog("Forneça um número inteiro: ");
		
		int n = Integer.parseInt(s);
		
		JOptionPane.showMessageDialog(null, n);
	}

}
