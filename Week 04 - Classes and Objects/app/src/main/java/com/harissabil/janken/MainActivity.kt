package com.harissabil.janken

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.harissabil.janken.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ibRock.setOnClickListener { startGame(Options.ROCK) }
        binding.ibPaper.setOnClickListener { startGame(Options.PAPER) }
        binding.ibScissors.setOnClickListener { startGame(Options.SCISSORS) }
    }

    private fun startGame(player: Options) {
        val computerOption = Game.pickRandomOption()
        binding.ivComputer.setImageResource(Game.pickDrawable(computerOption))

        when {
            Game.isWin(player, computerOption) -> binding.ivResult.setImageResource(R.drawable.win)
            Game.isDraw(player, computerOption) -> binding.ivResult.setImageResource(R.drawable.draw)
            else -> binding.ivResult.setImageResource(R.drawable.lose)
        }
    }
}