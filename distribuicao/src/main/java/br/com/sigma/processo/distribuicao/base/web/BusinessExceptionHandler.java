package br.com.sigma.processo.distribuicao.base.web;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import br.com.sigma.processo.distribuicao.base.validate.BusinessException;
import br.com.sigma.processo.distribuicao.util.text.JSONUtils;

@Provider
public class BusinessExceptionHandler implements ExceptionMapper<BusinessException> {

  @Override
  public javax.ws.rs.core.Response toResponse(BusinessException exception) {
    return Response.status(Status.BAD_REQUEST).entity(JSONUtils.toJSON(exception.getMessage())).build();
  }

}
