package aula14;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Estados {

	private HashMap<String, String> estados;
	
	
	public Estados() {
		this.estados = new HashMap<>();
	}
	
	public boolean inserirEstado(String sigla, String estado) {
		
		if (!estados.containsKey(sigla)) {
			this.estados.put(sigla, estado);
			return true;
		}else
			return false;		
	}
	
	public String getEstado(String sigla) {
		return this.estados.get(sigla);
	}
	
	public void imprimir() {
		for(Entry<String, String> estado: this.estados.entrySet()) {
			System.out.println(estado.getKey() + " - " + estado.getValue());
		}
	}
	
	public String getSigla(String e) {		
		for(Entry<String, String> estado: this.estados.entrySet()) {		
			if (e.equals(estado.getValue()))
				return estado.getKey();			
		}
		
		return null;
	}

		
}
