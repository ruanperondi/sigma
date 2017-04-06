package br.com.sigma.processo.distribuicao.base.validate;

/**
 * Classe responsável por considerar exceções relacioadas a regra de negócio
 *
 * @author Juan Perondi
 */
public class BusinessException extends Exception {

  private static final long serialVersionUID = -963234046829903256L;

  public BusinessException(String message) {
    super(message);
  }

  public String formatError() {
    return this.getMessage();
  }

}
