package codemakers.daggermvvm

import android.app.Activity
import android.app.Application
import codemakers.daggermvvm.di.component.AppComponent
import codemakers.daggermvvm.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/**
 * Created by jlbeltran94 on 13/10/17.
 */
class App: Application(), HasActivityInjector {

    @Inject
    lateinit var injector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity>
            = injector

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
                .applicacion(this)
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
    }
}