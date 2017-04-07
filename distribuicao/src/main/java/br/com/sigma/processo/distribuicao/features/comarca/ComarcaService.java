package br.com.sigma.processo.distribuicao.features.comarca;

import java.util.Set;

import br.com.sigma.processo.distribuicao.base.service.GenericService;
import br.com.sigma.processo.distribuicao.features.comarca.def.Comarca;
import br.com.sigma.processo.distribuicao.features.comarca.def.ComarcaDTO;
import br.com.sigma.processo.distribuicao.features.comarca.def.ComarcaFilter;
import br.com.sigma.processo.distribuicao.features.competencia.def.CompetenciaDTO;

/**
 * Classe responsável por determinar endpoints extras da Comarca
 *
 * @author Juan Perondi
 *
 */
public interface ComarcaService extends GenericService<Integer, Comarca, ComarcaDTO, ComarcaFilter> {


  /**
   * Recupera as competencias por Comarca
   *
   * @param idComarca ID da Comarca
   * @return Competencias presentes na comarca
   */
  public Set<CompetenciaDTO> getCompetenciasPorComarca(Integer idComarca);

}
