package com.cajusoftware.apps.android.lottieapplication.data.api.exts

import retrofit2.HttpException
import retrofit2.Response
import retrofit2.Retrofit

fun <T> Retrofit.build(clazz: Class<T>): T = this.create(clazz)

@Throws(HttpException::class)
fun <T> Response<T>.throwExceptionIfIsNotSuccessful() {
    if (isSuccessful.not()) throw HttpException(this)
}