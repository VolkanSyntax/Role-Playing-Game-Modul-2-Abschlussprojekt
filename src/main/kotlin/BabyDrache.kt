class BabyDrache( name: String,  hp: Int): Gegner(name, hp, hp) {
    var attacDamage = 20
    var healAmount = 10
    var attacDamage2 = 40


    override fun performAction(action: String, target: Held) {
        isProtected = false
        when (action) {
            "Babyschrei" -> target.takeDamage(attacDamage)
            "Babypups"->target.takeDamage(attacDamage2)
            "Drachenmilch" -> this.heal(healAmount)
            "Fluegelschutz"->{
                println("$name nutzt den Schutzpanzer.")
                isProtected = true
            }
            else -> super.performAction(action, target)
        }
    }


}