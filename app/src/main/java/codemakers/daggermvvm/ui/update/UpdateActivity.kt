package codemakers.daggermvvm.ui.update

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import codemakers.daggermvvm.R
import codemakers.daggermvvm.data.dao.TodoDao
import codemakers.daggermvvm.data.model.Todo
import codemakers.daggermvvm.databinding.ActivityEditBinding
import codemakers.daggermvvm.util.text
import com.jakewharton.rxbinding2.widget.text
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_edit.*
import javax.inject.Inject

/**
 * Created by jlbeltran94 on 13/10/17.
 */
class UpdateActivity: AppCompatActivity(){

    @Inject
    lateinit var dao: TodoDao
    lateinit var todo: Todo
    lateinit var binding: ActivityEditBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_edit)
        todo = savedInstanceState?.get("todo") as Todo
        editTodoDescription.editText?.text = todo.description as Editable

    }

}