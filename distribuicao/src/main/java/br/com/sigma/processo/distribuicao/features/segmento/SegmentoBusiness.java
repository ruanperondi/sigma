package br.com.sigma.processo.distribuicao.features.segmento;

import br.com.sigma.processo.distribuicao.base.business.GenericBusiness;
import br.com.sigma.processo.distribuicao.features.segmento.def.Segmento;
import br.com.sigma.processo.distribuicao.features.segmento.def.SegmentoFilter;

/**
 * Classe respons�vel por definir o contrato de regra de neg�cio da Segmento
 *
 * @author Juan Perondi
 */
public interface SegmentoBusiness extends GenericBusiness<Integer, Segmento, SegmentoFilter> {

}
