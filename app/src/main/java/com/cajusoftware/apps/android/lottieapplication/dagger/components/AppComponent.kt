package com.cajusoftware.apps.android.lottieapplication.dagger.components

import android.app.Application
import com.cajusoftware.apps.android.lottieapplication.App
import com.cajusoftware.apps.android.lottieapplication.dagger.modules.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AndroidServicesModule::class,
        AppModule::class,
        ActivityModule::class,
        URLsModule::class,
        NetworkModule::class,
        RequestModule::class,
        RepositoryModule::class,
        ViewModelModule::class,
        CoroutineDispatchersModule::class
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