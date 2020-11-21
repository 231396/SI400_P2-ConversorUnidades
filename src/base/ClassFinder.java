package base;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;

import converters.AbstractConverter;

/**
 * Class that find and instantiate AbstractConverter
 */
public final class ClassFinder {
	
	/**
	 * Array in which each value of it represents a class that is not part of the family of converters
	 */
	private static String[] prohibitedTexts = new String[] {
		"AbstractConverter", "MeasureType",		
	};	

	/**
	 * The method load classes that inherit from AbstractConverter in a given path
	 * @param path absolute path where the classes are
	 * @return list of AbstractConverter acquired in the given path
	 */
	public static ArrayList<AbstractConverter> loadClasses(String path) {
		ArrayList<AbstractConverter> result = new ArrayList<>();
		try {
			File folder = new File(path);			
			String pack = Util.getFileName(folder);

			File[] listOfFiles = folder.listFiles();
			
			for (File f : listOfFiles) {
				AbstractConverter ac = loadClass(f, pack);
				if (ac != null)
					result.add(ac);		
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}
	
	/**
	 * Load a single class that inherit from AbstractConverter in a given path
	 * @param path absolute path where the class is
	 * @return A instance of AbstractConverter of the load class
	 */
	public static AbstractConverter loadClass(File f, String packName) {
		AbstractConverter result = null;
		try {
			String fName = Util.getFileName(f).replace(".java", "");
			
			if (Arrays.stream(prohibitedTexts).anyMatch(fName::equals))
				return null;
			
			URL[] urls = new URL[]{ f.toURI().toURL() };
			
			URLClassLoader urlClassLoader = new URLClassLoader(urls);
			
			for (URL url : urls)
				System.out.println(url.toString());
			
			String clsName = packName + '.' + fName;
			result = (AbstractConverter)urlClassLoader.loadClass(clsName).getDeclaredConstructor().newInstance();
			
			urlClassLoader.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}
	
}
