package com.cajusoftware.apps.android.lottietest.rules

import com.cajusoftware.apps.android.lottietest.dispatchers.ServerDispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

class ServerTestRule : TestRule {

    private val mockWebServer = MockWebServer()
    private val port = 8080

    private val dispatcher by lazy {
        mockWebServer.dispatcher = ServerDispatcher
        ServerDispatcher
    }

    private fun start() {
        mockWebServer.start(port)
    }

    private fun stop() {
        dispatcher.finish()
        mockWebServer.shutdown()
    }

    override fun apply(base: Statement?, description: Description?): Statement {
        return object : Statement() {
            override fun evaluate() {
                start()
                try {
                    base?.evaluate()
                } finally {
                    stop()
                }
            }
        }
    }

    fun addResponse(
        urlPath: String,
        mockResponse: MockResponse,
        specificParameters: String?,
        shouldUseParameters: Boolean
    ) {
        dispatcher.addResponse(urlPath, mockResponse, specificParameters, shouldUseParameters)
    }

    companion object {
        fun create(): ServerTestRule {
            return ServerTestRule()
        }
    }
}