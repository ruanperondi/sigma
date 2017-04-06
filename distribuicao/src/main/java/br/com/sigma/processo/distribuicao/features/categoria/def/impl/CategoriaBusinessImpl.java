package br.com.sigma.processo.distribuicao.features.categoria.def.impl;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;

import br.com.sigma.processo.distribuicao.base.business.GenericBusinessImpl;
import br.com.sigma.processo.distribuicao.features.categoria.CategoriaBusiness;
import br.com.sigma.processo.distribuicao.features.categoria.def.Categoria;
import br.com.sigma.processo.distribuicao.features.categoria.def.CategoriaFilter;

/**
 * Classe responsável por definir o contrato de regra de negócio da Categoria
 *
 * @author Juan Perondi
 */
@Default
@Dependent
public class CategoriaBusinessImpl extends GenericBusinessImpl<Integer, Categoria, CategoriaFilter> implements CategoriaBusiness {

}
