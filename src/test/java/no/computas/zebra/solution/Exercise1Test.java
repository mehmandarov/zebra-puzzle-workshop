package no.computas.zebra.solution;

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


import com.hp.hpl.jena.rdf.model.Model;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Michael Gfeller
 */
public class Exercise1Test {

  @Test
  public void testModelIsNotNull() {
    Exercise1 exercise1 = new Exercise1();
    Model model = exercise1.getModel();
    Assert.assertNotNull(model);
  }

  @Test
  public void testIndividualsCountIs1() {
    Exercise1 exercise1 = new Exercise1();
    Assert.assertEquals(1, exercise1.getIndividualsCount());
  }

  @Test
  public void testIndividual() {
    Exercise1 exercise1 = new Exercise1();
    Assert.assertEquals("(:Joe :hasSentMessage 'Hello World!'^^http://www.w3.org/2001/XMLSchema#string)", exercise1.getIndividual());
  }
}
