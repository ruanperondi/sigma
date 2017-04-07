package br.com.sigma.processo.distribuicao.util.text;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Classe respons�vel por definir metodos utilitarios para json
 *
 * @author Juan Perondi
 */
public final class JSONUtils {

  /**
   * Metodo respons�vel por converter um objeto para um JSON
   * 
   * @param object Objeto que queremos converter
   * @return String em forma de JSOn
   */
  public static final String toJSON(Object object) {
    if (object == null) {
      return "{}";
    }
    try {
      ObjectMapper mapper = new ObjectMapper();
      return mapper.writeValueAsString(object);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return "{}";
  }
}
