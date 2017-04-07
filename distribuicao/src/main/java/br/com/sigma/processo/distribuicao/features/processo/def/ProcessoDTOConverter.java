package br.com.sigma.processo.distribuicao.features.processo.def;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;

import br.com.sigma.processo.distribuicao.base.dto.DTOConverter;
import br.com.sigma.processo.distribuicao.features.comarca.def.Comarca;
import br.com.sigma.processo.distribuicao.features.competencia.def.Competencia;

/**
 * Classe responsável por converter um DTO para uma Processo
 *
 * @author Juan Perondi
 */
@Default
@Dependent
public class ProcessoDTOConverter implements DTOConverter<Integer, Processo, ProcessoDTO> {

  @Override
  public ProcessoDTO convert(final Processo entity) {
    final ProcessoDTO dto = new ProcessoDTO();

    if (entity == null) {
      return dto;
    }

    dto.setCompetencia(entity.getCompetencia().getNome());
    dto.setNomeComarca(entity.getComarca().getNome());
    dto.setIdComarca(entity.getComarca().getId());
    dto.setNomeVara(entity.getVara().getNome());

    return dto;
  }

  @Override
  public Processo convert(final ProcessoDTO dto) {
    final Processo entity = new Processo();
    if (dto == null) {
      return entity;
    }

    entity.setNumeroProcessoUnico(dto.getNumeroProcesso());
    entity.setComarca(new Comarca(dto.getIdComarca()));

    Competencia competencia = new Competencia();
    competencia.setNome(dto.getCompetencia());

    entity.setCompetencia(competencia);

    return entity;
  }

}
