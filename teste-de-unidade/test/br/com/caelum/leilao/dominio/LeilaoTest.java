package br.com.caelum.leilao.dominio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LeilaoTest {

	@Test
	public void deveReceberUmLance() {
		Leilao leilao = new Leilao("Praystaxon");
		assertEquals(0, leilao.getLances().size());

		leilao.propoe(new Lance(new Usuario("Geronimo"), 500));

		assertEquals(1, leilao.getLances().size());
		assertEquals(500, leilao.getLances().get(0).getValor(), 0.0001);
	}

	@Test
	public void deveReceberVariosLances() {
		Leilao leilao = new Leilao("Bicicreta motorizada");
		leilao.propoe(new Lance(new Usuario("Véi da rua"), 300));
		leilao.propoe(new Lance(new Usuario("Fisioterapeutico"), 30000));

		assertEquals(2, leilao.getLances().size());
		assertEquals(300.0, leilao.getLances().get(0).getValor(), 0.0001);
		assertEquals(30000.0, leilao.getLances().get(1).getValor(), 0.0001);

	}

	@Test
	public void naoDeveAceitarDoisLancesSeguidosDaMesmaPessoa() {
		Usuario colecionador = new Usuario("Colecionador");
		Leilao leilao = new Leilao("Rosquinhas Mabel vencidas");
		leilao.propoe(new Lance(colecionador, 50));
		leilao.propoe(new Lance(colecionador, 51));

		assertEquals(1, leilao.getLances().size());
	}

	@Test
	public void naoDeveAceitarMaisQue5LancesDoMesmoUsuario() {
		Leilao leilao = new Leilao("Casa feita de doces");
		Usuario joao = new Usuario("João");
		Usuario maria = new Usuario("Maria");

		leilao.propoe(new Lance(joao, 0.1));
		leilao.propoe(new Lance(maria, 0.2));
		leilao.propoe(new Lance(joao, 1));
		leilao.propoe(new Lance(maria, 2));
		leilao.propoe(new Lance(joao, 10));
		leilao.propoe(new Lance(maria, 20));
		leilao.propoe(new Lance(joao, 100));
		leilao.propoe(new Lance(maria, 200));
		leilao.propoe(new Lance(joao, 1000));
		leilao.propoe(new Lance(maria, 2000));

		// Deve ser ignorado
		leilao.propoe(new Lance(joao, 50000));

		assertEquals(10, leilao.getLances().size());
		assertEquals(2000, leilao.ultimoLanceDado().getValor(), 0.001);
	}

	@Test
	public void deveDobrarUltimoLanceDado() {
		Leilao leilao = new Leilao("Tatu morto");
		Usuario meuPai = new Usuario("Meu Pai");
		Usuario meuTio = new Usuario("Meu Tio");

		leilao.propoe(new Lance(meuPai, 20));
		leilao.propoe(new Lance(meuTio, 50));

		leilao.dobraLance(meuPai);

		assertEquals(40, leilao.getLances().get(2).getValor());
	}
	
	@Test
	public void naoDeveDobrarCasoNaoHajaLanceAnterior() {
		Leilao leilao = new Leilao("Vassoura amaldicoada");
		Usuario bruxaVeia = new Usuario("Bruxa Velha");
		
		leilao.dobraLance(bruxaVeia);
		
		assertEquals(0, leilao.getLances().size());
	}

}
