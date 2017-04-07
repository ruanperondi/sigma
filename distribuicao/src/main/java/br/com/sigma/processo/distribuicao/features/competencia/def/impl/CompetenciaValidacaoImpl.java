package br.com.sigma.processo.distribuicao.features.competencia.def.impl;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;
import javax.persistence.TypedQuery;
import javax.validation.Valid;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import br.com.sigma.processo.distribuicao.base.validate.BusinessException;
import br.com.sigma.processo.distribuicao.base.validate.GenericJPAEntityValidation;
import br.com.sigma.processo.distribuicao.features.competencia.CompetenciaValidacao;
import br.com.sigma.processo.distribuicao.features.competencia.def.Competencia;
import br.com.sigma.processo.distribuicao.features.competencia.def.CompetenciaPK;

/**
 * Classe responsável pela validação padrão da entidade Competencia
 *
 * @author Juan Perondi
 */
@Default
@Dependent
public class CompetenciaValidacaoImpl extends GenericJPAEntityValidation<Long, CompetenciaPK, Competencia> implements CompetenciaValidacao {

  /**
   * Construtor da Classe
   */
  public CompetenciaValidacaoImpl() {
    super(Competencia.class, Long.class);
  }

  @Override
  public void validatePersist(Competencia object) throws BusinessException {
    isCompetenciaIdCadatrada(object);
  }

  @Override
  public boolean isCompetenciaIdCadatrada(@Valid Competencia competencia) throws BusinessException {
    TypedQuery<Competencia> query = super.manager.createNamedQuery("competencia.buscarPorPKIgnoreCase", Competencia.class).setParameter("idClasseProcessual", competencia.getId().getIdClasseProcessual()).setParameter("nomeCompetencia", StringUtils.upperCase(competencia.getId().getNome()));

    if (CollectionUtils.isEmpty(query.getResultList())) {
      return false;
    }

    throw new BusinessException("Competencia já cadastrada!");
  }

  @Override
  protected void validateDeactivate(final Competencia object) throws BusinessException {}

  @Override
  protected void validateActivate(final Competencia object) throws BusinessException {}

  @Override
  protected void validateBusinessInsert(final Competencia object) throws BusinessException {
    isCompetenciaIdCadatrada(object);
  }

  @Override
  protected void validateBusinessUpdate(final Competencia object) throws BusinessException {
    throw new BusinessException("Não é possivel trocar uma Competencia de Classe Processual!");
  }
}
