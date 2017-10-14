package codemakers.daggermvvm.di

import codemakers.daggermvvm.di.module.MainModule
import codemakers.daggermvvm.ui.add.AddActivity
import codemakers.daggermvvm.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector
import javax.inject.Scope

/**
 * Created by jlbeltran94 on 13/10/17.
 */
@Retention(AnnotationRetention.RUNTIME)
@Scope
annotation class ActivityScope

@Module
abstract class ActivityBuilders{

    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf(MainModule::class))
    abstract fun bindMainActivity(): MainActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf(MainModule::class))
    abstract fun bindAddActivity(): AddActivity


}