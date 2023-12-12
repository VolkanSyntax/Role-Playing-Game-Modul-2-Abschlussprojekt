import kotlin.math.roundToInt
class Beutel {

    // Beutel soll
    // 3 Heiltränke
    var anzahlHeiltraenke: Int = 3
    // 1 Vitamin
    var anzahlVitamin: Int = 1
    // haben.


    // Heiltrank nutzen Methode

    fun heiltrankNutzen(target: Held){
        // schauen ob noch Heiltränke da sind
        if (anzahlHeiltraenke > 0) {
            // benutzen = ein Held bekommt 20%
            target.heal((target.maxHp / 2).toInt())
            // benutzten Heiltrank wegschmeißen
            anzahlHeiltraenke--

        }

    }

    fun vitaminNutzen(target: Held){
        // schauen ob noch Heiltränke da sind
        if (anzahlVitamin > 0) {
            // benutzen = ein Held bekommt 20% mehr HP
            target.increaceAttacDamage(10)
            // benutzten Heiltrank wegschmeißen
            anzahlVitamin--
        }
    }


    fun isEmpty(): Boolean {
        if(anzahlVitamin==0&&anzahlHeiltraenke==0){
            return true
        }else{
            return false
        }

    }

    override fun toString(): String{
        return """
            1) Heltraenke (Anzahl $anzahlHeiltraenke)
            2) Vitamine: (Anzahl $anzahlVitamin)
        """.trimIndent()
    }




}