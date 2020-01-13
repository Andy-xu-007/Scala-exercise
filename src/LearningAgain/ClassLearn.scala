package LearningAgain

object ClassLearn {
  def main(args: Array[String]): Unit = {
    val s: Student = new Student

    s.age = 20
    s.faceValue = 888.88

    val BS = new BanSheng
    BS.printId

  }
}

class Student {
  val id: String = "u1001"
  var name: String = "老许"

  var age: Int = 18
  var faceValue: Double = 999.99
}

