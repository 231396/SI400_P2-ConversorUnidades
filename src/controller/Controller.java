package controller;

import java.util.ArrayList;

import base.ClassFinder;
import converters.AbstractConverter;
import converters.MeasureType;

public class Controller {

	public static ArrayList<AbstractConverter> getAllConverters() {
		String path = "C:\\Users\\Vitor\\Desktop\\converters";
		return ClassFinder.loadClasses(path);
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

}
