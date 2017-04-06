package br.com.sigma.processo.distribuicao.features.categoria;

import br.com.sigma.processo.distribuicao.base.business.GenericBusiness;
import br.com.sigma.processo.distribuicao.features.categoria.def.Categoria;
import br.com.sigma.processo.distribuicao.features.categoria.def.CategoriaFilter;

/**
 * Classe responsável por definir o contrato de regra de negócio da Categoria
 *
 * @author Juan Perondi
 */
public interface CategoriaBusiness extends GenericBusiness<Integer, Categoria, CategoriaFilter> {

}
