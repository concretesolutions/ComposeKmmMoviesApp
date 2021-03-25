package br.com.concrete.composekmmmoviesapp.androidApp

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import br.com.concrete.composekmmmoviesapp.androidApp.util.SCREEN_FAVORITES
import br.com.concrete.composekmmmoviesapp.androidApp.util.SCREEN_MOVIES
import br.com.concrete.composekmmmoviesapp.androidApp.util.tagButton
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MoviesAppScaffoldTest {

    @get:Rule
    val composeRule = createAndroidComposeRule<MainActivity>()


    @Before
    fun setup() {
        composeRule.setContent {
            MoviesApp()
        }
    }

    private val buttonMovies = tagButton("Movies")
    private val buttonFavorites = tagButton("Favorites")

    @Test
    fun givenInitialState_shouldShowMoviesTabSelected() {

        composeRule.onNode(hasTestTag(buttonMovies)).assertIsSelected()
        composeRule.onNode(hasTestTag(buttonFavorites)).assertIsNotSelected()

        composeRule.onNode(hasTestTag(SCREEN_MOVIES)).assertIsDisplayed()
    }


    @Test
    fun givenInitialState_whenFavoritesIsClicked_shouldSelectFavoritesTab(){

        composeRule
            .onNode( // FINDER
                hasTestTag(buttonFavorites) // MATCHER
            )
            .performClick() // ACTION

        composeRule.onNode(hasTestTag(buttonMovies)).assertIsNotSelected()
        composeRule.onNode(hasTestTag(buttonFavorites)).assertIsSelected()

        composeRule.onNode(hasTestTag(SCREEN_FAVORITES)).assertIsDisplayed()

    }

    @Test
    fun givenInitialState_shouldSeeBothTabs(){
        composeRule.onNode(hasTestTag(buttonMovies)).assertIsEnabled()
        composeRule.onNode(hasTestTag(buttonFavorites)).assertIsEnabled()
    }
}