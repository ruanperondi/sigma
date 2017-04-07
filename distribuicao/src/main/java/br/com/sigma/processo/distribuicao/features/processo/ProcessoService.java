package br.com.sigma.processo.distribuicao.features.processo;

import br.com.sigma.processo.distribuicao.base.validate.BusinessException;
import br.com.sigma.processo.distribuicao.features.processo.def.ProcessoDTO;

/**
 * Classe responsável por definir o contrato de serviço do Processo
 *
 * @author Juan Perondi Processo
 */
public interface ProcessoService {

  /**
   * Posta um Processo
   * 
   * @param processo Processo que queremos postar
   * @return Processo postado
   */
  public ProcessoDTO postarProcesso(ProcessoDTO processo) throws BusinessException;

  /**
   * Consulta um processo especifico
   * 
   * @param numeroProcesso Numero do Processo
   * @return Processo encontrado
   * @throws BusinessException Não foi possivel encontrar o processo
   */
  public ProcessoDTO consultarProcesso(Integer numeroProcesso) throws BusinessException;

}
