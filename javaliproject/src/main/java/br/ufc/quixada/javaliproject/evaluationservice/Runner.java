package br.ufc.quixada.javaliproject.evaluationservice;
import static org.junit.Assert.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.junit.Test;






public class Runner {
	@Test
	public static String runClass() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		
		int retornoEsperado = 9;
		int retornoFeito = 10;
		
		String assertionError = null;
        try {
        	
        	assertEquals(retornoEsperado, retornoFeito);
        	System.out.println("O método está correto");
        }
        catch (AssertionError ae) {
            assertionError = ae.toString();
            System.out.println(assertionError);
        }
        
    	return "Executou!";	
    	
    	

	}
	
	

}
