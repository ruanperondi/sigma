package br.com.sigma.processo.distribuicao.features.competencia;

import javax.validation.Valid;

import br.com.sigma.processo.distribuicao.base.validate.BusinessException;
import br.com.sigma.processo.distribuicao.base.validate.GenericEntityValidation;
import br.com.sigma.processo.distribuicao.features.competencia.def.Competencia;
import br.com.sigma.processo.distribuicao.features.competencia.def.CompetenciaPK;

/**
 * Classe responsável por definir regras de validação da Competencia
 *
 * @author Juan Perondi
 */
public interface CompetenciaValidacao extends GenericEntityValidation<CompetenciaPK, Competencia> {

  /**
   * Metodo que verifica se a vara está cadastrada
   * 
   * @param vara Competencia para cadastrar
   * @return Competencia Cadastrada
   * @throws BusinessException
   */
  public boolean isCompetenciaIdCadatrada(@Valid Competencia vara) throws BusinessException;

}
