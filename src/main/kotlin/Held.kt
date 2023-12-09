open class Held(val name: String, var hp: Int, val maxHp: Int, var isProtected: Boolean = false, var isVerflucht: Boolean = false)  {

    fun takeDamage(damage: Int) {
        if(!isProtected){
            hp = (hp - damage).coerceAtLeast(0)
            println("$name erleidet $damage Schaden. Verbleibende HP: $hp")
        }else{
            println("$name erleidet keinen Schaden wegen dem Schutz")
        }

    }

    fun fluch(percent: Int = 10){

        var condition = (100/maxHp*hp)<=20
        if((100/maxHp*hp)>20){
            isVerflucht=true
            hp= (hp*0.9).toInt().coerceAtLeast((maxHp*0.2).toInt())
            println("$name erleidet einen Fluch.Verbleibende HP: $hp")
        }else{
            isVerflucht=false
        }

    }


    fun isAlive(): Boolean = hp > 0

    fun heal(amount: Int) {
        hp = (hp + amount).coerceAtMost(maxHp)
        println("$name heilt sich um $amount. HP: $hp")
    }

    open fun performAction(action: String, target: Gegner) {
        when (action) {
            "attack" -> target.takeDamage(10) // Basisangriff
            "heal" -> this.heal(15) // Selbstheilung
            else -> println("Diese Action gibt es nicht")
        }
    }


    open fun getActionNames(): List<String>{
        return emptyList()
    }

   open fun increaceAttacDamage(percent:Int){}

    override fun toString(): String{
        return """
            Name: $name
            HP: $hp
        """.trimIndent()
    }

}


