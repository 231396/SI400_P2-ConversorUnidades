package base;



public class Main {
	/**
	 * Main thread of the program
	 * 
	 * @param args arguments passed from console
	 */
	public static void main(String[] args) {				
		//String path = "C:\\Projetos\\Java\\Eclipse\\SI400_P2-ConversorUnidades\\src\\converters";
		//System.out.println(ClassFinder.LoadClasses(path).toString());
		double d = 10000;
		double d2 = 0.000001;
		System.out.println(String.format("%.3E", d));
		System.out.println(String.format("%.3E", d2));
	}
}