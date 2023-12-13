

fun main() {
        // Helden
        val magier = Magier("Magier", 100) // Magier hat eigenen class en und Magier class en nimmt erben von helden // büyücü kendi sinfindan olusturuldu ama ana sinifi kahraman sinifidir diger alttaki 2 side aynisi
        val bogenschuetze = Bogenschuetze("Bogenschuetze", 100) // Bogenschütze hat eigenen class en und Bogenschütze class en nimmt erben von helden
        val krieger = Krieger("Krieger",100) // Krieger hat eigenen class en und Krieger class en nimmt erben von helden

        // Team an Helden // Magier, Bogenschütze , Krieger // Kahramanlar liste olarak veriliyor
        val helden: MutableList<Held> = mutableListOf(magier,bogenschuetze,krieger)

        // Gegner
        val drache = Drache("Drache",600)

        // Liste von Gegner // Drache // düsman Mutable liste olarak veriliyor
        val gegnerListe: MutableList<Gegner> = mutableListOf(drache)


        spielRunde(helden, gegnerListe) // Spiel Runde  helden und Gegner fängt an :)  // oyun Tur u  basliyor kahramanlar ve Düsmanlar..

    }

       val RED = "\u001B[31m"
       val YELLOW = "\u001B[33m"
       val BLUE = "\u001B[34m"
       val RESET = "\u001B[0m"

    fun spielRunde(helden: MutableList<Held>, gegnerListe: MutableList<Gegner>) {

        var gameOver: Boolean = false  // Verfolgt, ob das Spiel beendet ist oder nicht. Anfangs false // Oyunun bitip bitmediğini takip eder. Başlangıçta false
        var round: Int = 1 // Rundenzähler, erhöht sich bei jedem Durchlauf um 1 // Tur sayacı, her döngüde 1 artar
        val beutel = Beutel() // Ein Objekt, das Gegenstände enthält, die Spieler verwenden können (vom Typ Beutel) // Oyuncuların kullanabileceği eşyaları içeren bir nesne (Beutel sınıfından)
        var beschworungGenutzt = false // Dies ist ein Zeichen, das überprüft, ob die Feinde zusätzliche Hilfe gerufen haben oder nicht // Düşmanların ekstra yardım çağırıp çağırmadığını kontrol eder



        println("$YELLOW\n" +
                     "╦ ╦┬┬  ┬  ┬┌─┌─┐┌┬┐┌┬┐┌─┐┌┐┌  ┬┌┬┐  ╔═╗┌─┐┬┌─┐┬    \n" +
                     "║║║││  │  ├┴┐│ │││││││├┤ │││  ││││  ╚═╗├─┘│├┤ │    \n" +
                     "╚╩╝┴┴─┘┴─┘┴ ┴└─┘┴ ┴┴ ┴└─┘┘└┘  ┴┴ ┴  ╚═╝┴  ┴└─┘┴─┘  \n" +
                     "      ╔═╗┌─┐┬  ┌┬┐┌─┐┌┐┌  ╔═╗┬ ┬┌┐┌┌┬┐┌─┐─┐ ┬      \n" +
                     "      ║ ╦│ ││   ││├┤ │││  ╚═╗└┬┘│││ │ ├─┤┌┴┬┘      \n" +
                     "      ╚═╝└─┘┴─┘─┴┘└─┘┘└┘  ╚═╝ ┴ ┘└┘ ┴ ┴ ┴┴ └─      \n$RESET")
                     Thread.sleep(1800)

        println("""
            ${YELLOW}Willkommen bei Golden Syntax! 
            Ihre Helden: ein Zauberer, ein Bogenschütze und ein Krieger. 
            Ihre Aufgabe: gegen einen furchterregenden Drachen kämpfen. 
            Aber vergessen Sie nicht, der Drache kann nur einmal, genau einen Babydrachen rufen. 
            Ihre Intelligenz und Fähigkeiten werden Sie in diesem epischen Kampf zum Sieg führen. 
            Sind Sie bereit? 
            Das Abenteuer beginnt!$RESET
             """.trimIndent())
           Thread.sleep(11000)

        while (!gameOver){ // Die Schleife while (!gameOver) läuft, solange gameOver false ist. In jeder Runde // while (!gameOver) döngüsü, gameOver true olana kadar devam eder. Her turda
            println("\n$YELLOW---Runde $round!---$RESET\n")

            println("$BLUE--Unser Team:--$RESET") // println alle lebendem helden MutableListe nochmal
            var lebendeHelden = helden.filter { it.isAlive() }.toMutableList() // und filtert lebenHelden liste Wenn  im leben zeigt das in MutableList
            lebendeHelden.forEach { println(it) } // Dann wird die Information jedes noch lebenden Helden auf dem Bildschirm gedruckt. // Son olarak, hayatta olan her düşmanın bilgisi ekrana yazdırılır. Bu, oyuncunun hangi düşmanların
                                                  // Dies ermöglicht dem Spieler zu sehen, welche Helden noch im Spiel sind.           // hala oyun içinde olduğunu ve muhtemelen bir sonraki turda hangi düşmanlarla yüzleşeceğini görmesini sağlar.

            println("$RED--Gegner Team:--$RESET") // println alle lebendem Gegner MutableListe nochmal
            var lebendeGegner = gegnerListe.filter { it.isAlive()}.toMutableList() // und filtert lebenGegner liste Wenn  im leben zeigt das in MutableList
            lebendeGegner.forEach { println(it) } // Schließlich wird die Information jedes noch lebenden Gegners auf dem Bildschirm gedruckt. Dies ermöglicht dem Spieler zu sehen, welche Gegner       // Son olarak, hayatta olan her düşmanın bilgisi ekrana yazdırılır. Bu, oyuncunun hangi düşmanların
                                                  // noch im Spiel sind und gegen welche Gegner er möglicherweise in der nächsten Runde antreten muss                                                    // hala oyun içinde olduğunu ve muhtemelen bir sonraki turda hangi düşmanlarla yüzleşeceğini görmesini sağlar.


            lebendeGegner = aktionenHelden(lebendeHelden, lebendeGegner,beutel) // fangen wir zuerst mit lebenden helden action
            /*
            lebendeGegner = aktionenHelden(lebendeHelden, lebendeGegner,beutel): Diese Zeile ruft die Funktion auf, die die Aktionen der Helden verarbeitet.
            Diese Funktion bearbeitet die Aktionen der Helden (Angriff, Heilung usw.) und aktualisiert entsprechend den Zustand der Feinde

            lebendeGegner = aktionenHelden(lebendeHelden, lebendeGegner,beutel): Bu satır, kahramanların eylemlerini işleyen fonksiyonu çağırır.
            Bu fonksiyon, kahramanların hareketlerini (saldırı, iyileşme vb.) işler ve sonuçlarına göre düşmanların durumunu günceller.
            */

            if (!beschworungGenutzt){ // wenn nicht beschworen gemacht ist geht rein
                if ((1..3).random()==3){ // nimmt das hier zufall
                    beschwoereHelfer( gegnerListe) // wenn ja ist add beschworenHelfer
                    beschworungGenutzt=true // dann ersetzt treu
                }else{
                    lebendeHelden = aktionenGegner(lebendeGegner, lebendeHelden)
                    lebendeHelden = helden.filter { it.isAlive() }.toMutableList()
                }

            }else {
                lebendeHelden = aktionenGegner(lebendeGegner, lebendeHelden)     // Wenn bereits zuvor zusätzliche Hilfe gerufen wurde, werden erneut die Aktionen der Feinde verarbeitet
                lebendeHelden = helden.filter { it.isAlive() }.toMutableList()   // Eğer daha önce ekstra yardım çağırılmışsa, yine düşmanların eylemleri işlenir
            }

            println("$YELLOW Runde $round beendet!$RESET")
            gameOver = gameOver(lebendeHelden, lebendeGegner, gameOver)
            /*
            gameOver = gameOver(lebendeHelden, lebendeGegner, gameOver): Diese Zeile überprüft, ob das Spiel beendet ist.
            Wenn alle Helden oder alle Feinde besiegt sind, endet das Spiel
             */
            round++
        }
        println("$YELLOW\n" +
                "  __                                              \n" +
                " (_  ._  o  _  |   |_   _   _  ._   _|  _ _|_   | \n" +
                " __) |_) | (/_ |   |_) (/_ (/_ | | (_| (/_ |_   o \n" +
                "     |                                            \n$RESET")

    }



private fun beschwoereHelfer(gegnerListe: MutableList<Gegner>) {


            println("Der $RED Drache $RESET beschwort einen $RED Babydrachen$RESET")
            gegnerListe.add(BabyDrache("Babydrache",150))
    }

    private fun gameOver(helden: MutableList<Held>, lebendeGegner: MutableList<Gegner>, gameOver: Boolean): Boolean {

        var gameOver1 = gameOver // wenn helden liste Empty Filtert wenn keiner in liste gibt dann gibt println gameOver ersetzte helden verloren und game over true ersetzt dann spiel beendet
        if (helden.isEmpty()) {
            println("$RED Unsere Helden haben versagt... Game Over :($RESET")
            gameOver1 = true
        } else if (lebendeGegner.isEmpty()){ // wenn obenen liste noch held gibt kommt hier und filtert gegner wenn kein gegner in liste dann prntln Helden gewonnen ersetzte true dann ganz oben game over true spiel beendet
            println("$BLUE Geschafft! Unsere Helden haben gewonnen! Game Over :) $RESET")
            gameOver1 = true
        }
        return gameOver1
    }


    private fun aktionenHelden(helden: MutableList<Held>, lebendeGegner: MutableList<Gegner>, beutel: Beutel): MutableList<Gegner> {
        var lebendeGegner1 = lebendeGegner
        var inputValid = false
        var beutelUsed = false

        for (held in helden) {  // For-Schleife: Für jeden held, wenn lebendeGegner1 leer ist, endet die Funktion mit der aktuellen Liste der Gegner
            // For Döngüsü: Her held (kahraman) için bir döngü başlatılır. Eğer lebendeGegner1 (
            // hayatta olan düşmanlar) boşsa, döngü sonlanır ve güncel düşman listesi döndürülür
            if (lebendeGegner1.isEmpty()){
                return lebendeGegner1
            }


            /*
            Entscheidung zwischen Aktion oder Beutelnutzung: Spieler können zwischen einer Aktion (zum Beispiel Angreifen) oder der Nutzung des beutel wählen.
            Beutelnutzung: Wenn der beutel nicht leer ist, können die Spieler etwas aus dem Beutel verwenden (zum Beispiel einen Heiltrank oder ein Vitamin).
            Heldenaktion: Wenn der beutel nicht genutzt wird, wählen die Spieler, welche Aktion ihr Held ausführen soll. Die möglichen Aktionen jedes Helden werden aufgelistet,
            und der Spieler wählt eine davon aus.

            Eylem veya Beutel Kullanımı Seçimi: Oyuncular, bir eylem yapmak (örneğin saldırmak) veya beutel (çanta) kullanmak arasında seçim yapabilirler.
            Beutel Kullanımı: Eğer beutel boş değilse, oyuncular çantadan bir şey kullanabilirler (örneğin, bir iyileşme iksiri veya bir vitamin).
            Kahraman Eylemi: Eğer beutel kullanılmazsa, oyuncular kahramanlarının hangi eylemi yapacağını seçerler.
            Her kahramanın yapabileceği eylemler listelenir ve oyuncu bu eylemlerden birini seçer.
             */
            inputValid = false
            var chooseActionOrBeutel = 1
            if(!beutelUsed){ // wenn die beutel 1 gewählt frag nicht wieder.
                println("$YELLOW Druecke 1 um eine Aktion auszuwaehlen oder 2  um dem Beutel zu nutzen $RESET ")
                chooseActionOrBeutel = readln().toInt()
            }
            if (chooseActionOrBeutel==2){

                if (!beutel.isEmpty()){ // wenn beutel leer ist nicht genutz werden wenn nicht leer ist
                    println("Bitte waehle dir etwas von dem Beutel aus")
                    println(beutel) // sehen wir hier beutel HeilTraenke und vitamine
                    var beutelChoose = readln().toInt()
                    if(beutelChoose==1){
                        beutel.heiltrankNutzen(held)
                    }else{
                        beutel.vitaminNutzen(held)
                    }
                    beutelUsed=true
                }

            }else{
                println("$BLUE${held.name}$RESET soll angreifen. Wähle die Attacke per Zahleneingabe aus!")

                while (!inputValid){ // Diese Schleife wiederholt sich, bis eine gültige Eingabe vom Benutzer erhalten wird.
                    // Die Variable inputValid startet als false und wird auf true gesetzt, sobald eine gültige Eingabe erfolgt.
                    // while (!inputValid){ ... }: Bu döngü, kullanıcıdan geçerli bir girdi alınana kadar devam eder.
                    // inputValid adında bir değişkenin değeri false olduğunda döngü başlar ve geçerli bir girdi alındığında true olarak ayarlanır.

                    var heroActions = held.getActionNames() //Ruft die Methode getActionNames() des held-Objekts auf, um eine Liste von Aktionen // held nesnesinin getActionNames() metodunu çağırarak, bu karakterin yapabileceği eylemlerin bir listesini alır.
                    for ( i in heroActions.indices){ // Diese Schleife geht durch jede Aktion in der Liste heroActions. heroActions.indices gibt den Index für jede Aktion in der Liste // Bu for döngüsü, heroActions listesindeki her bir eylemi numaralandırarak ekrana yazdırır. heroActions.indices listesindeki her index için döngü çalışır.
                        println("$BLUE${i + 1} ${heroActions[i]}$RESET") // Druckt jede Aktion und ihre entsprechende Nummer aus. Mit i + 1 beginnt die Nummerierung bei 1 // Her bir eylemi ve onun karşılık gelen numarasını yazdırır. i + 1 ile numaralandırma 1'den başlar
                    }

                    val choice = readln().toInt() // Fordert den Benutzer auf, eine Zahl einzugeben und konvertiert diese Eingabe in einen Integer // Kullanıcıdan bir sayı girmesini isteyerek, bu girdiyi tam sayıya (Int) çevirir.
                    if (choice > 0 && choice <= (heroActions.size)){ // Überprüft, ob die Eingabe des Benutzers gültig ist. Die Zahl ist gültig, wenn sie größer als 0 und kleiner oder gleich der Größe der heroActions-Liste ist
                                                                                                     // Kullanıcının girdiği sayının geçerli olup olmadığını kontrol eder. Sayı 0'dan büyük ve heroActions listesinin boyutundan küçük veya eşitse geçerlidir.
                        held.performAction(heroActions[choice-1], lebendeGegner1.last()) // Wenn eine gültige Auswahl getroffen wird, ruft es die Methode performAction des held-Objekts auf. Diese Methode nimmt die gewählte Aktion und ein Ziel (hier lebendeGegner1.last()) entgegen
                        // Geçerli bir seçim yapıldığında, held nesnesinin performAction metodunu çağırır. Bu metod, seçilen eylemi ve bir hedefi (burada lebendeGegner1.last()) alır.
                        inputValid = true      // Setzt die Variable inputValid auf true, wenn eine gültige Eingabe erfolgt ist, wodurch die Schleife beendet wird. Geçerli bir girdi alındığında inputValid değişkenini true olarak ayarlar, böylece döngü sona erer
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

        /*
        Die erste For-Schleife (for (held in lebendeHelden)) prüft jeden Held (held).
        Wenn der Held verflucht ist (held.isVerflucht), wird die Funktion held.fluch() aufgerufen

        İlk for döngüsü (for (held in lebendeHelden)) her bir kahramanı (held) kontrol eder.
        Eğer kahraman lanetlenmişse (held.isVerflucht), held.fluch() fonksiyonu çağrılır.
         */

        for (held in lebendeHelden){
            if (held.isVerflucht){
                held.fluch()
            }
        }
        /*
        Die zweite For-Schleife (for (g in gegner)) führt Aktionen für jeden Feindcharakter (g) aus.
        Wenn die Liste lebendeHelden1 leer ist, beendet die Funktion und gibt diese Liste zurück.

        İkinci for döngüsü (for (g in gegner)) her bir düşman karakteri (g) için aksiyonlar gerçekleştirir.
        Eğer lebendeHelden1 listesi boşsa, fonksiyon bu listeyi döndürür ve sona erer.
         */
        for (g in gegner) {
            if (lebendeHelden1.isEmpty()){
                return lebendeHelden1
            }

            inputValid = false

            println("$RED${g.name}$RESET greift an.")

            /*
            Die Schleife while (!inputValid) wiederholt sich, bis eine gültige Aktion ausgeführt wird.
            Wenn der Gegner ein Drache (Drachen) ist, wird eine zufällige Aktion ausgewählt (zwischen 1 und 5).
            Verschiedene Aktionen (performAction) sind für den Drachen definiert: "Feuer Ball", "Fluegelschlag", "Feueratem", "Heilender Feuer Stein", "Fluch".
            Wenn der Gegner kein Drache ist, wird eine andere Reihe von Aktionen ausgewählt: "Babyschrei", "Babypups", "Drachenmilch", "Fluegelschutz".

            while (!inputValid) döngüsü, geçerli bir aksiyon gerçekleştirilene kadar devam eder.
            Eğer düşman bir Drache (ejderha) ise, rastgele bir aksiyon seçilir (1'den 5'e kadar).
            Ejderha için farklı aksiyonlar (performAction) tanımlanmış: "Feuer Ball", "Fluegelschlag", "Feueratem", "Heilender Feuer Stein", "Fluch".
            Eğer düşman ejderha değilse, farklı bir dizi aksiyon seçilir: "Babyschrei", "Babypups", "Drachenmilch", "Fluegelschutz".
             */
            while (!inputValid){

                if (g is Drache){
                    val choice = (1..5).random()
                    if (choice==1){
                        g.performAction("Feuer Ball",lebendeHelden1.first())
                    }else if(choice==2){
                        g.performAction("Fluegelschlag",lebendeHelden1.first())
                    }else if(choice==3){
                        for (held in lebendeHelden){ // Hier ist jede lebendehelden kriegt flächen schaden.. //  tüm yasiyan kahramanlarin hepsine hasar ver..
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



