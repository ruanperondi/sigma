package br.com.sigma.processo.distribuicao.base.filter;

import java.util.List;

import javax.ws.rs.QueryParam;

/**
 * Classe responsável por utilizar a base dos filtros
 *
 * @author Juan Perondi
 */
public class GenericFilter {

  @QueryParam("sort")
  private List<String> sort;

  @QueryParam("fields")
  private String fields;

  @QueryParam("limit")
  private Integer limit;

  @QueryParam("offSet")
  private Integer offSet;

  @QueryParam("count")
  private Long count;

  /**
   * Método responsável por retornar o campo sort
   *
   * @return retorna o campo sort
   */
  public List<String> getSort() {
    return sort;
  }

  /**
   * Seta o valor do parametro sort para o field sort
   *
   * @param sort valor para ser setado na variavel sort
   */
  public void setSort(List<String> sort) {
    this.sort = sort;
  }

  /**
   * Método responsável por retornar o campo fields
   *
   * @return retorna o campo fields
   */
  public String getFields() {
    return fields;
  }

  /**
   * Seta o valor do parametro fields para o field fields
   *
   * @param fields valor para ser setado na variavel fields
   */
  public void setFields(String fields) {
    this.fields = fields;
  }

  /**
   * Método responsável por retornar o campo limit
   *
   * @return retorna o campo limit
   */
  public Integer getLimit() {
    if (limit == null) {
      limit = 10;
    }

    return limit;
  }

  /**
   * Seta o valor do parametro limit para o field limit
   *
   * @param limit valor para ser setado na variavel limit
   */
  public void setLimit(Integer limit) {
    this.limit = limit;
  }

  /**
   * Método responsável por retornar o campo offSet
   *
   * @return retorna o campo offSet
   */
  public Integer getOffSet() {
    if (offSet == null) {
      offSet = 0;
    }

    return offSet;
  }

  /**
   * Seta o valor do parametro offSet para o field offSet
   *
   * @param offSet valor para ser setado na variavel offSet
   */
  public void setOffSet(Integer offSet) {
    this.offSet = offSet;
  }

  /**
   * Método responsável por retornar o campo count
   *
   * @return retorna o campo count
   */
  public Long getCount() {
    return count;
  }

  /**
   * Seta o valor do parametro count para o field count
   *
   * @param count valor para ser setado na variavel count
   */
  public void setCount(Long count) {
    this.count = count;
  }


}
