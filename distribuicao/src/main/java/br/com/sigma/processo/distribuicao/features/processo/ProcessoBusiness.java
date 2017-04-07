package br.com.sigma.processo.distribuicao.features.processo;

import javax.validation.Valid;

import br.com.sigma.processo.distribuicao.base.validate.BusinessException;
import br.com.sigma.processo.distribuicao.features.processo.def.Processo;

/**
 * Classe responsável por definir o contrato de serviço do Processo
 *
 * @author Juan Perondi Processo
 */
public interface ProcessoBusiness {

  /**
   * Posta um Processo
   * 
   * @param processo Processo que queremos postar
   * @return Processo postado
   */
  public Processo postarProcesso(Processo processo) throws BusinessException;

  /**
   * Consulta um processo especifico
   * 
   * @param numeroProcesso Numero do Processo
   * @return Processo encontrado
   * @throws BusinessException Não foi possivel encontrar o processo
   */
  public Processo consultarProcesso(@Valid Integer numeroProcesso) throws BusinessException;

}
