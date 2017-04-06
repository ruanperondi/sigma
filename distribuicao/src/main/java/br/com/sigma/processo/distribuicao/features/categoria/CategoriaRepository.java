package br.com.sigma.processo.distribuicao.features.categoria;

import br.com.sigma.processo.distribuicao.base.repository.GenericRepository;
import br.com.sigma.processo.distribuicao.features.categoria.def.Categoria;
import br.com.sigma.processo.distribuicao.features.categoria.def.CategoriaFilter;

/**
 * Classe respons�vel por definir o contrato para utiliza��o do Reposit�rio da entidade Categoria
 *
 * @author Juan Perondi
 */
public interface CategoriaRepository extends GenericRepository<Integer, Categoria, CategoriaFilter> {
}
