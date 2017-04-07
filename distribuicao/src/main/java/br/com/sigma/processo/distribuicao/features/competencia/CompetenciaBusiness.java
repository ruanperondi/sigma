package br.com.sigma.processo.distribuicao.features.competencia;

import br.com.sigma.processo.distribuicao.base.business.GenericBusiness;
import br.com.sigma.processo.distribuicao.features.competencia.def.Competencia;
import br.com.sigma.processo.distribuicao.features.competencia.def.CompetenciaFilter;
import br.com.sigma.processo.distribuicao.features.competencia.def.CompetenciaPK;

/**
 * Classe responsável por definir o contrato de regra de negócio da Competencia
 *
 * @author Juan Perondi
 */
public interface CompetenciaBusiness extends GenericBusiness<CompetenciaPK, Competencia, CompetenciaFilter> {

}
