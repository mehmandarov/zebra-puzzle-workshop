package no.jz14.zebra.solution;

/*
 * #%L
 * Zebra
 * %%
 * Copyright (C) 2014 Computas AS
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *    http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */


import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.ResourceFactory;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Michael Gfeller
 */
public class Exercise31Test {

  private static Exercise31 exercise31;

  @BeforeClass
  public static void setUp() throws Exception {
    exercise31 = new Exercise31();
  }

  @Test
  public void testIndividualsCount() {
    Assert.assertEquals(3, exercise31.getIndividualsCount());
  }

  @Test
  public void testHasBergen() {
    Individual bergen = exercise31.getIndividual("Bergen");
    Assert.assertNotNull(bergen);
    Assert.assertEquals("Bergen", bergen.getLocalName());
  }

  @Test
  public void testHasOslo() {
    Individual oslo = exercise31.getIndividual("Oslo");
    Assert.assertNotNull(oslo);
    Assert.assertEquals("Oslo", oslo.getLocalName());
  }

  @Test
  public void testHasLondon() {
    Individual london = exercise31.getIndividual("London");
    Assert.assertNotNull(london);
    Assert.assertEquals("London", london.getLocalName());
  }

  @Test
  public void testHasNotNorway() {
    Individual norway = exercise31.getIndividual("Norway");
    Assert.assertNull(norway);
  }

  @Test
  public void testHasNotNorwegian() {
    Individual norwegian = exercise31.getIndividual("Norwegian");
    Assert.assertNull(norwegian);
  }

  @Test
  public void testOsloHasMainLanguageNorwegian() {
    Individual oslo = exercise31.getIndividual("Oslo");
    Property mainLanguage = ResourceFactory.createProperty(Exercise3.NS, "hasMainLanguage");
    RDFNode norwegian = ResourceFactory.createResource(Exercise3.NS + "Norwegian");
    Assert.assertTrue(oslo.hasProperty(mainLanguage, norwegian));
  }

  @Test
  public void testOsloIsANorwegianCity() {
    Individual oslo = exercise31.getIndividual("Oslo");
    Assert.assertTrue(oslo.hasOntClass(Exercise3.NS + "NorwegianCity"));
  }

  @Test
  public void testBergenIsNotANorwegianCity() {
    Individual bergen = exercise31.getIndividual("Bergen");
    Assert.assertFalse(bergen.hasOntClass(Exercise3.NS + "NorwegianCity"));
  }

  @Test
  public void testLondonIsNotANorwegianCity() {
    Individual london = exercise31.getIndividual("London");
    Assert.assertFalse(london.hasOntClass(Exercise3.NS + "NorwegianCity"));
  }
}
