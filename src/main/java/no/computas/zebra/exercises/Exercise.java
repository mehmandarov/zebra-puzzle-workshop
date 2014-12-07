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


import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.util.iterator.ExtendedIterator;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Michael Gfeller
 */
public class Exercise {
  protected static final String TTL = "TTL";
  protected List<Individual> individuals;

  public int getIndividualsCount() {
    return individuals.size();
  }

  public Individual getIndividual(String localname) {
    for (Individual individual : individuals) {
      if (localname.equals(individual.getLocalName())) {
        return individual;
      }
    }
    return null;
  }

  public List<Individual> getIndividuals() {
    return Collections.unmodifiableList(individuals);
  }

  protected List<Individual> getIndividuals(OntModel model) {
    List<Individual> individuals = new ArrayList<Individual>();
    ExtendedIterator<Individual> iterator = model.listIndividuals();
    while (iterator.hasNext()) {
      individuals.add(iterator.next());
    }
    return individuals;
  }

  protected String printIndividuals(List<Individual> individuals) {
    StringBuilder stringBuffer = new StringBuilder();
    for (Individual individual : individuals) {
      stringBuffer.append(printIndividual(individual)).append("\n");
    }
    return stringBuffer.toString();
  }

  protected static String printIndividual(Individual individual) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Individual: " + individual.getLocalName() + "\n");
    StmtIterator properties = individual.listProperties();
    while (properties.hasNext()) {
      Statement s = properties.next();
      stringBuilder.append("  " + s.getPredicate().getLocalName() + " : " + s.getObject().toString() + "\n");
    }
    properties.close();
    stringBuilder.append("\n");
    stringBuilder.append(StringUtils.repeat("-", 70));
    return stringBuilder.toString();
  }
}
