public class Die {
    var value = 0
        private set

    var isLocked = false

    fun roll() {
        if (!isLocked) {
            value = (1..6).random()
        }
    }
}