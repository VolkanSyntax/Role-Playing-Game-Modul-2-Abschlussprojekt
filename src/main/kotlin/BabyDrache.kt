class BabyDrache( name: String,  hp: Int): Gegner(name, hp, hp) {
    var attacDamage = 20
    var healAmount = 10
    var attacDamage2 = 40


    val RED = "\u001B[31m"
    val RESET = "\u001B[0m"

    override fun performAction(action: String, target: Held) {
        isProtected = false
        when (action) {
            "Babyschrei" -> {
                println("$RED$name$RESET brüllt laut! Es ist ohrenbetäubend ")
                target.takeDamage(attacDamage)}
            "Babypups"->{
                println("$RED$name$RESET lässt einen mächtigen Pups los! Gegner sind betäubt ")
                target.takeDamage(attacDamage2)}
            "Drachenmilch" -> {
                println("$RED$name$RESET trinkt Drachenmilch und fühlt sich wieder stark ")
                this.heal(healAmount)}
            "Fluegelschutz"->{
                println("$RED$name$RESET nutzt den Schutzpanzer. Kein Schaden wird durchdringen ")
                isProtected = true
            }
            else -> super.performAction(action, target)
        }
    }


}

