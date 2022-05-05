import scala.collection.immutable.HashMap

class Roman_Numeral_Class extends App {
  def decode(input: String): Int = {
    var romanMap = HashMap("I" -> 1, "V" -> 5, "X" -> 10,
      "L" -> 50, "C" -> 100, "D" -> 500, "M" -> 1000)
    var replaceMap = HashMap("IV" -> "IIII", "IX" -> "VIIII",
      "XL" -> "XXXX", "XC" -> "LXXXX", "CD" -> "CCCC", "CM" -> "DCCCC")
    var sum = 0
    var convertedInput = input
    for {
      i <- replaceMap.keySet
    } yield {
      convertedInput = convertedInput.replaceAll(i, replaceMap(i))
    }
    println(convertedInput)

    for {
      i <- convertedInput.split("")
    } yield {
      sum = sum + romanMap(i)
    }
    sum
  }

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

}

object Roman_Numeral extends App {
  val romanNumeral = new Roman_Numeral_Class
  println(romanNumeral.encode(9))
}
