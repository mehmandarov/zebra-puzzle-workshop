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
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author Michael Gfeller
 */
@Test
public class Exercise31Test {

  private Exercise31 exercise31;

  @BeforeClass
  public void setUp() throws Exception {
    exercise31 = new Exercise31();
  }

  public void testIndividualsCount() {
    Assert.assertEquals(exercise31.getIndividualsCount(), 3);
  }

  public void testHasBergen() {
    Individual bergen = exercise31.getIndividual("Bergen");
    Assert.assertNotNull(bergen);
    Assert.assertEquals(bergen.getLocalName(), "Bergen");
  }

  public void testHasOslo() {
    Individual oslo = exercise31.getIndividual("Oslo");
    Assert.assertNotNull(oslo);
    Assert.assertEquals(oslo.getLocalName(), "Oslo");
  }

  public void testHasLondon() {
    Individual london = exercise31.getIndividual("London");
    Assert.assertNotNull(london);
    Assert.assertEquals(london.getLocalName(), "London");
  }

  public void testHasNotNorway() {
    Individual norway = exercise31.getIndividual("Norway");
    Assert.assertNull(norway);
  }

  public void testHasNotNorwegian() {
    Individual norwegian = exercise31.getIndividual("Norwegian");
    Assert.assertNull(norwegian);
  }

  public void testOsloHasMainLanguageNorwegian() {
    Individual oslo = exercise31.getIndividual("Oslo");
    Property mainLanguage = ResourceFactory.createProperty(Exercise3.NS, "hasMainLanguage");
    RDFNode norwegian = ResourceFactory.createResource(Exercise3.NS + "Norwegian");
    Assert.assertTrue(oslo.hasProperty(mainLanguage, norwegian));
  }

  public void testOsloIsANorwegianCity() {
    Individual oslo = exercise31.getIndividual("Oslo");
    Assert.assertTrue(oslo.hasOntClass(Exercise3.NS + "NorwegianCity"));
  }

  public void testBergenIsNotANorwegianCity() {
    Individual bergen = exercise31.getIndividual("Bergen");
    Assert.assertFalse(bergen.hasOntClass(Exercise3.NS + "NorwegianCity"));
  }

  public void testLondonIsNotANorwegianCity() {
    Individual london = exercise31.getIndividual("London");
    Assert.assertFalse(london.hasOntClass(Exercise3.NS + "NorwegianCity"));
  }
}
