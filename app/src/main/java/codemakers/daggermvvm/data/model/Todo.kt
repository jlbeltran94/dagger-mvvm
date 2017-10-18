package codemakers.daggermvvm.data.model

import android.annotation.SuppressLint
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey
import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parceler
import kotlinx.android.parcel.Parcelize
import java.util.*
import kotlin.reflect.KClass

/**
 * Created by jlbeltran94 on 13/10/17.
 */
@SuppressLint("ParcelCreator")
@Entity
@Parcelize
class Todo(
        @PrimaryKey(autoGenerate = true) var id: Long? = 0,
        var title: String,
        var description: String?,
        var date: Date
           ) : Parcelable{

    @Ignore
    constructor(title: String, description: String?): this(null, title, description, Date())

    companion object : Parceler<Todo> {
        override fun create(parcel: Parcel): Todo
                = Todo(parcel.readLong(),
                parcel.readString(),
                parcel.readString(),
                parcel.readSerializable() as Date)

        override fun Todo.write(parcel: Parcel, flags: Int) {
            parcel.writeLong(id!!)
            parcel.writeString(title)
            parcel.writeString(description)
            parcel.writeSerializable(date)
        }

    }

}