package br.com.sigma.processo.distribuicao.features.segmento;

import br.com.sigma.processo.distribuicao.base.repository.GenericRepository;
import br.com.sigma.processo.distribuicao.features.segmento.def.Segmento;
import br.com.sigma.processo.distribuicao.features.segmento.def.SegmentoFilter;

/**
 * Classe respons�vel por definir o contrato para utiliza��o do Reposit�rio da entidade Segmento
 *
 * @author Juan Perondi
 */
public interface SegmentoRepository extends GenericRepository<Integer, Segmento, SegmentoFilter> {
}
