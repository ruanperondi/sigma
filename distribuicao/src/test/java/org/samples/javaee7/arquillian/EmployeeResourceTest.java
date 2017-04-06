package org.samples.javaee7.arquillian;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.sigma.processo.distribuicao.base.business.GenericBusiness;
import br.com.sigma.processo.distribuicao.base.config.Configuration;
import br.com.sigma.processo.distribuicao.base.dto.DTOConverter;
import br.com.sigma.processo.distribuicao.base.filter.GenericFilter;
import br.com.sigma.processo.distribuicao.base.persistence.GenericPersistenceClass;
import br.com.sigma.processo.distribuicao.base.repository.EntityManagerRepository;
import br.com.sigma.processo.distribuicao.base.service.FilterResponse;
import br.com.sigma.processo.distribuicao.base.validate.BusinessException;
import br.com.sigma.processo.distribuicao.base.web.ApplicationActivator;
import br.com.sigma.processo.distribuicao.features.categoria.CategoriaValidacao;

@RunWith(Arquillian.class)
public class EmployeeResourceTest {

  private WebTarget target;


  @Deployment(testable = false)
  public static WebArchive createDeployment() {
    WebArchive addAsWebInfResource = ShrinkWrap.create(WebArchive.class).addPackage(CategoriaValidacao.class.getPackage());

    addAsWebInfResource.addPackage(GenericBusiness.class.getPackage());
    addAsWebInfResource.addClass(Configuration.class);
    addAsWebInfResource.addPackage(DTOConverter.class.getPackage());
    addAsWebInfResource.addPackage(GenericFilter.class.getPackage());
    addAsWebInfResource.addPackage(GenericPersistenceClass.class.getPackage());
    addAsWebInfResource.addPackage(EntityManagerRepository.class.getPackage());
    addAsWebInfResource.addPackage(FilterResponse.class.getPackage());
    addAsWebInfResource.addPackage(BusinessException.class.getPackage());
    addAsWebInfResource.addPackage(ApplicationActivator.class.getPackage());

    addAsWebInfResource.addAsResource("persistence-test.xml", "META-INF/persistence.xml").addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");

    return addAsWebInfResource;
  }

  @ArquillianResource
  private URL base;

  @Before
  public void setUp() throws MalformedURLException {
    Client client = ClientBuilder.newClient();
    target = client.target(URI.create(new URL(base, "registry/employee").toExternalForm()));
  }

  @Test
  @InSequence(1)
  public void testPostAndGet() {}
  // MultivaluedHashMap<String, String> map = new MultivaluedHashMap<>();
  // map.add("name", "Penny");
  // map.add("age", "1");
  // target.request().post(Entity.form(map));
  //
  // map.clear();
  // map.add("name", "Leonard");
  // map.add("age", "2");
  // target.request().post(Entity.form(map));
  //
  // map.clear();
  // map.add("name", "Sheldon");
  // map.add("age", "3");
  // target.request().post(Entity.form(map));
  //
  // Employee[] list = target.request().get(Employee[].class);
  // assertEquals(3, list.length);
  //
  // assertEquals("Penny", list[0].getName());
  // assertEquals(1, list[0].getAge());
  //
  // assertEquals("Leonard", list[1].getName());
  // assertEquals(2, list[1].getAge());
  //
  // assertEquals("Sheldon", list[2].getName());
  // assertEquals(3, list[2].getAge());
  // }
  //
  // /**
  // * Test of getPerson method, of class MyResource.
  // */
  // @Test
  // @InSequence(2)
  // public void testGetSingle() {
  // Employee p = target.path("{id}").resolveTemplate("id",
  // "1").request(MediaType.APPLICATION_XML).get(Employee.class);
  // assertEquals("Leonard", p.getName());
  // assertEquals(2, p.getAge());
  // }
  //
  // /**
  // * Test of putToList method, of class MyResource.
  // */
  // @Test
  // @InSequence(3)
  // public void testPut() {
  // MultivaluedHashMap<String, String> map = new MultivaluedHashMap<>();
  // map.add("name", "Howard");
  // map.add("age", "4");
  // target.request().post(Entity.form(map));
  //
  // Employee[] list = target.request().get(Employee[].class);
  // assertEquals(4, list.length);
  //
  // assertEquals("Howard", list[3].getName());
  // assertEquals(4, list[3].getAge());
  // }
  //
  // /**
  // * Test of deleteFromList method, of class MyResource.
  // */
  // @Test
  // @InSequence(4)
  // public void testDelete() {
  // target.path("{name}").resolveTemplate("name", "Howard").request().delete();
  // Employee[] list = target.request().get(Employee[].class);
  // assertEquals(3, list.length);
  // }
  //
  // @Test
  // @InSequence(5)
  // public void testClientSideNegotiation() {
  // JsonArray json = target.request().accept(MediaType.APPLICATION_JSON).get(JsonArray.class);
  // assertEquals(3, json.size());
  // for (int i = 0; i < json.size(); i++) {
  // JsonObject obj = json.getJsonObject(i);
  // String name = obj.getString("name");
  // int age = obj.getInt("age");
  //
  // if ("Penny".equals(name)) {
  // assertEquals(1, age);
  // } else if ("Leonard".equals(name)) {
  // assertEquals(2, age);
  // } else if ("Sheldon".equals(name)) {
  // assertEquals(3, age);
  // } else {
  // fail("Unknown Employee returned [" + name + ", " + age + "]");
  // }
  // }
  // }
  //
  // @Test
  // @InSequence(6)
  // public void testDeleteAll() {
  // Employee[] list = target.request().get(Employee[].class);
  // for (Employee p : list) {
  // target.path("{name}").resolveTemplate("name", p.getName()).request().delete();
  // }
  // list = target.request().get(Employee[].class);
  // assertEquals(0, list.length);
  // }

}
