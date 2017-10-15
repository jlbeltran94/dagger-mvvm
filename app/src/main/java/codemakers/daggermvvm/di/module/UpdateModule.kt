package codemakers.daggermvvm.di.module

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import codemakers.daggermvvm.di.ActivityScope
import codemakers.daggermvvm.ui.update.UpdateActivity
import codemakers.daggermvvm.ui.update.UpdateViewModel
import dagger.Module
import dagger.Provides

/**
 * Created by jlbeltran94 on 13/10/17.
 */
@Module
class UpdateModule{

    @ActivityScope
    @Provides
    fun provideUpdateViewModel(activity: UpdateActivity, factory: ViewModelProvider.Factory): UpdateViewModel
            = ViewModelProviders.of(activity, factory).get(UpdateViewModel::class.java)


}