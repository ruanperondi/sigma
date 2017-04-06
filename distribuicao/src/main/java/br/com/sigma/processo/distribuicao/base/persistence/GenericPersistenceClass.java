package br.com.sigma.processo.distribuicao.base.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.envers.Audited;

/**
 * Classe abstrata responsável pela definição basica das classes do sistema
 * 
 * @author Juan Perondi
 */
@MappedSuperclass
public abstract class GenericPersistenceClass<PK extends Serializable> {

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false, updatable = false)
	@Audited
	private Date dataInclusao;

	@Temporal(TemporalType.TIMESTAMP)
	@Audited
	private Date dataAlteracao;

	@Audited
	private Boolean ativo;

	@Enumerated(EnumType.STRING)
	@NotNull(message = "{origem.informacao.obrigatoria}")
	@Audited
	private OrigemInformacao origemInformacao;

	@Audited
	private Integer idUsuarioCadastrador;

	@Audited
	private Integer idUsuarioAtualizador;

	@PrePersist
	private void prePersist() {
		this.dataInclusao = new Date();

		if (ativo == null) {
			ativo = true;
		}
	}

	@PreUpdate
	private void preUpdate() {
		this.dataAlteracao = new Date();
	}

	/**
	 * Método responsável por retornar o campo
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

	/**
	 * Método responsável por retornar o campo
	 *
	 * @return retorna o campo origemInformacao
	 */
	public OrigemInformacao getOrigemInformacao() {
		return origemInformacao;
	}

	/**
	 * Seta o valor do parametro origemInformacao para o field origemInformacao
	 *
	 * @param origemInformacao
	 *            valor para ser setado na variavel origemInformacao
	 */
	public void setOrigemInformacao(OrigemInformacao origemInformacao) {
		this.origemInformacao = origemInformacao;
	}

	/**
	 * Método responsável por retornar o campo
	 *
	 * @return retorna o campo idUsuarioCadastrador
	 */
	public Integer getIdUsuarioCadastrador() {
		return idUsuarioCadastrador;
	}

	/**
	 * Seta o valor do parametro idUsuarioCadastrador para o field
	 * idUsuarioCadastrador
	 *
	 * @param idUsuarioCadastrador
	 *            valor para ser setado na variavel idUsuarioCadastrador
	 */
	public void setIdUsuarioCadastrador(Integer idUsuarioCadastrador) {
		this.idUsuarioCadastrador = idUsuarioCadastrador;
	}

	/**
	 * Método responsável por retornar o campo
	 *
	 * @return retorna o campo idUsuarioAtualizador
	 */
	public Integer getIdUsuarioAtualizador() {
		return idUsuarioAtualizador;
	}

	/**
	 * Seta o valor do parametro idUsuarioAtualizador para o field
	 * idUsuarioAtualizador
	 *
	 * @param idUsuarioAtualizador
	 *            valor para ser setado na variavel idUsuarioAtualizador
	 */
	public void setIdUsuarioAtualizador(Integer idUsuarioAtualizador) {
		this.idUsuarioAtualizador = idUsuarioAtualizador;
	}

	/**
	 * Método responsável por retornar o campo
	 *
	 * @return retorna o campo dataInclusao
	 */
	public Date getDataInclusao() {
		return dataInclusao;
	}

	/**
	 * Método responsável por retornar o campo
	 *
	 * @return retorna o campo dataAlteracao
	 */
	public Date getDataAlteracao() {
		return dataAlteracao;
	}

	/**
	 * Método responsável por retornar o campo
	 *
	 * @return retorna o campo Id
	 */
	public abstract PK getId();

	/**
	 * Seta o valor do parametro Id para o field Id
	 *
	 * @param Id
	 *            valor para ser setado na variavel Id
	 */
	public abstract void setId(PK id);

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof GenericPersistenceClass)) {
			return false;
		}
		GenericPersistenceClass other = (GenericPersistenceClass) obj;
		if (getId() == null) {
			if (other.getId() != null) {
				return false;
			}
		} else if (!getId().equals(other.getId())) {
			return false;
		}
		return true;
	}
}