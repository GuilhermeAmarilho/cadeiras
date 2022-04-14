package Aula22;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class DataHora {
	public static void main(String[] args) {
		
		// Trabalhando com data
		
		LocalDate hoje = LocalDate.now();
		LocalDate dataEspecifica = LocalDate.of(2020, Month.JANUARY, 10);
		
		
		// Formatos
		
		String dHF;
		
		LocalDateTime dataHora = LocalDateTime.of(2019, 04, 22, 13, 30, 00);
		dHF = dataHora.format(DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmmss"));
		System.out.printf(dHF); // Será impresso: 20190422T133000
		
		// para obter a data e hora no momento que essa linha foi executada
		
		LocalDateTime agora = LocalDateTime.now();
	}
}
