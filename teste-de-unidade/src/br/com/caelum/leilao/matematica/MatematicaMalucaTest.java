package br.com.caelum.leilao.matematica;

import static org.junit.Assert.*;

import org.junit.Test;

public class MatematicaMalucaTest {

	@Test
	public void testNumeroMaiorQue30() {
		//Montando cenário
		MatematicaMaluca matematica = new MatematicaMaluca();
		
		//Executando
		int retorno = matematica.contaMaluca(50);
		
		//Verificando
		assertEquals(200, retorno);
	}
	
	@Test
	public void testNumeroMenorQue30EMaiorQue10() {
		//Montando cenário
		MatematicaMaluca matematica = new MatematicaMaluca();
		
		//Executando
		int retorno = matematica.contaMaluca(20);
		
		//Verificando
		assertEquals(60, retorno);
	}
	
	@Test
	public void testNumeroMenorQue10() {
		//Montando cenário
		MatematicaMaluca matematica = new MatematicaMaluca();
		
		//Executando
		int retorno = matematica.contaMaluca(10);
		
		//Verificando
		assertEquals(20, retorno);
	}

}
