

fun main() {
        // Helden
        val magier = Magier("Magier", 100)
        val bogenschuetze = Bogenschuetze("Bogenschuetze", 100)
        val krieger = Krieger("Krieger",100)

        // Team an Helden
        val helden: MutableList<Held> = mutableListOf(magier,bogenschuetze,krieger)

        // Gegner
        val drache = Drache("Drache",600)
        val gegnerListe: MutableList<Gegner> = mutableListOf(drache)

        spielRunde(helden, gegnerListe)

    }



    fun spielRunde(helden: MutableList<Held>, gegnerListe: MutableList<Gegner>) {

        var gameOver: Boolean = false
        // Rundencounter
        var round: Int = 1
        val beutel = Beutel()
        var beschworungGenutzt = false

        while (!gameOver){
            println("---Runde $round!---")


            println("--Unser Team:--")
            // print alle helden in meinem team und ihre aktionen --> ueber liste der helden iterieren

            var lebendeHelden = helden.filter { it.isAlive() }.toMutableList()
            lebendeHelden.forEach { println(it) }


            // print alle gegner --> ueber liste der gegner iterieren
            println("--Gegner Team:--")
            var lebendeGegner = gegnerListe.filter { it.isAlive()}.toMutableList() // nur lebende Gegner werden rausgefiltert
            lebendeGegner.forEach { println(it) }


            lebendeGegner = aktionenHelden(lebendeHelden, lebendeGegner,beutel)


            if (!beschworungGenutzt){
                if ((1..3).random()==3){
                    beschwoereHelfer( gegnerListe)
                    beschworungGenutzt=true
                }else{
                    lebendeHelden = aktionenGegner(lebendeGegner, lebendeHelden)
                    lebendeHelden = helden.filter { it.isAlive() }.toMutableList()
                }

            }else {
                lebendeHelden = aktionenGegner(lebendeGegner, lebendeHelden)
                lebendeHelden = helden.filter { it.isAlive() }.toMutableList()
            }

            println("Runde $round beendet!")
            gameOver = gameOver(lebendeHelden, lebendeGegner, gameOver)
            round++
        }
        println("Spiel beendet!") // Logik: helden oder gegner tot?

    }

    private fun beschwoereHelfer(gegnerListe: MutableList<Gegner>) {
            println("Der Drache beschwort einen Babydrachen")
            gegnerListe.add(BabyDrache("Babydrache",150))
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

    //fertig
    private fun aktionenHelden(helden: MutableList<Held>, lebendeGegner: MutableList<Gegner>, beutel: Beutel): MutableList<Gegner> {
        var lebendeGegner1 = lebendeGegner
        var inputValid = false
        var beutelUsed = false


        for (held in helden) {
            if (lebendeGegner1.isEmpty()){
                return lebendeGegner1
            }
            inputValid = false
            var chooseActionOrBeutel = 1
            if(!beutelUsed){
                println("Druecke 1 um eine Aktion auszuwaehlen oder 2  um dem Beutel zu nutzen  ")
                chooseActionOrBeutel = readln().toInt()
            }
            if (chooseActionOrBeutel==2){

                if (!beutel.isEmpty()){
                    println("Bitte waehle dir etwas von dem Beutel aus")
                    println(beutel)
                    var beutelChoose = readln().toInt()
                    if(beutelChoose==1){
                        beutel.heiltrankNutzen(held)
                    }else{
                        beutel.vitaminNutzen(held)
                    }
                    beutelUsed=true
                }

            }else{
                println("${held.name} soll angreifen. Wähle die Attacke per Zahleneingabe aus!")

                while (!inputValid){

                    var heroActions = held.getActionNames()
                    for ( i in heroActions.indices){
                        println("${i + 1} ${heroActions[i]}")
                    }

                    val choice = readln().toInt()
                    if (choice > 0 && choice <= (heroActions.size)){
                        held.performAction(heroActions[choice-1], lebendeGegner1.last())
                        inputValid = true
                    }else{
                        println("Falsche Zahl eingegeben, gib eine gültige Zahl ein!")
                    }
                }

            }

        }
        return lebendeGegner1
    }


    private fun aktionenGegner(gegner: MutableList<Gegner>, lebendeHelden: MutableList<Held>, ): MutableList<Held> {
        var lebendeHelden1 = lebendeHelden
        var inputValid = false

        for (held in lebendeHelden){
            if (held.isVerflucht){
                held.fluch()
            }
        }
        for (g in gegner) {
            if (lebendeHelden1.isEmpty()){
                return lebendeHelden1
            }
            inputValid = false
            println("${g.name} greift an.")

            while (!inputValid){

                if (g is Drache){
                    val choice = (1..5).random()
                    if (choice==1){
                        g.performAction("Feuer Ball",lebendeHelden1.first())
                    }else if(choice==2){
                        g.performAction("Fluegelschlag",lebendeHelden1.first())
                    }else if(choice==3){
                        for (held in lebendeHelden){
                            g.performAction("Feueratem",held)
                        }
                    }else if(choice==4){
                        g.performAction("Heilender Feuer Stein",lebendeHelden1.first())
                    }else if(choice==5){
                        g.performAction("Fluch",lebendeHelden1.random())
                    }
                    inputValid = true
                }else{
                    val choice = (1..4).random()
                    if (choice==1){
                        g.performAction("Babyschrei",lebendeHelden1.first())
                    }else if(choice==2){
                        g.performAction("Babypups",lebendeHelden1.first())
                    }else if(choice==3){
                        for (held in lebendeHelden){
                            g.performAction("Drachenmilch",held)
                        }
                    }else if(choice==4){
                        g.performAction("Fluegelschutz",lebendeHelden1.first())
                    }
                    inputValid = true
                }


            }
        }
        return lebendeHelden
    }



