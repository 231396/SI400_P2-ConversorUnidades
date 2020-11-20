package base;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

import converters.AbstractConverter;

public final class ClassFinder {

	private static String[] prohibitedTexts = new String[] 
	{
		"AbstractConverter", "MeasureType",		
	};
	
	
	public static ArrayList<AbstractConverter> loadClasses(String path) {
		ArrayList<AbstractConverter> result = new ArrayList<>();
		try {
			File folder = new File(path);			
			String pack = getFileName(folder);

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
	
	public static AbstractConverter loadClass(File f, String packName) {
		AbstractConverter result = null;
		try {
			String fName = getFileName(f).replace(".java", "");
			
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
	
	private static String getFileName(File f) 
	{
		return Paths.get(f.toString()).getFileName().toString();		
	}
	
}
