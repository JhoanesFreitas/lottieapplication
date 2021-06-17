package com.cajusoftware.apps.android.lottieapplication.dagger.modules

import com.cajusoftware.apps.android.lottieapplication.data.exts.build
import com.cajusoftware.apps.android.lottieapplication.data.api.services.ApiService
import dagger.Module
import dagger.Provides
import dagger.Reusable
import retrofit2.Retrofit
import javax.inject.Named

@Module
class RequestModule {

    @Provides
    @Reusable
    fun provideApiService(
        @Named("RetrofitApi")
        retrofit: Retrofit
    ): ApiService =
        retrofit.build(ApiService::class.java)
}