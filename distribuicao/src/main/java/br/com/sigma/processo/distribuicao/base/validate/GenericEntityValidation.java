package br.com.sigma.processo.distribuicao.base.validate;

import java.io.Serializable;

import javax.validation.Valid;

import br.com.sigma.processo.distribuicao.base.persistence.GenericPersistenceClass;


public interface GenericEntityValidation<PK extends Serializable, T extends GenericPersistenceClass<PK>> {

  /**
   * Metodo responsável por validar constraints da entidade
   * 
   * @param object Valida as Uniques Constraints das Entidades
   */
  void validatePersist(@Valid T object) throws BusinessException;

  /**
   * Metodo responsável por validar status ativo
   * 
   * @param object Objeto que queremos validar
   */
  void validateActiveStatus(T object) throws BusinessException;

}
