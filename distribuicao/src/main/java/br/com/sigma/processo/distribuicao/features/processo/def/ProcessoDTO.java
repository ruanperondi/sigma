package br.com.sigma.processo.distribuicao.features.processo.def;

import br.com.sigma.processo.distribuicao.base.dto.GenericDTO;

/**
 * Classe responsável por ser o DTO entre Front e Back-end na parte do processo
 *
 * @author Juan Perondi
 */
public class ProcessoDTO extends GenericDTO<Integer, Processo>{

  private Integer numeroProcesso;

  private Integer idComarca;

  private String nomeComarca;

  private Integer idClasseProcessual;

  private String classeProcessual;

  private String nomeVara;

  private String competencia;

  /**
   * Método responsável por retornar o campo numeroProcesso
   *
   * @return retorna o campo numeroProcesso
   */
  public Integer getNumeroProcesso() {
    return numeroProcesso;
  }

  /**
   * Seta o valor do parametro numeroProcesso para o field numeroProcesso
   *
   * @param numeroProcesso valor para ser setado na variavel numeroProcesso
   */
  public void setNumeroProcesso(Integer numeroProcesso) {
    this.numeroProcesso = numeroProcesso;
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
   * Método responsável por retornar o campo classeProcessual
   *
   * @return retorna o campo classeProcessual
   */
  public String getClasseProcessual() {
    return classeProcessual;
  }

  /**
   * Seta o valor do parametro classeProcessual para o field classeProcessual
   *
   * @param classeProcessual valor para ser setado na variavel classeProcessual
   */
  public void setClasseProcessual(String classeProcessual) {
    this.classeProcessual = classeProcessual;
  }

  /**
   * Método responsável por retornar o campo nomeVara
   *
   * @return retorna o campo nomeVara
   */
  public String getNomeVara() {
    return nomeVara;
  }

  /**
   * Seta o valor do parametro nomeVara para o field nomeVara
   *
   * @param nomeVara valor para ser setado na variavel nomeVara
   */
  public void setNomeVara(String nomeVara) {
    this.nomeVara = nomeVara;
  }

  /**
   * Método responsável por retornar o campo competencia
   *
   * @return retorna o campo competencia
   */
  public String getCompetencia() {
    return competencia;
  }

  /**
   * Seta o valor do parametro competencia para o field competencia
   *
   * @param competencia valor para ser setado na variavel competencia
   */
  public void setCompetencia(String competencia) {
    this.competencia = competencia;
  }


}
