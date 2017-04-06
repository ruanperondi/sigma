package br.com.sigma.processo.distribuicao.features.categoria.def.impl;

import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;

import br.com.sigma.processo.distribuicao.base.repository.EntityManagerRepository;
import br.com.sigma.processo.distribuicao.features.categoria.CategoriaRepository;
import br.com.sigma.processo.distribuicao.features.categoria.def.Categoria;
import br.com.sigma.processo.distribuicao.features.categoria.def.CategoriaFilter;

/**
 * Classe responsável por realizar o que a classe EntityManager Repository exige
 *
 * @author Juan Perondi
 */
@Default
@Dependent
public class CategoriaRepositoryEntityManagerImpl extends EntityManagerRepository<Integer, Categoria, CategoriaFilter> implements CategoriaRepository {

  private static final List<String> COLUNAS_DEFAULT = Arrays.asList("id", "idExterno", "nome", "ativo");

  /**
   * Construtor da Classe
   */
  public CategoriaRepositoryEntityManagerImpl() {
    super(Categoria.class, CategoriaFilter.class);
  }

  /**
   * Retorna o JPQL default para utilizar na query
   * 
   * @return
   */
  protected List<String> getDefaultJPQL() {
    return COLUNAS_DEFAULT;
  }
}
