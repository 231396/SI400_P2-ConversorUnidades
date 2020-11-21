package base;

import java.util.ArrayList;

import converters.AbstractConverter;
import views.ViewConverter;

public class Main {
	/**
	 * Main thread of the program
	 * 
	 * @param args arguments passed from console
	 */
	public static void main(String[] args) {				
		String path = "C:\\Users\\Vitor\\Desktop\\converters";
		
		ArrayList<AbstractConverter> listConvertFrom = ClassFinder.loadClasses(path);
		
		
		
		ViewConverter viewConverter = new ViewConverter();
		
		
		
		viewConverter.setAllComboBox(listConvertFrom, listConvertFrom);
		
		viewConverter.setVisible(true);
		
		
	}
}