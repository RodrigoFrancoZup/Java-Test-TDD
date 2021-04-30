package br.com.caelum.leilao.dominio;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.caelum.leilao.ano.AnoBissexto;

public class TesteAnoBissexto {
	
	@Test
	public void verificaSeAnoEhBissexto() {
		
		//Preparando cenário
		AnoBissexto ano = new AnoBissexto();
		
		//Executando
		Boolean resposta = ano.ehBissexto(2016);
		Boolean resposta2 = ano.ehBissexto(2012);
		Boolean resposta3 = ano.ehBissexto(2015);
		Boolean resposta4 = ano.ehBissexto(2011);
		
		//Verificando
		assertEquals(true, resposta);
		assertEquals(true, resposta2);
		assertEquals(false, resposta3);
		assertEquals(false, resposta4);
		
	}


}
