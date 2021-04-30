package br.com.caelum.leilao.dominio;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TesteDoLeilao {
	


	@Test
	public void naoDeveAceitarDoisLancesSeguidosDoMesmoUsuario() {
		// Preparando cenário
		Leilao leilao = new Leilao("Leilao do PC Gamer");
		Usuario rodrigo = new Usuario("Rodrigo");

		// Executando
		leilao.propoe(new Lance(rodrigo, 500.00));
		leilao.propoe(new Lance(rodrigo, 1000.00));

		// Verificando
		assertEquals(1, leilao.getLances().size());
		assertEquals(500, leilao.getLances().get(0).getValor(), 0.0001);

	}

	@Test
	public void naoDeveAceitarMaisDoQue5LancesDeUmMesmoUsuario() {
		// Preparando cenário
		Leilao leilao = new Leilao("Leilao do PC Gamer");
		Usuario rodrigo = new Usuario("Rodrigo");
		Usuario matheus = new Usuario("Matheus");
		
		// Executando
		leilao.propoe(new Lance(rodrigo, 1000.00));
		leilao.propoe(new Lance(matheus, 2000.00));
		leilao.propoe(new Lance(rodrigo, 3000.00));
		leilao.propoe(new Lance(matheus, 4000.00));
		leilao.propoe(new Lance(rodrigo, 5000.00));
		leilao.propoe(new Lance(matheus, 6000.00));
		leilao.propoe(new Lance(rodrigo, 7000.00));
		leilao.propoe(new Lance(matheus, 8000.00));
		leilao.propoe(new Lance(rodrigo, 9000.00));
		leilao.propoe(new Lance(matheus, 10000.00));
		
		//Deve ser barrado
		leilao.propoe(new Lance(rodrigo, 9000.00));
		
		// Verificando
		assertEquals(10, leilao.getLances().size());
		assertEquals(10000, leilao.getLances().get(leilao.getLances().size()-1).getValor(), 0.0001);
	}
	
	@Test
	public void dobraValorDoUltimoLanceDoUsuario() {
		// Preparando cenário
		Leilao leilao = new Leilao("Leilao do PC Gamer");
		Usuario rodrigo = new Usuario("Rodrigo");
		Usuario matheus = new Usuario("Matheus");
		
		// Executando
		leilao.propoe(new Lance(rodrigo, 1500.00));
		leilao.propoe(new Lance(matheus, 2000.00));
		assertEquals(2, leilao.getLances().size());
		leilao.dobraLance(rodrigo);
		
		// Verificando
		assertEquals(3, leilao.getLances().size());
		assertEquals(3000, leilao.getLances().get(leilao.getLances().size()-1).getValor(), 0.0001);
	}
	
	

}
