package br.com.sigma.processo.distribuicao.features.competencia.def.impl;

import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;

import br.com.sigma.processo.distribuicao.base.repository.EntityManagerRepository;
import br.com.sigma.processo.distribuicao.features.competencia.CompetenciaRepository;
import br.com.sigma.processo.distribuicao.features.competencia.def.Competencia;
import br.com.sigma.processo.distribuicao.features.competencia.def.CompetenciaFilter;
import br.com.sigma.processo.distribuicao.features.competencia.def.CompetenciaPK;

/**
 * Competencia responsável por realizar o que a classe EntityManager Repository exige
 *
 * @author Juan Perondi
 */
@Default
@Dependent
public class CompetenciaRepositoryEntityManagerImpl extends EntityManagerRepository<CompetenciaPK, Competencia, CompetenciaFilter> implements CompetenciaRepository {

  private static final List<String> COLUNAS_DEFAULT = Arrays.asList("Competencia");

  /**
   * Construtor da Competencia
   */
  public CompetenciaRepositoryEntityManagerImpl() {
    super(Competencia.class, CompetenciaFilter.class);

    super.setTypedQuery(true);
  }

  /**
   * Retorna o JPQL default para utilizar na query
   * 
   * @return
   */
  @Override
  protected List<String> getDefaultJPQL() {
    return CompetenciaRepositoryEntityManagerImpl.COLUNAS_DEFAULT;
  }


}
