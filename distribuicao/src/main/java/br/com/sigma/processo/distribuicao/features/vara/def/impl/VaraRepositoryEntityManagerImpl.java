package br.com.sigma.processo.distribuicao.features.vara.def.impl;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;

import org.apache.commons.lang.StringUtils;

import br.com.sigma.processo.distribuicao.base.repository.EntityManagerRepository;
import br.com.sigma.processo.distribuicao.features.competencia.def.Competencia;
import br.com.sigma.processo.distribuicao.features.vara.VaraRepository;
import br.com.sigma.processo.distribuicao.features.vara.def.Vara;
import br.com.sigma.processo.distribuicao.features.vara.def.VaraFilter;
import br.com.sigma.processo.distribuicao.features.vara.def.VaraPK;

/**
 * Vara responsável por realizar o que a classe EntityManager Repository exige
 *
 * @author Juan Perondi
 */
@Default
@Dependent
public class VaraRepositoryEntityManagerImpl extends EntityManagerRepository<VaraPK, Vara, VaraFilter> implements VaraRepository {

  private static final List<String> COLUNAS_DEFAULT = Arrays.asList("Vara");

  /**
   * Construtor da Vara
   */
  public VaraRepositoryEntityManagerImpl() {
    super(Vara.class, VaraFilter.class);

    super.setTypedQuery(true);
  }

  /**
   * Retorna o JPQL default para utilizar na query
   * 
   * @return
   */
  @Override
  protected List<String> getDefaultJPQL() {
    return VaraRepositoryEntityManagerImpl.COLUNAS_DEFAULT;
  }

  @SuppressWarnings("unchecked")
  @Override
  public Set<Competencia> getCompetenciasPorVara(Integer idComarca, String nomeVara) {
    List<Competencia> resultSet = super.entityManager.createNamedQuery("vara.buscarCompetenciasVara").setParameter("idComarca", idComarca).setParameter("nomeVara", StringUtils.upperCase(nomeVara)).getResultList();
    Set<Competencia> retorno = new LinkedHashSet<>();

    for (Competencia competencia : resultSet) {
      retorno.add(competencia);
    }

    return retorno;
  }


}
