package br.com.sigma.processo.distribuicao.features.categoria;

import br.com.sigma.processo.distribuicao.base.repository.GenericRepository;
import br.com.sigma.processo.distribuicao.features.categoria.def.Categoria;
import br.com.sigma.processo.distribuicao.features.categoria.def.CategoriaFilter;

/**
 * Classe responsável por definir o contrato para utilização do Repositório da entidade Categoria
 *
 * @author Juan Perondi
 */
public interface CategoriaRepository extends GenericRepository<Integer, Categoria, CategoriaFilter> {
}
