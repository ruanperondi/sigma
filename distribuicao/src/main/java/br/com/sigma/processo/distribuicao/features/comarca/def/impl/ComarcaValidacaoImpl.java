package br.com.sigma.processo.distribuicao.features.comarca.def.impl;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;

import br.com.sigma.processo.distribuicao.base.validate.BusinessException;
import br.com.sigma.processo.distribuicao.base.validate.GenericJPAEntityValidation;
import br.com.sigma.processo.distribuicao.features.comarca.ComarcaValidacao;
import br.com.sigma.processo.distribuicao.features.comarca.def.Comarca;

/**
 * Classe responsável pela validação padrão da entidade Comarca
 *
 * @author Juan Perondi
 */
@Default
@Dependent
public class ComarcaValidacaoImpl extends GenericJPAEntityValidation<Long, Integer, Comarca> implements ComarcaValidacao {

  /**
   * Construtor da Classe
   */
  public ComarcaValidacaoImpl() {
    super(Comarca.class, Long.class);
  }

  @Override
  protected void validateDeactivate(final Comarca object) throws BusinessException {}

  @Override
  protected void validateActivate(final Comarca object) throws BusinessException {}

  @Override
  protected void validateBusinessInsert(final Comarca object) throws BusinessException {}

  @Override
  protected void validateBusinessUpdate(final Comarca object) throws BusinessException {}

}
