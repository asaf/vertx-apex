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

package io.vertx.ext.apex.addons;

import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.Handler;
import io.vertx.ext.apex.core.RoutingContext;
import io.vertx.ext.apex.addons.impl.TimeoutImpl;

/**
 * @author <a href="http://tfox.org">Tim Fox</a>
 */
@VertxGen
public interface Timeout extends Handler<RoutingContext> {

  static final long DEFAULT_TIMEOUT = 500;

  static Timeout timeout() {
    return new TimeoutImpl(DEFAULT_TIMEOUT);
  }

  static Timeout timeout(long timeout) {
    return new TimeoutImpl(timeout);
  }

  @Override
  void handle(RoutingContext event);

}
