package br.com.sigma.processo.distribuicao.base.dto;

import java.io.Serializable;

import br.com.sigma.processo.distribuicao.base.persistence.GenericPersistenceClass;

/**
 * Classe responsável por definir um contrato de DTO entre o serviçoo e o Business
 *
 * @author Juan Perondi
 *
 * @param <PK> Tipo da PK
 * @param <T> Tipo da classe persistente
 */
public abstract class GenericDTO<PK extends Serializable, T extends GenericPersistenceClass<PK>> {

  private PK id;

  /**
   * M�todo responsável por retornar o campo id
   *
   * @return retorna o campo id
   */
  public PK getId() {
    return id;
  }

  /**
   * Seta o valor do parametro id para o field id
   *
   * @param id valor para ser setado na variavel id
   */
  public void setId(final PK id) {
    this.id = id;
  }

}
