package base;

import converters.MetreConverter;

public class Main 
{
	/**
	 * Main thread of the program
	 * @param args arguments passed from console
	 */
	public static void main(String[] args) 
	{	
		MetreConverter m = new MetreConverter();
		
		System.out.println(m.getMeasureType());
		
	}		
}