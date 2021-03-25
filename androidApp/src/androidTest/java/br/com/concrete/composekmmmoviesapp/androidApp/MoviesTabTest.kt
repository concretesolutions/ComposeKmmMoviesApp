package br.com.concrete.composekmmmoviesapp.androidApp

import android.util.Log
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import br.com.concrete.composekmmmoviesapp.androidApp.util.COMPONENT_ITEM_MOVIES
import br.com.concrete.composekmmmoviesapp.androidApp.util.COMPONENT_LIST_MOVIES
import br.com.concrete.composekmmmoviesapp.androidApp.util.SCREEN_MOVIES
import br.com.concrete.composekmmmoviesapp.androidApp.utils.MockWebServerRule
import br.com.concrete.composekmmmoviesapp.androidApp.utils.loadAsFixture
import br.com.concrete.composekmmmoviesapp.androidApp.utils.retryer
import okhttp3.mockwebserver.MockResponse
//import okhttp3.mockwebserver.MockResponse
import org.junit.Before
import org.junit.Ignore
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith



@RunWith(AndroidJUnit4::class)
class MoviesTabTest {
    @get:Rule
    val composeRule = createAndroidComposeRule<MainActivity>()

    @get:Rule
    val mockWebServerRule = MockWebServerRule()

    fun enqueueResponse(responseFileName:String){
        val file = responseFileName.loadAsFixture()
        Log.d("AppMovie","File:$file")
        mockWebServerRule.mockWebServer.enqueue(MockResponse().setResponseCode(200).setBody(file))
    }

    fun enqueueResponseError(){
        mockWebServerRule.mockWebServer.enqueue(MockResponse().setResponseCode(400))
    }

    @Before
    fun setup(){

        composeRule.setContent {
            MoviesApp()
        }
    }

    @Test
    fun givenMoviesList_shouldShowAllItemsOfMoviesList(){
        enqueueResponse("response_movies_success.json")
        enqueueResponse("response_gender_success.json")
        retryer {

            composeRule
                .onNode(  //FINDER
                    hasTestTag(SCREEN_MOVIES)  //MATCHER
                )
                .assertIsDisplayed()  //ASSERTION
            composeRule
                .onNode(

                    hasTestTag(COMPONENT_LIST_MOVIES)
                )
                .assertExists()
            composeRule
                .onNode(
                    hasTestTag(COMPONENT_LIST_MOVIES)
                )
                .assert(
                    hasAnyChild(
                        hasTestTag(COMPONENT_ITEM_MOVIES)
                    )
                )
        }
        Log.d("AppMovieTeste", "QueueCount0:${mockWebServerRule.mockWebServer.requestCount}")
    }

  /*  composeRule.onNode(hasTestTag("Input")).assertTextEquals("Hello!")*/


    @Test
    fun givenMoviesList_shouldShowEmptyState(){
        enqueueResponse("response_movies_empty.json")
        enqueueResponse("response_gender_empty.json")
        retryer {
            composeRule
                .onNode(hasTestTag(SCREEN_MOVIES))
                .assertIsDisplayed()  //ASSERTION
            composeRule
                .onNode(hasTestTag(COMPONENT_LIST_MOVIES))
                .assertExists()

            composeRule
                .onNode(hasTestTag(COMPONENT_LIST_MOVIES))
                .assert(!hasAnyChild(hasTestTag(COMPONENT_ITEM_MOVIES)))

        }
        Log.d("AppMovieTeste", "QueueCount1:${mockWebServerRule.mockWebServer.requestCount}")
    }

    @Test
    fun givenMoviesList_shouldShowErrorState(){
        enqueueResponseError()
        enqueueResponseError()
        retryer {
            composeRule
                .onNode(  //FINDER
                    hasTestTag(SCREEN_MOVIES)  //MATCHER
                )
                .assertIsDisplayed()  //ASSERTION
            composeRule
                .onNode(hasText("Error")).assertIsDisplayed()
        }
        Log.d("AppMovieTeste", "QueueCount2:${mockWebServerRule.mockWebServer.requestCount}")
    }


}