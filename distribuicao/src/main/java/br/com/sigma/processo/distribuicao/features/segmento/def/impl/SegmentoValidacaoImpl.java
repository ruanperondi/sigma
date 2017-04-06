package br.com.sigma.processo.distribuicao.features.segmento.def.impl;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;

import br.com.sigma.processo.distribuicao.base.validate.BusinessException;
import br.com.sigma.processo.distribuicao.base.validate.GenericJPAEntityValidation;
import br.com.sigma.processo.distribuicao.features.segmento.SegmentoValidacao;
import br.com.sigma.processo.distribuicao.features.segmento.def.Segmento;

/**
 * Classe responsável por gerar a validação padrão
 *
 * @author Juan Perondi
 */
@Default
@Dependent
public class SegmentoValidacaoImpl extends GenericJPAEntityValidation<Long, Integer, Segmento> implements SegmentoValidacao {

  /**
   * Construtor da Classe
   */
  public SegmentoValidacaoImpl() {
    super(Segmento.class, Long.class);
  }

  @Override
  protected void validateDeactivate(Segmento object) throws BusinessException {}

  @Override
  protected void validateActivate(Segmento object) throws BusinessException {}

  @Override
  protected void validateBusinessInsert(Segmento object) throws BusinessException {}

  @Override
  protected void validateBusinessUpdate(Segmento object) throws BusinessException {}

}
