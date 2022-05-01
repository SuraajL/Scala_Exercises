object Snail extends App {
  def snail(array: List[List[Int]]): List[Int] = {
    var snailArray = array
    var arrayLength = array.size
    var result = List[Int]()

    while (result.size < (array.size)*(array.size)){
      def topRowLoop (o: Int = 0):Unit = {
        if o<arrayLength then {
          result = result :+ snailArray(0)(o)
          topRowLoop(o+1)
        }
      }
      topRowLoop()
      snailArray = snailArray.patch(0, Nil, 1) //.patch updates array with (index, replacement, number of characters)

      if (result.size < (array.size)*(array.size)) { //piece of shit while loop doesnt come out after final element so need this if statement
        def rightColumnLoop(p: Int = 0): Unit = {
          if p < arrayLength - 2 then {
            result = result :+ snailArray(p)((arrayLength) - 1)
            snailArray = snailArray.updated(p, snailArray(p).patch(arrayLength - 1, Nil, 1))
            rightColumnLoop(p + 1)
          }
        }
        rightColumnLoop()

        def bottomRowLoop(q: Int = arrayLength): Unit = {
          if q > 0 then {
            result = result :+ snailArray(snailArray.size - 1)(q - 1)
            bottomRowLoop(q - 1)
          }
        }
        bottomRowLoop()
        snailArray = snailArray.patch(snailArray.size - 1, Nil, 1)

        def leftColumnLoop(r: Int = snailArray.size - 1): Unit = {
          if r >= 0 then {
            result = result :+ snailArray(r)(0)
            snailArray = snailArray.updated(r, snailArray(r).patch(0, Nil, 1))
            leftColumnLoop(r - 1)
          }
        }
        leftColumnLoop()
        arrayLength = snailArray.size
      }
    }

    result
  }
//  println(snail(List(List(1,2,3), List(4,5,6), List(7,8,9))))
  println(snail(List(List(1,2,3,1), List(4,5,6,4), List(7,8,9,7), List(7,8,9,7))))

}
