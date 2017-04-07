package br.com.sigma.processo.distribuicao.features.competencia.def;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;

import br.com.sigma.processo.distribuicao.base.dto.DTOConverter;
import br.com.sigma.processo.distribuicao.features.classe_processual.def.ClasseProcessual;

/**
 * Classe responsável por converter um DTO para uma Competencia
 *
 * @author Juan Perondi
 */
@Default
@Dependent
public class CompetenciaDTOConverter implements DTOConverter<CompetenciaPK, Competencia, CompetenciaDTO> {

  @Override
  public CompetenciaDTO convert(final Competencia entity) {
    final CompetenciaDTO dto = new CompetenciaDTO();

    if (entity == null) {
      return dto;
    }

    dto.setNome(entity.getNome());
    dto.setIdClasseProcessual(entity.getClasseProcessual().getId());
    dto.setNomeClasseProcessual(entity.getClasseProcessual().getNome());

    return dto;
  }

  @Override
  public Competencia convert(final CompetenciaDTO dto) {
    final Competencia entity = new Competencia();
    if (dto == null) {
      return entity;
    }

    entity.setClasseProcessual(new ClasseProcessual(dto.getIdClasseProcessual()));
    entity.setNome(dto.getNome());

    return entity;
  }

}
