package base;

import java.util.ArrayList;
import java.util.Collections;

import converters.AbstractConverter;
import converters.MeasureType;
import views.ViewConverter;

/**
 * Class that has the main methods and contains most of the logic
 */
public class Controller {

	/**
	 * Indicates the user Language
	 */
	public static Languages programLanguage;
	/**
	 * Indicates the path where the program will search for the converters
	 */
	public static String pathConverters;

	/**
	 * Name of compiled .jar file name
	 */
	public static String jarFileName;

	/**
	 * Load and return a list of all AbstractConverter that is in a fixed path
	 * 
	 * @return a list of all AbstractConverter found
	 */
	public static ArrayList<AbstractConverter> getAllConverters() {
		ArrayList<AbstractConverter> listAllConverters = ClassFinder.loadClasses(jarFileName);
		Collections.sort(listAllConverters,
				(x, y) -> x.getMeasureType().getTypeString().compareTo(y.getMeasureType().getTypeString()));
		return listAllConverters;
	}

	/**
	 * Load a list of all AbstractConverter that is in a fixed path Then filter the
	 * list of AbstractConverter based in the MeasureType of the elements
	 * 
	 * @param measureType that will remain in the list
	 * @return list of all AbstractConverter that has the allowed MeasureType
	 */
	public static ArrayList<AbstractConverter> getListConvertByMeasureType(MeasureType measureType) {

		String stringMeasureType = measureType.getTypeString();

		ArrayList<AbstractConverter> listConvert = getAllConverters();

		for (int index = listConvert.size() - 1; index >= 0; index--) {
			AbstractConverter itemConverter = listConvert.get(index);

			if (!itemConverter.getMeasureType().getTypeString().equals(stringMeasureType)) {
				listConvert.remove(index);
			}

		}

		return listConvert;

	}

	/**
	 * Convert a value from a certain Measure to another Measure
	 * 
	 * @param convertFrom the measure of the given value
	 * @param convertTo   the measure that the value will be converted to
	 * @param stringConvertFrom the value that will be converted
	 * @return string in Scientific Notation of the value converted
	 */
	public static String convertMeasure(AbstractConverter convertFrom, AbstractConverter convertTo,
			String stringConvertFrom) {
		try {

			stringConvertFrom = stringConvertFrom.replace(',', '.');

			double valueConvertFrom = Double.parseDouble(stringConvertFrom);

			double valueConverted = convertTo.fromBasicUnit(convertFrom.toBasicUnit(valueConvertFrom));

			String valueInScientificNotation = Util.doubleToScientificNotation(valueConverted);

			return valueInScientificNotation;

		} catch (NumberFormatException e) {
			System.out.println("Number has a invalid value, skiping.");
		}
		return "";
	}

	/**
	 * Create a instance of the view ViewConverter, set the values and then show the
	 * view
	 * @throws Exception if occur an error during the load of the Converters Classes
	 */
	public static void createViewConverter() throws Exception {
		ViewConverter viewConverter = new ViewConverter();

		ArrayList<AbstractConverter> listConvertFrom = Controller.getAllConverters();
		viewConverter.setComboConvertFrom(listConvertFrom);
		viewConverter.setComboConvertTo();
		viewConverter.setVisible(true);
	}

}
