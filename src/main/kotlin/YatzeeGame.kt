import rules.IYahtzeeScoreRule

class YahtzeeGame {

    private val dice = arrayOf(Die(), Die(), Die(), Die(), Die(), Die())
    private var scoreRules = mutableSetOf<IYahtzeeScoreRule>()
    private var diceRollsLeft = 3

    fun addScoreRule(rule: IYahtzeeScoreRule) {
        if (scoreRules.any { it.getName() == rule.getName() }) {
            throw Exception("You can't add the same exception twice!")
        }

        scoreRules.add(rule)
    }

    fun lockDice(number: Int) {
        if (!(number in 1..6))
            throw IndexOutOfBoundsException("We're playing Yahtzee only with 6 dice!")

        dice[number - 1].isLocked = true
    }

    fun rollDice() {
        if (diceRollsLeft < 1)
            throw Exception("No more dice rolls for you!")

        for (die in dice) {
            die.roll()
        }

        diceRollsLeft--
    }

    fun printScore() {
        if (diceRollsLeft > 1) {
            throw Exception("Please throw the dice 3 times before deducing the score.")
        }

        if (scoreRules.size == 0) {
            throw Exception("Please setup your Yahtzee game with at least one rule!")
        }

        for (scoreRule in scoreRules) {
            val score = scoreRule.getScore(dice)

            if (score != 0) {
                println("[${scoreRule.getName()}]: Your score is: ${score}.")
                return
            }
        }

        println("You scored nothing! Better luck next time (or invent your own rules ;) )")
    }

    fun printDiceValues() {
        for (die in dice) {
            print("${die.value} ")
        }
        println()
    }
}