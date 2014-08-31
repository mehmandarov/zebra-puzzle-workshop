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


import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.util.PrintUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Michael Gfeller
 */
public class Exercise1 {

  private final Model model;

  public Exercise1() {
    model = null; //TODO
  }

  public Model getModel() {
    return model;
  }

  public int getIndividualsCount() {
    List<Statement> statementList = new ArrayList<Statement>();
    StmtIterator stmtIterator = model.listStatements();
    while (stmtIterator.hasNext()) {
      statementList.add(stmtIterator.next());
    }
    return statementList.size();
  }

  public String getIndividual() {
    Statement statement = model.listStatements().nextStatement();
    PrintUtil.registerPrefix("", "http://jz14/zebra/");
    return PrintUtil.print(statement);
  }
}
