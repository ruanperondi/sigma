package br.com.sigma.processo.distribuicao.features.competencia.def;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;
import org.hibernate.envers.Audited;

import br.com.sigma.processo.distribuicao.base.persistence.GenericPersistenceClass;
import br.com.sigma.processo.distribuicao.features.classe_processual.def.ClasseProcessual;

/**
 * Classe responsável por ter informações a respeito da Classe Processual
 */
@Entity
@Table
@DynamicUpdate
@SelectBeforeUpdate
@Audited
@NamedQuery(name = "competencia.buscarPorPKIgnoreCase", query = "SELECT v FROM Competencia v WHERE v.id.idClasseProcessual=:idClasseProcessual AND upper( v.id.nome ) =:nomeCompetencia")
public class Competencia extends GenericPersistenceClass<CompetenciaPK> {

  @EmbeddedId
  @NotNull(message = "{competencia.id.nulo}")
  @Valid
  private CompetenciaPK id;

  @ManyToOne(fetch = FetchType.EAGER)
  @NotNull(message = "{competencia.classe_processual.obrigatoria}")
  @JoinColumn(name = "id_classe_processual", insertable = false, updatable = false)
  private ClasseProcessual classeProcessual;

  @Column(unique = true, nullable = false, insertable = false, updatable = false)
  @NotNull(message = "{competencia.nome.obrigatoria}")
  private String nome;

  /**
   * Método responsável por retornar o campo id
   *
   * @return retorna o campo id
   */
  public CompetenciaPK getId() {
    return id;
  }

  /**
   * Seta o valor do parametro id para o field id
   *
   * @param id valor para ser setado na variavel id
   */
  public void setId(CompetenciaPK id) {
    this.id = id;
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
}
