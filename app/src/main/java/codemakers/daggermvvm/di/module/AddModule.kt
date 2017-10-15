package codemakers.daggermvvm.di.module

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import codemakers.daggermvvm.di.ActivityScope
import codemakers.daggermvvm.ui.add.AddActivity
import codemakers.daggermvvm.ui.add.AddViewModel
import dagger.Module
import dagger.Provides

/**
 * Created by jlbeltran94 on 13/10/17.
 */
@Module
class AddModule{

    @ActivityScope
    @Provides
    fun provideAddViewModel(activity: AddActivity, factory: ViewModelProvider.Factory): AddViewModel
            = ViewModelProviders.of(activity, factory).get(AddViewModel::class.java)


}