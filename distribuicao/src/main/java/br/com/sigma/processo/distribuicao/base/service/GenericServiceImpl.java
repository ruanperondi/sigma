package br.com.sigma.processo.distribuicao.base.service;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.inject.Any;
import javax.inject.Inject;
import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;

import br.com.sigma.processo.distribuicao.base.business.GenericBusiness;
import br.com.sigma.processo.distribuicao.base.dto.DTOConverter;
import br.com.sigma.processo.distribuicao.base.dto.GenericDTO;
import br.com.sigma.processo.distribuicao.base.filter.GenericFilter;
import br.com.sigma.processo.distribuicao.base.persistence.GenericPersistenceClass;
import br.com.sigma.processo.distribuicao.base.validate.BusinessException;
import br.com.sigma.processo.distribuicao.util.dto.DTOUtils;

/**
 * Classe responsável por definir o contrato basico de serviçoo
 *
 * @author Juan Perondi
 *
 * @param <PK> Tipo da Chave Primaria
 * @param <T> Tipo que queremos trabalhar
 * @param <DTO> DTO para conversão para o tipo
 */
public abstract class GenericServiceImpl<PK extends Serializable, T extends GenericPersistenceClass<PK>, DTO extends GenericDTO<PK, T>, F extends GenericFilter> implements GenericService<PK, T, DTO, F> {

  private static final long serialVersionUID = 8059750801292195920L;

  @Inject
  @Any
  protected DTOConverter<PK, T, DTO> converter;

  @Inject
  @Any
  private GenericBusiness<PK, T, F> business;

  @Override
  @GET
  public FilterResponse filter(@BeanParam final F filter) throws BusinessException {
    final List<T> foundList = business.filter(filter);
    final Long fountQuantity = business.count(filter);
    filter.setCount(fountQuantity);

    final List<DTO> convertToDTO = DTOUtils.convertToDTO(converter, foundList);

    return new FilterResponse(filter, convertToDTO);
  }

  @Override
  @POST
  public DTO save(final DTO dto) throws BusinessException {
    final T t = converter.convert(dto);

    return converter.convert(business.save(t));
  }

  @Override
  @PUT
  public DTO update(final DTO dto) throws BusinessException {
    final T t = converter.convert(dto);

    return converter.convert(business.update(t));
  }

  @Override
  public DTO get(final PK id) throws BusinessException {
    return converter.convert(business.get(id));
  }

}
