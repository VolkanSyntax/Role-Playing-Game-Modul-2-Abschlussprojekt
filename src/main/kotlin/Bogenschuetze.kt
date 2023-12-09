import kotlin.random.Random

class Bogenschuetze(name: String, hp: Int): Held(name, hp, hp) {
    var attacDamage = 40
    var healAmount = 20
    var attacDamage2 = 100


    override fun performAction(action: String, target: Gegner) {
        isProtected = false
        when (action) {
            "Bogen Attacke" -> target.takeDamage(attacDamage + Random.nextInt(50))
            "Wurf Schleuder" ->{
                this.takeDamage(100000)
                target.takeDamage(attacDamage2)
            }
            "Schlafen" -> this.heal(healAmount)
            "Schutz Mantel"->{
                println("$name nutzt den Schutz Mantel.")
                isProtected = true

            }
            else -> super.performAction(action, target)
        }
    }
    override fun getActionNames(): List<String> {
        return listOf("Bogen Attacke","Wurf Schleuder","Schlafen","Schutz Mantel")
    }

    override fun increaceAttacDamage(percent:Int){
        attacDamage += (attacDamage/100*percent).toInt()
    }
}