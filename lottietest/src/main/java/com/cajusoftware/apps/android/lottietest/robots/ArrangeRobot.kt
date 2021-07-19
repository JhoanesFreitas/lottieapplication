package com.cajusoftware.apps.android.lottietest.robots

import android.content.Context
import androidx.test.platform.app.InstrumentationRegistry
import com.cajusoftware.apps.android.lottietest.rules.ServerTestRule
import com.cajusoftware.apps.android.lottietest.utils.extentions.resolveJsonPath
import okhttp3.Headers
import okhttp3.mockwebserver.MockResponse

class ArrangeRobot(
    private val serverTestRule: ServerTestRule? = null,
    val context: Context = InstrumentationRegistry.getInstrumentation().targetContext,
) {

    fun mockResponse(
        urlPath: String,
        statusCode: Int,
        jsonResponse: String,
        specificParameter: String? = null,
        shouldUseParameters: Boolean = false,
        headers: Headers? = null
    ) {
        val mockResponse = MockResponse().apply {
            setResponseCode(statusCode)
            setBody(context.resolveJsonPath(jsonResponse))
            if (headers != null)
                this.headers = Headers.Builder()
                    .addAll(this.headers)
                    .addAll(headers)
                    .build()
        }

        serverTestRule?.addResponse(urlPath, mockResponse, specificParameter, shouldUseParameters)
    }

}