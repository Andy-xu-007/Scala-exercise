package LearningAgain

import scala.util.matching.Regex

object Parameter {
  def main(args: Array[String]): Unit = {
    def compute(input: Int) =
      if (input > 0)
        Right(math.sqrt(input))
      else
        Left("Error computing, invalid input")

    def displayResult(result: Either[String, Double]): Unit = {
      println(s"Raw: $result")
      result match {
        case Right(value) => println(s"result $value")
        case Left(err) => println(s"Error: $err")
      }
    }
    displayResult(compute(-4))

    val pattern: Regex = "(S|s)cala".r
    val str = "Scala is scalable language"
    pattern findAllIn str foreach println

    val arr = Array(1,7,6,4,5,3,9,4)
    // arr.par  已经被取消了
    val f2 = new Function2[Int, Double, (Double, Int)] {
      def apply(v1: Int, v2: Double): (Double, Int) = {
        (v2, v1)
      }
    }
  }
}
