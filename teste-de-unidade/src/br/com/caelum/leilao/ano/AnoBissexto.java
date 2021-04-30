package br.com.caelum.leilao.ano;

public class AnoBissexto {

	public Boolean ehBissexto(int i) {
		if (i % 400 == 0) {
			return true;
		} else if (i % 100 == 0) {
			return false;
		} else if (i % 4 == 0) {
			return true;
		} else {
			return false;
		}

	}

}
