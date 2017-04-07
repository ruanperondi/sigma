package br.com.sigma.processo.distribuicao.features.vara.def;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Classe responsável por representar a Chave Composta (PFK) de Vara e Comarca
 *
 * @author Juan Perondi
 */
@Embeddable
public class VaraPK implements Serializable {

  private static final long serialVersionUID = -1339790006113512974L;

  @Column(nullable = false, name = "id_comarca")
  private Integer idComarca;

  @Column(nullable = false)
  private String nome;

  /**
   * Construtor da Classe
   * 
   */
  public VaraPK() {
    super();
  }

  /**
   * Construtor da Classe
   * 
   * @param idComarca
   * @param nome
   */
  public VaraPK(Integer idComarca, String nome) {
    super();
    this.idComarca = idComarca;
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
    return "VaraPK [idComarca=" + idComarca + ", nome=" + nome + "]";
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
    result = prime * result + ((idComarca == null) ? 0 : idComarca.hashCode());
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
    if (!(obj instanceof VaraPK)) {
      return false;
    }
    VaraPK other = (VaraPK) obj;
    if (idComarca == null) {
      if (other.idComarca != null) {
        return false;
      }
    } else if (!idComarca.equals(other.idComarca)) {
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
