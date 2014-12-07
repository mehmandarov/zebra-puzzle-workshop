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
import com.hp.hpl.jena.ontology.Restriction;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.RDFList;
import com.hp.hpl.jena.rdf.model.Resource;

/**
 * @author Michael Gfeller
 */
public class Exercise33Jena extends Exercise32 {

  private final OntModel ontModel;

  public Exercise33Jena() {
    ontModel = readModel(MODEL_INPUT_EX33_JENA);
    OntClass norwegianCity = ontModel.getOntClass(NS + "NorwegianCity");
    OntClass city = ontModel.getOntClass(NS + "City");
    RDFList intersectingClasses = ontModel.createList();
    intersectingClasses = intersectingClasses.with(city);
    Property hasMainLanguage = ontModel.getProperty(NS, "hasMainLanguage");
    Restriction hasMainLanguageRestriction = ontModel.createRestriction(hasMainLanguage);
    Resource norwegian = ontModel.getOntResource(NS + "Norwegian");
    hasMainLanguageRestriction.convertToHasValueRestriction(norwegian);
    intersectingClasses.add(hasMainLanguageRestriction);
    norwegianCity.getEquivalentClass().convertToIntersectionClass(intersectingClasses);
    individuals = getIndividuals(ontModel);
  }

}
