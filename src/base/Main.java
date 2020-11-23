package base;

import java.util.ArrayList;
import java.util.Locale;

import converters.AbstractConverter;
import views.ViewConverter;

public class Main {
	
	/**
	 * Main thread of the program
	 * @param args arguments passed from console
	 */
	public static void main(String[] args) {

		//Get Jar file Name from system
		Controller.jarFileName = new java.io.File(Main.class
				.getProtectionDomain()
				.getCodeSource()
				.getLocation()
				.getPath())
				.getName();
		
		//Get chosen language or use default
		
		Locale language = Locale.getDefault();
		
		if (args.length > 0) {
			language = new Locale(args[0]);
		}

		if (Languages.PORTUGUESE.getLanguage().equals(language.getLanguage())) {
			Controller.programLanguage = Languages.PORTUGUESE;
		}else {
			Controller.programLanguage = Languages.ENGLISH;
		}
		
		//Create interface
		ViewConverter viewConverter = new ViewConverter();

		try {
			ArrayList<AbstractConverter> listConvertFrom = Controller.getAllConverters();
			viewConverter.setComboConvertFrom(listConvertFrom);
			viewConverter.setComboConvertTo();
			viewConverter.setVisible(true);			
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}