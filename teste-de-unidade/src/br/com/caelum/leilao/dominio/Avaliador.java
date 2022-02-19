package br.com.caelum.leilao.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Avaliador {
	public double maiorLance = Double.NEGATIVE_INFINITY;
	public double menorLance = Double.POSITIVE_INFINITY;
	private List<Lance> maiores;

	public void avalia(Leilao leilao) {
		for (Lance lance: leilao.getLances()) {
			if (lance.getValor() > this.maiorLance) {
				maiorLance = lance.getValor();
			}
			if (lance.getValor() < this.menorLance) {
				menorLance = lance.getValor();
			}
		}

		maiores = new ArrayList<>(leilao.getLances());

		Collections.sort(maiores, new Comparator<Lance>() {
			@Override
			public int compare(Lance l1, Lance l2) {
				if(l1.getValor() < l2.getValor()) return 1;
				if(l1.getValor() > l2.getValor()) return -1;
				return 0;
			}
		});
		maiores = maiores.subList(0, maiores.size() > 3 ? 3 : maiores.size());
	}

	public double getMedio(Leilao leilao) {
		double soma = 0;
		for (Lance lance : leilao.getLances()) {
			soma += lance.getValor();
		}

		return (soma/leilao.getLances().size());
	}

	public List<Lance> getTresMaiores(){
		return this.maiores;
	}
}
