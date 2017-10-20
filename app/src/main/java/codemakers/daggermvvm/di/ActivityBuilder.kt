package codemakers.daggermvvm.di

import codemakers.daggermvvm.ui.add.AddActivity
import codemakers.daggermvvm.ui.main.MainActivity
import codemakers.daggermvvm.ui.update.UpdateActivity
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
    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun bindAddActivity(): AddActivity

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun bindUpdateActivity(): UpdateActivity



}