package com.cajusoftware.apps.android.lottietest.rules

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

@ExperimentalCoroutinesApi
class CoroutineScopeRule private constructor(
    private val dispatcher: TestCoroutineDispatcher
) : TestRule, TestCoroutineScope by TestCoroutineScope(dispatcher) {

    companion object {
        fun create(): CoroutineScopeRule {
            return CoroutineScopeRule(TestCoroutineDispatcher())
        }
    }

    override fun apply(base: Statement?, description: Description?): Statement {
        return object : Statement() {
            override fun evaluate() {
                try {
                    Dispatchers.setMain(dispatcher)
                    base?.evaluate()
                } finally {
                    reset()
                }
            }
        }
    }

    private fun reset() {
        cleanupTestCoroutines()
        Dispatchers.resetMain()
    }
}