package br.com.caelum.leilao.dominio;

import org.junit.Test;

import junit.framework.Assert;


/**
 * 
 * O método testeMediaLances poderia estar na classe TesteDoAvaliador.
 *
 */
public class TesteMediaDosLances {
	
	@Test
	public void testeMediaLances() {
		
		// Montando o cenário
		Usuario rodrigo = new Usuario("Rodrigo");
		Usuario pedro = new Usuario("Pedro");
		Usuario ana = new Usuario("Ana");

		Leilao leilao = new Leilao("Leilao de Macbook aprrendido pela PF");

		Lance lanceRodrigo = new Lance(rodrigo, 200);
		leilao.propoe(lanceRodrigo);
				
		Lance lancePedro = new Lance(pedro, 150);
		leilao.propoe(lancePedro);
				
		Lance LanceAna = new Lance(ana, 250);
		leilao.propoe(LanceAna);
				
		Avaliador leiloeiro = new Avaliador();
				
		//Executa a ação
		leiloeiro.calculaMediaLances(leilao);
		
		//Verificação
		
		Double media = 200.00;
		
		Assert.assertEquals(200.00, leiloeiro.getMedia(), 0.00001);
	}

}
