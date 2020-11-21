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
		
		ViewConverter viewConverter = new ViewConverter();
		

		ArrayList<AbstractConverter> listConvertFrom = Controller.getAllConverters();
		
		
		
		viewConverter.setComboConvertFrom(listConvertFrom);
		viewConverter.setComboConvertTo();
		
		viewConverter.setVisible(true);
		
		
	}
}