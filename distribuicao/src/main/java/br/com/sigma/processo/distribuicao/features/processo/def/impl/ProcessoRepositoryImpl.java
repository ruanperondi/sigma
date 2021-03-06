package br.com.sigma.processo.distribuicao.features.processo.def.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang.StringUtils;

import br.com.sigma.processo.distribuicao.base.config.Configuration;
import br.com.sigma.processo.distribuicao.base.validate.BusinessException;
import br.com.sigma.processo.distribuicao.features.classe_processual.def.ClasseProcessual;
import br.com.sigma.processo.distribuicao.features.comarca.def.Comarca;
import br.com.sigma.processo.distribuicao.features.competencia.def.Competencia;
import br.com.sigma.processo.distribuicao.features.competencia.def.CompetenciaPK;
import br.com.sigma.processo.distribuicao.features.processo.ProcessoRepository;
import br.com.sigma.processo.distribuicao.features.processo.def.Processo;
import br.com.sigma.processo.distribuicao.features.vara.def.Vara;
import br.com.sigma.processo.distribuicao.features.vara.def.VaraPK;

/**
 * Classe responsável por consultar as informações de processo via SQL (Mais rápido)
 *
 * @author Juan Perondi
 */
@Dependent
@Default
public class ProcessoRepositoryImpl implements ProcessoRepository {

  @Resource(lookup = Configuration.UNIT_NAME)
  private DataSource dataSource;

  @PersistenceContext(unitName = Configuration.UNIT_NAME)
  private EntityManager em;

  @Override
  @Transactional(value = TxType.REQUIRED)
  public Vara getVaraDisponivel(@NotNull Processo processo) throws BusinessException {
    try {
      if (em.find(Processo.class, processo.getId()) != null) {
        throw new BusinessException("Já existe um processo cadastrado com o numero " + processo.getId());
      }

      if (!existeVaraDisponivel(processo)) {
        throw new BusinessException("Nenhuma Vara encontrada para na competencia e comarca solicitadas");
      }

      return getCompetenciaMenorQuantidadeProcessos(processo.getCompetencia(), processo.getComarca());
    } catch (SQLException e) {
      e.printStackTrace();

      throw new BusinessException("Não foi possivel efetuar as consultas");
    }
  }


  /**
   * Retorna a Vara com menor quantidade de processos
   * 
   * @param competencia Competencia
   * @param comarca comarca
   * @return Vara com a menor competencia
   * @throws SQLException
   */
  @Transactional(value = TxType.REQUIRED)
  private Vara getCompetenciaMenorQuantidadeProcessos(Competencia competencia, Comarca comarca) throws SQLException {
    try (Connection cn = dataSource.getConnection()) {
      final StringBuilder builder = new StringBuilder();


      builder.append(" select ");
      builder.append("     va.id_comarca, va.nome_vara, va.id_classe_processual, va.nome_competencia , (select count(processo.numero_processo_unico) from processo where va.id_comarca = processo.id_comarca AND processo.nome_vara = va.nome_vara)");
      builder.append(" from vara_competencia va");
      builder.append(" 	where upper(va.nome_competencia)=?");
      builder.append(" AND id_comarca = ?");
      builder.append(" order by 5,1 asc");

      final PreparedStatement stmt = cn.prepareStatement(builder.toString());
      stmt.setString(1, StringUtils.upperCase(competencia.getNome()));
      stmt.setInt(2, comarca.getId());

      final ResultSet rs = stmt.executeQuery();
      rs.next();

      final String nomeVara = rs.getString(2);
      final Integer idClasseProcessual = rs.getInt(1);

      competencia.setClasseProcessual(new ClasseProcessual(idClasseProcessual));
      competencia.setId(new CompetenciaPK(idClasseProcessual, competencia.getNome()));

      final Vara v = new Vara();
      v.setComarca(comarca);
      v.setNome(nomeVara);

      v.setId(new VaraPK(comarca.getId(), nomeVara));

      return v;
    }
  }


  /**
   * Verifica se existe uma competencia (seja lá qual for) para a vara solicitada
   * 
   * @param processo
   * @return
   * @throws SQLException
   */
  @Transactional(value = TxType.REQUIRED)
  private boolean existeVaraDisponivel(Processo processo) throws SQLException {
    try (Connection cn = dataSource.getConnection()) {
      StringBuilder builder = new StringBuilder();

      builder.append(" SELECT COUNT(1) FROM VARA_COMPETENCIA ");
      builder.append(" WHERE id_comarca=? ");
      builder.append(" AND upper(nome_competencia)=? ");

      PreparedStatement stmt = cn.prepareStatement(builder.toString());
      stmt.setInt(1, processo.getComarca().getId());
      stmt.setString(2, StringUtils.upperCase(processo.getCompetencia().getNome()));

      ResultSet rs = stmt.executeQuery();
      rs.next();

      if (rs.getInt(1) > 0) {
        return true;
      }

      return false;
    }
  }

  @Override
  public Processo getProcesso(Integer idProcesso) {
    return null;
  }

  @Override
  @Transactional(value = TxType.REQUIRED)
  public Processo salvarProcesso(Processo processo) {
    em.persist(processo);

    return processo;
  }

}
