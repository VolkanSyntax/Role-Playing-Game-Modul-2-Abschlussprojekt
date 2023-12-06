

fun performAction(source: Held, target: EndGegner, actionIndex: Int) {
    if (actionIndex in 0 until actions.size) {
        val action = actions[actionIndex]
        when (action) {
            is -> action.execute(this, target)
            is -> action.execute(this, source)
            is  -> action.execute(this, source)
            else -> println("Ungültige Aktion!")
        }
    } else {
        println("Ungültige Aktion!")
    }
}