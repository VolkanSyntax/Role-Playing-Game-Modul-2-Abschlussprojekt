class Krieger( name: String,  hp: Int): Held(name, hp, hp) {
    var attacDamage = 70
    var healAmount = 10
    var attacDamage2 = 100


    override fun performAction(action: String, target: Gegner) {
        isProtected = false
        when (action) {
            "Schwert Attacke" -> target.takeDamage(attacDamage)
            "In rage" ->{
                this.takeDamage(100)
                target.takeDamage(attacDamage2)
            }
            "Elixier" -> this.heal(healAmount)
            "Schutzpanzer"->{
                println("$name nutzt den Schutzpanzer.")
                isProtected = true
            }
            else -> super.performAction(action, target)
        }
    }


    override fun getActionNames(): List<String> {
        return listOf("Schwert Attacke","In rage","Elixier","Schutzpanzer")
    }

    override fun increaceAttacDamage(percent:Int){
        attacDamage += (attacDamage/100*percent).toInt()
    }


}