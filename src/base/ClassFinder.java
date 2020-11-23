package base;

import java.io.FileInputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

import converters.AbstractConverter;

/**
 * Class that find and instantiate AbstractConverter
 */
public final class ClassFinder {
		
	/**
	 * Name of the package where the converters are placed
	 */
	private final static String packageName = "converters";
	
	/**
	 * Array in which each value of it represents a class that is not part of the family of converters
	 */
	private final static String[] prohibitedClasses = new String[] { 
			packageName + ".AbstractConverter", 
			packageName + ".MeasureType"	
	};	

	/**
	 * Load all converters class dynamically.
	 * @param jarName name of compiled jar file
	 * @return list of AbstractConverter dynamically instanced
	 */
	public static ArrayList<AbstractConverter> loadClasses(String jarName) {

		ArrayList<AbstractConverter> myClasses = new ArrayList<AbstractConverter>();

		JarInputStream jarFile = null;
		JarEntry jarEntry = null;

		try {
			jarFile = new JarInputStream(new FileInputStream(jarName));

			while (true) {
				jarEntry = jarFile.getNextJarEntry();

				if (jarEntry == null)
					break;
				
				AbstractConverter newClass = loadClass(jarEntry, new URL("jar:file:" + jarName + "!/"));
				if(newClass != null)
					myClasses.add(newClass);								
			}
			jarFile.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return myClasses;
	}
	
	/**
	 * Load a single class dynamically
	 * @param jarEntry object represent the current jar file entry
	 * @param url the url object to jar file
	 * @return a AbstractConverter child or null if is not a child
	 */
	private static AbstractConverter loadClass(JarEntry jarEntry, URL url) 
	{
		AbstractConverter loadedClass = null;
	
		String jarString = jarEntry.getName();				
		
		if (jarString.startsWith(packageName) && jarString.endsWith(".class")) {
			String clsName = jarString.replaceAll("/", "\\.");

			clsName = clsName.replaceAll(".class", "");
			
			if (Arrays.stream(prohibitedClasses).anyMatch(clsName::equals))
				return null;

			try {
				URLClassLoader ucl = new URLClassLoader(new URL[] { url });
				Class<?> cls = ucl.loadClass(clsName);
				loadedClass = (AbstractConverter) cls.getDeclaredConstructor().newInstance();
				ucl.close();
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		return loadedClass;
	}	
}
