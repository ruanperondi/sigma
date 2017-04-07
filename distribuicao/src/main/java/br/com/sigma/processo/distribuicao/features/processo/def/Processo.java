package br.com.sigma.processo.distribuicao.features.processo.def;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;
import org.hibernate.envers.Audited;

import br.com.sigma.processo.distribuicao.base.persistence.GenericPersistenceClass;
import br.com.sigma.processo.distribuicao.features.classe_processual.def.ClasseProcessual;
import br.com.sigma.processo.distribuicao.features.comarca.def.Comarca;
import br.com.sigma.processo.distribuicao.features.competencia.def.Competencia;
import br.com.sigma.processo.distribuicao.features.vara.def.Vara;

@Entity
@Table
@DynamicUpdate
@SelectBeforeUpdate
@Audited
public class Processo extends GenericPersistenceClass<Integer> {

  @Id
  @NotNull(message = "{processo.id.obrigatorio}")
  private Integer numeroProcessoUnico;

  @ManyToOne
  @JoinColumns(value = {@JoinColumn(name = "nome_vara", referencedColumnName = "nome"), @JoinColumn(name = "id_comarca", referencedColumnName = "id_comarca")})
  @NotNull(message = "{vara.obrigatoria}")
  private Vara vara;

  @ManyToOne
  @JoinColumns(value = {@JoinColumn(name = "nome_competencia", referencedColumnName = "nome"), @JoinColumn(name = "id_classe_processual", referencedColumnName = "id_classe_processual")})
  @NotNull(message = "{competencia.obrigatoria}")
  private Competencia competencia;

  @ManyToOne
  @JoinColumn(insertable = false, updatable = false, name = "id_comarca")
  @NotNull(message = "{comarca.obrigatoria}")
  private Comarca comarca;

  @ManyToOne
  @JoinColumn(insertable = false, updatable = false, name = "id_classe_processual")
  private ClasseProcessual classeProcessual;

  /**
   * Método responsável por retornar o campo id
   *
   * @return retorna o campo id
   */
  public Integer getId() {
    return numeroProcessoUnico;
  }

  /**
   * Seta o valor do parametro id para o field id
   *
   * @param id valor para ser setado na variavel id
   */
  public void setId(Integer id) {
    this.numeroProcessoUnico = id;
  }

  /**
   * Método responsável por retornar o campo vara
   *
   * @return retorna o campo vara
   */
  public Vara getVara() {
    return vara;
  }

  /**
   * Seta o valor do parametro vara para o field vara
   *
   * @param vara valor para ser setado na variavel vara
   */
  public void setVara(Vara vara) {
    this.vara = vara;
  }

  /**
   * Método responsável por retornar o campo competencia
   *
   * @return retorna o campo competencia
   */
  public Competencia getCompetencia() {
    return competencia;
  }

  /**
   * Seta o valor do parametro competencia para o field competencia
   *
   * @param competencia valor para ser setado na variavel competencia
   */
  public void setCompetencia(Competencia competencia) {
    this.competencia = competencia;
  }

  /**
   * Método responsável por retornar o campo comarca
   *
   * @return retorna o campo comarca
   */
  public Comarca getComarca() {
    return comarca;
  }

  /**
   * Seta o valor do parametro comarca para o field comarca
   *
   * @param comarca valor para ser setado na variavel comarca
   */
  public void setComarca(Comarca comarca) {
    this.comarca = comarca;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((numeroProcessoUnico == null) ? 0 : numeroProcessoUnico.hashCode());
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
    if (!super.equals(obj)) {
      return false;
    }
    if (!(obj instanceof Processo)) {
      return false;
    }
    Processo other = (Processo) obj;
    if (numeroProcessoUnico == null) {
      if (other.numeroProcessoUnico != null) {
        return false;
      }
    } else if (!numeroProcessoUnico.equals(other.numeroProcessoUnico)) {
      return false;
    }
    return true;
  }

  /**
   * Método responsável por retornar o campo numeroProcessoUnico
   *
   * @return retorna o campo numeroProcessoUnico
   */
  public Integer getNumeroProcessoUnico() {
    return numeroProcessoUnico;
  }

  /**
   * Seta o valor do parametro numeroProcessoUnico para o field numeroProcessoUnico
   *
   * @param numeroProcessoUnico valor para ser setado na variavel numeroProcessoUnico
   */
  public void setNumeroProcessoUnico(Integer numeroProcessoUnico) {
    this.numeroProcessoUnico = numeroProcessoUnico;
  }

  /**
   * Método responsável por retornar o campo classeProcessual
   *
   * @return retorna o campo classeProcessual
   */
  public ClasseProcessual getClasseProcessual() {
    return classeProcessual;
  }

  /**
   * Seta o valor do parametro classeProcessual para o field classeProcessual
   *
   * @param classeProcessual valor para ser setado na variavel classeProcessual
   */
  public void setClasseProcessual(ClasseProcessual classeProcessual) {
    this.classeProcessual = classeProcessual;
  }



}
