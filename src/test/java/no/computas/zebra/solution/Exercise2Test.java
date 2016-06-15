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


import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * @author Michael Gfeller
 */
public class Exercise2Test {

  @Test
  public void testTtlIsSameAsExercise1() throws IOException {
    Exercise2 exercise2 = new Exercise2();

    String expected = StringUtils.trim(IOUtils.toString(getClass().getResource("/exercise1.ttl"), "UTF-8"));
    String actual = StringUtils.trim(exercise2.getModelAsTtl());
    Assert.assertEquals(expected, actual);
  }
}
