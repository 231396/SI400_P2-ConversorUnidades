package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;
import java.util.regex.Pattern;

import converters.AbstractConverter;

/**
 * Class that find and instantiate AbstractConverter
 */
public final class ClassFinder {

	/**
	 * Array in which each value of it represents a class that is not part of the
	 * family of converters
	 */
	private static String[] prohibitedTexts = new String[] { "AbstractConverter", "MeasureType", "ClassFinder", };

	private static String convertersFolder = "converters";

	/**
	 * The method load classes that inherit from AbstractConverter in a given path
	 * 
	 * @param path absolute path where the classes are
	 * @return list of AbstractConverter acquired in the given path
	 */
	/*
	 * public static ArrayList<AbstractConverter> loadClasses() {
	 * ArrayList<AbstractConverter> result = new ArrayList<>(); try {
	 * System.out.println("Caminho user.dir : "+System.getProperty("user.dir"));
	 * 
	 * File folder = new File(System.getProperty("user.dir")+ "\\src\\" +
	 * convertersFolder);
	 * 
	 * File[] listOfFiles = folder.listFiles();
	 * 
	 * for (File f : listOfFiles) { //System.out.println(f); AbstractConverter ac =
	 * loadClass(f); if (ac != null) result.add(ac); }
	 * 
	 * } catch (Exception ex) { ex.printStackTrace(); } return result; }
	 */

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

				if ((jarEntry.getName().startsWith(packageName)) && (jarEntry.getName().endsWith(".class"))) {
					String classname = jarEntry.getName().replaceAll("/", "\\.");

					classname = classname.substring(0, classname.length() - 6);

					if (classname.contains("$") == false) {
						ClassLoader.getSystemClassLoader();
						URL url = new URL("jar:file:" + jarName + "!/");

						URLClassLoader ucl = new URLClassLoader(new URL[] { url });

						try {
							Class<AbstractConverter> myLoadedClass = (Class<AbstractConverter>) ucl.loadClass(classname);

							AbstractConverter myClass = (AbstractConverter) myLoadedClass.newInstance();
							myClasses.add(myClass);
						} catch (Exception e) {
						}
					}
				}
			}

			jarFile.close();
		} catch (Exception e) {
		}

		return myClasses;
	}

	/**
	 * Load a single class that inherit from AbstractConverter in a given path
	 * 
	 * @param path absolute path where the class is
	 * @return A instance of AbstractConverter of the load class
	 */
	public static AbstractConverter loadClass(File f) {
		AbstractConverter result = null;
		try {
			String fName = Util.getFileName(f).replace(".java", "");

			if (Arrays.stream(prohibitedTexts).anyMatch(fName::equals))
				return null;

			String clsName = convertersFolder + '.' + fName;
			Class<?> cls = Class.forName(clsName);

			result = (AbstractConverter) cls.getDeclaredConstructor().newInstance();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

}
