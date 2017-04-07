package br.com.sigma.processo.distribuicao.features.processo.def.impl;

import javax.enterprise.inject.Any;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;
import javax.validation.Valid;

import br.com.sigma.processo.distribuicao.base.config.Configuration;
import br.com.sigma.processo.distribuicao.base.validate.BusinessException;
import br.com.sigma.processo.distribuicao.features.processo.ProcessoBusiness;
import br.com.sigma.processo.distribuicao.features.processo.ProcessoRepository;
import br.com.sigma.processo.distribuicao.features.processo.def.Processo;
import br.com.sigma.processo.distribuicao.features.vara.def.Vara;

/**
 * Classe responsável por realizar as regras de negócio do Processo
 *
 * @author Juan Perondi
 */
public class ProcessoBusinessImpl implements ProcessoBusiness {

  @Inject
  @Any
  private ProcessoRepository repository;

  @PersistenceContext(unitName = Configuration.UNIT_NAME)
  private EntityManager em;

  @Override
  @Transactional(value = TxType.REQUIRED)
  public Processo postarProcesso(Processo processo) throws BusinessException {

    if (processo.getComarca() == null || processo.getComarca().getId() == null) {
      throw new BusinessException("A comarca é obrigatória!");
    }

    if (processo.getCompetencia() == null || processo.getCompetencia().getNome() == null) {
      throw new BusinessException("A Competencia é obrigatória!");
    }

    Vara v = repository.getVaraDisponivel(processo);
    processo.setVara(v);

    return repository.salvarProcesso(processo);
  }

  @Override
  public Processo consultarProcesso(@Valid Integer numeroProcesso) throws BusinessException {
    return em.find(Processo.class, numeroProcesso);
  }

}
