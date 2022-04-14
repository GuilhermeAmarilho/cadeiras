package lista04;

public class Tempo{
	private int hora;
	private int minuto;
	private int segundo;
	
	// =========== CONSTRUCTOR =========== 
	
	public Tempo() {
		this.hora = 0;
		this.minuto = 0;
		this.segundo = 0;
	}

	public Tempo(int segundo) {
		if(segundo < 60 && segundo >= 0) {			
			this.hora = 0;
			this.minuto = 0;
			this.segundo = segundo;
		}
		else {
			System.out.println("Informe o horário corretamente!");
			this.defaultValue();
		}
	}

	public Tempo(int minuto, int segundo) {
		if((segundo < 60 && segundo >= 0) && (minuto < 60 && minuto >= 0)) {			
			this.hora = 0;
			this.minuto = minuto;
			this.segundo = segundo;
		}
		else {
			System.out.println("Informe o horário corretamente!");
			this.defaultValue();
		}
	}
	
	public Tempo(int hora, int minuto, int segundo) {
		if((segundo < 60 && segundo >= 0) && (minuto < 60 && minuto >= 0) && (hora>=0)) {			
			this.hora = hora;
			this.minuto = minuto;
			this.segundo = segundo;
		}
		else {
			System.out.println("Informe o horário corretamente!");
			this.defaultValue();
		}
	}
	
	// =========== SETers ===========
	
	public boolean setHora(int hora) {
		if(hora>0) {			
			this.hora = hora;
			return true;
		}else {
			return false;
		}
	}
	
	public boolean setMinuto(int minuto) {
		if(minuto < 60 && minuto > 0) {			
			this.minuto = minuto;
			return true;
		}else {
			return false;
		}
	}
	
	public boolean setSegundo(int segundo) {
		if(segundo < 60 && segundo > 0) {			
			this.segundo = segundo;
			return true;
		}else {
			return false;
		}
	}
	
	// =========== GETers ===========
	
	public int getHora() {
		return this.hora;
	}
	public int getMinuto() {
		return this.minuto;
	}
	public int getSegundo() {
		return this.segundo;
	}
		
	// =========== Functions ===========
	
	private void defaultValue() {
		this.hora = 0;
		this.minuto = 0;
		this.segundo = 0;
	}
	
	public String toString() {
		return (this.hora+":"+this.minuto+":"+this.segundo);
	}
	
	public long toSecond() {
		return ((this.hora*3600) + (this.minuto*60) + this.segundo);
	}
	
	public String timeDiff(Tempo tempo) {
		int hora , minuto, segundo;
		hora = this.hora - tempo.getHora();
		if (this.minuto >= tempo.getMinuto()) {
			minuto = this.minuto - tempo.getMinuto();  
		}else {
			hora--;
			minuto = (this.minuto + 60) - tempo.getMinuto();
		}
		if (this.segundo >= tempo.getSegundo()) {
			segundo = this.segundo - tempo.getSegundo();
		}else {
			minuto--;
			segundo = (this.segundo + 60) - tempo.getSegundo();
		}
		return ( hora + ":" + minuto + ":" + segundo );
	}
}
