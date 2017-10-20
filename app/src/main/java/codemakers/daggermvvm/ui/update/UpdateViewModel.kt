package codemakers.daggermvvm.ui.update

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import codemakers.daggermvvm.data.dao.TodoDao
import codemakers.daggermvvm.data.model.Todo
import codemakers.daggermvvm.util.applySchedulers
import io.reactivex.Observable
import io.reactivex.internal.operators.observable.ObservableFromCallable
import javax.inject.Inject

/**
 * Created by jlbeltran94 on 13/10/17.
 */
class UpdateViewModel @Inject constructor(val dao: TodoDao) : ViewModel(){

    fun updateTodo(todo: Todo): Observable<Unit> =
            ObservableFromCallable{ dao.update(todo) }
                    .applySchedulers()

}