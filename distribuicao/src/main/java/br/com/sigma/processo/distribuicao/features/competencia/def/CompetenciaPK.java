package br.com.sigma.processo.distribuicao.features.competencia.def;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Classe responsável por representar a Chave Composta (PFK) de Competencia e ClasseProcessual
 *
 * @author Juan Perondi
 */
@Embeddable
public class CompetenciaPK implements Serializable {

  private static final long serialVersionUID = 1472279054857199784L;

  @Column(nullable = false, name = "id_classe_processual")
  private Integer idClasseProcessual;

  @Column(unique = true, nullable = false)
  private String nome;

  /**
   * Construtor da Classe
   * 
   */
  public CompetenciaPK() {
    super();
  }

  /**
   * Construtor da Classe
   * 
   * @param idClasseProcessual
   * @param nome
   */
  public CompetenciaPK(Integer idClasseProcessual, String nome) {
    super();
    this.idClasseProcessual = idClasseProcessual;
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

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "CompetenciaPK [idClasseProcessual=" + idClasseProcessual + ", nome=" + nome + "]";
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((idClasseProcessual == null) ? 0 : idClasseProcessual.hashCode());
    result = prime * result + ((nome == null) ? 0 : nome.hashCode());
    return result;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (!(obj instanceof CompetenciaPK)) {
      return false;
    }
    CompetenciaPK other = (CompetenciaPK) obj;
    if (idClasseProcessual == null) {
      if (other.idClasseProcessual != null) {
        return false;
      }
    } else if (!idClasseProcessual.equals(other.idClasseProcessual)) {
      return false;
    }
    if (nome == null) {
      if (other.nome != null) {
        return false;
      }
    } else if (!nome.equals(other.nome)) {
      return false;
    }
    return true;
  }



}
