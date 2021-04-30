package br.com.caelum.leilao.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Avaliador {



	private double maiorDeTodos = Double.NEGATIVE_INFINITY;
	private double menorDeTodos = Double.POSITIVE_INFINITY;
	private List<Lance> maiores;
	private Double media = 0.0;

	public void avalia(Leilao leilao) {
		if(leilao.getLances().size() == 0) {
			throw new RuntimeException("Leilao tem que ter lance!");
		}
		for (Lance lance : leilao.getLances()) {
			if (lance.getValor() > maiorDeTodos)
				maiorDeTodos = lance.getValor();
			if (lance.getValor() < menorDeTodos)
				menorDeTodos = lance.getValor();
		}

		pegaOsMaioresNo(leilao);
	}

	private void pegaOsMaioresNo(Leilao leilao) {
		maiores = new ArrayList<Lance>(leilao.getLances());
		Collections.sort(maiores, new Comparator<Lance>() {
			public int compare(Lance o1, Lance o2) {
				if (o1.getValor() < o2.getValor())
					return 1;
				if (o1.getValor() > o2.getValor())
					return -1;
				return 0;
			}
		});
		maiores = maiores.subList(0, maiores.size() > 3 ? 3 : maiores.size());
	}

	public void calculaMediaLances(Leilao leilao) {
		for (Lance lance : leilao.getLances()) {
			media += lance.getValor();
		}
		media = media / leilao.getLances().size();
	}

	public List<Lance> getTresMaiores() {
		return this.maiores;
	}

	public double getMaiorValor() {
		return maiorDeTodos;
	}

	public double getMenorValor() {
		return menorDeTodos;
	}

	public Double getMedia() {
		return media;
	}

}
