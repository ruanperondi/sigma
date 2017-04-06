package br.com.sigma.processo.distribuicao.features.classe_processual.def;

import br.com.sigma.processo.distribuicao.base.dto.GenericDTO;

/**
 * Classe respons�vel por represntar um DTO da entidade de Classe Processual para trabalhar com o
 * Front e o Back
 *
 * @author Juan Perondi
 */
public class ClasseProcessualDTO extends GenericDTO<Integer, ClasseProcessual> {

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
