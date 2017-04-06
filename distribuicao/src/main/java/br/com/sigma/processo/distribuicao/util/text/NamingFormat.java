package br.com.sigma.processo.distribuicao.util.text;

/**
 * Classe respons�vel por ter formata��es de naming
 *
 * @author Juan Perondi
 */
public final class NamingFormat {

	/**
	 * Metodo respons�vel por converter algo de camel case para underscore
	 * 
	 * @param value
	 *            Valor que queremos converter
	 * @return o que era camel case para score
	 */
	public static String toUnderscore(String value) {
		String regex = "([a-z])([A-Z]+)";
		String replacement = "$1_$2";

		return value.replaceAll(regex, replacement).toLowerCase();
	}

}
