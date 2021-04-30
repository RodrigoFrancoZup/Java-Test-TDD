package br.com.caelum.leilao.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leilao {

	private String descricao;
	private List<Lance> lances;

	public Leilao(String descricao) {
		this.descricao = descricao;
		this.lances = new ArrayList<Lance>();
	}

	public void propoe(Lance lance) {

		if (lances.isEmpty() || !ultimoLanceDado().getUsuario().equals(lance.getUsuario())
				&& quantidadeDeLance(lance.getUsuario()) < 5) {
			lances.add(lance);
		}

	}

	private int quantidadeDeLance(Usuario usuario) {
		int contador = 0;
		for (Lance aux : lances) {
			if (aux.getUsuario().equals(usuario))
				contador++;
		}
		return contador;
	}

	private Lance ultimoLanceDado() {
		return lances.get(lances.size() - 1);
	}

    public void dobraLance(Usuario usuario) {
        Lance ultimoLance = ultimoLanceDo(usuario);
            propoe(new Lance(usuario, ultimoLance.getValor()*2));
    }

    private Lance ultimoLanceDo(Usuario usuario) {
        Lance ultimo = null;
        for(Lance lance : lances) {
            if(lance.getUsuario().equals(usuario)) ultimo = lance;
        }

        return ultimo;
    }

	public String getDescricao() {
		return descricao;
	}

	public List<Lance> getLances() {
		return Collections.unmodifiableList(lances);
	}

}
