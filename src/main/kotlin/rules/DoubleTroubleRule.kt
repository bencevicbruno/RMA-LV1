import rules.IYahtzeeScoreRule

class DoubleTroubleRule: IYahtzeeScoreRule {

    // if at least two numbers are equal: sum + 11
    override fun getScore(dice: Array<Die>): Int {
        val values = dice.map { it.value }

        for (i in 1..6) {
            if (values.filter { it == i }.size == 2) {
                return values.sum() + 11
            }
        }

        return 0
        0    }

    override fun getName() = "Double Trouble"
}