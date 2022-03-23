import rules.IYahtzeeScoreRule

class FullHouseRule: IYahtzeeScoreRule {

    // 3 + 3 identical
    override fun getScore(dice: Array<Die>): Int {
        val values = dice.map { it.value }

        for (i in 1..6) {
            if (values.filter { it == i }.size == 3) {
                for (j in (i..6)) {
                    if (i == j) continue
                    if (values.filter { it == j }.size == 3) {
                        return values.sum() + 30
                    }
                }
            }
        }

        return 0
    }

    override fun getName(): String = "Full House"
}