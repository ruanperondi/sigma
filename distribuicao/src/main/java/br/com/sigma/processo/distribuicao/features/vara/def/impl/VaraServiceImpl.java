package br.com.sigma.processo.distribuicao.features.vara.def.impl;

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

import br.com.sigma.processo.distribuicao.base.service.GenericServiceImpl;
import br.com.sigma.processo.distribuicao.base.validate.BusinessException;
import br.com.sigma.processo.distribuicao.features.competencia.def.CompetenciaDTO;
import br.com.sigma.processo.distribuicao.features.competencia.def.CompetenciaDTOConverter;
import br.com.sigma.processo.distribuicao.features.vara.VaraBusiness;
import br.com.sigma.processo.distribuicao.features.vara.VaraService;
import br.com.sigma.processo.distribuicao.features.vara.def.Vara;
import br.com.sigma.processo.distribuicao.features.vara.def.VaraDTO;
import br.com.sigma.processo.distribuicao.features.vara.def.VaraFilter;
import br.com.sigma.processo.distribuicao.features.vara.def.VaraPK;
import br.com.sigma.processo.distribuicao.util.dto.DTOUtils;

/**
 * Classe responsável por determinar o endpoint de acesso a Varas
 *
 * @author Juan Perondi
 *
 */
@Path("/varas")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
@RequestScoped
@Default
public class VaraServiceImpl extends GenericServiceImpl<VaraPK, Vara, VaraDTO, VaraFilter> implements VaraService {

  private static final long serialVersionUID = 5679482448879849677L;

  @Inject
  @Any
  private VaraBusiness varaBusiness;

  @Inject
  @Any
  private CompetenciaDTOConverter converter;


  @GET
  @Path("/comarca/{idComarca}/vara/{nomeVara}")
  public VaraDTO get(@PathParam("idComarca") final Integer idComarca, @PathParam("nomeVara") String nomeVara) throws BusinessException {
    return super.get(new VaraPK(idComarca, nomeVara));
  }

  @Override
  @GET
  @Path("/{id}/vara/{nomeVara}/competencias")
  public Set<CompetenciaDTO> getCompetenciasPorVara(@PathParam("id") Integer idComarca, @PathParam("nomeVara") String nomeVara) {
    return DTOUtils.convertToDTO(converter, varaBusiness.getCompetenciasPorVara(idComarca, nomeVara));
  }

}
