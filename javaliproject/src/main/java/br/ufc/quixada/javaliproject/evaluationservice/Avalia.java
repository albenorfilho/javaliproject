package br.ufc.quixada.javaliproject.evaluationservice;



import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;



public class Avalia {

	public static String run(String testepath, String implementacaopath, List<Associacao> associacoes) throws MalformedURLException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		/*
		URL classUrl;
    	classUrl = new URL("file:///javali/");
		System.out.println(classUrl.getPath());
    	URL[] classUrls = { classUrl };
    	@SuppressWarnings("resource")
		URLClassLoader ucl = new URLClassLoader(classUrls);
    	Class<?> c = ucl.loadClass("CalculadoraImpl");
    	*/
		double valor = 0;
    	
    	URLClassLoader loader = (URLClassLoader)ClassLoader.getSystemClassLoader();
    	MyClassLoader l = new MyClassLoader(loader.getURLs());
    	l.addURL(new URL("file://"+implementacaopath)); 
    	l.addURL(new URL("file://"+testepath)); 
    	/* 
    	 * O nome do jar não é importante, o aluno pode 
    	 * nomear com o nome que quiser. O que importa é 
    	 * o nome dos pacotes
    	 */
    	for(int i = 0; i< associacoes.size(); i++){
    	Class implementacao = l.loadClass(associacoes.get(i).getClasseNome());
    	Class teste = l.loadClass(associacoes.get(i).getTesteNome());
    	
    	
    	//System.out.println(implementacao.getName());
    	//System.out.println(teste.getName());
    	
    	Object objImpl = implementacao.newInstance();
    	Object objTest = teste.newInstance();
    	
    	
	    	for (Method metodo : teste.getDeclaredMethods()) {
	    		//System.out.println(metodo.getName() + " foi executado.");
	    		Method my_method = teste.getDeclaredMethod(metodo.getName(), Object.class);
	  		    
	  		    valor += (Double) my_method.invoke(objTest, objImpl);
	  		    //System.out.println(metodo.getName() + " foi executado.");
	  		    
	    	}
    	}
    	System.out.println("Nota:" + valor);
    	
    	
    	return "############################################### Executado!###########################################################################";

	}

}

