package br.com.sigma.processo.distribuicao.features.comarca.def.impl;

import java.util.Set;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import br.com.sigma.processo.distribuicao.base.business.GenericBusinessImpl;
import br.com.sigma.processo.distribuicao.features.comarca.ComarcaBusiness;
import br.com.sigma.processo.distribuicao.features.comarca.ComarcaRepository;
import br.com.sigma.processo.distribuicao.features.comarca.def.Comarca;
import br.com.sigma.processo.distribuicao.features.comarca.def.ComarcaFilter;
import br.com.sigma.processo.distribuicao.features.competencia.def.Competencia;

/**
 * Classe respons�vel por definir o contrato de regra de neg�cio da Comarca
 *
 * @author Juan Perondi
 */
@Default
@Dependent
public class ComarcaBusinessImpl extends GenericBusinessImpl<Integer, Comarca, ComarcaFilter> implements ComarcaBusiness {

  @Inject
  @Any
  private ComarcaRepository repository;

  @Override
  public Set<Competencia> getCompetenciasPorComarca(Integer idComarca) {
    return repository.getCompetenciasPorComarca(idComarca);
  }

}
