package br.com.sigma.processo.distribuicao.features.comarca.def;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;

import br.com.sigma.processo.distribuicao.base.dto.DTOConverter;

/**
 * Classe responsável por converter um DTO para uma Comarca
 *
 * @author Juan Perondi
 */
@Default
@Dependent
public class ComarcaDTOConverter implements DTOConverter<Integer, Comarca, ComarcaDTO> {

  @Override
  public ComarcaDTO convert(final Comarca entity) {
    final ComarcaDTO dto = new ComarcaDTO();

    if (entity == null) {
      return dto;
    }

    dto.setId(entity.getId());
    dto.setNome(entity.getNome());

    return dto;
  }

  @Override
  public Comarca convert(final ComarcaDTO dto) {
    final Comarca entity = new Comarca();
    if (dto == null) {
      return entity;
    }

    entity.setId(dto.getId());
    entity.setNome(dto.getNome());

    return entity;
  }

}
