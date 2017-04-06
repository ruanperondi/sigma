package br.com.sigma.processo.distribuicao.features.segmento.def.impl;

import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;

import br.com.sigma.processo.distribuicao.base.repository.EntityManagerRepository;
import br.com.sigma.processo.distribuicao.features.segmento.SegmentoRepository;
import br.com.sigma.processo.distribuicao.features.segmento.def.Segmento;
import br.com.sigma.processo.distribuicao.features.segmento.def.SegmentoFilter;

/**
 * Classe responsável por realizar o que a classe EntityManager Repository exige
 *
 * @author Juan Perondi
 */
@Default
@Dependent
public class SegmentoRepositoryEntityManagerImpl extends EntityManagerRepository<Integer, Segmento, SegmentoFilter> implements SegmentoRepository {

  private static final List<String> COLUNAS_DEFAULT = Arrays.asList("id", "idExterno", "nome", "ativo");

  /**
   * Construtor da Classe
   */
  public SegmentoRepositoryEntityManagerImpl() {
    super(Segmento.class, SegmentoFilter.class);
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
