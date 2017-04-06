package br.com.sigma.processo.distribuicao.features.segmento.def.impl;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;

import br.com.sigma.processo.distribuicao.base.business.GenericBusinessImpl;
import br.com.sigma.processo.distribuicao.features.segmento.SegmentoBusiness;
import br.com.sigma.processo.distribuicao.features.segmento.def.Segmento;
import br.com.sigma.processo.distribuicao.features.segmento.def.SegmentoFilter;

/**
 * Classe responsável por definir o contrato de regra de negócio da Segmento
 *
 * @author Juan Perondi
 */
@Default
@Dependent
public class SegmentoBusinessImpl extends GenericBusinessImpl<Integer, Segmento, SegmentoFilter> implements SegmentoBusiness {

}
