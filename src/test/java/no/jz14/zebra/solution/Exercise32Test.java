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
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author Michael Gfeller
 */
@Test
public class Exercise32Test {

  private Exercise32 exercise32;

  @BeforeClass
  public void setUp() {
    exercise32 = new Exercise32();
  }

  public void testIndividualsCount() {
    Assert.assertEquals(exercise32.getIndividualsCount(), 9);
  }

  public void testOsloIsANorwegianCity() {
    Individual oslo = exercise32.getIndividual("Oslo");
    Assert.assertTrue(oslo.hasOntClass(Exercise3.NS + "NorwegianCity"));
  }

  public void testBergenIsNotANorwegianCity() {
    Individual bergen = exercise32.getIndividual("Bergen");
    Assert.assertFalse(bergen.hasOntClass(Exercise3.NS + "NorwegianCity"));
  }

  public void testLondonIsNotANorwegianCity() {
    Individual london = exercise32.getIndividual("London");
    Assert.assertFalse(london.hasOntClass(Exercise3.NS + "NorwegianCity"));
  }

  public void testVeggeliIsNotANorwegianCity() {
    Individual veggeli = exercise32.getIndividual("Veggeli");
    Assert.assertFalse(veggeli.hasOntClass(Exercise3.NS + "NorwegianCity"));
  }

  @Test(dataProvider = "individuals")
  public void testExpectedIndividual(String localname) {
    Individual individual = exercise32.getIndividual(localname);
    Assert.assertNotNull(individual);
    Assert.assertEquals(individual.getLocalName(), localname);
  }

  @DataProvider(name = "individuals")
  public Object[][] createData() {
    return new Object[][]{
            {"Norwegian"},
            {"Bergen"},
            {"Denmark"},
            {"English"},
            {"Oslo"},
            {"London"},
            {"Veggeli"},
            {"Norway"},
            {"Sweden"},
    };
  }
}
