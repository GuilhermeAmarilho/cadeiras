package lanhouse;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map.Entry;

public class LanHouse {
	private ArrayList<Computador> pcs;
	private HashMap<Computador, Integer> computadores;
	private HashMap<String, String> defeitosEncontrados;
	
	public LanHouse() {
		this.computadores = new HashMap<>(); 
	}
	
	public boolean inserirComputador(Computador pc) {
		if (!computadores.containsKey(pc)) {
			this.computadores.put(pc, 0);
			return true;
		}else {
			return false;	
		}
	}
	
	public boolean removerComputador(Computador pc) {
		if (this.computadores.containsKey(pc)) {
			this.computadores.remove(pc);
			return true;
		} else {
			return false;
		}
	}
	
	public void listarPorMemoria(Integer memoria) {
		System.out.println("===== Computadores com pelo menos "+memoria+" GB RAM =====");
		for(Entry<Computador, Integer> computador: this.computadores.entrySet()) {
			if (computador.getKey().getCapacidadeMemoria() >= memoria) {
				System.out.println("Modelo: "+computador.getKey().getModelo());
				System.out.println("Memória total: "+computador.getKey().getCapacidadeMemoria());
				System.out.println("Placa de vídeo: "+computador.getKey().getPlacaVideo());
				System.out.println("Processador: "+computador.getKey().getProcessador());
				System.out.println();
			}
		}
	}

	public boolean alugarComputador(Computador pc, Integer hora) {
		if(this.computadores.containsKey(pc) && pc.getStatus() == 0) {
			this.computadores.remove(pc);
			pc.setStatus(1);			
			this.computadores.put(pc, hora);
			return true; //gambiarra pois não consegui alterar o atributo, então o recriei.
		}
		return false;
	}

	public boolean computadorDefeituoso(Computador pc, String Hora, String defeito) {
		if(this.computadores.containsKey(pc)) {
			this.computadores.remove(pc);
			pc.setStatus(2);			
			this.computadores.put(pc, 0);
			this.defeitosEncontrados.put(Hora, defeito);
			return true; //gambiarra pois não consegui alterar o atributo, então o recriei.
		}
		return false;
	}

}
