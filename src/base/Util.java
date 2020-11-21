package base;

public class Util {
	
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
	
	public static String trimZerosString(String strNumber) {
		return strNumber.replaceAll("^0+", "").replaceAll("0{2,}$", "");	
	}
	
}
