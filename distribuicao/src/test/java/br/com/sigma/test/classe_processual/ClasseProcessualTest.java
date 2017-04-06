package br.com.sigma.test.classe_processual;

import javax.enterprise.inject.Any;
import javax.inject.Inject;
import javax.ws.rs.BadRequestException;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.sigma.processo.distribuicao.base.service.FilterResponse;
import br.com.sigma.processo.distribuicao.features.classe_processual.def.ClasseProcessualDTO;
import br.com.sigma.processo.distribuicao.features.classe_processual.def.ClasseProcessualFilter;
import br.com.sigma.processo.distribuicao.features.classe_processual.def.impl.ClasseProcessualServiceImpl;

@RunWith(Arquillian.class)
public class ClasseProcessualTest {

  @Inject
  @Any
  private ClasseProcessualServiceImpl serviceClasseProcessual;

  @Deployment
  public static WebArchive createDeployment() {
    final WebArchive addAsWebInfResource = ShrinkWrap.create(WebArchive.class).addAsDirectory("target/classes");

    addAsWebInfResource.addAsResource("persistence-test.xml", "META-INF/persistence.xml").addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");

    return addAsWebInfResource;
  }

  @Test
  @InSequence(1)
  public void testPostAndGet() {
    final FilterResponse filter = serviceClasseProcessual.filter(new ClasseProcessualFilter());

    Assert.assertEquals(0L, filter.getFilter().getCount().longValue());
  }

  @Test
  @InSequence(3)
  public void cadastrar() {
    ClasseProcessualDTO dto = new ClasseProcessualDTO();
    dto.setNome("Nova Classe Processual");

    dto = serviceClasseProcessual.save(dto);

    dto = new ClasseProcessualDTO();
    dto.setNome("Nova Classe Processual 2");
    dto = serviceClasseProcessual.save(dto);

    dto = new ClasseProcessualDTO();
    dto.setNome("Nova Classe Processual 3");
    dto = serviceClasseProcessual.save(dto);

    dto = new ClasseProcessualDTO();
    dto.setNome("Nova Classe Processual 4");
    dto = serviceClasseProcessual.save(dto);

    Assert.assertNotNull(dto.getId());
  }

  @Test(expected = BadRequestException.class)
  @InSequence(4)
  public void naoPodePermitirInserirDuplicado() {
    ClasseProcessualDTO dto = new ClasseProcessualDTO();
    dto.setNome("Nova Classe Processual");
    dto = serviceClasseProcessual.save(dto);
  }

  @Test
  @InSequence(5)
  public void devePossuirQuatroRegistros() {
    final FilterResponse filter = serviceClasseProcessual.filter(new ClasseProcessualFilter());

    System.out.println(filter.getFilter().getCount());

    Assert.assertEquals(4L, filter.getFilter().getCount().longValue());
  }

}
