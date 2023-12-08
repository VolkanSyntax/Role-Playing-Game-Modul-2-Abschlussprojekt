

    fun main() {
        // Helden
        val magier = Magier("Magier", 100)
        val bogenschuetze = Bogenschuetze("Bogenschuetze", 100)
        val krieger = Krieger("Krieger",100)

        // Team an Helden
        val helden: MutableList<Held> = mutableListOf(magier,bogenschuetze,krieger)

        // Gegner
        val drache = Krieger("Drache",500)
        val gegnerListe: MutableList<Gegner> = mutableListOf(drache)

        spielRunde(helden, gegnerListe)

    }



    fun spielRunde(helden: MutableList<Held>, gegnerListe: MutableList<Gegner>) {
        // Game Loop Vorbereitung
        // Variable, anhand der wir pruefen, ob das spiel vorbei ist
        var gameOver: Boolean = false
        // Rundencounter
        var round: Int = 1


        while (!gameOver){
            println("---Runde $round!---")
            // Logik, um den Gegner Helfer zu beschwören
            //rufeHelfer(round, gegnerListe)

            // print alle helden in meinem team und ihre aktionen --> ueber liste der helden iterieren
            println("--Unser Team:--")
            // print alle helden in meinem team und ihre aktionen --> ueber liste der helden iterieren
            var lebendeHelden = helden.filter { it.isAlive() }.toMutableList()
            lebendeHelden.forEach { println(it) }
            // print alle gegner --> ueber liste der gegner iterieren
            println("--Gegner Team:--")
            var lebendeGegner = gegnerListe.filter { it.isAlive()}.toMutableList() // nur lebende Gegner werden rausgefiltert
            lebendeGegner.forEach { println(it) }


            lebendeGegner = aktionenHelden(lebendeHelden, lebendeGegner)
            // gegner greifen an: exact das gleiche
            // hardcode, keine richtige Logik

            lebendeHelden = aktionenGegner(lebendeGegner, lebendeHelden)
            lebendeHelden = helden.filter { it.isAlive() }.toMutableList()

            println("Runde $round beendet!")
            println("ggf. Status von allen ausdrucken...")
            gameOver = gameOver(helden, lebendeGegner, gameOver)
            round++
        }
        println("Spiel beendet! Alle Gegner sind besiegt!") // Logik: helden oder gegner tot?

    }

    private fun rufeHelfer(round: Int, gegnerListe: MutableList<Pokemon>) {
        if (round == 2) {
            println("Das Gegner Team holt sich in der $round. Runde einen Helfer dazu.....")
            gegnerListe.add(Pokemon("Helfer-Pokemon Mauzi"))
        }
    }

    private fun gameOver(helden: MutableList<Held>, lebendeGegner: MutableList<Gegner>, gameOver: Boolean): Boolean {
        var gameOver1 = gameOver
        if (helden.isEmpty()) {
            println("Unsere Helden haben versagt... Game Over :(")
            gameOver1 = true
        } else if (lebendeGegner.isEmpty()){
            println("Geschafft! Unsere Helden haben gewonnen! Game Over :) ")
            gameOver1 = true
        }
        return gameOver1
    }

    private fun aktionenHelden(helden: MutableList<Held>, lebendeGegner: MutableList<Gegner>): MutableList<Gegner> {
        var lebendeGegner1 = lebendeGegner
        var inputValid = false
        // schleife, bis alle helden angegriffen haben:
        // print: "1./2./3. held soll angreifen, welche attacke?"
        for (held in helden) {
            inputValid = false
            println("${held.name} soll angreifen. Wähle die Attacke per Zahleneingabe aus!")

            while (!inputValid){
                println("[1] => Tackle, [2] => Heuler, etc")
                try {
                    val choice = readln().toInt()
                    when (choice) {
                        1 -> {
                            held.tackle(lebendeGegner1.first())
                            // angeben, dass ggf gegner bereits gestorben ist
                            lebendeGegner1 = lebendeGegner1.filter { !it.isDead }.toMutableList()
                            inputValid = true
                        }
                        // 2 -> held.heuler(gegner.random())
                        // etc weitere attacken
                        else -> {
                            println("Falsche Zahl eingegeben, gib eine gültige Zahl ein!")
                            // inputValid bleibt hier false -> Schleife geht von vorne los
                        }
                    }
                } catch (e: Exception) {
                    println("Bitte eine Zahl eingeben... Probier's nochmal")
                }
            }
        }
        return lebendeGegner1
    }



    private fun aktionenGegner(helden: MutableList<Gegner>, lebendeGegner: MutableList<Held>): MutableList<Held> {
        var lebendeGegner1 = lebendeGegner
        var inputValid = false
        // schleife, bis alle helden angegriffen haben:
        // print: "1./2./3. held soll angreifen, welche attacke?"
        for (held in helden) {
            inputValid = false
            println("${held.name} soll angreifen. Wähle die Attacke per Zahleneingabe aus!")

            while (!inputValid){
                println("[1] => Tackle, [2] => Heuler, etc")
                try {
                    val choice = readln().toInt()
                    when (choice) {
                        1 -> {
                            held.tackle(lebendeGegner1.first())
                            // angeben, dass ggf gegner bereits gestorben ist
                            lebendeGegner1 = lebendeGegner1.filter { !it.isDead }.toMutableList()
                            inputValid = true
                        }
                        // 2 -> held.heuler(gegner.random())
                        // etc weitere attacken
                        else -> {
                            println("Falsche Zahl eingegeben, gib eine gültige Zahl ein!")
                            // inputValid bleibt hier false -> Schleife geht von vorne los
                        }
                    }
                } catch (e: Exception) {
                    println("Bitte eine Zahl eingeben... Probier's nochmal")
                }
            }
        }
        return lebendeGegner1
    }






    /*
        fun main() {


            val endgegner = Gegner("Endgegner", 150)
            endgegner.actions.add(Gegner.AttackAction(30))
            endgegner.actions.add(Gegner.HealAction(10))
            endgegner.actions.add(Gegner.ProtectAction())

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

    */