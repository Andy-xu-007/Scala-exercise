package lesson_base

/**
  * 隐式转换，隐式值，隐式参数，隐式转换函数
  * 隐式转换函数只与函数的参数类型和返回类型有关，与函数名称无关，
  *     所以作用域内不能有相同的参数类型和返回类型的不同名称隐式转换函数
  * 隐式类不能定义在外面，
  */

class Animal(xname:String){
  def canFly()={
    println(s"$xname can fly ...")
  }
}

class Rabbit(yname:String){
  val name1 = yname
}

object day_7_implicit {

  implicit def RabbitToAnimal(r:Rabbit):Animal ={
    new Animal(r.name1)
  }

  def sysName(age:Int)(implicit name:String)={
    println(s"$name is a student, age = $age")
  }

  def main(args: Array[String]): Unit = {
    implicit val name:String = "Andy"
    // 同类型的参数不能有两个隐式值
    sysName(100)
    val rabbit = new Rabbit("rabbit")
    rabbit.canFly()

  }

}
