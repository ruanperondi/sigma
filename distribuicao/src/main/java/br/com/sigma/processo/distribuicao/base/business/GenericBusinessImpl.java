package br.com.sigma.processo.distribuicao.base.business;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.inject.Any;
import javax.inject.Inject;

import br.com.sigma.processo.distribuicao.base.filter.GenericFilter;
import br.com.sigma.processo.distribuicao.base.persistence.GenericPersistenceClass;
import br.com.sigma.processo.distribuicao.base.repository.GenericRepository;
import br.com.sigma.processo.distribuicao.base.validate.BusinessException;
import br.com.sigma.processo.distribuicao.base.validate.GenericEntityValidation;

public abstract class GenericBusinessImpl<PK extends Serializable, T extends GenericPersistenceClass<PK>, F extends GenericFilter> implements GenericBusiness<PK, T, F> {

  @Inject
  @Any
  private GenericRepository<PK, T, F> repository;

  @Inject
  @Any
  private GenericEntityValidation<PK, T> validation;

  @Override
  public List<T> filter(final F filter) throws BusinessException {
    return repository.filter(filter);
  }

  @Override
  public Long count(final F filter) throws BusinessException {
    return repository.count(filter);
  }

  @Override
  public T get(final PK id) throws BusinessException {
    final T t = repository.get(id);

    if (t != null) {
      return t;
    }

    throw new BusinessException("ID " + id + " n�o encontrado!");
  }

  @Override
  public T save(final T t) throws BusinessException {
    validation.validatePersist(t);

    return repository.save(t);
  }

  @Override
  public T update(final T t) throws BusinessException {
    validation.validatePersist(t);

    return repository.edit(t);
  }
}
