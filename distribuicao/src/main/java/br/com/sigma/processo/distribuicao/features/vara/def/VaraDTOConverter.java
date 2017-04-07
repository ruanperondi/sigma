package br.com.sigma.processo.distribuicao.features.vara.def;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import br.com.sigma.processo.distribuicao.base.dto.DTOConverter;
import br.com.sigma.processo.distribuicao.features.comarca.def.Comarca;
import br.com.sigma.processo.distribuicao.features.competencia.def.CompetenciaDTOConverter;
import br.com.sigma.processo.distribuicao.util.dto.DTOUtils;

/**
 * Classe responsável por converter um DTO para uma Vara
 *
 * @author Juan Perondi
 */
@Default
@Dependent
public class VaraDTOConverter implements DTOConverter<VaraPK, Vara, VaraDTO> {

  @Inject
  private CompetenciaDTOConverter converterCompetencia;

  @Override
  public VaraDTO convert(final Vara entity) {
    final VaraDTO dto = new VaraDTO();

    if (entity == null) {
      return dto;
    }

    dto.setNome(entity.getNome());
    dto.setIdComarca(entity.getComarca().getId());
    dto.setNomeComarca(entity.getComarca().getNome());

    dto.setCompetenciaList(DTOUtils.convertToDTO(converterCompetencia, entity.getCompetencias()));

    return dto;
  }

  @Override
  public Vara convert(final VaraDTO dto) {
    final Vara entity = new Vara();
    if (dto == null) {
      return entity;
    }

    entity.setComarca(new Comarca(dto.getIdComarca()));
    entity.setNome(dto.getNome());

    entity.setCompetencias(DTOUtils.convertToEntity(converterCompetencia, dto.getCompetenciaList()));

    return entity;
  }

}
