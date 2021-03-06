/*
 * Copyright 2014 Red Hat, Inc.
 *
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  and Apache License v2.0 which accompanies this distribution.
 *
 *  The Eclipse Public License is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  The Apache License v2.0 is available at
 *  http://www.opensource.org/licenses/apache2.0.php
 *
 *  You may elect to redistribute this code under either of these licenses.
 */

package io.vertx.ext.apex.addons.test;

import io.vertx.core.http.HttpMethod;
import io.vertx.ext.apex.addons.Logger;
import io.vertx.ext.apex.test.ApexTestBase;
import org.junit.Test;

/**
 *
 * Kind of hard to test this!
 *
 * @author <a href="http://tfox.org">Tim Fox</a>
 */
public class LoggerTest extends ApexTestBase {

  @Override
  public void setUp() throws Exception {
    super.setUp();

  }

  @Test
  public void testLogger1() throws Exception {
    Logger logger = Logger.logger();
    testLogger(logger);
  }

  @Test
  public void testLogger2() throws Exception {
    Logger logger = Logger.logger(Logger.Format.TINY);
    testLogger(logger);
  }

  @Test
  public void testLogger3() throws Exception {
    Logger logger = Logger.logger(true, Logger.Format.TINY);
    testLogger(logger);
  }

  private void testLogger(Logger logger) throws Exception {
    router.route().handler(logger);
    router.route().handler(rc -> rc.response().end());
    testRequest(HttpMethod.GET, "/somedir", 200, "OK");
  }


}
