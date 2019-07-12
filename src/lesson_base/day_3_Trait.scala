package lesson_base

// Trait不能传参
trait Read{
  def read(name:String)={
    println(s"&name is reading...")
  }
}

trait Listen{
  def listen(name:String)={
    println(s"&name is listening...")
  }
}

// 一个类继承多个Trait时，第一个关键字用extends，之后的用with
class Person_1() extends Read with Listen {

}

trait IsEquale{
  def isEqu(o:Any):Boolean
  def isNotEqu(o:Any):Boolean = !isEqu(o)
}

class Point(xx:Int,xy:Int)extends IsEquale {
  val x = xx
  val y = xy

  override def isEqu(o: Any): Boolean = {
    // 先判断是不是point的实例，然后再作为point的实例取出x
    o.isInstanceOf[Point]&&o.asInstanceOf[Point].x==this.x
  }
}

object day_3_Trait {
  def main(args: Array[String]): Unit = {
    /**
      * Trait中可以有方法体的实现或者方法体的不实现，类继承了Trait要实现Trait中没有实现的方法
      */
    val p = new Person_1()
    p.read("Andy")
    p.listen("Jessa")
    val p1 = new Point(1,2)
    val p2 = new Point(1,2)
    println(p1.isNotEqu(p2))
  }
}
