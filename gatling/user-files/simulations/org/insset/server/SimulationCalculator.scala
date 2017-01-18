package org.insset.server

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class SimulationCalculator extends Simulation {

	val httpProtocol = http
		.baseURL("http://localhost:8084")
		.inferHtmlResources()

	val headers_0 = Map(
		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8",
		"Cache-Control" -> "max-age=0",
		"If-Modified-Since" -> "Tue, 17 Jan 2017 14:45:17 GMT",
		"If-None-Match" -> """W/"2624-1484664317000"""")

	val headers_1 = Map(
		"Accept" -> "text/css,*/*;q=0.1",
		"Cache-Control" -> "max-age=0",
		"If-Modified-Since" -> "Mon, 16 Jan 2017 16:40:32 GMT",
		"If-None-Match" -> """W/"22259-1484584832000"""")

	val headers_2 = Map(
		"Cache-Control" -> "max-age=0",
		"If-Modified-Since" -> "Tue, 17 Jan 2017 14:55:27 GMT",
		"If-None-Match" -> """W/"126319-1484664927000"""")

	val headers_3 = Map(
		"Cache-Control" -> "max-age=0",
		"If-Modified-Since" -> "Mon, 16 Jan 2017 16:40:32 GMT",
		"If-None-Match" -> """W/"1384-1484584832000"""")

    val uri1 = "http://localhost:8084/calculatorInsset"

	val scn = scenario("SimulationCalculator")
		.exec(http("request_0")
			.get("/calculatorInsset/")
			.headers(headers_0)
			.resources(http("request_1")
			.get(uri1 + "/calculatorInsset/gwt/standard/standard.css")
			.headers(headers_1)
			.check(status.is(304)),
            http("request_2")
			.get(uri1 + "/calculatorInsset/E6BA359D7341470B267E781FB8A7A754.cache.js")
			.headers(headers_2)
			.check(status.is(304)),
            http("request_3")
			.get(uri1 + "/calculatorInsset/gwt/standard/images/hborder.png")
			.headers(headers_3)
			.check(status.is(304)))
			.check(status.is(304)))

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}