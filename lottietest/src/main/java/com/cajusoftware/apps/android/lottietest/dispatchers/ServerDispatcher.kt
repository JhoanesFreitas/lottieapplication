package com.cajusoftware.apps.android.lottietest.dispatchers

import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest

private const val NOT_FOUND = 404

internal object ServerDispatcher : Dispatcher() {

    private const val PARAM = "[PARAM]"
    private val paramRegex = Regex("([0-9A-Z]+|\\{[\\w-]+\\})")

    private val mappedRequests = mutableListOf<String>()
    private val receivedRequests = mutableListOf<String>()
    private val unknownResponses = mutableListOf<String>()

    private val responseMap = mutableMapOf<String, MutableList<MockResponse>>()

    fun addResponse(
        urlPath: String,
        response: MockResponse,
        specificParameter: String? = null,
        shouldUseParameters: Boolean = false
    ) {
        val path = "/" + when {
            specificParameter != null -> paramRegex.replace(urlPath, specificParameter)
            shouldUseParameters -> urlPath
            else -> paramRegex.replace(urlPath, PARAM)
        }

        mappedRequests += urlPath

        if (path !in responseMap) responseMap[path] = mutableListOf()

        responseMap[path]?.add(response)
    }

    override fun dispatch(request: RecordedRequest): MockResponse {
        val path = request.path?.split("?")?.first() ?: ""
        val pathWithRegex = paramRegex.replace(path, PARAM)

        receivedRequests += request.path.orEmpty()

        val responses = when {
            responseMap[path] != null -> responseMap[path]
            responseMap[pathWithRegex] != null -> responseMap[pathWithRegex]
            responseMap[request.path] != null -> responseMap[request.path]
            else -> {
                unknownResponses += request.path.orEmpty()
                return MockResponse().apply {
                    setResponseCode(NOT_FOUND)
                }
            }
        }

        if (responses?.size == 1) responseMap.remove(path)

        return responses?.removeAt(0) ?: MockResponse()
    }

    fun finish() {
        mappedRequests.clear()
        responseMap.clear()
        receivedRequests.clear()
        unknownResponses.clear()
    }
}