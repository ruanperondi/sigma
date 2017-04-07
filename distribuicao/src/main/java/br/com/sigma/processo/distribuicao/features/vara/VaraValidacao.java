package br.com.sigma.processo.distribuicao.features.vara;

import javax.validation.Valid;

import br.com.sigma.processo.distribuicao.base.validate.BusinessException;
import br.com.sigma.processo.distribuicao.base.validate.GenericEntityValidation;
import br.com.sigma.processo.distribuicao.features.vara.def.Vara;
import br.com.sigma.processo.distribuicao.features.vara.def.VaraPK;

/**
 * Classe responsável por definir regras de validação da Vara
 *
 * @author Juan Perondi
 */
public interface VaraValidacao extends GenericEntityValidation<VaraPK, Vara> {

  /**
   * Metodo que verifica se a vara está cadastrada
   * 
   * @param vara Vara para cadastrar
   * @return Vara Cadastrada
   * @throws BusinessException
   */
  public boolean isVaraIdCadatrada(@Valid Vara vara) throws BusinessException;

}
