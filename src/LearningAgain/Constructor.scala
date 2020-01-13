package LearningAgain

/**
 * 主构造器中的参数如果不用var或者val修饰，那么就不会成为这个类的成员变量（相当于类内部的一个变量 ），
 *    和private[this]的区别是：private[this]修饰的参数可以被派生类继承，只是不能使用
 *  class User private( . . . ) { . . . } 构造器私有，只有伴生对象可以用
 *
 */

class Constructor(val name:String,
                  private var id:Int,
                  private[this] var age:Int) {
  def getAge = {
    age
  }

  var gender = "男"
  var y = "2020"
  // 辅助构造器是对主构造器的扩展，不加val或var
  def this(name:String,
            id:Int,
            age:Int,
            gender: String,
           year:String)= {
    // 辅助构造器第一行必须调用主构造器或其他辅助构造器
    this(name, id, age)
    this.gender = gender
    this.y = year

  }

}

object Constructor {
  def main(args: Array[String]): Unit = {
    val c = new Constructor("andy", 27, 18)

    println(c.name)
    println(c.id)
    println(c.getAge)
    println(c.y)
    println(c.gender)  // 男

    val c1 = new Constructor("bill", 34, 98, "man", "2048")
    println(c.gender)  // man
  }
}
