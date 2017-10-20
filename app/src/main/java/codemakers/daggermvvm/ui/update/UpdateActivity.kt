package codemakers.daggermvvm.ui.update

import android.arch.lifecycle.Observer
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import codemakers.daggermvvm.R
import codemakers.daggermvvm.data.dao.TodoDao
import codemakers.daggermvvm.data.model.Todo
import codemakers.daggermvvm.databinding.ActivityEditBinding
import codemakers.daggermvvm.di.Injectable
import codemakers.daggermvvm.ui.LifeDisposable
import codemakers.daggermvvm.util.text
import codemakers.daggermvvm.util.validateForm
import com.jakewharton.rxbinding2.view.clicks
import com.jakewharton.rxbinding2.widget.text
import dagger.android.AndroidInjection
import io.reactivex.Observable
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.activity_edit.*
import javax.inject.Inject

/**
 * Created by jlbeltran94 on 13/10/17.
 */
class UpdateActivity: AppCompatActivity(), Injectable{

    @Inject
    lateinit var updateViewModel : UpdateViewModel
    lateinit var todo: Todo
    lateinit var binding: ActivityEditBinding
    val dis: LifeDisposable = LifeDisposable(this)



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_edit)
        todo = intent.getParcelableExtra("todo")
        title = todo.title
        editTodoDescription.editText?.setText(todo.description)

    }

    override fun onResume() {
        super.onResume()

        dis add saveTodo.clicks()
                .flatMap { validateForm(R.string.requiredFields, editTodoDescription.text()) }
                .flatMap {
                    todo.description = it[0]
                    updateViewModel.updateTodo(todo)
                }
                .subscribe { finish() }
    }



}