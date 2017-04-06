package br.com.sigma.processo.distribuicao.features.classe_processual;

import br.com.sigma.processo.distribuicao.base.service.GenericService;
import br.com.sigma.processo.distribuicao.features.classe_processual.def.ClasseProcessual;
import br.com.sigma.processo.distribuicao.features.classe_processual.def.ClasseProcessualDTO;
import br.com.sigma.processo.distribuicao.features.classe_processual.def.ClasseProcessualFilter;

/**
 * Classe responsável por determinar endpoints extras da Classe processual
 *
 * @author Juan Perondi
 *
 */
public interface ClasseProcessualService extends GenericService<Integer, ClasseProcessual, ClasseProcessualDTO, ClasseProcessualFilter> {

}
