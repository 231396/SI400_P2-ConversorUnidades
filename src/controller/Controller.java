package controller;

import java.util.ArrayList;
import java.util.Collections;

import base.ClassFinder;
import base.Util;
import converters.AbstractConverter;
import converters.MeasureType;

public class Controller {

	public static ArrayList<AbstractConverter> getAllConverters() {
		String path = "C:\\Users\\Vitor\\Desktop\\converters";
		ArrayList<AbstractConverter> listAllConverters = ClassFinder.loadClasses(path);  
		Collections.sort(listAllConverters, (x,y ) -> x.getMeasureType().getTypeString().compareTo(y.getMeasureType().getTypeString()));
		return listAllConverters;
	}

	public static ArrayList<AbstractConverter> getAllConvertersByPath(String path) {
		path = "C:\\Users\\Vitor\\Desktop\\converters";
		return ClassFinder.loadClasses(path);
	}

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
	
	public static String convertMeasure(AbstractConverter convertFrom, AbstractConverter convertTo, String stringConvertFrom) {
		try {

			double valueConvertFrom = Double.parseDouble(stringConvertFrom);

			double valueConverted = convertTo.fromBasicUnit(convertFrom.toBasicUnit(valueConvertFrom));
			
			String valueInScientificNotation = Util.doubleToScientificNotation(valueConverted);
			
			return valueInScientificNotation;
			
		} catch (NumberFormatException e) {
			System.out.println("O numero não tem um formato válido");
		}
		return "";
	}

}
