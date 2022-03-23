package rules

import Die

public class YahtzeeRule: IYahtzeeScoreRule {

    // 5 identical
    override fun getScore(dice: Array<Die>): Int {
        val values = dice.map { it.value }

        for (i in 1..6) {
            if (values.filter { it == i }.size == 5) {
                return values.sum() + 50
            }
        }

        return 0
    }

    override fun getName(): String = "Yatzee"
}