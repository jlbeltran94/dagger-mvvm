package codemakers.daggermvvm.ui.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import codemakers.daggermvvm.R
import codemakers.daggermvvm.data.dao.TodoDao
import codemakers.daggermvvm.data.model.Todo
import codemakers.daggermvvm.ui.adapter.TodoAdapter
import codemakers.daggermvvm.util.applySchedulers
import io.reactivex.Observable
import io.reactivex.internal.operators.observable.ObservableFromArray
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import android.arch.lifecycle.ViewModelProvider
import android.databinding.DataBindingUtil
import android.util.Log
import codemakers.daggermvvm.databinding.ActivityMainBinding
import codemakers.daggermvvm.ui.add.AddActivity
import codemakers.daggermvvm.ui.update.UpdateActivity
import codemakers.daggermvvm.util.snackBarAction
import com.jakewharton.rxbinding2.view.clicks
import dagger.android.AndroidInjection
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import org.jetbrains.anko.contentView
import org.jetbrains.anko.startActivity
import javax.inject.Inject



class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var mainViewModel: MainViewModel

    @Inject
    lateinit var adapter:TodoAdapter

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.recycler.adapter = adapter
        mainViewModel.listTodo()
                .subscribeBy(
                        onNext = {
                            adapter.todos = it
                        }
                )

        goToAdd.clicks()
                .subscribeBy(
                        onNext = {
                            goToAdd()
                        }
                )

        adapter.todoDeleted
                .flatMap { todo -> mainViewModel.removeTodo(todo).map { todo } }
                .flatMap { snackBarAction(contentView!!,getString(R.string.todoDeleted), getString(R.string.undo), it) }
                .flatMap { mainViewModel.recoverTodo(it) }
                .subscribe()

        adapter.todoSelected
                .subscribeBy(
                        onNext = {
                            goToUpdate(it)
                        }
                )




    }

    fun goToAdd(){
        startActivity<AddActivity>()
    }

    fun goToUpdate(todo: Todo){
        startActivity<UpdateActivity>("todo" to todo)
    }

}
