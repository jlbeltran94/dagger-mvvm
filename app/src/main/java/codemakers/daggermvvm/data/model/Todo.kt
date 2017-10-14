package codemakers.daggermvvm.data.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey
import java.util.*

/**
 * Created by jlbeltran94 on 13/10/17.
 */
@Entity
class Todo(
        @PrimaryKey(autoGenerate = true) var id: Long? = 0,
        var title: String,
        var description: String?,
        var date: Date
           ){

    @Ignore
    constructor(title: String, description: String?): this(null, title, description, Date())
}