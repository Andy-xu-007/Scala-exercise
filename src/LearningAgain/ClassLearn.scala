package LearningAgain

object ClassLearn {
  def apply() = {
    println(888)
  }
  def apply(x: Int) = {
    println(x)
  }
  def main(args: Array[String]): Unit = {
    ClassLearn()  // 必须加括号，apply方法才会被默认执行
    ClassLearn.apply  // 这两行代码等价，只有apply方法可以被直接执行
    ClassLearn(999)  // 允许有多个apply方法，但是参数个数不能一样
    ClassLearn.apply(100)

    val arr = Array(1,2,3,4)  // 没有new，就是object
    val arr1 = Array.apply(1,2,3,4)  // 和上面的一样，调用了默认的apply方法

    val s: Student = new Student
    s.age = 20
    s.faceValue = 888.88

    val BS = new BanSheng
    BS.printId

    // 多态：父类引用指向子类对象【接口指向实现类】，m调用的是User中的方法，即使在Abstract中有同样的方法
    val m: Abstract = new User
    m.run()
    m.breath()

    // 可以动态的增加trait
    val u = new User with TraitExample {
      override def exercise(): Unit = println("trait exercise true")
    }
    u.exercise()
    u.learn()

  }
}

class Student {
  val id: String = "u1001"
  var name: String = "老许"
  var age: Int = 18
  var faceValue: Double = 999.99
}

// 多个trait用with连接
class User extends Abstract with Trait {
  // 由于该方法没有定义实现，所以关键字override可以省略
  override def run(): Unit = {
    println("抽象重写")
  }

  // 即使已经定义了有实现的方法，仍然可以通过Ctrl + o 来选择目标方法重写
  // 关键字override不能省略
  override def breath(): Unit = {
    println("调皮")
  }

  override def fly(): Unit = {
    println("this is a trait")
  }
}
abstract class User1 extends Abstract

