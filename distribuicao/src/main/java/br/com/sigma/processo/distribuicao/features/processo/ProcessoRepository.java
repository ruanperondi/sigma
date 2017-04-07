package br.com.sigma.processo.distribuicao.features.processo;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import br.com.sigma.processo.distribuicao.base.validate.BusinessException;
import br.com.sigma.processo.distribuicao.features.processo.def.Processo;
import br.com.sigma.processo.distribuicao.features.vara.def.Vara;

/**
 * Classe responsável por definir o contrato da validação do processo
 *
 * @author Juan Perondi
 */
public interface ProcessoRepository {

  /**
   * Metod responsável por retornar a Competencia disponível para as capacidades do processl
   * 
   * @param processo Processo que queremos validar
   * @return Competencia encontrada
   * @throws BusinessException
   */
  public Vara getVaraDisponivel(@NotNull Processo processo) throws BusinessException;

  /**
   * Recupera um processo e o devolve
   *
   * @param idProcesso ID do Processo
   * @return Processo
   */
  public Processo getProcesso(Integer idProcesso);

  /**
   * Salva o process
   * 
   * @param processo Salva o processo e devolve sua competencia
   * @return processo com a competencia
   */
  public Processo salvarProcesso(@Valid Processo processo);


}
