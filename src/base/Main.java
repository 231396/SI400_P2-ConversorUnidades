package base;

import java.util.ArrayList;
import java.util.Locale;

import converters.AbstractConverter;
import views.ViewConverter;

public class Main {
	/**
	 * Main thread of the program
	 * 
	 * @param args arguments passed from console
	 */
	public static void main(String[] args) {				
		
		if(args.length > 0) {
			String pathConverters = args[0];
			Controller.pathConverters = pathConverters;
		}else {
			Controller.pathConverters = "C:\\Users\\Vitor\\Desktop\\converters";
		}
		
		
		if(Languages.PORTUGUESE.getLanguage().equals(Locale.getDefault().getLanguage())){
			Controller.programLanguage = Languages.PORTUGUESE;
		}else {
			Controller.programLanguage = Languages.ENGLISH;
		}


		ViewConverter viewConverter = new ViewConverter();
		

		ArrayList<AbstractConverter> listConvertFrom = Controller.getAllConverters();
		
		viewConverter.setComboConvertFrom(listConvertFrom);
		viewConverter.setComboConvertTo();
		
		viewConverter.setVisible(true);
		
		
	}
}