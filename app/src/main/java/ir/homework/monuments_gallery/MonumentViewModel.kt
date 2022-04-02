package ir.homework.monuments_gallery

import androidx.lifecycle.ViewModel

class MonumentViewModel: ViewModel() {
    var monumentList = mutableListOf<Monument>()

    init {
        Repository.setMonumentList()
        monumentList = Repository.monumentList
    }
}