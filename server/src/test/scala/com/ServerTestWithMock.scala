package com

import org.scalamock.scalatest.MockFactory
import org.scalatest.Matchers
import org.scalatest.funsuite.AnyFunSuite

/**
 * Test server with Mock support by ScalaMock.
 */
class ServerTestWithMock extends AnyFunSuite with MockFactory with Matchers {
  test("Test server with cache") {
    // Mocks/stubs for dependencies.
    val cacheMock = mock[Cache[Request, Response]]
    val cachebleStub = stubFunction[Request, Boolean]
    cachebleStub.when(*).returns(true)

    // Wire Sut with stubbed/mocked dependecies.
    val server= new ServerWithCache(cacheMock, cachebleStub)

    // Arrange.
    val request = Request("Some request")
    val expectedResponse = Response(request.body + "'s response")

    // Mock expectations.
    inSequence {
      (cacheMock.cached _).expects(request).returning(false)
      (cacheMock.put _).expects(request, *)
      (cacheMock.cached _).expects(request).returning(true)
      (cacheMock get _).expects(request).returning(expectedResponse)
    }

    // Act + Assert
    server.serve(request) shouldEqual expectedResponse
    server.serve(request) shouldEqual expectedResponse
    cachebleStub verify request twice()
  }
}
