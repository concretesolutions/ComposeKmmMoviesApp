package br.com.concrete.composekmmmoviesapp.androidApp

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.GlobalContext
import org.koin.test.AutoCloseKoinTest
import org.koin.test.check.checkModules

@RunWith(AndroidJUnit4::class)
class KoinTest : AutoCloseKoinTest() {
    @Test
    fun givenKoinAppStarted_shouldHaveAllModulesResolved() {
        GlobalContext.get().checkModules()
    }
}