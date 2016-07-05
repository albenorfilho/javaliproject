package br.ufc.quixada.javaliproject.evaluationservice;



import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

import com.sun.tools.javac.Main;



public class Avalia {

	public static ResultadoAvaliacao run(String testepath, String implementacaopath, List<Associacao> associacoes) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, IOException {
		
		double valor = 0;
		String message = "Métodos que deram defeito: ";
    	
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
	    	
	    	Class implementacao = l.loadClass("javaliproject.implementacoes." + associacoes.get(i).getClasseNome());
	    	Class teste = l.loadClass("javaliproject.testes." + associacoes.get(i).getTesteNome());
	    	//System.out.println(implementacao.getName());
	    	//System.out.println(teste.getName());
	    	
	    	Object objImpl = implementacao.newInstance();
	    	Object objTest = teste.newInstance();
    	
    	
	    	for (Method metodo : teste.getDeclaredMethods()) {
	    		
	    		//System.out.println(metodo.getName() + " foi executado.");
	    		Method my_method = teste.getDeclaredMethod(metodo.getName(), Object.class);
	  		    double notaDoMetodo = (Double) my_method.invoke(objTest, objImpl);
	  		    valor += notaDoMetodo;
	  		    if(notaDoMetodo==0){
	  		    	String old = metodo.getName();
	  		    	String nomeMetodo = old.replace("test", "");
	  		    	System.out.println(nomeMetodo + "<-------------------------");
	  		    	message += nomeMetodo + " ";
	  		    }
	  		    //System.out.println(metodo.getName() + " foi executado.");
	  		    
	    	}
    	}
    	System.out.println("Nota:" + valor);
    	if(valor==10){
    		message = "Parabéns! Todos os métodos estão corretos!";
    	}
    	ResultadoAvaliacao resultado = new ResultadoAvaliacao();
    	resultado.setNota(valor);
    	resultado.setMensagem(message);
    	loader.close();
    	l.close();
    	return resultado;

	}

}

