package br.com.caelum.anobissexto;

public class AnoBissexto {
	
	
	public boolean ehBissexto(int ano) {
	
		if (ano % 400 == 0) 
			return true;
		if (ano % 100 == 0) 
			return true;
		if (ano % 4 == 0)
			return true;
		return false;
	}

}
