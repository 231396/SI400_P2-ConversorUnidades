package base;

import java.io.File;
import java.io.FilenameFilter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import converters.AbstractConverter;
import converters.MetreConverter;

public class Main {
	/**
	 * Main thread of the program
	 * 
	 * @param args arguments passed from console
	 */
	public static void main(String[] args) {

		// Prepare.
		String packageName = "C:\\Users\\Vitor\\Desktop";
		List<Class<AbstractConverter>> commands = new ArrayList<Class<AbstractConverter>>();
		URL root = Thread.currentThread().getContextClassLoader().getResource(packageName.replace(".", "/"));

		// Filter .class files.
		try {
			File[] files = new File(URLDecoder.decode(packageName, "UTF-8"))
					.listFiles();/*
									 * (new FilenameFilter() { public boolean accept(File dir, String name) { return
									 * name.endsWith(".class"); } });
									 */

			// Find classes implementing ICommand.
			for (File file : files) {
				String className = file.getName();//.replaceAll(".class$", "");
				Class<?> cls;
				try {
					cls = Class.forName(packageName + "\\" + className);
					if (AbstractConverter.class.isAssignableFrom(cls)) {
						commands.add((Class<AbstractConverter>) cls);
					}

				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("Erro e: " + e.getStackTrace());
				}
			}

		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("Erro e1: " + e1.getStackTrace());
		}

		for (Class<AbstractConverter> abstractConverter : commands) {
			AbstractConverter obj;
			try {
				if(abstractConverter.getName().equals("converters.AbstractConverter")) {
					continue;
				}
				System.out.println("Nome da Classe: " + abstractConverter.getName());
				obj = (AbstractConverter) Class.forName(abstractConverter.getName()).newInstance();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Erro e: " + e.getStackTrace());
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Erro e: " + e.getStackTrace());
			}
			catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Erro e: " + e.getStackTrace());
			}
		}

		/*
		 * AbstractConverter obj = (AbstractConverter)
		 * Class.forName("test.MyClass").newInstance(); obj.getMeasureType();
		 */

	}
}