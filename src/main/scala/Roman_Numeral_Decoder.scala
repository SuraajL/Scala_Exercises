import scala.collection.immutable.HashMap

object Roman_Numeral_Decoder extends App {
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
    println(decode("IX"))
}
