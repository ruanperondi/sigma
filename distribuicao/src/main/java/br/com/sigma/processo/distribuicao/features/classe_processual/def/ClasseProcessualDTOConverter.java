package br.com.sigma.processo.distribuicao.features.classe_processual.def;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;

import br.com.sigma.processo.distribuicao.base.dto.DTOConverter;

/**
 * Classe respons�vel por converter um DTO para uma Classe Processual
 *
 * @author Juan Perondi
 */
@Default
@Dependent
public class ClasseProcessualDTOConverter implements DTOConverter<Integer, ClasseProcessual, ClasseProcessualDTO> {

  @Override
  public ClasseProcessualDTO convert(final ClasseProcessual entity) {
    final ClasseProcessualDTO dto = new ClasseProcessualDTO();

    if (entity == null) {
      return dto;
    }

    dto.setId(entity.getId());
    dto.setNome(entity.getNome());

    return dto;
  }

  @Override
  public ClasseProcessual convert(final ClasseProcessualDTO dto) {
    final ClasseProcessual entity = new ClasseProcessual();
    if (dto == null) {
      return entity;
    }

    entity.setId(dto.getId());
    entity.setNome(dto.getNome());

    return entity;
  }

}
