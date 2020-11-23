package base;

import java.util.Locale;

public enum Languages {
	PORTUGUESE("pt"),
	ENGLISH("na");

	private String language; 

	private Languages(String stringLanguage) {
		language = new Locale(stringLanguage).getLanguage();
	}

	public String getLanguage() {
		return language;
	}
}