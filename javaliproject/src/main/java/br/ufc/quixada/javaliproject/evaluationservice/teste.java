package br.ufc.quixada.javaliproject.evaluationservice;

import static org.junit.Assert.*;

import org.junit.Test;

public class teste {

	@Test
	public static String test() {
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
