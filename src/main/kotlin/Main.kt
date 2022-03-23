import rules.IYahtzeeScoreRule
import rules.PokerRule

fun main(args: Array<String>) {
    // Initializing the game
    val game = YahtzeeGame()
    game.addScoreRule(PokerRule())
    game.addScoreRule(FullHouseRule())
    game.addScoreRule(DoubleTroubleRule())

    // Playing the game
    game.rollDice()
    game.lockDice(1)
    game.rollDice()
    game.lockDice(3)
    game.rollDice()

    // Final result
    game.printScore()
    game.printDiceValues()
}