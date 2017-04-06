package br.com.sigma.processo.distribuicao.base.validate;

import java.io.Serializable;

import javax.validation.Valid;

import br.com.sigma.processo.distribuicao.base.persistence.GenericPersistenceClass;

/**
 * Classe respons�vel por utilizar a valida��o generica para alguns campos
 *
 * @author Juan Perondi
 */
public abstract class GenericEntityValidationImpl<PK extends Serializable, T extends GenericPersistenceClass<PK>> implements GenericEntityValidation<PK, T> {

  /* (non-Javadoc)
   * @see br.com.softbox.tradelinks.base.validate.GenericEntityValidation#validatePersist(T)
   */
  @Override
  public void validatePersist(@Valid T object) throws BusinessException {
    validateUniqueConstraints(object);

    if (object.getId() == null) {
      validateBusinessInsert(object);
    } else {
      validateBusinessUpdate(object);
    }
  }

  /* (non-Javadoc)
   * @see br.com.softbox.tradelinks.base.validate.GenericEntityValidation#validateActiveStatus(T)
   */
  @Override
  public void validateActiveStatus(T object) throws BusinessException {
    if (object.getId() == null) {
      return;
    }

    if (object.getAtivo() == null || !object.getAtivo()) {
      validateDeactivate(object);
    } else {
      validateActivate(object);
    }
  }

  /**
   * Metodo respons�vel por validar a inativa��o de um registro
   * 
   * @param object Objeto que queremos validar
   */
  protected abstract void validateDeactivate(T object) throws BusinessException;

  /**
   * Metodo respons�vel por validar a ativa��o de um registro
   * 
   * @param object Objeto que queremos validar
   */
  protected abstract void validateActivate(T object) throws BusinessException;

  /**
   * Valida regras de neg�cio para inser��o
   * 
   * @param object Objeto que queremos validar
   */
  protected abstract void validateBusinessInsert(T object) throws BusinessException;

  /**
   * Valida regras de neg�cio para atualiza��o
   * 
   * @param object Objeto que queremos validar
   */
  protected abstract void validateBusinessUpdate(T object) throws BusinessException;

  /**
   * Metodo respons�vel por validar Constraints unicas
   * 
   * @param object Valida Constraints Unicas
   * @throws BusinessException
   */
  protected abstract void validateUniqueConstraints(T object) throws BusinessException;

}