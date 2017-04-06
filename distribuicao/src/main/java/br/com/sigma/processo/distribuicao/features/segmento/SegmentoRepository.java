package br.com.sigma.processo.distribuicao.features.segmento;

import br.com.sigma.processo.distribuicao.base.repository.GenericRepository;
import br.com.sigma.processo.distribuicao.features.segmento.def.Segmento;
import br.com.sigma.processo.distribuicao.features.segmento.def.SegmentoFilter;

/**
 * Classe responsável por definir o contrato para utilização do Repositório da entidade Segmento
 *
 * @author Juan Perondi
 */
public interface SegmentoRepository extends GenericRepository<Integer, Segmento, SegmentoFilter> {
}
