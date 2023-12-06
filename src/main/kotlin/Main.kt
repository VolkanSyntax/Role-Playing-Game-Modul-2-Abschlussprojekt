



    fun main() {
        val held = Held("Magier", 100)
        held.actions.add(Held.AttackAction(20))
        held.actions.add(Held.HealAction(15))
        held.actions.add(Held.ProtectAction())

        val held2 = Held("Magier2", 100)
        held2.actions.add(Held.AttackAction(20))
        held2.actions.add(Held.HealAction(15))
        held2.actions.add(Held.ProtectAction())

        val held3 = Held("Magier3", 100)
        held3.actions.add(Held.AttackAction(20))
        held3.actions.add(Held.HealAction(15))
        held3.actions.add(Held.ProtectAction())



        val endgegner = EndGegner("Endgegner", 150)
        endgegner.actions.add(EndGegner.AttackAction(30))
        endgegner.actions.add(EndGegner.HealAction(10))
        endgegner.actions.add(EndGegner.ProtectAction())

        var roundnr = 1
        var gamefinish = false
        while (!gamefinish){
            println("Bitte wähle eine Aktion aus")
            var input = 0
            do {
                for (i in  held.getActionNames().indices){
                    var actionsList = held.getActionNames()
                    println(i.toString() + " -> "+ actionsList[i])
                }
                try {
                    input = readln().toInt()
                } catch(e: Exception) {
                    println("Gebe die richtige Nummer ein")
                }
            } while (input !in held.getActionNames().indices)
            held.performAction(held,endgegner,input)



            gamefinish = true
        }


        /*
        held.displayInfo()
        endgegner.displayInfo()

        held.performAction(held,endgegner,0) // Magier greift Krieger an
        endgegner.performAction(endgegner,held, 2) // Krieger wirkt Schutzzauber auf Magier



        held.displayInfo()
        endgegner.displayInfo()
        */
    }

