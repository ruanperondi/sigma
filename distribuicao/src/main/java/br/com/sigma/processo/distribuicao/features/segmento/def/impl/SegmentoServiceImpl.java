package br.com.sigma.processo.distribuicao.features.segmento.def.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.sigma.processo.distribuicao.base.service.GenericServiceImpl;
import br.com.sigma.processo.distribuicao.features.segmento.SegmentoService;
import br.com.sigma.processo.distribuicao.features.segmento.def.Segmento;
import br.com.sigma.processo.distribuicao.features.segmento.def.SegmentoDTO;
import br.com.sigma.processo.distribuicao.features.segmento.def.SegmentoFilter;

/**
 * Classe responsável por
 *
 * @author Juan Perondi
 *
 */
@Path("/segmentos")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class SegmentoServiceImpl extends GenericServiceImpl<Integer, Segmento, SegmentoDTO, SegmentoFilter> implements SegmentoService {

  private static final long serialVersionUID = 6831206113494397369L;

  public SegmentoServiceImpl() {
    super(SegmentoDTO.class);
  }

  @Override
  @GET
  @Path("/{id}")
  public SegmentoDTO get(@PathParam("id") Integer id) {
    return super.get(id);
  }

}
