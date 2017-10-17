package codemakers.daggermvvm.util

import android.support.design.widget.Snackbar
import android.support.design.widget.TextInputLayout
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import codemakers.daggermvvm.data.model.Todo
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.subjects.PublishSubject
import org.jetbrains.anko.toast

/**
 * Created by jlbeltran94 on 13/10/17.
 */
fun ViewGroup.inflate(layout: Int) = LayoutInflater.from(context)
        .inflate(layout, this, false)

fun TextInputLayout.text():String = editText?.text.toString()

fun AppCompatActivity.validateForm(message: Int,
                                   vararg fields: String) : Observable<List<String>>
        = Observable.create<List<String>>{
        if(fields.contains("")) toast(message)
        else it.onNext(fields.toList())
        it.onComplete()
    }


fun AppCompatActivity.snackBarAction(container: View,
                                     message: Int,
                                     button: Int,
                                     obj: Any) : Observable<Any>
        = Observable.create<Any> { emitter->
        Snackbar.make(container,message,Snackbar.LENGTH_LONG)
                .setAction(button, {
                    emitter.onNext(obj)
                    emitter.onComplete()
                } )
                .show()
    }


