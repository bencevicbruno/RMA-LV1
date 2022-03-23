package rules

import Die

interface IYahtzeeScoreRule {

    fun getScore(dice: Array<Die>): Int
    fun getName(): String
}