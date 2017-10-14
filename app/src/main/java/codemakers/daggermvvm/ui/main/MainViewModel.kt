package codemakers.daggermvvm.ui.main

import android.arch.lifecycle.ViewModel
import codemakers.daggermvvm.data.dao.TodoDao
import codemakers.daggermvvm.data.model.Todo
import codemakers.daggermvvm.util.applySchedulers
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * Created by jlbeltran94 on 13/10/17.
 */
class MainViewModel @Inject constructor(val dao: TodoDao) : ViewModel(){

    fun listTodo(): Flowable<List<Todo>> = dao.all().applySchedulers()



}