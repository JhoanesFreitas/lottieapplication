package com.cajusoftware.apps.android.lottieapplication.data.api.services

import com.cajusoftware.apps.android.lottieapplication.commons.models.responses.CatsInformation
import com.cajusoftware.apps.android.lottieapplication.data.api.interceptors.CONNECT_TIMEOUT
import com.cajusoftware.apps.android.lottieapplication.data.api.interceptors.READ_TIMEOUT
import com.cajusoftware.apps.android.lottieapplication.data.api.urls.URLs.Companion.FACTS
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiService {

    @Headers("$CONNECT_TIMEOUT:5000", "$READ_TIMEOUT:5000")
    @GET(FACTS)
    suspend fun getData(): Array<CatsInformation?>
}