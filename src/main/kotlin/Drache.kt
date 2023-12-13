class Drache( name: String,  hp: Int): Gegner(name, hp, hp) {
    var attacDamage = 50
    var healAmount = 50
    var attacDamage2 = 100
    var feueratemDamage = 20


    override fun performAction(action: String, target: Held) {
        val RED = "\u001B[31m"
        val RESET = "\u001B[0m"

        when (action) {
            "Feuer Ball" ->{
                println("$RED$name$RESET speit einen Feuer Ball")
                target.takeDamage(attacDamage)
            }
            "Fluegelschlag" ->{
                println("$RED$name$RESET führt einen Fluegelschlag aus")
                target.takeDamage(attacDamage2)
            }
            "Feueratem" -> {
                println("$RED$name$RESET führte bei allen Helden einen Feueratem aus")
                target.takeDamage(feueratemDamage)
            }
            "Heilender Feuer Stein" ->{
                this.heal(healAmount)
            }
            "Fluch"-> target.fluch()
            else -> super.performAction(action, target)
        }
    }


}