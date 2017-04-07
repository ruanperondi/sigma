package br.com.sigma.processo.distribuicao.features.vara;

import java.util.Set;

import br.com.sigma.processo.distribuicao.base.service.GenericService;
import br.com.sigma.processo.distribuicao.features.competencia.def.CompetenciaDTO;
import br.com.sigma.processo.distribuicao.features.vara.def.Vara;
import br.com.sigma.processo.distribuicao.features.vara.def.VaraDTO;
import br.com.sigma.processo.distribuicao.features.vara.def.VaraFilter;
import br.com.sigma.processo.distribuicao.features.vara.def.VaraPK;

/**
 * Classe responsável por determinar endpoints extras da Vara
 *
 * @author Juan Perondi
 */
public interface VaraService extends GenericService<VaraPK, Vara, VaraDTO, VaraFilter> {

  /**
   * Recupera as competencias por Vara
   *
   * @param idComarca ID da Comarca
   * @param nomeVara Nome da Vara para pesquisa
   * @return Competencias presentes na vara
   */
  public Set<CompetenciaDTO> getCompetenciasPorVara(Integer idComarca, String nomeVara);


}
