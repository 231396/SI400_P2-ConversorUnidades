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

		Locale language = Locale.getDefault();

		if (args.length > 0) {
			language = new Locale(args[0]);
		}

		Controller.jarFileName = new java.io.File(
				Main.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getName();


		if (Languages.PORTUGUESE.getLanguage().equals(language.getLanguage())) {
			Controller.programLanguage = Languages.PORTUGUESE;
		}else {
			Controller.programLanguage = Languages.ENGLISH;
		}

		/*ArrayList<AbstractConverter> list = Controller.getAllConverters();

		System.out.println(list.size());
		for (AbstractConverter a : list) {
			System.out.println(a);
		}*/
		
		ViewConverter viewConverter = new ViewConverter();


		ArrayList<AbstractConverter> listConvertFrom = Controller.getAllConverters();
		viewConverter.setComboConvertFrom(listConvertFrom);
		viewConverter.setComboConvertTo();
		
		viewConverter.setVisible(true);

	}
}