package base;

import views.ViewConverter;

public class Main {
	/**
	 * Main thread of the program
	 * 
	 * @param args arguments passed from console
	 */
	public static void main(String[] args) {				
		String path = "C:\\Users\\Vitor\\Desktop\\converters";
		System.out.println(ClassFinder.LoadClasses(path).toString());
		
		ViewConverter viewConverter = new ViewConverter();
		viewConverter.show();
		
	}
}