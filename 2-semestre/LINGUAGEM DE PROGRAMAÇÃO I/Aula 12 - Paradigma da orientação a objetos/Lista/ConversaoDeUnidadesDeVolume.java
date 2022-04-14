package lista04;

public class ConversaoDeUnidadesDeVolume {
	
	// ======== 1 ========
	
	public static double LitroParaCentimetros3(double litro) {
		System.out.println(litro+" Litros equivalem � "+(litro*1000)+" Centimetros�");
		return litro*1000;
	}
	public static double Centimetros3ParaLitro(double cm3) {
		System.out.println(cm3+" Centimetros� equivalem � "+(cm3/1000)+" Litros");
		return cm3/1000;
	}

	// ======== 2 ========

	public static double Metros3ParaLitro(double m3) {
		System.out.println(m3+" Metros� equivalem � "+(m3*1000)+" Litros");
		return m3*1000;
	}
	public static double LitroParaMetros3(double litros) {
		System.out.println(litros+" Litros equivalem � "+(litros/1000)+" Metros�");
		return litros*1000;
	}
	
	// ======== 3 ========

	public static double Metros3ParaPes3(double m3) {		
		System.out.println(m3+" Metros� equivalem � "+(m3*35.32)+" P�s�");
		return m3*35.32;
	}
	public static double Pes3ParaMetros3(double p3) {		
		System.out.println(p3+" P�s� equivalem � "+(p3/35.32)+" Metros�");
		return p3/35.32;
	}
	
	// ======== 4 ========

	public static double GalaoAmericanoParaPolegadas3(double galao) {
		System.out.println(galao+" Gal�es Americ�nos equivalem � "+(galao * 231)+" Polegadas�");
		return galao * 231;
	}
	public static double Polegadas3ParaGalaoAmericano(double p3) {
		System.out.println(p3+" Polegadas� equivalem � "+(p3 / 231)+" Gal�es Americ�nos");
		return p3 / 231;
	}

	// ======== 5 ========
	
	public static double GalaoAmericanoParaLitro(double galao) {
		System.out.println(galao+" Gal�es Americ�nos equivalem � "+(galao * 3785)+" Litros");
		return galao * 3785;
	}
	public static double LitroParaGalaoAmericano(double litro) {
		System.out.println(litro+" Gal�es Americ�nos equivalem � "+(litro / 3785)+" Litros");
		return litro / 3785;
	}
}
