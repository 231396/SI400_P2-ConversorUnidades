package base;

import java.io.File;
import java.nio.file.Paths;

/**
 * Class where all methods are static and don't have true propose alone.
 * Helping other classes.
 */
public final class Util {
	
	/**
	 * From the path of given file get the last string in the URL. 
	 * Ex: lorin/epsi/can.java => can.java
	 * @param f is a file that contains a path
	 * @return name of last element in the URL
	 */
	public static String getFileName(File f) 
	{
		return Paths.get(f.toString()).getFileName().toString();		
	}
	
	/**
	 * Convert the number to string using scientific notation if necessary.
	 * Scientific Notation is used when the number is 10^7 or 10^-7 and default notation otherwise.
	 * @param number value to be converted to string
	 * @return a number string that may be in scientific notation or not
	 */
	public static String doubleToScientificNotation(Double number) {				
		int beforeComma, afterComma = 0;
		// Convert number to string and trim its zeros
		String numberString = trimZerosString(String.format("%.12f", Math.abs(number)));
		
		String[] strs = numberString.split("[\\.\\,]");
		
		beforeComma = strs[0].length();		
		if (strs.length > 1)
			afterComma = strs[1].length();			
		
		if (beforeComma >= 7 || afterComma >= 7)
			return String.format("%.3E", number);
		else
			return String.format("%." + afterComma + "f", number);
	}	
	
	/**
	 * Trim zeros from left and right of a string
	 * @param strNumber number that must have been previously converted to string
	 * @return same string of strNumber but without 0 in beginning and end
	 */
	public static String trimZerosString(String strNumber) {
		return strNumber.replaceAll("^0+", "").replaceAll("0{2,}$", "");	
	}
	
}
