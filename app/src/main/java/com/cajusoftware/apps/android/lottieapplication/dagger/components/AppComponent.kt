package com.cajusoftware.apps.android.lottieapplication.dagger.components

import android.app.Application
import com.cajusoftware.apps.android.lottieapplication.App
import com.cajusoftware.apps.android.lottieapplication.dagger.modules.ActivityModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppComponent::class,
        ActivityModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {
    @Component.Builder
    interface Builder {

        @BindsInstance
        fun create(app: Application): Builder

        fun build(): AppComponent
    }
}