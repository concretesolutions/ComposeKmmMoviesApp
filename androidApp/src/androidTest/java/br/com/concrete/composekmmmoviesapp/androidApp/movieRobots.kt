package br.com.concrete.composekmmmoviesapp.androidApp

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import br.com.concrete.composekmmmoviesapp.androidApp.utils.HttpStatus
import br.com.concrete.composekmmmoviesapp.androidApp.utils.loadAsFixture
import okhttp3.mockwebserver.MockResponse

/*class movieRobots (
    val mockWebServerRule: MockWebServerRule,
    action: movieRobots.() -> Unit) {

    init {
        action.invoke(this)
    }*/

    // pega o arquivo json que criamos
    //retorna uma resposta de sucesso
  /*  fun enqueueResponse(responseFileName:String){
        mockWebServerRule.mockWebServer.enqueue(MockResponse().setBody(responseFileName.loadAsFixture()))
    }

    //retorna resposta de erro do servidor
    fun enqueueMockServerError(){
        mockWebServerRule.mockWebServer.enqueue(MockResponse().setResponseCode(HttpStatus.STATUS_400))
    }

    // retorna resposta de erro
    fun enqueueMockServerRequestError(t: Throwable){
        mockWebServerRule.mockWebServer.enqueue(MockResponse())
    }
//}*/


    fun checkTextVisible(text :String){
        val composeRule = createAndroidComposeRule<MainActivity>()
        composeRule
            .onNode(hasText(text)).assertIsDisplayed()
    }


