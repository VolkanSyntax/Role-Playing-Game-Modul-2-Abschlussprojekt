open class EndGegner(val name: String, var hp: Int) {

        class AttackAction(val damage: Int) {
            fun execute(source: EndGegner, target: Held) {
                println("${source.name} greift ${target.name} an und fügt $damage Schaden zu!")
                target.hp -= damage
            }
        }

        class HealAction(val healAmount: Int) {
            fun execute(source: EndGegner, target: EndGegner) {
                println("${source.name} heilt ${target.name} um $healAmount HP.")
                target.hp += healAmount
            }
        }

        class ProtectAction {
            var protected = false

            fun execute(source: EndGegner, target: EndGegner) {
                if (!protected) {
                    println("${source.name} wirkt einen Schutzzauber auf ${target.name}.")
                    protected = true
                } else {
                    println("${target.name} ist bereits geschützt.")
                }
            }
        }

        val actions = mutableListOf<Any>()

        fun performAction(source: EndGegner, target: Held, actionIndex: Int) {
            if (actionIndex in 0 until actions.size) {
                val action = actions[actionIndex]
                when (action) {
                    is AttackAction ->  action.execute(this, target)
                    is HealAction -> action.execute(this, source)
                    is ProtectAction -> action.execute(this, source)
                    else -> println("Ungültige Aktion!")
                }
            } else {
                println("Ungültige Aktion!")
            }
        }

        fun displayInfo() {
            println("$name - HP: $hp")
        }


}