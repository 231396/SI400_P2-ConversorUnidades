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
	 * Array in which each value of it represents a class that is not part of the family of converters
	 */
	private final static String[] prohibitedTexts = new String[] { "AbstractConverter", "MeasureType" };
	
	private final static String convertersFolder = "converters";

	public static ArrayList<AbstractConverter> getExternalWorkloads(String jarName) {

		String packageName = convertersFolder;

		packageName = packageName.replaceAll("\\.", "/");

		ArrayList<AbstractConverter> myClasses = new ArrayList<AbstractConverter>();

		JarInputStream jarFile = null;
		JarEntry jarEntry = null;

		try {
			jarFile = new JarInputStream(new FileInputStream(jarName));

			while (true) {
				jarEntry = jarFile.getNextJarEntry();

				if (jarEntry == null)
					break;
				
				String jarString = jarEntry.getName();

				
				
				
				if (jarString.startsWith(packageName) && jarString.endsWith(".class")) {
					String clsName = jarString.replaceAll("/", "\\.");

					clsName = clsName.replaceAll(".class", "");
					
					if (Arrays.stream(prohibitedTexts).anyMatch(clsName.replace(convertersFolder+".", "")::equals))
						continue;
					URL url = new URL("jar:file:" + jarName + "!/");

					URLClassLoader ucl = new URLClassLoader(new URL[] { url });

					try {
						Class<?> myLoadedClass = ucl.loadClass(clsName);
						AbstractConverter myClass = (AbstractConverter) myLoadedClass.getDeclaredConstructor().newInstance();
						myClasses.add(myClass);
					} 
					catch (Exception e) {
						e.printStackTrace();
					}
					ucl.close();
				}
			}

			jarFile.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return myClasses;
	}
}
