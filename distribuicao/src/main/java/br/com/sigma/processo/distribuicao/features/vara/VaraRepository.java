package br.com.sigma.processo.distribuicao.features.vara;

import java.util.Set;

import br.com.sigma.processo.distribuicao.base.repository.GenericRepository;
import br.com.sigma.processo.distribuicao.features.competencia.def.Competencia;
import br.com.sigma.processo.distribuicao.features.vara.def.Vara;
import br.com.sigma.processo.distribuicao.features.vara.def.VaraFilter;
import br.com.sigma.processo.distribuicao.features.vara.def.VaraPK;

/**
 * Classe responsável por definir o contrato para utilização do Repositório da entidade Vara
 *
 * @author Juan Perondi
 */
public interface VaraRepository extends GenericRepository<VaraPK, Vara, VaraFilter> {

  /**
   * Retorna as Competencias por Vara
   * 
   * @param idComarca id da Comarca
   * @param nomeVara nome da vara
   * @return Set com as Competencias
   */
  public Set<Competencia> getCompetenciasPorVara(Integer idComarca, String nomeVara);
}
