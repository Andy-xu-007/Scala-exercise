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

  }
}
