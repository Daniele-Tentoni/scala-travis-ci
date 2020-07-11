package com

import org.scalamock.scalatest.MockFactory
import org.scalatest.matchers.should.Matchers
import org.scalatest.funsuite.AnyFunSuite

/**
 * Test server with Mock support by ScalaMock.
 */
class ServerTestWithMock extends AnyFunSuite with MockFactory with Matchers {
  test("Test server without cache") {
    val cacheMock = mock[Cache[Request, Response]]
    val cacheableStub = stubFunction[Request, Boolean]
    cacheableStub when * returns false

    val server = new ServerWithCache(cacheMock, cacheableStub)

    val request = Request("Some request")
    val expectedResponse = Response(request.body + "'s response")

    server serve request shouldEqual expectedResponse
    server serve request shouldEqual expectedResponse
    cacheableStub verify request twice()
  }

  test("Test server with cache") {
    // Mocks/stubs for dependencies.
    val cacheMock = mock[Cache[Request, Response]]
    val cacheableStub = stubFunction[Request, Boolean]
    cacheableStub.when(*).returns(true)

    // Wire Sut with stubbed/mocked dependecies.
    val server = new ServerWithCache(cacheMock, cacheableStub)

    // Arrange.
    val request = Request("Some request")
    val expectedResponse = Response(request.body + "'s response")

    // Mock expectations.
    inSequence {
      cacheMock.cached _ expects request returning false
      cacheMock.put _ expects(request, *)
      cacheMock.cached _ expects request returning true
      cacheMock.get _ expects request returning expectedResponse
    }

    // Act + Assert
    server serve request shouldEqual expectedResponse
    server serve request shouldEqual expectedResponse
    cacheableStub verify request twice()
  }
}