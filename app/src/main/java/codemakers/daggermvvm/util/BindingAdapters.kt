package codemakers.daggermvvm.util

import android.databinding.BindingAdapter
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by jlbeltran94 on 13/10/17.
 */


@BindingAdapter("app:dateFormat")
fun applyFormat(textView: TextView, date: Date){
    val format = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    textView.text = format.format(date)
}