package br.com.sigma.processo.distribuicao.features.segmento.def;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;

import br.com.sigma.processo.distribuicao.base.dto.DTOConverter;

/**
 * Classe responsável por converter um DTO para uma Segmento
 *
 * @author Juan Perondi
 */
@Default
@Dependent
public class SegmentoDTOConverter implements DTOConverter<Integer, Segmento, SegmentoDTO> {

  @Override
  public SegmentoDTO convert(Segmento entity) {
    SegmentoDTO dto = new SegmentoDTO();

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
  public Segmento convert(SegmentoDTO dto) {
    Segmento entity = new Segmento();
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
