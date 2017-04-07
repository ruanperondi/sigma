package br.com.sigma.processo.distribuicao.features.vara.def;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;
import org.hibernate.envers.Audited;

import br.com.sigma.processo.distribuicao.base.persistence.GenericPersistenceClass;
import br.com.sigma.processo.distribuicao.features.comarca.def.Comarca;
import br.com.sigma.processo.distribuicao.features.competencia.def.Competencia;

/**
 * Classe responsável por ter informações a respeito da Classe Processual
 */
@Entity
@Table
@DynamicUpdate
@SelectBeforeUpdate
@Audited
@NamedQueries({@NamedQuery(name = "vara.buscarPorPKIgnoreCase", query = "SELECT v FROM Vara v WHERE v.id.idComarca=:idComarca AND upper( v.id.nome ) =:nomeVara"),
    @NamedQuery(name = "vara.buscarCompetenciasComarca", query = "SELECT distinct v.competencias FROM Vara v WHERE v.id.idComarca=:idComarca"),
    @NamedQuery(name = "vara.buscarCompetenciasVara", query = "SELECT distinct v.competencias FROM Vara v WHERE v.id.idComarca=:idComarca AND upper(v.id.nome) =:nomeVara")})
public class Vara extends GenericPersistenceClass<VaraPK> {

  @EmbeddedId
  @NotNull(message = "{vara.id.nulo}")
  @Valid
  private VaraPK id;

  @ManyToOne
  @JoinColumn(insertable = false, updatable = false, name = "id_comarca")
  @NotNull(message = "{vara.comarca.obrigatoria}")
  private Comarca comarca;

  @Column(nullable = false, insertable = false, updatable = false)
  @NotNull(message = "{vara.nome.obrigatoria}")
  private String nome;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "vara_competencia", joinColumns = {@JoinColumn(name = "nome_vara", referencedColumnName = "nome"), @JoinColumn(name = "id_comarca", referencedColumnName = "id_comarca")},
      inverseJoinColumns = {@JoinColumn(name = "nome_competencia", referencedColumnName = "nome"), @JoinColumn(name = "id_classe_processual", referencedColumnName = "id_classe_processual")})
  private Set<Competencia> competencias;

  /**
   * Método responsável por retornar o campo id
   *
   * @return retorna o campo id
   */
  public VaraPK getId() {
    return id;
  }

  /**
   * Seta o valor do parametro id para o field id
   *
   * @param id valor para ser setado na variavel id
   */
  public void setId(VaraPK id) {
    this.id = id;
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
   * Método responsável por retornar o campo competencias
   *
   * @return retorna o campo competencias
   */
  public Set<Competencia> getCompetencias() {
    return competencias;
  }

  /**
   * Seta o valor do parametro competencias para o field competencias
   *
   * @param competencias valor para ser setado na variavel competencias
   */
  public void setCompetencias(Set<Competencia> competencias) {
    this.competencias = competencias;
  }


}
