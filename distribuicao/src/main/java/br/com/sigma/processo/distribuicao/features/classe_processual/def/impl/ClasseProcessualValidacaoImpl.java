package br.com.sigma.processo.distribuicao.features.classe_processual.def.impl;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;

import br.com.sigma.processo.distribuicao.base.validate.BusinessException;
import br.com.sigma.processo.distribuicao.base.validate.GenericJPAEntityValidation;
import br.com.sigma.processo.distribuicao.features.classe_processual.ClasseProcessualValidacao;
import br.com.sigma.processo.distribuicao.features.classe_processual.def.ClasseProcessual;

/**
 * Classe responsável pela validação padrão da entidade classe processual
 *
 * @author Juan Perondi
 */
@Default
@Dependent
public class ClasseProcessualValidacaoImpl extends GenericJPAEntityValidation<Long, Integer, ClasseProcessual> implements ClasseProcessualValidacao {

  /**
   * Construtor da Classe
   */
  public ClasseProcessualValidacaoImpl() {
    super(ClasseProcessual.class, Long.class);
  }

  @Override
  protected void validateDeactivate(final ClasseProcessual object) throws BusinessException {}

  @Override
  protected void validateActivate(final ClasseProcessual object) throws BusinessException {}

  @Override
  protected void validateBusinessInsert(final ClasseProcessual object) throws BusinessException {}

  @Override
  protected void validateBusinessUpdate(final ClasseProcessual object) throws BusinessException {}

}
