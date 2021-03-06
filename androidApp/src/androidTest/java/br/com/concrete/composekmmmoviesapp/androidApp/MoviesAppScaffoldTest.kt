package br.com.concrete.composekmmmoviesapp.androidApp

import androidx.compose.ui.test.assertIsNotSelected
import androidx.compose.ui.test.assertIsSelected
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MoviesAppScaffoldTest{
    @get:Rule
    val composeRule = createAndroidComposeRule<MainActivity>()

    private val buttonMovies = "Button-Movies"
    private val buttonFavorites = "Button-Favorites"

    @Before
    fun setup(){
        composeRule.setContent {
            MoviesApp()
        }
    }

    @Test
    fun givenInitialState_shouldShowMoviesTabSelected(){
        composeRule.onNode(hasTestTag(buttonMovies)).assertIsSelected()
        composeRule.onNode(hasTestTag(buttonFavorites)).assertIsNotSelected()
    }

    @Test
    fun givenInitialState_whenFavoritesIsClicked_shouldSelectFavoritesTab(){
        composeRule.onNode(hasTestTag(buttonFavorites)).performClick()

        composeRule.onNode(hasTestTag(buttonMovies)).assertIsNotSelected()
        composeRule.onNode(hasTestTag(buttonFavorites)).assertIsSelected()
    }
}