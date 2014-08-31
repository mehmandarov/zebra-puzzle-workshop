package no.jz14.zebra.exercises;

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

import java.util.ArrayList;
import java.util.List;

/**
 * @author Michael Gfeller
 */
@Test
public class Exercise4Test {

  private Exercise4 exercise4;

  @BeforeClass
  public void setUp() throws Exception {
    exercise4 = new Exercise4();
  }

  public void testZebraHasOwner() {
    List<Individual> individuals = exercise4.getIndividuals();
    List<Individual> found = new ArrayList<Individual>();
    Property hasPet = ResourceFactory.createProperty(Exercise4.NS, "hasPet");
    RDFNode zebra = ResourceFactory.createResource(Exercise4.NS + "Zebra");
    for (Individual individual : individuals) {
      if (individual.hasProperty(hasPet, zebra)) {
        found.add(individual);
      }
    }
    Assert.assertFalse(found.isEmpty());
    for (Individual individual : found) {
      System.out.println(Exercise.printIndividual(individual));
    }
  }

  public void testSomebodyDrinksWater() {
    List<Individual> individuals = exercise4.getIndividuals();
    List<Individual> found = new ArrayList<Individual>();
    Property hasPet = ResourceFactory.createProperty(Exercise4.NS, "drinks");
    RDFNode zebra = ResourceFactory.createResource(Exercise4.NS + "Water");
    for (Individual individual : individuals) {
      if (individual.hasProperty(hasPet, zebra)) {
        found.add(individual);
      }
    }
    Assert.assertFalse(found.isEmpty());
    for (Individual individual : found) {
      System.out.println(Exercise.printIndividual(individual));
    }
  }

}
