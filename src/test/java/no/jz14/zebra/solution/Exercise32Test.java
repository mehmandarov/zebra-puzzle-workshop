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
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Michael Gfeller
 */
public class Exercise32Test {

  private static Exercise32 exercise32;

  @BeforeClass
  public static void setUp() {
    exercise32 = new Exercise32();
  }

  @Test
  public void testIndividualsCount() {
    Assert.assertEquals(9, exercise32.getIndividualsCount());
  }

  @Test
  public void testOsloIsANorwegianCity() {
    Individual oslo = exercise32.getIndividual("Oslo");
    Assert.assertTrue(oslo.hasOntClass(Exercise3.NS + "NorwegianCity"));
  }

  @Test
  public void testBergenIsNotANorwegianCity() {
    Individual bergen = exercise32.getIndividual("Bergen");
    Assert.assertFalse(bergen.hasOntClass(Exercise3.NS + "NorwegianCity"));
  }

  @Test
  public void testLondonIsNotANorwegianCity() {
    Individual london = exercise32.getIndividual("London");
    Assert.assertFalse(london.hasOntClass(Exercise3.NS + "NorwegianCity"));
  }

  @Test
  public void testVeggeliIsNotANorwegianCity() {
    Individual veggeli = exercise32.getIndividual("Veggeli");
    Assert.assertFalse(veggeli.hasOntClass(Exercise3.NS + "NorwegianCity"));
  }

  @Test
  public void testIndividuals() {
    Assert.assertTrue(assertIndividual("Norwegian"));
    Assert.assertTrue(assertIndividual("Bergen"));
    Assert.assertTrue(assertIndividual("Denmark"));
    Assert.assertTrue(assertIndividual("English"));
    Assert.assertTrue(assertIndividual("Oslo"));
    Assert.assertTrue(assertIndividual("London"));
    Assert.assertTrue(assertIndividual("Veggeli"));
    Assert.assertTrue(assertIndividual("Norway"));
    Assert.assertTrue(assertIndividual("Sweden"));
  }

  private boolean assertIndividual(String localname) {
    Individual individual = exercise32.getIndividual(localname);
    return individual != null && localname.equals(individual.getLocalName());
  }
}
