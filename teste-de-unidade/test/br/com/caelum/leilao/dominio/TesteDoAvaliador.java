package br.com.caelum.leilao.dominio;

import org.junit.Assert;
import org.junit.Test;



public class TesteDoAvaliador {
	
	@Test
	public void deveAvaliarOsLancesEmOrdemCrescente() {
		
		// Montando o cenário
		Usuario rodrigo = new Usuario("Rodrigo");
		Usuario pedro = new Usuario("Pedro");
		Usuario ana = new Usuario("Ana");

		Leilao leilao = new Leilao("Leilao de Macbook aprrendido pela PF");

		Lance lanceRodrigo = new Lance(rodrigo, 1000);
		leilao.propoe(lanceRodrigo);
		
		Lance lancePedro = new Lance(pedro, 2000);
		leilao.propoe(lancePedro);
		
		Lance LanceAna = new Lance(ana, 3000);
		leilao.propoe(LanceAna);
		
		Avaliador leiloeiro = new Avaliador();
		
		//Executa a ação
		leiloeiro.avalia(leilao);
		
		//Verificando e analisando: valor desejado x valor obtido
		Double maiorValorEsperado = 3000.0;
		Double menorValorEsperado = 1000.0;
		
		//O terceiro parâmetro = 0.00001 é para arredondar o Double,
		//Ponto flutuante dá problemas em casas decimais sem esse delta!
		
		Assert.assertEquals(maiorValorEsperado, leiloeiro.getMaiorValor(), 0.00001);
		Assert.assertEquals(menorValorEsperado, leiloeiro.getMenorValor(), 0.00001);
	}
}
