import scala.collection.immutable.HashMap

object Roman_Numeral_Encoder extends App {
    def encode(input: Int): String = {
      var romanMap = HashMap(1 -> "I", 5 -> "V", 10 -> "X" ,
        50 -> "L", 100 -> "C" , 500 -> "D", 1000 -> "M")
      var replaceMap = HashMap("IIII" -> "IV", "VIIII" -> "IX",
        "XXXX" -> "XL", "LXXXX" -> "XC", "CCCC" -> "CD", "DCCCC" -> "CM")
      var sum = input
      var convertedInput = ""
      val orderedKeySet = List(1000, 500, 100, 50, 10, 5, 1)

      for {
        i <- orderedKeySet
      } yield {
        while (sum >= i) {
          sum = sum - i
          convertedInput += romanMap(i)
        }
      }

      for {
        i <- replaceMap.keySet
      } yield {
        convertedInput = convertedInput.replaceAll(i, replaceMap(i))
      }

      convertedInput
    }
    println(decode(99))
}

//converts number to roman numeral equivalent
