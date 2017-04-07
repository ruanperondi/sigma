package br.com.sigma.processo.distribuicao.features.comarca.def;

import javax.ws.rs.QueryParam;

import br.com.sigma.processo.distribuicao.base.filter.GenericFilter;
import br.com.sigma.processo.distribuicao.util.query.RepresentColumn;

/**
 * Classe responsável por definir o que ser� utilizado como filtro para a comarca
 *
 * @author Juan Perondi
 */
public class ComarcaFilter extends GenericFilter {

  @QueryParam("nome")
  @RepresentColumn
  private String nome;

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

}
