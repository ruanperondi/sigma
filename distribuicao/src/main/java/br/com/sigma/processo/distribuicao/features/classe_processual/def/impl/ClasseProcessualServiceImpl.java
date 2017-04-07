package br.com.sigma.processo.distribuicao.features.classe_processual.def.impl;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.sigma.processo.distribuicao.base.service.GenericServiceImpl;
import br.com.sigma.processo.distribuicao.base.validate.BusinessException;
import br.com.sigma.processo.distribuicao.features.classe_processual.ClasseProcessualService;
import br.com.sigma.processo.distribuicao.features.classe_processual.def.ClasseProcessual;
import br.com.sigma.processo.distribuicao.features.classe_processual.def.ClasseProcessualDTO;
import br.com.sigma.processo.distribuicao.features.classe_processual.def.ClasseProcessualFilter;

/**
 * Classe responsável por determinar o endpoint de acesso a Classe Processual
 *
 * @author Juan Perondi
 *
 */
@Path("/classes")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
@RequestScoped
@Default
public class ClasseProcessualServiceImpl extends GenericServiceImpl<Integer, ClasseProcessual, ClasseProcessualDTO, ClasseProcessualFilter> implements ClasseProcessualService {

  private static final long serialVersionUID = 6831206113494397369L;

  @Override
  @GET
  @Path("/{id}")
  public ClasseProcessualDTO get(@PathParam("id") final Integer id) throws BusinessException {
    return super.get(id);
  }

}
