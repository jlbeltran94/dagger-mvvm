package codemakers.daggermvvm.di.module

import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import codemakers.daggermvvm.data.AppDatabase
import codemakers.daggermvvm.data.dao.TodoDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by jlbeltran94 on 13/10/17.
 */
@Module
class AppModule{

    @Singleton
    @Provides
    fun provideContext( application: Application): Context = application

    @Singleton
    @Provides
    fun provideDatabase(context: Context): AppDatabase =
            Room.databaseBuilder(context, AppDatabase::class.java, "todo.db")
                    .build()

    @Singleton
    @Provides
    fun providesTodoDao(appDatabase: AppDatabase): TodoDao =
            appDatabase.todoDao()
}