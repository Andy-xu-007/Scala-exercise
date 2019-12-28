package LearningAgain

/**
 * 1，子类中的方法要覆盖父类中的方法，必须写override（参见foo）
 * 2，子类中的属性val要覆盖父类中的属性，必须写override（参见nameVal）
 * 3，父类中的变量不可以覆盖（参见nameVar）
 * 4，抽象类中可以不用写override
 * 5，钻石结构的类继承，override的作用就体现出来了
 */

object OverRide {
  def main(args: Array[String]): Unit = {
    val b1: classB = new classB
    println(b1.foo)
    println(b1.nameVAL)
    println(b1.nameVAR)
    println(" * * * ")

    val b2:classA = new classB
    println(b2.foo)
    println(b2.nameVAL)
    println(b2.nameVAR)

    b2.nameVAR = "c"
    println(b2.nameVAR)


    val kittyDog = new Cat with Dog
    println(kittyDog.talk)
    val monkeyCat = new MonkeyCat
    println(monkeyCat.talk)

    /**
     * I am Dog
     * I am monkeyCat
     */

  }

  class classA {
    val nameVAL = "A"
    var nameVAR = "A"

    def foo:String = {
      "classA.foo"
    }
  }

  class classB extends classA {
    override val nameVAL = "B"
    override def foo:String = {
      "classB.foo"
    }
  }



  trait T {
    def foo:String
    def bar:String
  }
  // class TB对trait T中的两个成员都要定义，但是不需要加override
  class TB extends T {
    def foo:String = {
      "TB.foo"
    }
    def bar:String = "TB.bar"
  }
  // 不需要全部成员都定义
  trait TT extends T {
    def bar:String = "TT.bar"
  }
  // 不需要全部成员都定义
  class TTB extends TT {
    def foo: String = "TT.foo"
  }


  trait Animal {
    def talk: String
  }
  trait Cat extends Animal {
    def talk: String = "I am Cat"
  }
  trait Monkey extends Animal {
    def talk: String = "I am monkey"
  }
  trait Dog extends Animal {
    override def talk: String = "I am Dog"
  }

  class MonkeyCat extends Monkey with Cat {
    override def talk: String = "I am monkeyCat"
  }


  class Person(val age : Int){
    val name = "no name"
  }

  class XiaoMing(age: Int, override val name: String) extends Person(age){

  }


}
