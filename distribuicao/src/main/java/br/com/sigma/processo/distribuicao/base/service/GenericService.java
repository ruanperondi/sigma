package br.com.sigma.processo.distribuicao.base.service;

import java.io.Serializable;
import java.util.List;

import br.com.sigma.processo.distribuicao.base.dto.GenericDTO;
import br.com.sigma.processo.distribuicao.base.filter.GenericFilter;
import br.com.sigma.processo.distribuicao.base.persistence.GenericPersistenceClass;

/**
 * Classe responsável por ter uum serviço de um tipo especifico
 *
 * @author Juan Perondi
 *
 * @param <PK> Tipo da Chave Primaria
 * @param <T> Tipo referente ao banco de Dados
 * @param <DTO> DTO para fazer a transferencia das informações so serviçi para a tela
 * @param <F> Filtro
 */
public interface GenericService<PK extends Serializable, T extends GenericPersistenceClass<PK>, DTO extends GenericDTO<PK, T>, F extends GenericFilter> extends Serializable {

  /**
   * Metodo responsável por filtrar
   * 
   * @param filter Filter que queremos realizar
   * @return lista dos objetos encontrados
   */
  FilterResponse filter(F filter);

  /**
   * Retorna uma instancia com o ID passado por parâmetro
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
   * Realiza a atualização de status
   * 
   * @param Lista dos DTOs para realizar atualização em lote
   * @param status Status Status
   * @return Lista atualizada
   */
  List<DTO> updateStatus(List<DTO> id, Boolean status);

}
