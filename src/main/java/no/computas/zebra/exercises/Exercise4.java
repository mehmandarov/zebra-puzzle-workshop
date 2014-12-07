package no.computas.zebra.exercises;

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


import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.reasoner.Reasoner;
import org.mindswap.pellet.jena.PelletReasonerFactory;

/**
 * @author Michael Gfeller
 */
public class Exercise4 extends Exercise {

  public static String NS = "http://www.computas.no/zebra#";

  private final OntModel ontModel;
  private final String modelBase = "exercise4-zebra.ttl";

  public Exercise4() {
    ontModel = readModel();
    individuals = getIndividuals(ontModel);
  }

  protected OntModel readModel() {
    Reasoner reasoner = PelletReasonerFactory.theInstance().create();
    Model infModel = ModelFactory.createInfModel(reasoner, ModelFactory.createDefaultModel());
    OntModel ontModel = ModelFactory.createOntologyModel(PelletReasonerFactory.THE_SPEC, infModel);
    ontModel.read(getClass().getResourceAsStream("/" + modelBase), null, TTL);
    return ontModel;
  }
}
