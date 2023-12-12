open class Held(val name: String, var hp: Int, val maxHp: Int, var isProtected: Boolean = false, var isVerflucht: Boolean = false)  {
                                               // maximal Limit nimmt maxHp

    fun takeDamage(damage: Int) {  // takeDamage ist auf deutsch schadenNehmen
        if(!isProtected){ // (!isProtected) <-- wenn ist kein  geschützt hat
            hp = (hp - damage).coerceAtLeast(0) // helden hp - hp zieht schaden und wenn gebliebene hp punkte  unter 0 wenn minus  ist gibt wieder diesem code .coerceAtleast wieder 0
            println("$name erleidet $damage Schaden. Verbleibende HP: $hp")
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
    fun fluch(percent: Int = 10) { ... }:
Bu satır, fluch adında bir fonksiyon tanımlıyor. Bu fonksiyon, bir yüzdelik parametre alıyor
(percent) ve bu parametrenin varsayılan değeri %10.
fluch fonksiyonu, bir kahramanın (Held) üzerindeki laneti yönetmek için kullanılıyor.
if((100/maxHp*hp)>20) { ... }:
Bu if ifadesi, kahramanın mevcut sağlık puanlarının (HP) maksimum sağlık puanlarına
(maxHp) oranını hesaplıyor ve bu oranın `%20'den fazla olup olmadığını kontrol ediyor.
Eğer kahramanın sağlığı toplam sağlık puanlarının `%20'sinden fazlaysa, bu blok çalışıyor.
isVerflucht=true:
Bu satır, kahramanın lanetlenmiş (isVerflucht) olduğunu belirtiyor. Yani lanet aktif hale geliyor.
hp= (hp*0.9).toInt().coerceAtLeast((maxHp*0.2).toInt()):
Bu satır, kahramanın mevcut sağlık puanlarını `%10 azaltıyor.
Örneğin, eğer kahramanın 100 HP'si varsa, bu, HP'sini 90'a indiriyor.
.coerceAtLeast((maxHp*0.2).toInt()) bölümü, sağlık puanlarının toplam sağlık puanlarının
%20'sinden daha düşük olmamasını sağlıyor. Yani, eğer bu hesaplama sonucu
HP %20'nin altına düşecekse, HP otomatik olarak `%20'ye ayarlanıyor.
println("$name erleidet einen Fluch.Verbleibende HP: $hp"):
Bu satır, kahramanın ismini ve kalan sağlık puanlarını ekrana yazdırıyor.
Bu, kahramanın lanetlendiğini ve kalan HP'sini gösteriyor.
else { isVerflucht=false }:
Eğer kahramanın sağlığı toplam sağlık puanlarının %20'sinden azsa,
else bloğu çalışıyor ve bu, kahramanın lanetlenmediğini (isVerflucht=false`) belirtiyor.


     */
    fun fluch(percent: Int = 10){ // parameter ist %10 prozent  eingegeben..
        if((100/maxHp*hp)>20){ // if rechnet akutellen hp zu seinen maxHp übeprüft ob dieses Verhältnis mehr als 20% beträgt.Wenn die Gesundheit des Helden mehr als 20% seiner maximalen Gesundheitspunkte beträgt, wird dieser Block ausgeführt.
            isVerflucht=true // Diese Zeile zeigt an, dass der Held verflucht ist (isVerflucht). Das heißt, der Fluch ist aktiv.
            hp= (hp*0.9).toInt().coerceAtLeast((maxHp*0.2).toInt())             /* hp= (hp*0.9).toInt().coerceAtLeast((maxHp*0.2).toInt()):
                                                                                   Diese Zeile verringert die aktuellen Gesundheitspunkte des Helden um 10%. Zum Beispiel,
                                                                                   wenn der Held 100 HP hat, wird es auf 90 reduziert.
                                                                                   Der Teil .coerceAtLeast((maxHp*0.2).toInt()) stellt sicher, dass die Gesundheitspunkte nicht unter
                                                                                   20% der maximalen Gesundheitspunkte fallen. Wenn diese Berechnung zu einem HP-Wert führt, der unter 20% liegt,
                                                                                   wird das HP automatisch auf 20% eingestellt. */
            println("$name erleidet einen Fluch.Verbleibende HP: $hp")
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

   open fun increaceAttacDamage(percent:Int){} // die funktion attacken schaden erhöht prozenten.. // bu funksiyon yüzde olarak saldiri hasarini arttirmak icin kullaniliyor

    override fun toString(): String{ // zeigt das hier sein status name und hp
        return """
            Name: $name
            HP: $hp
        """.trimIndent()
    }

}


