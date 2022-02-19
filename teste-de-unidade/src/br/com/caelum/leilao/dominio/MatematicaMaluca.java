package br.com.caelum.leilao.dominio;

/**
 * Uma classe que faz calculos sem sentido, mas é só pra testar mesmo
 *
 * @author fabio
 * @version 1.0
 */
public class MatematicaMaluca {

    public int contaMaluca(int numero) {
	if (numero > 30)
	    return numero * 4;
	else if (numero > 10)
	    return numero * 3;
	else
	    return numero * 2;
    }

}
