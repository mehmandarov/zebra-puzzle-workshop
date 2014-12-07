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


import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.reasoner.Reasoner;
import org.mindswap.pellet.jena.PelletReasonerFactory;

/**
 * @author Michael Gfeller
 */
public class Exercise4Jena extends Exercise {

  public static String NS = "http://www.computas.no/zebra#";

  private final OntModel ontModel;
  private final String modelBase = "exercise4-zebra-jena.ttl";

  public Exercise4Jena() {
    ontModel = readModel();
    // statement #2
    Resource englishman = ontModel.getResource(NS + "Englishman");
    Property livesIn = ontModel.getProperty(NS + "livesIn");
    Property hasColor = ontModel.getProperty(NS + "hasColor");
    Resource red = ontModel.getResource(NS + "Red");
    OntClass redThing = ontModel.createClass();
    redThing.addProperty(hasColor, red);
    englishman.addProperty(livesIn, redThing);

    // statement #3
    Resource spaniard = ontModel.getResource(NS + "Spaniard");
    Property hasPet = ontModel.getProperty(NS + "hasPet");
    Resource dog = ontModel.getResource(NS + "Dog");
    spaniard.addProperty(hasPet, dog);

    // statement #4
    Property drinks = ontModel.getProperty(NS + "drinks");
    Resource coffee = ontModel.getResource(NS + "Coffee");
    OntClass s4Thing = ontModel.createClass();
    s4Thing.addProperty(drinks, coffee);
    Resource green = ontModel.getResource(NS + "Green");
    OntClass greenThing = ontModel.createClass();
    greenThing.addProperty(hasColor, green);
    s4Thing.addProperty(livesIn, greenThing);

    // statement #5
    Resource ukrainian = ontModel.getResource(NS + "Ukrainian");
    Resource tea = ontModel.getResource(NS + "Tea");
    ukrainian.addProperty(drinks, tea);

    // statement #6
    Property isRightTo = ontModel.getProperty(NS + "isRightTo");
    Resource ivory = ontModel.getResource(NS + "Ivory");
    OntClass ivoryThing = ontModel.createClass();
    ivoryThing.addProperty(hasColor, ivory);
    greenThing.addProperty(isRightTo, ivoryThing);

    // statement #7
    Property rides = ontModel.getProperty(NS + "rides");
    OntClass fujiRider = ontModel.createClass();
    Resource fuji = ontModel.getResource(NS + "Fuji");
    fujiRider.addProperty(rides, fuji);
    Resource snails = ontModel.getResource(NS + "Snails");
    fujiRider.addProperty(hasPet, snails);

    // statement #8
    OntClass giantRider = ontModel.createClass();
    Resource giant = ontModel.getResource(NS + "Giant");
    giantRider.addProperty(rides, giant);
    Resource yellow = ontModel.getResource(NS + "Yellow");
    OntClass yellowThing = ontModel.createClass();
    yellowThing.addProperty(hasColor, yellow);
    giantRider.addProperty(livesIn, yellowThing);

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
