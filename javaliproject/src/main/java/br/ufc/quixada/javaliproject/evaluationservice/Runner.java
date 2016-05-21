package br.ufc.quixada.javaliproject.evaluationservice;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;






public class Runner {

	public static String runClass() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		//Let's compile and load the student's class
    	ExternalClassBuilder my_class = new ExternalClassBuilder();
    	Class<?> c = my_class.run("//classes/", "Operation");
    	Object obj = c.newInstance();	
    	Class d = my_class.run("//classes/", "CasoDeTeste2");
    	Object obj2 = d.newInstance();
    	Method my_method = d.getDeclaredMethod("test", Class.class);
		System.out.println(my_method.invoke(obj2, c));
    	return "Executou!";	
    	
    	

	}
	
	

}
