package br.com.concrete.composekmmmoviesapp.androidApp

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import br.com.concrete.composekmmmoviesapp.androidApp.util.COMPONENT_ITEM_MOVIES
import br.com.concrete.composekmmmoviesapp.androidApp.util.COMPONENT_LIST_MOVIES
import br.com.concrete.composekmmmoviesapp.androidApp.util.SCREEN_FAVORITES
import br.com.concrete.composekmmmoviesapp.androidApp.util.SCREEN_MOVIES
import org.junit.Before
import org.junit.Ignore
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MoviesTabTest {
    @get:Rule
    val composeRule = createAndroidComposeRule<MainActivity>()

    @Before
    fun setup(){
        composeRule.setContent {
            MoviesApp()
        }
    }

    @Test
    fun givenMoviesList_shouldShowAllItemsOfMoviesList(){
        // NECESSITA MOCK
     /*   ESPRESSO
        onView // EQUIVALENTE AO FINDER
     (ViewMatchers.withText(text))  //MATCHER
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed())) //ASSERTION
            */

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
            .onNode(hasTestTag(COMPONENT_LIST_MOVIES)
            )
            .assert(hasAnyChild(
                hasTestTag(COMPONENT_ITEM_MOVIES)))
    }

    @Ignore
    @Test
    fun givenMoviesList_shouldShowEmptyState(){
    // NECESSITA MOCK
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
            .onNode(hasTestTag(COMPONENT_LIST_MOVIES)
            )
            .assert(!hasAnyChild(
                hasTestTag(COMPONENT_ITEM_MOVIES)))
    }


    @Test
    fun givenMoviesList_shouldShowErrorState(){
        // NECESSITA MOCK
        composeRule
            .onNode(  //FINDER
                hasTestTag(SCREEN_MOVIES)  //MATCHER
            )
            .assertIsDisplayed()  //ASSERTION
        composeRule
            .onNode(hasText("Error")).assertIsDisplayed()
    }

}