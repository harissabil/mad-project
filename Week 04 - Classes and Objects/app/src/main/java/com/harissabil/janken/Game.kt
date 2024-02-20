package com.harissabil.janken

object Game {

    fun pickRandomOption(): Options = Options.entries.toTypedArray().random()

    fun pickDrawable(option: Options): Int = when (option) {
        Options.ROCK -> R.drawable.rock
        Options.PAPER -> R.drawable.paper
        Options.SCISSORS -> R.drawable.scissors
    }

    fun isDraw(player: Options, computer: Options): Boolean = player == computer

    fun isWin(player: Options, computer: Options): Boolean = when (player) {
        Options.ROCK -> computer == Options.SCISSORS
        Options.PAPER -> computer == Options.ROCK
        Options.SCISSORS -> computer == Options.PAPER
    }
}