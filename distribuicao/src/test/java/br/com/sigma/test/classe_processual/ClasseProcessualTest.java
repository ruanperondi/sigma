package br.com.sigma.test.classe_processual;

import javax.enterprise.inject.Any;
import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import br.com.sigma.processo.distribuicao.base.service.FilterResponse;
import br.com.sigma.processo.distribuicao.base.validate.BusinessException;
import br.com.sigma.processo.distribuicao.features.classe_processual.ClasseProcessualService;
import br.com.sigma.processo.distribuicao.features.classe_processual.def.ClasseProcessualDTO;
import br.com.sigma.processo.distribuicao.features.classe_processual.def.ClasseProcessualFilter;

@RunWith(Arquillian.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClasseProcessualTest {

  @Deployment(testable = true)
  public static WebArchive createDeployment() {
    final WebArchive addAsWebInfResource = ShrinkWrap.create(WebArchive.class).addAsDirectory("target/classes");

    addAsWebInfResource.addAsResource("persistence-test.xml", "META-INF/persistence.xml").addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");

    return addAsWebInfResource;
  }

  @Inject
  @Any
  private ClasseProcessualService serviceClasseProcessual;

  @Test
  public void _1naoDevePossuirRegistros() throws BusinessException {
    final FilterResponse filter = serviceClasseProcessual.filter(new ClasseProcessualFilter());

    Assert.assertEquals(0L, filter.getFilter().getCount().longValue());
  }

  @Test
  public void _2TentaCadastrarComErro() throws BusinessException {
    ClasseProcessualDTO dto = new ClasseProcessualDTO();

    dto = serviceClasseProcessual.save(dto);
    final FilterResponse filter = serviceClasseProcessual.filter(new ClasseProcessualFilter());
    Assert.assertEquals(0L, filter.getFilter().getCount().longValue());
  }

  @Test
  public void _3naoPodePermitirInserirDuplicado() throws BusinessException {
    ClasseProcessualDTO dto = new ClasseProcessualDTO();
    dto.setNome("Nova Classe Processual");
    dto = serviceClasseProcessual.save(dto);

    final FilterResponse filter = serviceClasseProcessual.filter(new ClasseProcessualFilter());
    Assert.assertEquals(1L, filter.getFilter().getCount().longValue());
  }

  @Test
  public void _5devePossuirQuasdsaatroRegistros() throws BusinessException {
    Assert.assertEquals(1, 3);
  }

  @Test
  public void _4devePossuirQuatroRegistros() throws BusinessException {
    final FilterResponse filter = serviceClasseProcessual.filter(new ClasseProcessualFilter());

    Assert.assertEquals(3L, filter.getFilter().getCount().longValue());
  }


}
