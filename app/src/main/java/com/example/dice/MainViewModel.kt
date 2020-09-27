package com.example.dice

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel(private val repository: IMainRepository):ViewModel() {
    var imageId =MutableLiveData(R.drawable.empty_dice)

    fun getRandomDice(){
        imageId.value = repository.getImageIdForDiceValue()
    }
    
}