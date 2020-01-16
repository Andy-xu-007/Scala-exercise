package LearningAgain

// view bounds are deprecated,  replace with implicit parameters
class GeneralityView[T <% Comparable[T]] {
  def bigger(x: T, y: T): T = {
    if(x.compareTo(y) > 0) x else y
  }
}

class Generality_Implicit[T](implicit ev:T=> Comparable[T]) {
  def bigger(x: T, y: T): T = {
    if(x.compareTo(y) > 0) x else y
  }
}

object GeneralityView {

  def main(args: Array[String]): Unit = {
    val r = new GeneralityView[Int]
    val pair = r.bigger(3, 5)
    println(pair)

    val n = new Generality_Implicit[Int]()
    val pair2 = n.bigger(6,7)
    println(pair2)
  }
}