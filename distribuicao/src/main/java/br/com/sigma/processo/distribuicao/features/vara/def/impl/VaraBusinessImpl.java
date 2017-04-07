package br.com.sigma.processo.distribuicao.features.vara.def.impl;

import java.util.Set;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import br.com.sigma.processo.distribuicao.base.business.GenericBusinessImpl;
import br.com.sigma.processo.distribuicao.base.validate.BusinessException;
import br.com.sigma.processo.distribuicao.features.competencia.def.Competencia;
import br.com.sigma.processo.distribuicao.features.vara.VaraBusiness;
import br.com.sigma.processo.distribuicao.features.vara.VaraRepository;
import br.com.sigma.processo.distribuicao.features.vara.def.Vara;
import br.com.sigma.processo.distribuicao.features.vara.def.VaraFilter;
import br.com.sigma.processo.distribuicao.features.vara.def.VaraPK;

/**
 * Classe respons�vel por definir o contrato de regra de neg�cio da Vara
 *
 * @author Juan Perondi
 */
@Default
@Dependent
public class VaraBusinessImpl extends GenericBusinessImpl<VaraPK, Vara, VaraFilter> implements VaraBusiness {

  @Inject
  @Any
  private VaraRepository repository;

  @Override
  public Vara save(Vara t) throws BusinessException {
    if (t.getComarca() == null) {
      throw new BusinessException("Classe Processual não informada!");
    }

    VaraPK pk = new VaraPK(t.getComarca().getId(), t.getNome());
    t.setId(pk);

    return super.save(t);
  }

  @Override
  public Vara update(Vara t) throws BusinessException {
    if (t.getComarca() == null) {
      throw new BusinessException("Classe Processual não informada!");
    }

    VaraPK pk = new VaraPK(t.getComarca().getId(), t.getNome());
    t.setId(pk);

    return super.save(t);
  }

  @Override
  public Set<Competencia> getCompetenciasPorVara(Integer idComarca, String idVara) {
    return repository.getCompetenciasPorVara(idComarca, idVara);
  }

}
