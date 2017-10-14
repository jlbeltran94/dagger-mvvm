package codemakers.daggermvvm.util

import android.support.design.widget.TextInputLayout
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import org.jetbrains.anko.toast

/**
 * Created by jlbeltran94 on 13/10/17.
 */
fun ViewGroup.inflate(layout: Int) = LayoutInflater.from(context).inflate(layout, this, false)

fun TextInputLayout.text():String = editText?.text.toString()

fun AppCompatActivity.validateForm(message: String, title: String?, description: String?) : Observable<List<String>>{
    if (!title.isNullOrBlank() && !description.isNullOrBlank()){
        return Observable.create {
            it.onNext(listOf(title!!, description!!))
        }
    }
    toast(message)
    return Observable.create {  }
}


