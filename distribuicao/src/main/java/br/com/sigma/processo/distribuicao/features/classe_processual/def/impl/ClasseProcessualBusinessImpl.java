package br.com.sigma.processo.distribuicao.features.classe_processual.def.impl;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;

import br.com.sigma.processo.distribuicao.base.business.GenericBusinessImpl;
import br.com.sigma.processo.distribuicao.features.classe_processual.ClasseProcessualBusiness;
import br.com.sigma.processo.distribuicao.features.classe_processual.def.ClasseProcessual;
import br.com.sigma.processo.distribuicao.features.classe_processual.def.ClasseProcessualFilter;

/**
 * Classe respons�vel por definir o contrato de regra de neg�cio da Classe Processual
 *
 * @author Juan Perondi
 */
@Default
@Dependent
public class ClasseProcessualBusinessImpl extends GenericBusinessImpl<Integer, ClasseProcessual, ClasseProcessualFilter> implements ClasseProcessualBusiness {

}
