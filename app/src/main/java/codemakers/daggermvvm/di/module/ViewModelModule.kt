package codemakers.daggermvvm.di.module

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import codemakers.daggermvvm.ui.add.AddViewModel
import codemakers.daggermvvm.ui.main.MainViewModel
import codemakers.daggermvvm.ui.update.UpdateViewModel
import codemakers.daggermvvm.util.AppViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by jlbeltran94 on 13/10/17.
 */


@Module
abstract class ViewModelModule{

    @Binds
    abstract fun binViewModelFactory(factory: AppViewModelFactory):ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AddViewModel::class)
    abstract fun bindAddViewModel(viewModel: AddViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(UpdateViewModel::class)
    abstract fun bindUpdateViewModel(viewModel: UpdateViewModel): ViewModel


}