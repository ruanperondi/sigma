package br.com.sigma.processo.distribuicao.features.classe_processual.def;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;
import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.NotBlank;

import br.com.sigma.processo.distribuicao.base.persistence.GenericPersistenceClass;

/**
 * Classe responsável por ter informações a respeito da Classe Processual
 */
@Entity
@Table
@DynamicUpdate
@SelectBeforeUpdate
@Audited
public class ClasseProcessual extends GenericPersistenceClass<Integer> {

  @Id
  @TableGenerator(name = "classe_processual_id", table = "sequence_ids", pkColumnName = "name", valueColumnName = "value")
  @GeneratedValue(strategy = GenerationType.TABLE, generator = "classe_processual_id")
  private Integer id;

  @Column(unique = true, nullable = false, length = 70)
  @NotBlank(message = "{classe_processual.nome.obrigatorio}")
  private String nome;

  /**
   * Construtor da Classe
   * 
   * @param id
   */
  public ClasseProcessual(Integer id) {
    super();
    this.id = id;
  }

  /**
   * Construtor da Classe
   */
  public ClasseProcessual() {
    super();
  }

  @Override
  public Integer getId() {
    return id;
  }

  @Override
  public void setId(final Integer id) {
    this.id = id;
  }

  /**
   * M�todo respons�vel por retornar o campo nome
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
  public void setNome(final String nome) {
    this.nome = nome;
  }
}
