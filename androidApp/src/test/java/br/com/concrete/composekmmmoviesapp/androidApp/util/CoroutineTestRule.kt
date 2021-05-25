package br.com.concrete.composekmmmoviesapp.androidApp.util

import androidx.arch.core.executor.ArchTaskExecutor
import androidx.arch.core.executor.TaskExecutor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

@ExperimentalCoroutinesApi
class CoroutineTestRule(
    val testDispatcher: TestCoroutineDispatcher = TestCoroutineDispatcher()
) : TestRule {
    override fun apply(base: Statement?, description: Description?): Statement {
        return object : Statement() {
            override fun evaluate() {
                try {
                    Dispatchers.setMain(testDispatcher)
                    ArchTaskExecutor.getInstance().setDelegate(object : TaskExecutor() {
                        override fun executeOnDiskIO(runnable: Runnable) = runnable.run()

                        override fun isMainThread() = true

                        override fun postToMainThread(runnable: Runnable) = runnable.run()
                    })
                    base?.evaluate()
                } finally {
                    testDispatcher.cleanupTestCoroutines()
                    Dispatchers.resetMain()
                    ArchTaskExecutor.getInstance().setDelegate(null)
                }
            }
        }
    }
}