package lista04;

public class TestaConversaoDeUnidadesDeVolume {
	public static void main(String[] args) {
		ConversaoDeUnidadesDeVolume cv = new ConversaoDeUnidadesDeVolume();	
		// ======== 1 ========
		cv.LitroParaCentimetros3(1527);
		cv.Centimetros3ParaLitro(134);
		// ======== 2 ========		
		cv.Metros3ParaLitro(145);
		cv.LitroParaCentimetros3(850);
		// ======== 3 ========
		cv.Metros3ParaPes3(480);
		cv.Pes3ParaMetros3(94);
		// ======== 4 ========
		cv.GalaoAmericanoParaPolegadas3(820);
		cv.Polegadas3ParaGalaoAmericano(340);
		// ======== 5 ========
		cv.GalaoAmericanoParaLitro(683);
		cv.LitroParaGalaoAmericano(120);
	}
}
