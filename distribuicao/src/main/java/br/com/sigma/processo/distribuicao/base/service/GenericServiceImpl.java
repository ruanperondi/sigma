package br.com.sigma.processo.distribuicao.base.service;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.inject.Any;
import javax.inject.Inject;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;

import org.apache.commons.lang.StringUtils;

import br.com.sigma.processo.distribuicao.base.business.GenericBusiness;
import br.com.sigma.processo.distribuicao.base.dto.DTOConverter;
import br.com.sigma.processo.distribuicao.base.dto.GenericDTO;
import br.com.sigma.processo.distribuicao.base.filter.GenericFilter;
import br.com.sigma.processo.distribuicao.base.persistence.GenericPersistenceClass;
import br.com.sigma.processo.distribuicao.base.validate.BusinessException;
import br.com.sigma.processo.distribuicao.util.dto.DTOUtils;

/**
 * Classe respons�vel por definir o contrato basico de Servi�o
 *
 * @author Juan Perondi
 *
 * @param <PK> Tipo da Chave Primaria
 * @param <T> Tipo que queremos trabalhar
 * @param <DTO> DTO para convers�o para o tipo
 */
public abstract class GenericServiceImpl<PK extends Serializable, T extends GenericPersistenceClass<PK>, DTO extends GenericDTO<PK, T>, F extends GenericFilter> implements GenericService<PK, T, DTO, F> {

  private static final long         serialVersionUID = 8059750801292195920L;

  @Inject
  @Any
  private DTOConverter<PK, T, DTO>  converter;

  @Inject
  @Any
  private GenericBusiness<PK, T, F> business;

  private final Class<DTO>          dtoClass;

  /**
   * Construtor da Classe
   * 
   * @param dtoClass
   */
  public GenericServiceImpl(final Class<DTO> dtoClass) {
    super();
    this.dtoClass = dtoClass;
  }

  @Override
  @GET
  public FilterResponse filter(@BeanParam final F filter) {
    try {
      if (!StringUtils.isEmpty(filter.getFields())) {
        DTOUtils.validateFiledsWithDTO(dtoClass, filter.getFields());
      }

      final List<T> foundList = business.filter(filter);
      final Long fountQuantity = business.count(filter);
      filter.setCount(fountQuantity);

      final List<DTO> convertToDTO = DTOUtils.convertToDTO(converter, foundList);

      return new FilterResponse(filter, convertToDTO);
    } catch (final BusinessException e) {
      throw new BadRequestException(e.formatError());
    }
  }

  @Override
  @POST
  public DTO save(final DTO dto) {
    try {
      final T t = converter.convert(dto);

      return converter.convert(business.save(t));
    } catch (final BusinessException e) {
      throw new BadRequestException(e.formatError());
    }
  }

  @Override
  @PUT
  public DTO update(final DTO dto) {
    try {
      final T t = converter.convert(dto);

      return converter.convert(business.update(t));
    } catch (final BusinessException e) {
      throw new BadRequestException(e.formatError());
    }
  }

  @Override
  public DTO get(final PK id) {
    try {
      return converter.convert(business.get(id));
    } catch (final BusinessException e) {
      throw new NotFoundException(e.formatError());
    }
  }

}
