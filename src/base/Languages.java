package base;

import java.util.Locale;

/**
 * Enum is used to determine the system language
 */
public enum Languages {
	PORTUGUESE("pt"),
	ENGLISH("na");

	/**
	 * Saved speak language
	 */
	private String language; 

	/**
	 * Constructor of the enum. Given a country code to get the get speak language.
	 * @param stringLanguage country code
	 */
	private Languages(String stringLanguage) {
		language = new Locale(stringLanguage).getLanguage();
	}

	/**
	 * Get from language variable.
	 * @return language string
	 */
	public String getLanguage() {
		return language;
	}
}