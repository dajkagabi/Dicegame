package com.example.dice_game

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Button
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }

        //App start
        rollDice()
    }


    private fun rollDice() {
        // Dice object 6
        val dice = Dice(6)
        val diceRoll = dice.roll()
        //Image displays
        val diceImage: ImageView = findViewById(R.id.imageView)
        //Images by map ID
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        //Drawable from a folder
        diceImage.setImageResource(drawableResource)
        //Drawable description
        diceImage.contentDescription = diceRoll.toString()
    }
}


class Dice(private val numSides: Int) {


    fun roll(): Int {
        //Random dice
        return (1..numSides).random()
    }
}

