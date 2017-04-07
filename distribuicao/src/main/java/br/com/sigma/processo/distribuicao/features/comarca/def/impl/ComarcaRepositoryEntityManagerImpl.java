package br.com.sigma.processo.distribuicao.features.comarca.def.impl;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;

import br.com.sigma.processo.distribuicao.base.repository.EntityManagerRepository;
import br.com.sigma.processo.distribuicao.features.comarca.ComarcaRepository;
import br.com.sigma.processo.distribuicao.features.comarca.def.Comarca;
import br.com.sigma.processo.distribuicao.features.comarca.def.ComarcaFilter;
import br.com.sigma.processo.distribuicao.features.competencia.def.Competencia;

/**
 * Classe responsável por realizar o que a classe EntityManager Repository exige
 *
 * @author Juan Perondi
 */
@Default
@Dependent
public class ComarcaRepositoryEntityManagerImpl extends EntityManagerRepository<Integer, Comarca, ComarcaFilter> implements ComarcaRepository {

  private static final List<String> COLUNAS_DEFAULT = Arrays.asList("id", "nome");

  /**
   * Construtor da Classe
   */
  public ComarcaRepositoryEntityManagerImpl() {
    super(Comarca.class, ComarcaFilter.class);
  }

  /**
   * Retorna o JPQL default para utilizar na query
   * 
   * @return
   */
  @Override
  protected List<String> getDefaultJPQL() {
    return ComarcaRepositoryEntityManagerImpl.COLUNAS_DEFAULT;
  }

  @SuppressWarnings("unchecked")
  @Override
  public Set<Competencia> getCompetenciasPorComarca(Integer idComarca) {
    List<Competencia> resultSet = super.entityManager.createNamedQuery("vara.buscarCompetenciasComarca").setParameter("idComarca", idComarca).getResultList();
    Set<Competencia> retorno = new LinkedHashSet<>();

    for (Competencia competencia : resultSet) {
      retorno.add(competencia);
    }

    return retorno;
  }
}
