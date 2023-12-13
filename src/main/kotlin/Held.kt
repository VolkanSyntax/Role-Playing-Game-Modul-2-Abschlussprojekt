open class Held(val name: String, var hp: Int, val maxHp: Int, var isProtected: Boolean = false, var isVerflucht: Boolean = false)  {
                                               // maximal Limit nimmt maxHp

    fun takeDamage(damage: Int) {
                          // takeDamage ist auf deutsch schadenNehmen
        if(!isProtected){ // (!isProtected) <-- wenn ist kein  geschützt hat
            hp = (hp - damage).coerceAtLeast(0) // helden hp - hp zieht schaden und wenn gebliebene hp punkte  unter 0 wenn minus  ist gibt wieder diesem code .coerceAtleast wieder 0
            println("$BLUE$name$RESET erleidet $damage Schaden. Verbleibende HP: $hp")
        }else{
            println("$name erleidet keinen Schaden wegen dem Schutz")
        }
     /*
     .coerceAtLeast(0) =>
      if((hp - damage)<0){
      hp = 0
      }else{
      hp = (hp - damage)
      }
      */

    }


    /*
   Parametre:
Fonksiyon, varsayılan olarak 10'a ayarlanmış isteğe bağlı bir percent parametresini alır. Bu yüzde değeri daha sonra fonksiyonda kullanılacaktır.
Koşul:
if ((100 / maxHp * hp) > 20) koşulu, karakterin mevcut HP'sinin maksimum HP'sinin %20'sinden fazla olup olmadığını kontrol eder.
Lanetleme Mekanizması:
Koşul karşılanırsa, karakter "lanetlenmiş" olarak işaretlenir (isVerflucht=true).
Karakterin HP'si %90'a düşürülür (hp * 0.9), ancak bu, coerceAtLeast((maxHp * 0.2).toInt()) tarafından sınırlanır. Bu, karakterin HP'sinin asla maksimum HP'nin %20'sinin altına düşemeyeceği anlamına gelir.
Karakterin adı ve kalan HP'sini gösteren ilgili bir mesaj yazdırılır.
Dönüş Değeri:
Koşul karşılanmazsa, karakter "lanetlenmemiş" olarak işaretlenir (isVerflucht=false).
Özetle, fonksiyon, bir karakterin HP'sinin maksimum HP'sinin belirli bir yüzdesini aşıp aşmadığını kontrol eder. Eğer öyleyse, karakter lanetlenir ve HP'si %90'a düşürülür, ancak asla maksimum HP'nin %20'sinin altına düşmez. Aksi takdirde karakter lanetlenmez


     */
    //Das Habe Ich ChatGBT Genommen !!!
    fun fluch(percent: Int = 10){
        // parameter ist %10 prozent  eingegeben..
        if((100/maxHp*hp)>20){ // if rechnet akutellen hp zu seinen maxHp übeprüft ob dieses Verhältnis mehr als 20% beträgt.Wenn die Gesundheit des Helden mehr als 20% seiner maximalen Gesundheitspunkte beträgt, wird dieser Block ausgeführt.
            isVerflucht=true // Diese Zeile zeigt an, dass der Held verflucht ist (isVerflucht). Das heißt, der Fluch ist aktiv.
            hp= (hp*0.9).toInt().coerceAtLeast((maxHp*0.2).toInt())

            println("$BLUE$name$RESET erleidet einen Fluch.Verbleibende HP: $hp")
        }else{
            isVerflucht=false /* Wenn die Gesundheit des Helden weniger als 20% seiner
            maximalen Gesundheitspunkte beträgt, wird der else-Block ausgeführt und zeigt an,
            dass der Held nicht verflucht ist (isVerflucht=false).*/
        }

    }


    fun isAlive(): Boolean = hp > 0 // hp grosser als 0 dann ist er im leben gibt es true zurück



    fun heal(amount: Int) {
        hp = (hp + amount).coerceAtMost(maxHp) // sein hp mit heillen hp addition wenn sein hp über 100 überreicht wird wieder sein maxHp dass heisst wieder 100 HP
        println("$name heilt sich um $amount. HP: $hp")
    }
    /*
    .coerceAtMost(maxHp) =>
    if((hp + amount)>maxHp){
        hp = maxHp
    }else{
        hp = (hp + amount)
    }

     */

    open fun performAction(action: String, target: Gegner) {} // action und sein Ziel // birinde aksiyon aliyorsun target ise hedef kissini belirliyorsun..


    open fun getActionNames(): List<String>{ // da hier ruft action list oder actions namen // Kahramanlarin hareketlerini gösteren liste yada yapacagi eylemleri
        return emptyList()
    }

   open fun increaceAttacDamage(percent:Int){} // vitamine die funktion attacken schaden erhöht prozenten.. //  bu funksiyon yüzde olarak saldiri hasarini arttirmak icin kullaniliyor

    override fun toString(): String{ // zeigt das hier sein status name und hp
        return """
            Name: $name
            HP: $hp
        """.trimIndent()
    }



    val CYAN = "\u001B[36m"
    val RED = "\u001B[31m"
    val YELLOW = "\u001B[33m"
    val BLUE = "\u001B[34m"
    val RESET = "\u001B[0m"

}

