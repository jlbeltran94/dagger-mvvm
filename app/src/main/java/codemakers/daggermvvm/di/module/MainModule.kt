package codemakers.daggermvvm.di.module

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import codemakers.daggermvvm.di.ActivityScope
import codemakers.daggermvvm.ui.adapter.TodoAdapter
import codemakers.daggermvvm.ui.main.MainActivity
import codemakers.daggermvvm.ui.main.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides

/**
 * Created by jlbeltran94 on 13/10/17.
 */

@Module
class MainModule{

    @ActivityScope
    @Provides
    fun provideMainViewModel(activity: MainActivity, factory: ViewModelProvider.Factory): MainViewModel
            = ViewModelProviders.of(activity, factory).get(MainViewModel::class.java)

    @ActivityScope
    @Provides
    fun provideAdapter():TodoAdapter = TodoAdapter()

}