package br.com.sigma.processo.distribuicao.features.competencia.def.impl;

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
import br.com.sigma.processo.distribuicao.features.competencia.CompetenciaService;
import br.com.sigma.processo.distribuicao.features.competencia.def.Competencia;
import br.com.sigma.processo.distribuicao.features.competencia.def.CompetenciaDTO;
import br.com.sigma.processo.distribuicao.features.competencia.def.CompetenciaFilter;
import br.com.sigma.processo.distribuicao.features.competencia.def.CompetenciaPK;

/**
 * Classe responsável por determinar o endpoint de acesso a Competencias
 *
 * @author Juan Perondi
 */
@Path("/competencias")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
@RequestScoped
@Default
public class CompetenciaServiceImpl extends GenericServiceImpl<CompetenciaPK, Competencia, CompetenciaDTO, CompetenciaFilter> implements CompetenciaService {

  private static final long serialVersionUID = 5679482448879849677L;

  @GET
  @Path("/classe/{idClasseProcessual}/competencia/{nomeCompetencia}")
  public CompetenciaDTO get(@PathParam("idClasseProcessual") final Integer idClasseProcessual, @PathParam("nomeCompetencia") String nomeCompetencia) throws BusinessException {
    return super.get(new CompetenciaPK(idClasseProcessual, nomeCompetencia));
  }

}
