package br.com.sigma.processo.distribuicao.features.categoria.def;

import javax.ws.rs.QueryParam;

import br.com.sigma.processo.distribuicao.base.filter.GenericFilter;
import br.com.sigma.processo.distribuicao.util.query.RepresentColumn;

/**
 * Classe responsável por definir o que será utilizado como filtro para a categoria
 *
 * @author Juan Perondi
 */
public class CategoriaFilter extends GenericFilter {

  @QueryParam("idExterno")
  @RepresentColumn
  private String idExterno;

  @QueryParam("ativo")
  @RepresentColumn
  private Boolean ativo;

  @QueryParam("nome")
  @RepresentColumn
  private String nome;

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

  /**
   * Método responsável por retornar o campo ativo
   *
   * @return retorna o campo ativo
   */
  public Boolean getAtivo() {
    return ativo;
  }

  /**
   * Seta o valor do parametro ativo para o field ativo
   *
   * @param ativo valor para ser setado na variavel ativo
   */
  public void setAtivo(Boolean ativo) {
    this.ativo = ativo;
  }

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
}
