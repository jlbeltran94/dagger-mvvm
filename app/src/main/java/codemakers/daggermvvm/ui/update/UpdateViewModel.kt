package codemakers.daggermvvm.ui.update

import android.arch.lifecycle.ViewModel
import codemakers.daggermvvm.data.dao.TodoDao
import javax.inject.Inject

/**
 * Created by jlbeltran94 on 13/10/17.
 */
class UpdateViewModel @Inject constructor(val dao: TodoDao) : ViewModel()