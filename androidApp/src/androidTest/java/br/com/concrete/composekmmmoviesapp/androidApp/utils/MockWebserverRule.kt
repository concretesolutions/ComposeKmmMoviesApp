package br.com.concrete.composekmmmoviesapp.androidApp.utils

import android.util.Log
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
        Log.d("AppMovie","iniciou o mock")
        mockWebServer.start(8080)
        baseUrl = mockWebServer.url("/").toString()
        Log.d("AppMovie","baseUrl:$baseUrl")
    }

    //finaliza o teste
    override fun finished(description: Description?) {
        super.finished(description)
        mockWebServer.shutdown()
        Log.d("AppMovie","finalizou o mock")
    }
}