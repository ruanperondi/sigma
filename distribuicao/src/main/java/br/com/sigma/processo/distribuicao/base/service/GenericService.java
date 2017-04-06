package br.com.sigma.processo.distribuicao.base.service;

import java.io.Serializable;
import java.util.List;

import br.com.sigma.processo.distribuicao.base.dto.GenericDTO;
import br.com.sigma.processo.distribuicao.base.filter.GenericFilter;
import br.com.sigma.processo.distribuicao.base.persistence.GenericPersistenceClass;

/**
 * Classe respons�vel por ter uum servi�o de um tipo especifico
 *
 * @author Juan Perondi
 *
 * @param <PK> Tipo da Chave Primaria
 * @param <T> Tipo referente ao banco de Dados
 * @param <DTO> DTO para fazer a transferencia das informa��es so servi�i para a tela
 * @param <F> Filtro
 */
public interface GenericService<PK extends Serializable, T extends GenericPersistenceClass<PK>, DTO extends GenericDTO<PK, T>, F extends GenericFilter> extends Serializable {

  /**
   * Metodo respons�vel por filtrar
   * 
   * @param filter Filter que queremos realizar
   * @return lista dos objetos encontrados
   */
  FilterResponse filter(F filter);

  /**
   * Retorna uma instancia com o ID passado por par�metro
   * 
   * @param id Id que queremos trabalhar
   * @return DTO com os valores encontrados
   */
  DTO get(PK id);

  /**
   * Salva um objeto
   * 
   * @param dto DTO para salvarmos
   * @return Retorna o DTO salvo
   */
  DTO save(DTO dto);

  /**
   * Realiza o Update em um DTO
   * 
   * @param dto DTO que queremos trabalhar
   * @return DTO atualizado
   */
  DTO update(DTO dto);

  /**
   * Realiza a atualiza��o de status
   * 
   * @param Lista dos DTOs para realizar atualiza��o em lote
   * @param status Status Status
   * @return Lista atualizada
   */
  List<DTO> updateStatus(List<DTO> id, Boolean status);

}
