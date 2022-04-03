package ir.homework.monuments_gallery

import androidx.lifecycle.ViewModel

class MonumentViewModel: ViewModel() {
    var monumentList = mutableListOf<Monument>()
    var tipList = mutableListOf<String>()

    init {
        Repository.setMonumentList()
        monumentList = Repository.monumentList
        Repository.setTipList()
        tipList = Repository.tipList
    }
}