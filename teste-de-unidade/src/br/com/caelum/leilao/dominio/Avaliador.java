package br.com.caelum.leilao.dominio;

public class Avaliador {

	private Double menorValor = Double.POSITIVE_INFINITY;
	private Double maiorValor = Double.NEGATIVE_INFINITY;
	private Double media = 0.00;
	

	public void avalia(Leilao leilao) {
		for (Lance aux : leilao.getLances()) {
			if (aux.getValor() <= menorValor) {
				menorValor = aux.getValor();
			}
			if (aux.getValor() >= maiorValor) {
				maiorValor = aux.getValor();
			}
		}

	}
	
	
	public void calculaMediaLances(Leilao leilao) {
		Double somatorio = 0.00;
		for(Lance aux : leilao.getLances()) {
			somatorio += aux.getValor();
		}
		media = somatorio / leilao.getLances().size();
	}
	
	public Double getMedia() {
		return media;
	}
	
	public Double getMaiorValor() {
		return maiorValor;
	}
	
	public Double getMenorValor() {
		return menorValor;
	}

}
