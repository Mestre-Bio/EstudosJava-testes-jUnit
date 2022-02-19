package br.com.caelum.leilao.dominio;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MatematicaMalucaTest {
    int numero;
    MatematicaMaluca matematicaM = new MatematicaMaluca();

    @Test
    public void maiorQueTrinta() {
	numero = 50;
	assertEquals(numero*4, matematicaM.contaMaluca(numero));

    }
    @Test
    public void menorQueDez() {
	numero = 5;
	assertEquals(numero*2, matematicaM.contaMaluca(numero));
    }

    @Test
    public void entreDezETrinta() {
	numero = 15;
	assertEquals(numero*3, matematicaM.contaMaluca(15));
    }
}
