package br.com.sigma.processo.distribuicao.features.categoria;

import br.com.sigma.processo.distribuicao.base.business.GenericBusiness;
import br.com.sigma.processo.distribuicao.features.categoria.def.Categoria;
import br.com.sigma.processo.distribuicao.features.categoria.def.CategoriaFilter;

/**
 * Classe respons�vel por definir o contrato de regra de neg�cio da Categoria
 *
 * @author Juan Perondi
 */
public interface CategoriaBusiness extends GenericBusiness<Integer, Categoria, CategoriaFilter> {

}
