package codemakers.daggermvvm.data.model

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
@Entity
class Todo(
        @PrimaryKey(autoGenerate = true) var id: Long? = 0,
        var title: String,
        var description: String?,
        var date: Date
           ) : Parcelable{

    @Ignore
    constructor(title: String, description: String?): this(null, title, description, Date())

    @Ignore
    constructor(source: Parcel) : this(
            source.readValue(Long::class.java.classLoader) as Long?,
            source.readString(),
            source.readString(),
            source.readSerializable() as Date
    )

    @Ignore
    override fun describeContents() = 0

    @Ignore
    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeValue(id)
        writeString(title)
        writeString(description)
        writeSerializable(date)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Todo> = object : Parcelable.Creator<Todo> {
            override fun createFromParcel(source: Parcel): Todo = Todo(source)
            override fun newArray(size: Int): Array<Todo?> = arrayOfNulls(size)
        }
    }

}