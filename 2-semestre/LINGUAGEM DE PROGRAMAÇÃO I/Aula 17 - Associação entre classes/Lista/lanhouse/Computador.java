package lanhouse;

public class Computador {
	private Integer codigo;
	private Integer status;
	private String modelo;
	private Integer capacidadeMemoria;
	private String placaVideo;
	private String processador;
	
	public Computador(Integer codigo, Integer status, String modelo, Integer capacidadeMemoria, String placaVideo, String processador) {
		this.codigo = codigo;
		this.status = status;
		this.modelo = modelo;
		this.capacidadeMemoria = capacidadeMemoria;
		this.placaVideo = placaVideo;
		this.processador = processador;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getCapacidadeMemoria() {
		return capacidadeMemoria;
	}

	public void setCapacidadeMemoria(Integer capacidadeMemoria) {
		this.capacidadeMemoria = capacidadeMemoria;
	}

	public String getPlacaVideo() {
		return placaVideo;
	}

	public void setPlacaVideo(String placaVideo) {
		this.placaVideo = placaVideo;
	}

	public String getProcessador() {
		return processador;
	}

	public void setProcessador(String processador) {
		this.processador = processador;
	}
	
	public void imprimir() {
		System.out.println("################################");
		System.out.println("Código: "+this.getCodigo());
		System.out.println("Status: "+this.getStatus());
		System.out.println("Modelo: "+this.getModelo());
		System.out.println("Memória total: "+this.getCapacidadeMemoria());
		System.out.println("Placa de vídeo: "+this.getPlacaVideo());
		System.out.println("Processador: "+this.getProcessador());
		System.out.println();
	}
	
}
