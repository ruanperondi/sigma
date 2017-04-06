package br.com.sigma.processo.distribuicao.base.business;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.inject.Any;
import javax.inject.Inject;

import br.com.sigma.processo.distribuicao.base.filter.GenericFilter;
import br.com.sigma.processo.distribuicao.base.persistence.GenericPersistenceClass;
import br.com.sigma.processo.distribuicao.base.persistence.OrigemInformacao;
import br.com.sigma.processo.distribuicao.base.repository.GenericRepository;
import br.com.sigma.processo.distribuicao.base.validate.BusinessException;
import br.com.sigma.processo.distribuicao.base.validate.GenericEntityValidation;

public class GenericBusinessImpl<PK extends Serializable, T extends GenericPersistenceClass<PK>, F extends GenericFilter> implements GenericBusiness<PK, T, F> {

  @Inject
  @Any
  private GenericRepository<PK, T, F> repository;

  @Inject
  @Any
  private GenericEntityValidation<PK, T> validation;

  @Override
  public List<T> filter(F filter) throws BusinessException {
    return repository.filter(filter);
  }

  @Override
  public Long count(F filter) throws BusinessException {
    return repository.count(filter);
  }

  @Override
  public T get(PK id) throws BusinessException {
    T t = repository.get(id);

    if (t != null) {
      return t;
    }

    throw new BusinessException("nao.encontrado");
  }

  @Override
  public T save(T t) throws BusinessException {
    t.setOrigemInformacao(OrigemInformacao.WEB);
    validation.validatePersist(t);

    return repository.save(t);
  }

  @Override
  public T update(T t) throws BusinessException {
    validation.validatePersist(t);

    return repository.edit(t);
  }

  @Override
  public List<T> updateStatus(List<T> list) throws BusinessException {
    for (T t : list) {
      validation.validateActiveStatus(t);
    }

    for (T t : list) {
      T entityToEdit = this.get(t.getId());
      entityToEdit.setAtivo(t.getAtivo());

      repository.edit(entityToEdit);
    }

    return list;
  }

}
