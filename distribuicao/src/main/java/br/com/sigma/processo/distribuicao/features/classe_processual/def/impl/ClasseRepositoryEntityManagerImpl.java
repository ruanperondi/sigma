package br.com.sigma.processo.distribuicao.features.classe_processual.def.impl;

import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;

import br.com.sigma.processo.distribuicao.base.repository.EntityManagerRepository;
import br.com.sigma.processo.distribuicao.features.classe_processual.ClasseProcessualRepository;
import br.com.sigma.processo.distribuicao.features.classe_processual.def.ClasseProcessual;
import br.com.sigma.processo.distribuicao.features.classe_processual.def.ClasseProcessualFilter;

/**
 * Classe responsável por realizar o que a classe EntityManager Repository exige
 *
 * @author Juan Perondi
 */
@Default
@Dependent
public class ClasseRepositoryEntityManagerImpl extends EntityManagerRepository<Integer, ClasseProcessual, ClasseProcessualFilter> implements ClasseProcessualRepository {

  private static final List<String> COLUNAS_DEFAULT = Arrays.asList("id", "nome");

  /**
   * Construtor da Classe
   */
  public ClasseRepositoryEntityManagerImpl() {
    super(ClasseProcessual.class, ClasseProcessualFilter.class);
  }

  /**
   * Retorna o JPQL default para utilizar na query
   * 
   * @return
   */
  @Override
  protected List<String> getDefaultJPQL() {
    return ClasseRepositoryEntityManagerImpl.COLUNAS_DEFAULT;
  }
}
