package codemakers.daggermvvm.util

import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import io.reactivex.android.schedulers.AndroidSchedulers



/**
 * Created by jlbeltran94 on 13/10/17.
 */

fun <T> Flowable<T>.applySchedulers(): Flowable<T> {
    return   compose { it.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()) }
}

fun <T> Observable<T>.applySchedulers(): Observable<T> {
    return   compose { it.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()) }
}




