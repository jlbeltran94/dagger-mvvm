package codemakers.daggermvvm.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverter
import android.arch.persistence.room.TypeConverters
import codemakers.daggermvvm.data.dao.TodoDao
import codemakers.daggermvvm.data.model.Todo
import java.util.*

/**
 * Created by jlbeltran94 on 13/10/17.
 */


object TodoConverter{

    @TypeConverter
    @JvmStatic
    fun dateToLong(date: Date):Long = date.time

    @TypeConverter
    @JvmStatic
    fun longToDate(timestap:Long) = Date(timestap)

}

@Database(entities = arrayOf(Todo::class), version = 1)
@TypeConverters(TodoConverter::class)
abstract class AppDatabase: RoomDatabase(){

    abstract fun todoDao(): TodoDao
}