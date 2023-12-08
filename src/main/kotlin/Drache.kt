class Drache( name: String,  hp: Int): Held(name, hp, hp) {
    var attacDamage = 70
    var healAmount = 10
    var attacDamage2 = 100


    override fun performAction(action: String, target: Gegner) {
        isProtected = false
        when (action) {
            "Schwert Attacke" -> target.takeDamage(attacDamage)
            "In rage" ->{
                this.takeDamage(100000)
                target.takeDamage(attacDamage2)
            }
            "Elexier" -> this.heal(healAmount)
            "Schutzpanzer"->{
                println("$name nutzt den Schutzpanzer.")
                isProtected = true

            }
            else -> super.performAction(action, target)
        }
    }





}