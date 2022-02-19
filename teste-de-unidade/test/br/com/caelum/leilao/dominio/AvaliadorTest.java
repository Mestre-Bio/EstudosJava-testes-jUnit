package br.com.caelum.leilao.dominio;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class AvaliadorTest {
	Usuario joao = new Usuario("João");
	Usuario jose = new Usuario("Jose");
	Usuario maria = new Usuario("Maria");

	Leilao leilao = new Leilao("Playstation 5 zerado");

	@Test
	public void testaMaiorEMenor() {
		leilao.propoe(new Lance(joao, 250.0));
		leilao.propoe(new Lance(jose, 300.0));
		leilao.propoe(new Lance(maria, 500.0));

		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		assertEquals(500.00, leiloeiro.maiorLance, 0.001);
		assertEquals(250.0, leiloeiro.menorLance, 0.001);
	}

	@Test
	public void testaMedio() {
		leilao.propoe(new Lance(joao, 400.0));
		leilao.propoe(new Lance(jose, 300.0));
		leilao.propoe(new Lance(maria, 500.0));

		Avaliador leiloeiro = new Avaliador();
		assertEquals(400.0, leiloeiro.getMedio(leilao), 0.001);
	}

	@Test
	public void fazerLeilaoComApenasUmLance() {
		leilao.propoe(new Lance(maria, 300.0));
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		assertEquals(300.0, leiloeiro.maiorLance,0.0001);
		assertEquals(300.0, leiloeiro.menorLance,0.0001);
		assertEquals(300.0, leiloeiro.getMedio(leilao),0.0001);
	}

	@Test
	public void deveEncontrarTresMaiores() {
		leilao.propoe(new Lance(maria, 100));
		leilao.propoe(new Lance(joao, 300));
		leilao.propoe(new Lance(maria, 200));
		leilao.propoe(new Lance(joao, 400));

		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);

		List<Lance> maiores = leiloeiro.getTresMaiores();

		assertEquals(3, maiores.size());
		assertEquals(400.0, maiores.get(0).getValor(), 0.0001);
		assertEquals(300.0, maiores.get(1).getValor(), 0.0001);
		assertEquals(200.0, maiores.get(2).getValor(), 0.0001);
	}
}
