package br.ufc.quixada.javaliproject.evaluationservice;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLClassLoader;

public class ExternalClassBuilder {
	
	
	public Class<?> run(String folder_url, String className ) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		//To compile
		String path = folder_url + className + ".java";
		System.out.println(path);
        PrintWriter saida = new PrintWriter(new FileWriter("logCompilacao.txt"));
        PrintWriter system = new PrintWriter(System.out);
        int resultComp = com.sun.tools.javac.Main.compile(new String[]{path},system);
    	System.out.println("Show: " + resultComp);
    	//To load
		URL classUrl;
    	classUrl = new URL("file://" + folder_url);
		System.out.println(classUrl.getPath());
    	URL[] classUrls = { classUrl };
    	@SuppressWarnings("resource")
		URLClassLoader ucl = new URLClassLoader(classUrls);
    	Class<?> c = ucl.loadClass(className);
    	
    	
		return c;
			
	} 
	
	
}
