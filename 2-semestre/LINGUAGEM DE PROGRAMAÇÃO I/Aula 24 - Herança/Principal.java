package heranca;


public class Principal {

	public static void main(String[] args) {

			
		Dimensao dim = new Dimensao(5,10,5);
		Telefone a = new Telefone(1, "ABC123", "MesaTel", 0.5f, dim);
//		
//		//tel.imprimirDados();
//		
		Dimensao dim2 = new Dimensao(5,10,5);
		SemFio b = new SemFio(2, "XYQ123", "SemFioTel", 0.3f, dim2, 3000f, 5, 2f);
//		
//		telSF.imprimirDados();
		
		Dimensao dim3 = new Dimensao(20, 5, 1);
		Celular c = new Celular(3, "Iphone", "20", 0.5f, dim3, 3000f, 5, 2f, "Snapdragon X", 16);
		
		Telefone d = new Celular(4, "Iphone", "12", 0.5f, dim3, 3000f, 5, 2f, "Snapdragon X", 16);
		
		Telefone e  = new SemFio(5, "XYQ123", "SemFioTel", 0.5f, dim2, 2000f, 5, 2f);

		Celular f1 = (Celular)d;
		
		if (a instanceof Celular)
			((Celular)a).conectarWifi();
		else
		if (a instanceof Telefone)
			a.conectarRedeTelefonia();
					
//		f1.imprimirDados();
//		f1.conectarWifi();		
//		d.imprimirDados();
//		d.conectarRedeTelefonia();
//		b.conectarRedeTelefonia();
//		f1.conectarWifi();
//		f1.conectarRedeTelefonia();
		
		
		//erro de typecasting
		//telefone não pode ser um celular
//		Celular f2 = (Celular)a;
//		f2.conectarWifi();
																			
	}
}
