package rules

import Die

public class PokerRule: IYahtzeeScoreRule {

    // 4 identical
    override fun getScore(dice: Array<Die>): Int {
        val values = dice.map { it.value }

        for (i in 1..6) {
            if (values.filter { it == i }.size == 4) {
                return values.sum() + 40
            }
        }

        return 0
    }

    override fun getName(): String = "Poker"
}