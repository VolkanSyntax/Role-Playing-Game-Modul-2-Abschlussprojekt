open class Gegner(val name: String, var hp: Int, val maxHp: Int, var isProtected: Boolean = false)  {


    fun takeDamage(damage: Int) {

        val CYAN = "\u001B[36m"
        val RED = "\u001B[31m"
        val YELLOW = "\u001B[33m"
        val BLUE = "\u001B[34m"
        val RESET = "\u001B[0m"

        if(!isProtected){
            hp = (hp - damage).coerceAtLeast(0)
            println("$RED$name$RESET erleidet $damage Schaden. Verbleibende HP: $hp")
        }else{
            println("$name erleidet keinen Schaden wegen dem Schutz")
        }

    }
    fun isAlive(): Boolean = hp > 0

    fun heal(amount: Int) {
        hp = (hp + amount).coerceAtMost(maxHp)
        println("$name heilt sich um $amount. HP: $hp")
    }

    open fun performAction(action: String, target: Held) {}


    override fun toString(): String{
        return """
            Name: $name
            HP: $hp
        """.trimIndent()
    }

}


