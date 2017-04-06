package br.com.sigma.processo.distribuicao.base.business;

import java.io.Serializable;
import java.util.List;

import br.com.sigma.processo.distribuicao.base.filter.GenericFilter;
import br.com.sigma.processo.distribuicao.base.persistence.GenericPersistenceClass;
import br.com.sigma.processo.distribuicao.base.validate.BusinessException;

/**
 * Classe respons�vel por ter uum servi�o de um tipo especifico
 *
 * @author Juan Perondi
 *
 * @param <PK> Tipo da Chave Primaria
 * @param <T> Tipo referente ao banco de Dados
 * @param <F> Filtro
 */
public interface GenericBusiness<PK extends Serializable, T extends GenericPersistenceClass<PK>, F extends GenericFilter> {

  /**
   * Metodo respons�vel por filtrar
   * 
   * @param filter Filter que queremos realizar
   * @return lista dos objetos encontrados
   * @throws BusinessException 
   */
  List<T> filter(F filter) throws BusinessException;

  /**
   * Retorna uma instancia com o ID passado por par�metro
   * 
   * @param id Id que queremos trabalhar
   * @return T com os valores encontrados
   */
  T get(PK id) throws BusinessException;

  /**
   * Salva um objeto
   * 
   * @param t T para salvarmos
   * @return Retorna o T salvo
   */
  T save(T t) throws BusinessException;

  /**
   * Realiza o Update em um T
   * 
   * @param t T que queremos trabalhar
   * @return T atualizado
   */
  T update(T t) throws BusinessException;

  /**
   * Realiza a atualiza��o de status
   * 
   * @param Lista dos Ts para realizar atualiza��o em lote
   * @return Lista atualizada
   */
  List<T> updateStatus(List<T> list) throws BusinessException;

  /**
   * Metodo respons�vel por fazer a contagem de inform�oes que podem ser retornadas no filter
   * 
   * @param filter Filter que queremos mexer
   * @return Quantidade Encontrados
   * @throws BusinessException
   */
  Long count(F filter) throws BusinessException;

}
