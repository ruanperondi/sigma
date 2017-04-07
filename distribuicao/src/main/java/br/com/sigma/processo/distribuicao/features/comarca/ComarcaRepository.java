package br.com.sigma.processo.distribuicao.features.comarca;

import java.util.Set;

import br.com.sigma.processo.distribuicao.base.repository.GenericRepository;
import br.com.sigma.processo.distribuicao.features.comarca.def.Comarca;
import br.com.sigma.processo.distribuicao.features.comarca.def.ComarcaFilter;
import br.com.sigma.processo.distribuicao.features.competencia.def.Competencia;

/**
 * Classe responsável por definir o contrato para utilização do Repositório da entidade Comarca
 *
 * @author Juan Perondi
 */
public interface ComarcaRepository extends GenericRepository<Integer, Comarca, ComarcaFilter> {
  /**
   * Recupera as competencias por Comarca
   *
   * @param idComarca ID da Comarca
   * @return Competencias presentes na comarca
   */
  public Set<Competencia> getCompetenciasPorComarca(Integer idComarca);

}
