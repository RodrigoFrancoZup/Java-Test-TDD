package br.com.caelum.leilao.dominio;

import org.junit.Test;

public class TesteLance {

	@Test(expected = IllegalArgumentException.class)
	public void testeLanceComValor0() {
		Lance lance = new Lance(new Usuario("Rodrigo"), 0.0);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testeLanceComValorNegativo() {
		Lance lance = new Lance(new Usuario("Rodrigo"), -10.0);
	}

}
