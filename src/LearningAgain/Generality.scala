package LearningAgain

// T是Comparable接口的子类
class Generality[T <: Comparable[T]] {
  def bigger(x: T, y: T): T = {
    if(x.compareTo(y) > 0) x else y
  }
}

/**
 * 在scala中有两个专门用来比较的trait，Ordered，Ordering
 * Ordered 实现了 Comparable接口， Ordered 对Comparable接口进行了扩展
 * Ordering 实现了 Comparator接口， Ordering 对 Comparator接口进行了扩展
 */
class Generality2[T <% Ordered[T]] {   // 该方法已弃用： Generality2[T](implicit ev: T => Ordered[T])
  def bigger(x: T, y: T): T = {
    if(x >= y) x else y  // 可以直接用类似的 >= 方法
  }
}

object Generality {
  import MyPredef.stu2OrderStu
  def main(args: Array[String]): Unit = {

    // Int 比大小，调用的是Java中的Integer，因为Scala中的Int没有compareTo方法
    val pair = new Generality[Integer]
    val i = pair.bigger(5, 8)
    println(i)

    // String 比大小，同样用的是Java中的compareTo
    val pair1 = new Generality[String]
    val n = pair1.bigger("andy", "tonny")
    println(n)

    // Int => Ordering[Int] => Ordered[Int]
    val m = new Generality2[Int]
    val pair2 = m.bigger(4,9)
    println(pair2)

    val h = new Generality2[Stu]
    val pair3 = h.bigger(new Stu("Andy", 18), new Stu("Athene", 24) )
    println(pair3)

    val p = new Generality2[Stu]

  }
}
