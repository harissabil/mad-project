package com.harissabil.mad01

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ivDice: ImageView = findViewById(R.id.iv_dice)
        val btnRoll: Button = findViewById(R.id.btn_roll)

        val diceRoll = (1..6)

        btnRoll.setOnClickListener {
            val diceRolled = diceRoll.random()
            val diceImage = when (diceRolled) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            }
            ivDice.setImageResource(diceImage)
        }
    }
}