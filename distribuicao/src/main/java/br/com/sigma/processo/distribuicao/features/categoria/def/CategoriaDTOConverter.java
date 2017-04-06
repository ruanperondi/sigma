package br.com.sigma.processo.distribuicao.features.categoria.def;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;

import br.com.sigma.processo.distribuicao.base.dto.DTOConverter;

/**
 * Classe responsável por converter um DTO para uma Categoria
 *
 * @author Juan Perondi
 */
@Default
@Dependent
public class CategoriaDTOConverter implements DTOConverter<Integer, Categoria, CategoriaDTO> {

  @Override
  public CategoriaDTO convert(Categoria entity) {
    CategoriaDTO dto = new CategoriaDTO();

    if (entity == null) {
      return dto;
    }

    dto.setAtivo(entity.getAtivo());
    dto.setId(entity.getId());
    dto.setIdExterno(entity.getIdExterno());
    dto.setNome(entity.getNome());

    return dto;
  }

  @Override
  public Categoria convert(CategoriaDTO dto) {
    Categoria entity = new Categoria();
    if (dto == null) {
      return entity;
    }

    entity.setAtivo(dto.getAtivo());
    entity.setId(dto.getId());
    entity.setIdExterno(dto.getIdExterno());
    entity.setNome(dto.getNome());

    return entity;
  }

}
