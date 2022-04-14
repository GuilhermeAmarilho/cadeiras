package aula03;

public class TestesString {
	
	public static void main(String[] args) {
		String s = new String("IFC Videira");
		
		String subs = s.substring(6);
		
		//System.out.println("Substring: " + subs);
		
		subs = "2021:IFC:Videira";
		
		String[] n = subs.split(";");		
				
		System.out.println(n[0]);
		
		
	}

}
