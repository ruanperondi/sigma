package br.com.sigma.processo.distribuicao.util.query;

import java.lang.reflect.Field;

import javax.persistence.Query;

import org.apache.commons.lang.StringUtils;

import br.com.sigma.processo.distribuicao.base.filter.GenericFilter;
import br.com.sigma.processo.distribuicao.base.validate.BusinessException;
import br.com.sigma.processo.distribuicao.util.text.ReflectionUtils;

/**
 * Classe respons�vel por setar o valor na query
 *
 * @author Juan Perondi
 */
public class RepresentColumnSetter extends RepresentColumnJPQL {

  /**
   * Metodo respons�vel por setar valor na clausula
   * 
   * @param clazz Classe que queremos trabalhar
   * @param typedQuery Query para setarmos
   * @param filter Filter
   * @throws BusinessException
   */
  public static <T extends GenericFilter> void setClauses(Class<T> clazz, Query typedQuery, T filter) throws BusinessException {
    try {
      Field[] fieldsAnnotated = ReflectionUtils.getAnnotatedDeclaredFields(clazz, RepresentColumn.class, true);

      for (int i = 0; i < fieldsAnnotated.length; i++) {
        Field fieldAnnotated = fieldsAnnotated[i];
        fieldAnnotated.setAccessible(true);

        if (!hasValue(fieldAnnotated, filter)) {
          continue;
        }

        setClause(fieldAnnotated, filter, typedQuery);
      }
    } catch (IllegalArgumentException | IllegalAccessException e) {
      throw new BusinessException("erro ao tentar ler as informa��es da entidade de filtro" + clazz);
    }
  }

  /**
   * Metodo respons�vel por setar as informa��es na query
   * 
   * @param fieldAnnotated Campo que queremos etar
   * @param filter Filter para setar
   * @param query Query que ser� setada
   * @throws IllegalArgumentException Exce��o faltando valor
   * @throws IllegalAccessException exce��o ao tentar acessar o valor
   */
  private static <T extends GenericFilter> void setClause(Field fieldAnnotated, T filter, Query query) throws IllegalArgumentException, IllegalAccessException {
    Object value = fieldAnnotated.get(filter);

    if (fieldAnnotated.getGenericType() != String.class) {
      query.setParameter(fieldAnnotated.getName(), value);
    } else {
      query.setParameter(fieldAnnotated.getName(), StringUtils.upperCase("%" + value + "%"));
    }
  }
}
