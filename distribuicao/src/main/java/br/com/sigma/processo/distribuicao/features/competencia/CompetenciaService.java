package br.com.sigma.processo.distribuicao.features.competencia;

import br.com.sigma.processo.distribuicao.base.service.GenericService;
import br.com.sigma.processo.distribuicao.features.competencia.def.Competencia;
import br.com.sigma.processo.distribuicao.features.competencia.def.CompetenciaDTO;
import br.com.sigma.processo.distribuicao.features.competencia.def.CompetenciaFilter;
import br.com.sigma.processo.distribuicao.features.competencia.def.CompetenciaPK;

/**
 * Classe responsável por determinar endpoints extras da Competencia
 *
 * @author Juan Perondi
 */
public interface CompetenciaService extends GenericService<CompetenciaPK, Competencia, CompetenciaDTO, CompetenciaFilter> {

}
