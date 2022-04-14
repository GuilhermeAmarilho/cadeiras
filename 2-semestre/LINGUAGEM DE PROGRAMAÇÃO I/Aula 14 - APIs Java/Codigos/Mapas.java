package aula14;

import java.util.HashMap;

public class Mapas {

	public static void main(String[] args) {
		HashMap<String, String> cores = new HashMap();
		
		cores.put("branco", "FFFFFF");
		cores.put("preto", "000000");
		cores.put("vermelho", "FF00000");				
		
		for (String c : cores.keySet()) {
			System.out.println(c + "  " + cores.get(c));
			
		}
	}
}
