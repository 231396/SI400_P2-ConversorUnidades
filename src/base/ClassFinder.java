package base;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

import converters.AbstractConverter;

public final class ClassFinder {

	public static String[] prohibitedTexts = new String[] 
	{
		"AbstractConverter", "MeasureType",		
	};
	
	
	public static ArrayList<AbstractConverter> LoadClasses(String path) {
		ArrayList<AbstractConverter> result = new ArrayList<>();
		try {
			File folder = new File(path);			
			String pack = FileName(folder);

			File[] listOfFiles = folder.listFiles();
			
			for (File f : listOfFiles) 
				if (f != null)
					result.add(LoadClass(f, pack));		
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}
	
	public static AbstractConverter LoadClass(File f, String packName) {
		AbstractConverter result = null;
		try {
			String fName = FileName(f).replace(".java", "");
			
			if (Arrays.stream(prohibitedTexts).anyMatch(fName::equals))
				return null;
			
			URL[] urls = new URL[]{ f.toURI().toURL() };
			
			URLClassLoader urlClassLoader = new URLClassLoader(urls);
			
			//for (URL url : urls)
				//System.out.println(url.toString());
			
			String clsName = packName + '.' + fName;
			result = (AbstractConverter)urlClassLoader.loadClass(clsName).getDeclaredConstructor().newInstance();
			
			urlClassLoader.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}
	
	public static String FileName(File f) 
	{
		return Paths.get(f.toString()).getFileName().toString();		
	}
	
}
