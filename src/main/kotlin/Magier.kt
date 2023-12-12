class Magier( name: String,  hp: Int): Held(name, hp, hp) {
    var attacDamage = 50 // Angriff Schaden // Saldiri hasari Karsi tarafa verilen
    var healAmount = 20 // Heilung Menge  // Kendisini iyilestirme miktari
    var attacDamage2 = 200 // Angriff Schaden2 // burda saldiri hasari 2 olarak verildi yüksek saldiri


    override fun performAction(action: String, target: Gegner) {  // action und sein Ziel Gengner // birinde aksiyon aliyorsun target ise hedef kissini belirliyorsun düsmani yani
        isProtected = false // Zu Beginn jeder Aktion wird der Schutzstatus des Charakters zurückgesetzt (standardmäßig ungeschützt) // Her aksiyon başında karakterin koruma durumu sıfırlanır (varsayılan olarak korumasız hale getirilir).
        when (action) {
            "ZauberSturm" -> target.takeDamage(attacDamage)
            "TodesZauber" ->{
                this.takeDamage(1000)   // das hier erst selber  schadet und danach sein gegner schadet (This. heisst selber)
                target.takeDamage(attacDamage2)
            }
            "HeilZauber" -> this.heal(healAmount) // hier heilt sich selber
            "ZauberSchild"->{
                println("$name nutzt den Schutzzauber.")
                isProtected = true // Der Charakter wechselt in den Schutzmodus (isProtected = true)
                                   // und der Zustand wird auf dem Bildschirm angezeigt // kullanilirsa karekter koruma moduna gecer ve durumu ekrana yazilir
                                   // bir sonraki düsman karisamaz sadece bir raund icin gecerli olacaktir ikinici sinde tekrar false olur

            }
            else -> super.performAction(action, target)
        }
    }
    override fun getActionNames(): List<String> {  // getAktions liste brauchen wir in main mein liste für Magier aktions ist  liste
        return listOf("ZauberSturm","TodesZauber","HeilZauber","ZauberSchild")
    }

    override fun increaceAttacDamage(percent:Int){  // das nutzen wir in beutel vitaminen z.B attackdamage ist 50  50 teilen / 100 = 0,5   0.5 * 10 = 5 .toInt
        attacDamage += (attacDamage/100*percent).toInt()
    }

}