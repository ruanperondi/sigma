package br.com.sigma.processo.distribuicao.features.unidade_negocio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.validator.constraints.NotBlank;

import br.com.sigma.processo.distribuicao.base.persistence.GenericPersistenceClass;

/**
 * Classe responsável por ter informações a respeito da Unidade de Negócio
 */
@Entity
@Table
public class UnidadeNegocio extends GenericPersistenceClass<Integer> {

	@Id
	@TableGenerator(name = "unidade_negocio_id", table = "sequence_ids", pkColumnName = "name", valueColumnName = "value")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "unidade_negocio_id")
	private Integer id;

	@Column(unique = true, nullable = false, length = 40)
	@NotBlank(message = "{unidade.negocio.nome.obrigatorio}")
	private String nome;

	@Column(unique = true, nullable = false, length = 40)
	@NotBlank(message = "{unidade.negocio.id.externo.obrigatorio}")
	private String idExterno;

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Método responsável por retornar o campo nome
	 *
	 * @return retorna o campo nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Seta o valor do parametro nome para o field nome
	 *
	 * @param nome
	 *            valor para ser setado na variavel nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Método responsável por retornar o campo idExterno
	 *
	 * @return retorna o campo idExterno
	 */
	public String getIdExterno() {
		return idExterno;
	}

	/**
	 * Seta o valor do parametro idExterno para o field idExterno
	 *
	 * @param idExterno
	 *            valor para ser setado na variavel idExterno
	 */
	public void setIdExterno(String idExterno) {
		this.idExterno = idExterno;
	}
}
