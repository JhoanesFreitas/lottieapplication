package com.cajusoftware.apps.android.lottieapplication.core.dagger

import android.app.Application
import com.cajusoftware.apps.android.lottieapplication.core.UITestApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class
    ]
)
internal interface TestAppComponent : AndroidInjector<UITestApp> {
    @Component.Builder
    interface Builder {

        @BindsInstance
        fun create(app: Application): Builder

        fun build(): TestAppComponent
    }
}