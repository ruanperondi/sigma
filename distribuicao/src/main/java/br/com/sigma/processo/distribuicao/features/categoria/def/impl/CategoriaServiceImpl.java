package br.com.sigma.processo.distribuicao.features.categoria.def.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.sigma.processo.distribuicao.base.service.GenericServiceImpl;
import br.com.sigma.processo.distribuicao.features.categoria.CategoriaService;
import br.com.sigma.processo.distribuicao.features.categoria.def.Categoria;
import br.com.sigma.processo.distribuicao.features.categoria.def.CategoriaDTO;
import br.com.sigma.processo.distribuicao.features.categoria.def.CategoriaFilter;

/**
 * Classe responsável por
 *
 * @author Juan Perondi
 *
 */
@Path("/categorias")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class CategoriaServiceImpl extends GenericServiceImpl<Integer, Categoria, CategoriaDTO, CategoriaFilter> implements CategoriaService {

  private static final long serialVersionUID = 6831206113494397369L;

  public CategoriaServiceImpl() {
    super(CategoriaDTO.class);
  }

  @Override
  @GET
  @Path("/{id}")
  public CategoriaDTO get(@PathParam("id") Integer id) {
    return super.get(id);
  }

}
