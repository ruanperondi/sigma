package br.com.sigma.processo.distribuicao.features.classe_processual;

import br.com.sigma.processo.distribuicao.base.repository.GenericRepository;
import br.com.sigma.processo.distribuicao.features.classe_processual.def.ClasseProcessual;
import br.com.sigma.processo.distribuicao.features.classe_processual.def.ClasseProcessualFilter;

/**
 * Classe responsável por definir o contrato para utilização do Repositório da entidade Categoria
 *
 * @author Juan Perondi
 */
public interface ClasseProcessualRepository extends GenericRepository<Integer, ClasseProcessual, ClasseProcessualFilter> {
}
