package br.com.caelum.leilao.dominio;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class FiltroDeLanceTest {

    Leilao leilao = new Leilao("Bicicreta");
    Usuario joao = new Usuario("João");
    FiltroDeLances filtro = new FiltroDeLances();

    @Test
    public void adicionaEntre1000E3000() {
	List<Lance> resultado = filtro.filtra(Arrays.asList(
		new Lance(joao, 2000),
		new Lance(joao, 3000),
		new Lance(joao, 1000),
		new Lance(joao, 800)));
	assertEquals(1, resultado.size());
	assertEquals(2000, resultado.get(0).getValor(), 0.0001);
    }
    @Test
    public void adicionaEntre500E700() {
	List<Lance> resultado = filtro.filtra(Arrays.asList(
		new Lance(joao, 500),
		new Lance(joao, 600),
		new Lance(joao, 700),
		new Lance(joao, 800)));
	assertEquals(1, resultado.size());
	assertEquals(600.0, resultado.get(0).getValor(), 0.0001);
    }
    @Test
    public void adicionaMaiorQue5000() {
	List<Lance> resultado = filtro.filtra(Arrays.asList(
		new Lance(joao, 5001),
		new Lance(joao, 6000),
		new Lance(joao, 10000)));
	assertEquals(3, resultado.size());
    }
    @Test
    public void naoAdicionaMenorQue500() {
	List<Lance> resultado = filtro.filtra(Arrays.asList(
		new Lance(joao, 1),
		new Lance(joao, 200),
		new Lance(joao, 500)));
	assertEquals(0, resultado.size());
    }
    @Test
    public void naoAdicionaEntre700E1000() {
	List<Lance> resultado = filtro.filtra(Arrays.asList(
		new Lance(joao, 700),
		new Lance(joao, 850),
		new Lance(joao, 1000)));
	assertEquals(0, resultado.size());
    }
    @Test
    public void naoAdicionaEntre3000E5000() {
	List<Lance> resultado = filtro.filtra(Arrays.asList(
		new Lance(joao, 3000),
		new Lance(joao, 4500),
		new Lance(joao, 5000)));
	assertEquals(0, resultado.size());
    }

}
