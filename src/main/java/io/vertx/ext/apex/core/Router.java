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

package io.vertx.ext.apex.core;

import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.ext.apex.core.impl.RouterImpl;

import java.util.List;

/**
 * @author <a href="http://tfox.org">Tim Fox</a>
 */
@VertxGen
public interface Router {

  static Router router(Vertx vertx) {
    return new RouterImpl(vertx);
  }

  void accept(HttpServerRequest request);

  void handleContext(RoutingContext context);

  void handleFailure(FailureRoutingContext context);

  Route route();

  Route route(HttpMethod method, String path);

  Route route(String path);

  Route routeWithRegex(HttpMethod method, String regex);

  Route routeWithRegex(String regex);

  List<Route> getRoutes();

  Router clear();

  Router mountSubRouter(String mountPoint, Router subRouter);

  Router exceptionHandler(Handler<Throwable> exceptionHandler);

}
