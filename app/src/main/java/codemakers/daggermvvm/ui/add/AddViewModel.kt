package codemakers.daggermvvm.ui.add

import android.arch.lifecycle.ViewModel
import codemakers.daggermvvm.data.dao.TodoDao
import codemakers.daggermvvm.data.model.Todo
import codemakers.daggermvvm.util.applySchedulers
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by jlbeltran94 on 13/10/17.
 */
class AddViewModel @Inject constructor(val dao: TodoDao) : ViewModel(){

    fun insert(title: String, description: String): Observable<Unit>{
        return Observable.fromCallable { dao.insert(Todo(title,description)) }
                .applySchedulers()
    }

}