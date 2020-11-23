package base;

import java.io.FileInputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

import converters.AbstractConverter;

/**
 * Class that find and instantiate AbstractConverter
 */
public final class ClassFinder {

	//private static String[] prohibitedTexts = new String[] { "AbstractConverter", "MeasureType", "ClassFinder", };

	private final static String convertersFolder = "converters";

	public static ArrayList<AbstractConverter> getExternalWorkloads(String jarName) {
		//jarName = "C:\\Users\\Vitor\\Desktop\\teste.jar";
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

					if (clsName.contains("$") == false) {
						//ClassLoader.getSystemClassLoader();
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
			}

			jarFile.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return myClasses;
	}
}
