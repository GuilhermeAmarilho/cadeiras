package lista04;

public class ConversaoDeUnidadesDeVolume {
	
	// ======== 1 ========
	
	public static double LitroParaCentimetros3(double litro) {
		System.out.println(litro+" Litros equivalem á "+(litro*1000)+" Centimetros³");
		return litro*1000;
	}
	public static double Centimetros3ParaLitro(double cm3) {
		System.out.println(cm3+" Centimetros³ equivalem á "+(cm3/1000)+" Litros");
		return cm3/1000;
	}

	// ======== 2 ========

	public static double Metros3ParaLitro(double m3) {
		System.out.println(m3+" Metros³ equivalem á "+(m3*1000)+" Litros");
		return m3*1000;
	}
	public static double LitroParaMetros3(double litros) {
		System.out.println(litros+" Litros equivalem á "+(litros/1000)+" Metros³");
		return litros*1000;
	}
	
	// ======== 3 ========

	public static double Metros3ParaPes3(double m3) {		
		System.out.println(m3+" Metros³ equivalem á "+(m3*35.32)+" Pés³");
		return m3*35.32;
	}
	public static double Pes3ParaMetros3(double p3) {		
		System.out.println(p3+" Pés³ equivalem á "+(p3/35.32)+" Metros³");
		return p3/35.32;
	}
	
	// ======== 4 ========

	public static double GalaoAmericanoParaPolegadas3(double galao) {
		System.out.println(galao+" Galões Americânos equivalem á "+(galao * 231)+" Polegadas³");
		return galao * 231;
	}
	public static double Polegadas3ParaGalaoAmericano(double p3) {
		System.out.println(p3+" Polegadas³ equivalem á "+(p3 / 231)+" Galões Americânos");
		return p3 / 231;
	}

	// ======== 5 ========
	
	public static double GalaoAmericanoParaLitro(double galao) {
		System.out.println(galao+" Galões Americânos equivalem á "+(galao * 3785)+" Litros");
		return galao * 3785;
	}
	public static double LitroParaGalaoAmericano(double litro) {
		System.out.println(litro+" Galões Americânos equivalem á "+(litro / 3785)+" Litros");
		return litro / 3785;
	}
}
