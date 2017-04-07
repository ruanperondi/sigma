package br.com.sigma.processo.distribuicao.features.competencia.def.impl;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;

import br.com.sigma.processo.distribuicao.base.business.GenericBusinessImpl;
import br.com.sigma.processo.distribuicao.base.validate.BusinessException;
import br.com.sigma.processo.distribuicao.features.competencia.CompetenciaBusiness;
import br.com.sigma.processo.distribuicao.features.competencia.def.Competencia;
import br.com.sigma.processo.distribuicao.features.competencia.def.CompetenciaFilter;
import br.com.sigma.processo.distribuicao.features.competencia.def.CompetenciaPK;

/**
 * Classe respons�vel por definir o contrato de regra de neg�cio da Competencia
 *
 * @author Juan Perondi
 */
@Default
@Dependent
public class CompetenciaBusinessImpl extends GenericBusinessImpl<CompetenciaPK, Competencia, CompetenciaFilter> implements CompetenciaBusiness {


  @Override
  public Competencia save(Competencia t) throws BusinessException {
    if (t.getClasseProcessual() == null) {
      throw new BusinessException("Classe Processual não informada!");
    }

    CompetenciaPK pk = new CompetenciaPK(t.getClasseProcessual().getId(), t.getNome());
    t.setId(pk);

    return super.save(t);
  }

  @Override
  public Competencia update(Competencia t) throws BusinessException {
    if (t.getClasseProcessual() == null) {
      throw new BusinessException("Classe Processual não informada!");
    }

    CompetenciaPK pk = new CompetenciaPK(t.getClasseProcessual().getId(), t.getNome());
    t.setId(pk);

    return super.save(t);
  }

}
