package br.com.sigma.processo.distribuicao.base.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;
import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Session;

import br.com.sigma.processo.distribuicao.base.config.Configuration;
import br.com.sigma.processo.distribuicao.base.filter.GenericFilter;
import br.com.sigma.processo.distribuicao.base.persistence.GenericPersistenceClass;
import br.com.sigma.processo.distribuicao.base.validate.BusinessException;
import br.com.sigma.processo.distribuicao.util.query.RepresentColumnJPQL;
import br.com.sigma.processo.distribuicao.util.query.RepresentColumnSetter;
import br.com.sigma.processo.distribuicao.utils.jpa.JPAUtils;

/**
 * Classe responsável por utilizar o contrato do repositório pelo EntityManager
 *
 * @author Juan Perondi
 */
public abstract class EntityManagerRepository<PK extends Serializable, T extends GenericPersistenceClass<PK>, F extends GenericFilter> implements GenericRepository<PK, T, F> {

  @PersistenceContext(unitName = Configuration.UNIT_NAME)
  private EntityManager entityManager;

  private Class<T> clazz;

  private Class<F> filterClass;

  private String columns;

  /**
   * Construtor da Classe
   * 
   * @param clazz Classe para utilizarmos como base
   */
  public EntityManagerRepository(Class<T> clazz, Class<F> filterClass) {
    super();
    this.clazz = clazz;
    this.filterClass = filterClass;
  }

  /**
   * Metodo responsável por realizar uma pesquisa e retornar a quatidade de registros encontrados
   * 
   * @param filter Filtro que iremos utilizar
   * @return Quantidade de registros encontrados
   * @throws BusinessException
   */
  public Long count(F filter) throws BusinessException {
    TypedQuery<Long> typedQuery = entityManager.createQuery(generateJPQLCount(filter), Long.class);

    setParameters(typedQuery, filter);

    return typedQuery.getSingleResult();
  }

  @SuppressWarnings("unchecked")
  @Override
  @Transactional(value = TxType.REQUIRED)
  public List<T> filter(F filter) throws BusinessException {
    Query typedQuery = entityManager.createQuery(generateJPQLFilter(filter));

    setParameters(typedQuery, filter);

    typedQuery.setMaxResults(filter.getLimit());
    typedQuery.setFirstResult(filter.getOffSet());

    return JPAUtils.convertToClass(clazz, typedQuery.getResultList(), this.columns);
  }

  @Override
  @Transactional(value = TxType.REQUIRED)
  public T get(PK id) {
    return entityManager.find(clazz, id);
  }

  @Override
  @Transactional(value = TxType.REQUIRED)
  public T save(@Valid T entity) {
    entityManager.persist(entity);

    return entity;
  }

  @Override
  @Transactional(value = TxType.REQUIRED)
  public T edit(T entity) {
    Session session = entityManager.unwrap(Session.class);
    session.update(entity);

    return entity;
  }

  /**
   * Metodo responsável por gerar um JPQL para utilizarmos no FIltro
   * 
   * @param filter Filtro que queremos utilizar
   * @return String com a JPQL gerada
   * @throws BusinessException
   */
  public String generateJPQLFilter(F filter) throws BusinessException {
    return buildJPQL(filter, getDefaultJPQL(), false);
  }

  /**
   * Constroi o JPQL da Categoria. <br>
   * Se os campo fields não for passado, então será considerado o campo whenEmpty
   * 
   * @param fields Campos
   * @param list Campo utilizado quando construirmos o JPQL
   * @throws BusinessException
   */
  private String buildJPQL(F filter, List<String> list, boolean countMode) throws BusinessException {
    StringBuilder builder = new StringBuilder(" SELECT ");

    this.columns = getFields(filter, list, countMode);

    builder.append(columns);
    builder.append(" FROM " + this.clazz.getSimpleName() + " ");

    String clause = RepresentColumnJPQL.jpqlClauseBuild(filterClass, filter);

    if (!StringUtils.isEmpty(clause)) {
      builder.append(" WHERE ");
      builder.append(clause);
    }

    return builder.toString();
  }

  /**
   * Retorna o JPQL default para consulta
   * 
   * @return JPQL padrão para a consulta
   */
  protected abstract List<String> getDefaultJPQL();

  /**
   * Metodo responsável por gerar um JPQL para utilizarmos no FIltro
   * 
   * @param filter Filtro que queremos utilizar
   * @return String com a JPQL gerada
   * @throws BusinessException
   */
  protected String generateJPQLCount(F filter) throws BusinessException {
    return this.buildJPQL(filter, null, true);
  }

  /**
   * Metodo responsável por setar os parametros na Query
   * 
   * @param typedQuery Query Tipada
   * @param filter Filtro para preenchermos a Query
   * @throws BusinessException
   */
  protected void setParameters(Query typedQuery, F filter) throws BusinessException {
    RepresentColumnSetter.setClauses(filterClass, typedQuery, filter);
  }

  /**
   * Metodo que retorna os campos. <br>
   * se for countMode irá retornar count(1), se os fields da Categoria forem preenchidos, entçao
   * este será passado por parâmetro, senão serão aqueles definodos na variavel whenEmpty
   * 
   * @param filter Filter para utilizarmos
   * @param list Quando for vazio
   * @param countMode Modo de Contagem
   * @return Campos em forma de String
   */
  protected String getFields(F filter, List<String> list, boolean countMode) {
    if (countMode) {
      return "count(1)";
    }

    if (!StringUtils.isEmpty(filter.getFields())) {
      return filter.getFields();
    }

    return StringUtils.join(list.toArray(), ",");
  }

}
