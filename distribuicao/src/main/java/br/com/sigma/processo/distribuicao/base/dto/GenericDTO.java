package br.com.sigma.processo.distribuicao.base.dto;

import java.io.Serializable;

import br.com.sigma.processo.distribuicao.base.persistence.GenericPersistenceClass;

/**
 * Classe respons�vel por definir um contrato de DTO entre o Servi�o e o
 * Business
 *
 * @author Juan Perondi
 *
 * @param <PK>
 *            Tipo da PK
 * @param <T>
 *            Tipo da classe persistente
 */
public abstract class GenericDTO<PK extends Serializable, T extends GenericPersistenceClass<PK>> {

	private PK id;

	private Boolean ativo;

	/**
	 * M�todo respons�vel por retornar o campo id
	 *
	 * @return retorna o campo id
	 */
	public PK getId() {
		return id;
	}

	/**
	 * Seta o valor do parametro id para o field id
	 *
	 * @param id
	 *            valor para ser setado na variavel id
	 */
	public void setId(PK id) {
		this.id = id;
	}

	/**
	 * M�todo respons�vel por retornar o campo ativo
	 *
	 * @return retorna o campo ativo
	 */
	public Boolean getAtivo() {
		return ativo;
	}

	/**
	 * Seta o valor do parametro ativo para o field ativo
	 *
	 * @param ativo
	 *            valor para ser setado na variavel ativo
	 */
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
}
