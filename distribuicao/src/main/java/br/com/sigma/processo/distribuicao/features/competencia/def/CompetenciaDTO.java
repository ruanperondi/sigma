package br.com.sigma.processo.distribuicao.features.competencia.def;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.sigma.processo.distribuicao.base.dto.GenericDTO;

/**
 * Classe responsável por represntar um DTO da entidade de ClasseProcessual para trabalhar com o
 * Front e o Back
 *
 * @author Juan Perondi
 */
@JsonIgnoreProperties("id")
public class CompetenciaDTO extends GenericDTO<CompetenciaPK, Competencia> {

  private String nome;

  private Integer idClasseProcessual;

  private String nomeClasseProcessual;

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

  /**
   * Método responsável por retornar o campo nomeClasseProcessual
   *
   * @return retorna o campo nomeClasseProcessual
   */
  public String getNomeClasseProcessual() {
    return nomeClasseProcessual;
  }

  /**
   * Seta o valor do parametro nomeClasseProcessual para o field nomeClasseProcessual
   *
   * @param nomeClasseProcessual valor para ser setado na variavel nomeClasseProcessual
   */
  public void setNomeClasseProcessual(String nomeClasseProcessual) {
    this.nomeClasseProcessual = nomeClasseProcessual;
  }
}
