package br.com.caelum.leilao.dominio;

import static org.junit.Assert.assertEquals;

import java.util.Collections;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.caelum.leilao.builder.CriadorDeLeilao;

public class TesteDoAvaliador {

	Avaliador leiloeiro;
	Usuario rodrigo;

	@Before
	public void setUp() {
		this.leiloeiro = new Avaliador();
		this.rodrigo = new Usuario("Rodrigo");
	}

	@Test
	public void deveAvaliarOsLancesEmOrdemCrescente() {

		// Montando o cenário
		Usuario pedro = new Usuario("Pedro");
		Usuario ana = new Usuario("Ana");

		Leilao leilao = new Leilao("Leilao de Macbook aprrendido pela PF");

		Lance lanceRodrigo = new Lance(rodrigo, 1000);
		leilao.propoe(lanceRodrigo);

		Lance lancePedro = new Lance(pedro, 2000);
		leilao.propoe(lancePedro);

		Lance LanceAna = new Lance(ana, 3000);
		leilao.propoe(LanceAna);

		// Executa a ação
		leiloeiro.avalia(leilao);

		// Verificando e analisando: valor desejado x valor obtido
		Double maiorValorEsperado = 3000.0;
		Double menorValorEsperado = 1000.0;

		// O terceiro parâmetro = 0.00001 é para arredondar o Double,
		// Ponto flutuante dá problemas em casas decimais sem esse delta!

		Assert.assertEquals(maiorValorEsperado, leiloeiro.getMaiorValor(), 0.00001);
		Assert.assertEquals(menorValorEsperado, leiloeiro.getMenorValor(), 0.00001);
	}

	@Test
	public void testeAvaliadorComApenasUmLance() {
		// Montando o cenário
		Leilao leilao = new Leilao("Leilao Iphone");
		Usuario leo = new Usuario("Leo");
		Lance lance = new Lance(leo, 750.00);
		leilao.propoe(lance);

		// Executa a ação
		leiloeiro.avalia(leilao);

		// Verificando resposta
		Assert.assertEquals(750, leiloeiro.getMaiorValor(), 0.00001);
		Assert.assertEquals(750, leiloeiro.getMenorValor(), 0.00001);

	}

	@Test
	public void testeLeilaoComLancesRandomicos() {
		// Montando o cenário
		Leilao leilao = new Leilao("Leilao de Camaro apreendido");

		Usuario maria = new Usuario("Maria");
		Usuario pedro = new Usuario("Pedro");
		Usuario betania = new Usuario("betania");
		Usuario valdir = new Usuario("valdir");
		Usuario claudio = new Usuario("claudio");
		Usuario isabela = new Usuario("isabela");

		leilao.propoe(new Lance(maria, 200.00));
		leilao.propoe(new Lance(pedro, 450.00));
		leilao.propoe(new Lance(betania, 120.00));
		leilao.propoe(new Lance(valdir, 700.00));
		leilao.propoe(new Lance(claudio, 630.00));
		leilao.propoe(new Lance(isabela, 230.00));

		// Executa
		leiloeiro.avalia(leilao);

		// Verifica
		Assert.assertEquals(700.00, leiloeiro.getMaiorValor(), 0.00001);
		Assert.assertEquals(120.00, leiloeiro.getMenorValor(), 0.00001);

	}

	@Test
	public void testeLeilaoComLancesDecrescentes() {
		// Montando o cenário
		Leilao leilao = new Leilao("Leilao de Camaro apreendido");

		Usuario maria = new Usuario("Maria");
		Usuario pedro = new Usuario("Pedro");
		Usuario betania = new Usuario("betania");
		Usuario valdir = new Usuario("valdir");
		Usuario claudio = new Usuario("claudio");
		Usuario isabela = new Usuario("isabela");

		leilao.propoe(new Lance(maria, 1000.00));
		leilao.propoe(new Lance(pedro, 900.00));
		leilao.propoe(new Lance(betania, 800.00));
		leilao.propoe(new Lance(valdir, 700.00));
		leilao.propoe(new Lance(claudio, 630.00));
		leilao.propoe(new Lance(isabela, 230.00));

		// Executa
		leiloeiro.avalia(leilao);

		// Verifica
		Assert.assertEquals(1000.00, leiloeiro.getMaiorValor(), 0.00001);
		Assert.assertEquals(230.00, leiloeiro.getMenorValor(), 0.00001);
	}

	@Test
	public void testeLeilaoComTresLancesComRetornoDosTresMaiores() {

		// Montando o cenário

		/*
		 * Criado agora pelo BUILDER:
		 * 
		 * Leilao leilao = new Leilao("Leilao de Camaro apreendido");
		 */

		Usuario maria = new Usuario("Maria");
		Usuario pedro = new Usuario("Pedro");
		Usuario betania = new Usuario("betania");
		Usuario valdir = new Usuario("valdir");
		Usuario claudio = new Usuario("claudio");
		Usuario isabela = new Usuario("isabela");

		/*
		 * Criado agora pelo BUILDER:
		 * 
		 * leilao.propoe(new Lance(maria, 1000.00)); leilao.propoe(new Lance(claudio,
		 * 630.00)); leilao.propoe(new Lance(pedro, 900.00)); leilao.propoe(new
		 * Lance(isabela, 230.00)); leilao.propoe(new Lance(betania, 800.00));
		 * leilao.propoe(new Lance(valdir, 700.00));
		 */

		Leilao leilao = new CriadorDeLeilao().para("Leilao de Camaro apreendido").lance(maria, 1000.00)
				.lance(claudio, 630.00).lance(pedro, 900.00).lance(isabela, 230.00).lance(betania, 800.00)
				.lance(valdir, 700.00).constroi();

		// Executa
		leiloeiro.avalia(leilao);

		// Verifica
		// Lembre-se em uma lista devemos ter 1+N em Asssert (N = tamanho da lista)
		// Devemos ter teste (assert) para o tamanho da lista
		// E devemos ter um assert para todos os elementos da lista
		// Em uma lista ainda é importante testar: lista vazia, lista com 1 item e
		// com valores ordenados e sem ordem!
		Assert.assertEquals(3, leiloeiro.getTresMaiores().size());
		Assert.assertEquals(1000.00, leiloeiro.getTresMaiores().get(0).getValor(), 0.00001);
		Assert.assertEquals(900.00, leiloeiro.getTresMaiores().get(1).getValor(), 0.00001);
		Assert.assertEquals(800.00, leiloeiro.getTresMaiores().get(2).getValor(), 0.00001);
	}

	@Test
	public void testeLeilaoComDoisLancesComRetornoDosTresMaiores() {

		// Montando o cenário
		Leilao leilao = new Leilao("Leilao de Camaro apreendido");

		Usuario maria = new Usuario("Maria");
		Usuario pedro = new Usuario("Pedro");

		leilao.propoe(new Lance(maria, 1000.00));
		leilao.propoe(new Lance(pedro, 630.00));

		// Executa
		leiloeiro.avalia(leilao);

		// Verifica
		Assert.assertEquals(2, leiloeiro.getTresMaiores().size());
		Assert.assertEquals(1000.00, leiloeiro.getTresMaiores().get(0).getValor(), 0.00001);
		Assert.assertEquals(630.00, leiloeiro.getTresMaiores().get(1).getValor(), 0.00001);
	}

	@Test(expected = RuntimeException.class)
	public void testeLeilaoSemLanceException() {
		// Motando Cenario
		Leilao leilao = new CriadorDeLeilao().para("Leilao de Camaro apreendido").constroi();

		// Executa
		leiloeiro.avalia(leilao);

	}
}
