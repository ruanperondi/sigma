package br.com.sigma.processo.distribuicao.features.vara.def;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.sigma.processo.distribuicao.base.dto.GenericDTO;
import br.com.sigma.processo.distribuicao.features.competencia.def.CompetenciaDTO;

/**
 * Classe responsável por represntar um DTO da entidade de Comarca para trabalhar com o Front e o
 * Back
 *
 * @author Juan Perondi
 */
@JsonIgnoreProperties("id")
public class VaraDTO extends GenericDTO<VaraPK, Vara> {

  private String nome;

  private Integer idComarca;

  private String nomeComarca;

  private Set<CompetenciaDTO> competenciaList;

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

  /**
   * Método responsável por retornar o campo nomeComarca
   *
   * @return retorna o campo nomeComarca
   */
  public String getNomeComarca() {
    return nomeComarca;
  }

  /**
   * Seta o valor do parametro nomeComarca para o field nomeComarca
   *
   * @param nomeComarca valor para ser setado na variavel nomeComarca
   */
  public void setNomeComarca(String nomeComarca) {
    this.nomeComarca = nomeComarca;
  }

  /**
   * Método responsável por retornar o campo competenciaList
   *
   * @return retorna o campo competenciaList
   */
  public Set<CompetenciaDTO> getCompetenciaList() {
    return competenciaList;
  }

  /**
   * Seta o valor do parametro competenciaList para o field competenciaList
   *
   * @param competenciaList valor para ser setado na variavel competenciaList
   */
  public void setCompetenciaList(Set<CompetenciaDTO> competenciaList) {
    this.competenciaList = competenciaList;
  }


}
