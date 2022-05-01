object Recursion{
  def main(args: Array[String]): Unit = {
    def loop (acc: Int = 0):Unit = {
      if acc<10 then {
        println(acc)
        loop(acc+1)
      }
    }
    loop()
  }
}
