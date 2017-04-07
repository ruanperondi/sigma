package br.com.sigma.processo.distribuicao.features.vara.def.impl;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;
import javax.persistence.TypedQuery;
import javax.validation.Valid;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import br.com.sigma.processo.distribuicao.base.validate.BusinessException;
import br.com.sigma.processo.distribuicao.base.validate.GenericJPAEntityValidation;
import br.com.sigma.processo.distribuicao.features.vara.VaraValidacao;
import br.com.sigma.processo.distribuicao.features.vara.def.Vara;
import br.com.sigma.processo.distribuicao.features.vara.def.VaraPK;

/**
 * Classe responsável pela validação padrão da entidade Vara
 *
 * @author Juan Perondi
 */
@Default
@Dependent
public class VaraValidacaoImpl extends GenericJPAEntityValidation<Long, VaraPK, Vara> implements VaraValidacao {

  /**
   * Construtor da Classe
   */
  public VaraValidacaoImpl() {
    super(Vara.class, Long.class);
  }

  @Override
  public void validatePersist(Vara object) throws BusinessException {
    isVaraIdCadatrada(object);
  }

  @Override
  public boolean isVaraIdCadatrada(@Valid Vara vara) throws BusinessException {
    TypedQuery<Vara> query = super.manager.createNamedQuery("vara.buscarPorPKIgnoreCase", Vara.class).setParameter("idComarca", vara.getId().getIdComarca()).setParameter("nomeVara", StringUtils.upperCase(vara.getId().getNome()));

    if (CollectionUtils.isEmpty(query.getResultList())) {
      return false;
    }

    throw new BusinessException("Vara já cadastrada!");
  }

  @Override
  protected void validateDeactivate(final Vara object) throws BusinessException {}

  @Override
  protected void validateActivate(final Vara object) throws BusinessException {}

  @Override
  protected void validateBusinessInsert(final Vara object) throws BusinessException {
    isVaraIdCadatrada(object);
  }

  @Override
  protected void validateBusinessUpdate(final Vara object) throws BusinessException {
    throw new BusinessException("Não é possivel trocar uma Vara de Comarca!");
  }
}
