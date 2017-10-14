package codemakers.daggermvvm.ui.add

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import codemakers.daggermvvm.R
import codemakers.daggermvvm.data.model.Todo
import codemakers.daggermvvm.databinding.ActivityAddBinding
import codemakers.daggermvvm.util.text
import codemakers.daggermvvm.util.validateForm
import com.jakewharton.rxbinding2.view.clicks
import dagger.android.AndroidInjection
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.activity_add.*
import javax.inject.Inject

/**
 * Created by jlbeltran94 on 13/10/17.
 */
class AddActivity : AppCompatActivity(){

    @Inject
    lateinit var addViewModel:AddViewModel

    lateinit var binding: ActivityAddBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add)


        addTodo.clicks()
                .flatMap { validateForm("Verifica los campos", addTodoName.text(), addTodoDescription.text()) }
                .flatMap {
                    addViewModel.insert(it[0],it[1]) }
                .subscribeBy(
                        onNext = {
                            finish()
                        }
                )

    }



}