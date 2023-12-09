class Magier( name: String,  hp: Int): Held(name, hp, hp) {
    var attacDamage = 50
    var healAmount = 20
    var attacDamage2 = 200


    override fun performAction(action: String, target: Gegner) {
        isProtected = false
        when (action) {
            "ZauberSturm" -> target.takeDamage(attacDamage)
            "TodesZauber" ->{
                this.takeDamage(100000)
                target.takeDamage(attacDamage2)
            }
            "HeilZauber" -> this.heal(healAmount)
            "ZauberSchild"->{
                println("$name nutzt den Schutzzauber.")
                isProtected = true

            }
            else -> super.performAction(action, target)
        }
    }
    override fun getActionNames(): List<String> {
        return listOf("ZauberSturm","TodesZauber","HeilZauber","ZauberSchild")
    }

    override fun increaceAttacDamage(percent:Int){
        attacDamage += (attacDamage/100*percent).toInt()
    }

}