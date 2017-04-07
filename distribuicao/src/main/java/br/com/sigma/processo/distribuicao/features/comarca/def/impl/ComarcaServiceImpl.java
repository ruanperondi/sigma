package br.com.sigma.processo.distribuicao.features.comarca.def.impl;

import java.util.Set;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.sigma.processo.distribuicao.base.dto.DTOConverter;
import br.com.sigma.processo.distribuicao.base.service.GenericServiceImpl;
import br.com.sigma.processo.distribuicao.base.validate.BusinessException;
import br.com.sigma.processo.distribuicao.features.comarca.ComarcaBusiness;
import br.com.sigma.processo.distribuicao.features.comarca.ComarcaService;
import br.com.sigma.processo.distribuicao.features.comarca.def.Comarca;
import br.com.sigma.processo.distribuicao.features.comarca.def.ComarcaDTO;
import br.com.sigma.processo.distribuicao.features.comarca.def.ComarcaFilter;
import br.com.sigma.processo.distribuicao.features.competencia.def.Competencia;
import br.com.sigma.processo.distribuicao.features.competencia.def.CompetenciaDTO;
import br.com.sigma.processo.distribuicao.features.competencia.def.CompetenciaPK;
import br.com.sigma.processo.distribuicao.util.dto.DTOUtils;

/**
 * Classe responsável por determinar o endpoint de acesso a Comarcas
 *
 * @author Juan Perondi
 *
 */
@Path("/comarcas")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
@RequestScoped
@Default
public class ComarcaServiceImpl extends GenericServiceImpl<Integer, Comarca, ComarcaDTO, ComarcaFilter> implements ComarcaService {

  private static final long serialVersionUID = 5679482448879849677L;

  @Inject
  @Any
  private ComarcaBusiness comarcaBusiness;

  @Inject
  @Any
  protected DTOConverter<CompetenciaPK, Competencia, CompetenciaDTO> converter;

  @Override
  @GET
  @Path("/{id}")
  public ComarcaDTO get(@PathParam("id") final Integer id) throws BusinessException {
    return super.get(id);
  }

  @Override
  @GET
  @Path("/{id}/competencias")
  public Set<CompetenciaDTO> getCompetenciasPorComarca(@PathParam("id") Integer idComarca) {
    return DTOUtils.convertToDTO(converter, comarcaBusiness.getCompetenciasPorComarca(idComarca));
  }

}
