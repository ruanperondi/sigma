package br.com.sigma.processo.distribuicao.features.processo.def.impl;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.sigma.processo.distribuicao.base.validate.BusinessException;
import br.com.sigma.processo.distribuicao.features.processo.ProcessoBusiness;
import br.com.sigma.processo.distribuicao.features.processo.ProcessoService;
import br.com.sigma.processo.distribuicao.features.processo.def.ProcessoDTO;
import br.com.sigma.processo.distribuicao.features.processo.def.ProcessoDTOConverter;

@Path("/processos")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
@RequestScoped
public class ProcessoServiceImpl implements ProcessoService {

  @Inject
  @Any
  private ProcessoBusiness business;

  @Inject
  @Any
  private ProcessoDTOConverter converter;

  @Override
  @POST
  public ProcessoDTO postarProcesso(ProcessoDTO processo) throws BusinessException {
    return converter.convert(business.postarProcesso(converter.convert(processo)));
  }

  @GET
  @Path("/{numeroProcesso}")
  public ProcessoDTO consultarProcesso(@PathParam("numeroProcesso") Integer numeroProcesso) throws BusinessException {
    return converter.convert(business.consultarProcesso(numeroProcesso));
  }

}
