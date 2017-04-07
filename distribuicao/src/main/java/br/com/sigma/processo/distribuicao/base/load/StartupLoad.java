package br.com.sigma.processo.distribuicao.base.load;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

import org.apache.commons.lang.math.RandomUtils;

import br.com.sigma.processo.distribuicao.base.validate.BusinessException;
import br.com.sigma.processo.distribuicao.features.classe_processual.ClasseProcessualBusiness;
import br.com.sigma.processo.distribuicao.features.classe_processual.def.ClasseProcessual;
import br.com.sigma.processo.distribuicao.features.comarca.ComarcaBusiness;
import br.com.sigma.processo.distribuicao.features.comarca.def.Comarca;
import br.com.sigma.processo.distribuicao.features.comarca.def.ComarcaFilter;
import br.com.sigma.processo.distribuicao.features.competencia.CompetenciaBusiness;
import br.com.sigma.processo.distribuicao.features.competencia.def.Competencia;
import br.com.sigma.processo.distribuicao.features.vara.VaraBusiness;
import br.com.sigma.processo.distribuicao.features.vara.def.Vara;

@Singleton
@Startup
public class StartupLoad {

  @Inject
  @Any
  private ComarcaBusiness comarcaBusiness;

  @Inject
  @Any
  private VaraBusiness varaBusiness;


  @Inject
  @Any
  private ClasseProcessualBusiness classeProcessualBusiness;

  @Inject
  @Any
  private CompetenciaBusiness competenciaBusiness;

  /**
   * c
   */
  @PostConstruct
  private void init() {
    try {
      if (comarcaBusiness.count(new ComarcaFilter()) > 0L) {
        return;
      }

      List<ClasseProcessual> classeProcessualList = getClasseProcessualList();
      List<Competencia> competenciaList = getCompetenciaList(classeProcessualList);

      List<Comarca> comarcaList = getComarcaList();
      List<Vara> varaList = getVaraList(comarcaList, competenciaList);
    } catch (BusinessException e) {
      e.printStackTrace();
    }
  }


  private List<Competencia> getCompetenciaList(List<ClasseProcessual> classeProcessualList) throws BusinessException {
    List<String> competenciaList = new ArrayList<>();

    competenciaList.add("Feitos Gerais Cíveis");
    competenciaList.add("Família");
    competenciaList.add("Fazenda");
    competenciaList.add("Infância");
    competenciaList.add("Diretoria");
    competenciaList.add("Falência");
    competenciaList.add("Juizado Especial Cível");
    competenciaList.add("Juizado Especial (Crime)");

    List<Competencia> competenciaListRetorno = new ArrayList<>();

    for (String nomeClasseProcessual : competenciaList) {
      Competencia competencia = new Competencia();
      competencia.setNome(nomeClasseProcessual);
      competencia.setClasseProcessual(classeProcessualList.get(RandomUtils.nextInt(classeProcessualList.size() - 1)));

      competenciaBusiness.save(competencia);
      competenciaListRetorno.add(competencia);
    }

    return competenciaListRetorno;
  }

  private List<ClasseProcessual> getClasseProcessualList() throws BusinessException {
    List<String> classeProcessualList = new ArrayList<String>();
    classeProcessualList.add("Ação de Impugnação de Mandato Eletivo (AIME)");
    classeProcessualList.add("Ação de Investigação Judicial Eleitoral (AIJE)");
    classeProcessualList.add("Ação Rescisória (AR)");
    classeProcessualList.add("Conflito de Competência (CC)");

    List<ClasseProcessual> classeListRetorno = new ArrayList<>();

    for (String nomeClasse : classeProcessualList) {
      ClasseProcessual classe = new ClasseProcessual();
      classe.setNome(nomeClasse);

      classeProcessualBusiness.save(classe);
      classeListRetorno.add(classe);
    }

    return classeListRetorno;
  }

  private List<Vara> getVaraList(List<Comarca> comarcaList, List<Competencia> competenciaList) throws BusinessException {
    List<String> varaList = new ArrayList<>();

    varaList.add("Primeira vara cível da capital");
    varaList.add("Primeira vara especializada da família e sucessões");
    varaList.add("Primeira vara especializada da fazenda pública");
    varaList.add("Primeira vara especializada direito bancário");
    varaList.add("Quarta vara cível");
    varaList.add("Quarta vara especializada da fazenda pública");
    varaList.add("Quarta vara especializada de família e sucessões");
    varaList.add("Quarta vara especializada direito bancário");
    varaList.add("Quinta vara cível");
    varaList.add("Quinta vara especializada da fazenda pública");
    varaList.add("Quinta vara especializada de família e sucessões");
    varaList.add("Segunda vara cível - especializada em direito agrário");
    varaList.add("Segunda vara especializada da fazenda pública");
    varaList.add("Segunda vara especializada de família e sucessões");
    varaList.add("Segunda vara especializada direito bancário");
    varaList.add("Sétima vara cível");
    varaList.add("Setor de arquivo");
    varaList.add("Sexta vara cível da capital");
    varaList.add("Terceira vara cível");
    varaList.add("Terceira vara especializada da fazenda pública");
    varaList.add("Terceira vara especializada de família e sucessões");
    varaList.add("Terceira vara especializada direito bancário");
    varaList.add("Vara especializada de ação civil pública e ação popular");
    varaList.add("Vara especializada de execução fiscal)");

    List<Vara> varaListRetorno = new ArrayList<>();

    for (String nomeVara : varaList) {
      Vara vara = new Vara();
      vara.setNome(nomeVara);
      vara.setComarca(comarcaList.get(RandomUtils.nextInt(comarcaList.size() - 1)));

      int randonQuantityCompetencias = RandomUtils.nextInt(competenciaList.size() - 1);
      Set<Competencia> competenciaSet = new LinkedHashSet<>();
      for (int i = 0; i < randonQuantityCompetencias; i++) {
        competenciaSet.add(competenciaList.get(RandomUtils.nextInt(competenciaList.size() - 1)));
      }

      vara.setCompetencias(competenciaSet);
      varaBusiness.save(vara);
    }

    return varaListRetorno;
  }

  private List<Comarca> getComarcaList() throws BusinessException {
    List<String> asList = Arrays.asList("São Paulo", "Rio de Janeiro", "Brasília", "Salvador", "Fortaleza", "Belo Horizonte", "Manaus", "Curitiba");
    List<Comarca> comarcas = new ArrayList<>();

    for (String string : asList) {
      Comarca comarca = new Comarca();
      comarca.setNome(string);

      comarcas.add(comarca);
      comarcaBusiness.save(comarca);
    }

    return comarcas;
  }
}
