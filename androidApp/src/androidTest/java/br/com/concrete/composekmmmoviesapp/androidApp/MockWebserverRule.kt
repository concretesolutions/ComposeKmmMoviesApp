package br.com.concrete.composekmmmoviesapp.androidApp

import br.com.concrete.composekmmmoviesapp.androidApp.data.baseUrl
import okhttp3.mockwebserver.MockWebServer
import org.junit.rules.TestWatcher
import org.junit.runner.Description

//o TestWatcher é uma Rule
class MockWebServerRule: TestWatcher() {

    val mockWebServer = MockWebServer()

    // inicia o teste
    override fun starting(description: Description?) {
        super.starting(description)

        mockWebServer.start(8080)
        baseUrl = mockWebServer.url("/").toString()
    }

    //finaliza o teste
    override fun finished(description: Description?) {
        super.finished(description)
        mockWebServer.shutdown()
    }
}