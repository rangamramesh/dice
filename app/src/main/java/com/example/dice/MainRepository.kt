package com.example.dice

import kotlin.random.Random

class MainRepository : IMainRepository {


    override fun getImageIdForDiceValue(): Int {
        return when (Random.nextInt(6) + 1) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }
}

interface IMainRepository {
    fun getImageIdForDiceValue(): Int
}
