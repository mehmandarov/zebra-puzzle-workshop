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


import com.hp.hpl.jena.datatypes.xsd.XSDDatatype;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;

import java.io.StringWriter;

/**
 * @author Michael Gfeller
 */
public class Exercise2 {

  private Model createModel() {
    Model model = ModelFactory.createDefaultModel();
    String NS = "http://jz14/zebra/";
    model.setNsPrefix("", NS);
    model.setNsPrefix("xsd", "http://www.w3.org/2001/XMLSchema#");
    Resource subject = model.createResource(NS + "Joe");
    Property predicate = model.createProperty(NS + "hasSentMessage");
    String object = "Hello World!";
    subject.addProperty(predicate, object, XSDDatatype.XSDstring);
    return model;
  }

  public String getModelAsTtl() {
    Model model = createModel();
    StringWriter stringWriter = new StringWriter();
    model.write(stringWriter, "TTL");
    return stringWriter.toString();
  }
}
