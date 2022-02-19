package br.com.caelum.anobissexto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AnoBissextoTest {

	@Test
	void anoMultiploDe400DeveSerBiessexto() {
		AnoBissexto anoTest = new AnoBissexto();
		
		assertEquals(true, anoTest.ehBissexto(2000));
	}
	
	@Test
	void anoMultiploDe100DeveSerBissexto() {
		AnoBissexto anoTest = new AnoBissexto();
		
		assertEquals(true, anoTest.ehBissexto(2300));
	}
	
	@Test
	void anoMultiploDe4DeveSerBissexto() {
		AnoBissexto anoTest = new AnoBissexto();
		
		assertEquals(true, anoTest.ehBissexto(2072));
	}
	
	@Test
	void anoPrimoNaoDeveSerBissexto() {
		AnoBissexto anoTest = new AnoBissexto();
		
		assertEquals(false, anoTest.ehBissexto(2017));
	}

}
