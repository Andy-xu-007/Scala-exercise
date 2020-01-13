package Test

object test {
  def main(args: Array[String]) = {
    var sign = 0
    val ch = List("andy", "bill", "Kenney", "hake")

    ch match {
      //case '+' => sign = -1
      //case '_' => sign = 1
      case _ if sign == 3 => sign = 3
      //case c:Char => "Char: " + c
       case List("andy", "bill", otherResult @ _*) => println(otherResult)
      case _ => sign = 2

    }
    println(sign)

  }
}
