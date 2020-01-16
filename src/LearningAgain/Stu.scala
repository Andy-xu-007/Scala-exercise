package LearningAgain


// 以下两种方法，优先使用隐式函数
class Stu(val name: String, val id: Int) extends Comparable[Stu] {
  override def compareTo(o: Stu): Int = {
    (this.id - o.id)
  }
  override def toString: String = s"name: $name, id: $id"
}

object MyPredef {
  implicit val stu2OrderStu = (stu: Stu) => new Ordered[Stu] {
    override def compare(that: Stu): Int = {
      (stu.id - that.id)
    }
  }

  implicit object OrderingMan extends Ordering[Man] {
    override def compare(x: Man, y: Man): Int = {
      x.age - y.age
    }

  }
}

class Man(val name: String, val age: Int) {
  override def toString: String = s"name: $name, id: $age"
}