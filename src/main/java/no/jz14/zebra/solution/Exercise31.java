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


import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.rdf.model.ModelFactory;

/**
 * @author Michael Gfeller
 */
public class Exercise31 extends Exercise3 {

    private final OntModel ontModel;

    public Exercise31() {
        ontModel = readModel();
        individuals = getIndividuals(ontModel);
        System.err.println(printIndividuals(individuals));
    }

    private OntModel readModel() {
        OntModel ontModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
        ontModel.read(getClass().getResourceAsStream("/" + MODEL_INPUT_EX31_EX32), null, TTL);
        return ontModel;
    }

}
