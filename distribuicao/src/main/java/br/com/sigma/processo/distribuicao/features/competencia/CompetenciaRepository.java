package br.com.sigma.processo.distribuicao.features.competencia;

import br.com.sigma.processo.distribuicao.base.repository.GenericRepository;
import br.com.sigma.processo.distribuicao.features.competencia.def.Competencia;
import br.com.sigma.processo.distribuicao.features.competencia.def.CompetenciaFilter;
import br.com.sigma.processo.distribuicao.features.competencia.def.CompetenciaPK;

/**
 * Classe responsável por definir o contrato para utilização do Repositório da entidade Competencia
 *
 * @author Juan Perondi
 */
public interface CompetenciaRepository extends GenericRepository<CompetenciaPK, Competencia, CompetenciaFilter> {


}
