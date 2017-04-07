package br.com.sigma.processo.distribuicao.features.competencia.def;

import javax.ws.rs.QueryParam;

import br.com.sigma.processo.distribuicao.base.filter.GenericFilter;
import br.com.sigma.processo.distribuicao.util.query.RepresentColumn;

/**
 * Classe responsável por definir o que ser� utilizado como filtro para a competencia
 *
 * @author Juan Perondi
 */
public class CompetenciaFilter extends GenericFilter {

  @QueryParam("nome")
  @RepresentColumn()
  private String nome;

  @QueryParam("idClasseProcessual")
  @RepresentColumn("classeProcessual.id")
  private Integer idClasseProcessual;


  /**
   * Retorna o campo nome
   *
   * @return Retorna o campo nome
   */
  public final String getNome() {
    return nome;
  }

  /**
   * Seta o parametro nome para o campo nome
   *
   * @param nome Parametro para setar no valor nome
   */
  public final void setNome(final String nome) {
    this.nome = nome;
  }

  /**
   * Método responsável por retornar o campo idClasseProcessual
   *
   * @return retorna o campo idClasseProcessual
   */
  public Integer getIdClasseProcessual() {
    return idClasseProcessual;
  }

  /**
   * Seta o valor do parametro idClasseProcessual para o field idClasseProcessual
   *
   * @param idClasseProcessual valor para ser setado na variavel idClasseProcessual
   */
  public void setIdClasseProcessual(Integer idClasseProcessual) {
    this.idClasseProcessual = idClasseProcessual;
  }
}
