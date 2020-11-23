package base;

import java.util.ArrayList;

import converters.AbstractConverter;

public class Main {
	/**
	 * Main thread of the program
	 * 
	 * @param args arguments passed from console
	 */
	public static void main(String[] args) {				
		
		Controller.programLanguage = Languages.ENGLISH;
		
		ArrayList<AbstractConverter> list = ClassFinder.loadClasses();
		
		System.out.println(list.size());
		for (AbstractConverter a : list) {
			System.out.println(a);
		}
		
	}
}