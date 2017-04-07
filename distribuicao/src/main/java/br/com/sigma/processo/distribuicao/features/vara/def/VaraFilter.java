package br.com.sigma.processo.distribuicao.features.vara.def;

import javax.ws.rs.QueryParam;

import br.com.sigma.processo.distribuicao.base.filter.GenericFilter;
import br.com.sigma.processo.distribuicao.util.query.RepresentColumn;

/**
 * Classe responsável por definir o que ser� utilizado como filtro para a vara
 *
 * @author Juan Perondi
 */
public class VaraFilter extends GenericFilter {

  @QueryParam("nome")
  @RepresentColumn()
  private String nome;

  @QueryParam("idComarca")
  @RepresentColumn("comarca.id")
  private Integer idComarca;


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
   * Método responsável por retornar o campo idComarca
   *
   * @return retorna o campo idComarca
   */
  public Integer getIdComarca() {
    return idComarca;
  }

  /**
   * Seta o valor do parametro idComarca para o field idComarca
   *
   * @param idComarca valor para ser setado na variavel idComarca
   */
  public void setIdComarca(Integer idComarca) {
    this.idComarca = idComarca;
  }
}
