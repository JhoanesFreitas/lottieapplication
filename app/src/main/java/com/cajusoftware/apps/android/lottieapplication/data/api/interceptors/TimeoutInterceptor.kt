package com.cajusoftware.apps.android.lottieapplication.data.api.interceptors

import okhttp3.Interceptor
import okhttp3.Response
import java.util.concurrent.TimeUnit

const val CONNECT_TIMEOUT = "CONNECT_TIMEOUT"
const val READ_TIMEOUT = "READ_TIMEOUT"
const val WRITE_TIMEOUT = "WRITE_TIMEOUT"

class TimeoutInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        var connectTimeout = chain.connectTimeoutMillis()
        var readTimeout = chain.readTimeoutMillis()
        var writeTimeout = chain.writeTimeoutMillis()

        val builder = request.newBuilder()

        request.header(CONNECT_TIMEOUT)?.let {
            connectTimeout = it.toInt()
            builder.removeHeader(CONNECT_TIMEOUT)
        }

        request.header(READ_TIMEOUT)?.let {
            readTimeout = it.toInt()
            builder.removeHeader(READ_TIMEOUT)
        }

        request.header(WRITE_TIMEOUT)?.let {
            writeTimeout = it.toInt()
            builder.removeHeader(WRITE_TIMEOUT)
        }

        return chain
            .withConnectTimeout(connectTimeout, TimeUnit.MILLISECONDS)
            .withReadTimeout(readTimeout, TimeUnit.MILLISECONDS)
            .withWriteTimeout(writeTimeout, TimeUnit.MILLISECONDS)
            .proceed(builder.build())
    }
}