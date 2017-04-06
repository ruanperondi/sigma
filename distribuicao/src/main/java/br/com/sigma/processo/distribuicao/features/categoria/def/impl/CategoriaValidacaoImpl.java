package br.com.sigma.processo.distribuicao.features.categoria.def.impl;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;

import br.com.sigma.processo.distribuicao.base.validate.BusinessException;
import br.com.sigma.processo.distribuicao.base.validate.GenericJPAEntityValidation;
import br.com.sigma.processo.distribuicao.features.categoria.CategoriaValidacao;
import br.com.sigma.processo.distribuicao.features.categoria.def.Categoria;

/**
 * Classe responsável por gerar a validação padrão
 *
 * @author Juan Perondi
 */
@Default
@Dependent
public class CategoriaValidacaoImpl extends GenericJPAEntityValidation<Long, Integer, Categoria> implements CategoriaValidacao {

  /**
   * Construtor da Classe
   */
  public CategoriaValidacaoImpl() {
    super(Categoria.class, Long.class);
  }

  @Override
  protected void validateDeactivate(Categoria object) throws BusinessException {}

  @Override
  protected void validateActivate(Categoria object) throws BusinessException {}

  @Override
  protected void validateBusinessInsert(Categoria object) throws BusinessException {}

  @Override
  protected void validateBusinessUpdate(Categoria object) throws BusinessException {}

}
