package br.com.sigma.processo.distribuicao.features.vara;

import java.util.Set;

import br.com.sigma.processo.distribuicao.base.business.GenericBusiness;
import br.com.sigma.processo.distribuicao.features.competencia.def.Competencia;
import br.com.sigma.processo.distribuicao.features.vara.def.Vara;
import br.com.sigma.processo.distribuicao.features.vara.def.VaraFilter;
import br.com.sigma.processo.distribuicao.features.vara.def.VaraPK;

/**
 * Classe responsável por definir o contrato de regra de negócio da Vara
 *
 * @author Juan Perondi
 */
public interface VaraBusiness extends GenericBusiness<VaraPK, Vara, VaraFilter> {

  /**
   * Retorna as competencias de uma Vara
   * 
   * @param idComarca id da Comarca
   * @param nomeVara id da Competencia
   * @return nome da Comarca
   */
  public Set<Competencia> getCompetenciasPorVara(Integer idComarca, String nomeVara);

}
