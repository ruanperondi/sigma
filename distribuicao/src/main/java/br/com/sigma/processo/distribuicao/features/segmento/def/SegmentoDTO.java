package br.com.sigma.processo.distribuicao.features.segmento.def;

import br.com.sigma.processo.distribuicao.base.dto.GenericDTO;

/**
 * Classe responsável por represntar um DTO da entidade de Segmento para trabalhar com o Front e o
 * Back
 *
 * @author Juan Perondi
 */
public class SegmentoDTO extends GenericDTO<Integer, Segmento> {

  private String nome;

  private String idExterno;

  /**
   * Método responsável por retornar o campo nome
   *
   * @return retorna o campo nome
   */
  public String getNome() {
    return nome;
  }

  /**
   * Seta o valor do parametro nome para o field nome
   *
   * @param nome valor para ser setado na variavel nome
   */
  public void setNome(String nome) {
    this.nome = nome;
  }

  /**
   * Método responsável por retornar o campo idExterno
   *
   * @return retorna o campo idExterno
   */
  public String getIdExterno() {
    return idExterno;
  }

  /**
   * Seta o valor do parametro idExterno para o field idExterno
   *
   * @param idExterno valor para ser setado na variavel idExterno
   */
  public void setIdExterno(String idExterno) {
    this.idExterno = idExterno;
  }
}
