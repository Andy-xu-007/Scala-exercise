import java.sql.Date

/**
  * 1, Scala中定义在object中的变量，方法都是静态的,object相当于java中的单例对象，object, Trait不能传参，
  * 2, Scala中一行后的代码“；”可加可不加，会有分号推断机制，多行代码写在一行，需要分号
  * 3, a : Int 是变量的类型，可以写，也可以不写，不写会自动推断
  * 4，定义变量用var，常量用val
  * 5，class 可以传递参数，传参就有了默认的构造函数，类中的属性默认就有了getter,setter方法
  * 6, 重写构造，第一行要调用默认构造
  * 7, 当new一个class时，类中除了方法不执行，其他都执行，同一个包下，class的名称不能相同
  * 8， Scala中如果class和object的名称一致，那么这个class叫做这个object的伴生类，这个object叫做这个class的伴生对象，他们之间可以互相访问私有变量。
  * 9，private是私有参数的定义，外部不能访问
  * 10,递归函数需要指定函数的返回类型
  * 11，如果定义方法体可以一行搞定，那么方法体中的“{ ... } ”可以省略。等号也可以省略，省略之后无论方法体最后一行计算的结果是什么都会被放弃，返回Unit
  * 12，
  */

class Person(xname:String, xage:Int){
  val name = xname
  var age = xage
  var gender = 'm'
  /**
    * 重新构造
    */
  def this(yname:String, yage:Int, ygender:Char){
    this(yname,yage)   //  调用默认构造
    this.gender = ygender
  }

  //  参数含有默认参数
  def fun(a:Int=2,b:Int=3)={
    a*b
  }

  // 可变长参数
  def func(elems:String*)={
    for(elem<-elems){
      println(elem)
    }
  }

  // 匿名函数，可以加参数来传递
  val a = ()=>{
    println("hello world")
  }

  // 偏应用函数
  def showLog(date:Date,log:String)={
    println(date + log)
  }
  // val date = new Date()  // 调用java
  showLog(date,"aaa")
  showLog(date,"bbb")
  val fun1 = showLog(date:Date,_:String)  //  偏函数，变化的参数用下划线表示
  fun1("aaa")
  fun1("bbb")
  // 函数中的某个参数不变，另外的参数一致在变，可以这样写

  // 高阶函数
  /**
    * 函数的参数是函数
    * 函数的返回是函数
    * 函数参数和返回都是函数
    */
  def func1(a:Int,b:Int): Int ={
    a+b
  }
  def func2(s:String,f:(Int,Int)=>Int)={
    val result = f(100,200)
    s+"~"+result
  }
  func2("hello",func1)

  // 函数的返回是函数
  def fun5(a:Int,b:Int):(String,String)=>String ={
    val Result = a + b
    def fun6(s1:String,s2:String):String={
      s1+s2+Result
    }
    fun6
  }
  fun5(10,20)("hello","world")

  // 函数的参数和返回都是函数


  def showHello(): Unit ={
    println("hello world!" + test.score)  //  常量意义直接调用
  }
}


object test {
  val score = 200
  def main(args: Array[String]): Unit = {

    /**
      * if ... else
      */
      var a = 50
    if(a < 50){
      println("a 小于50" )
    }
    else if(a>=50 && a <= 400){
      println("a 大")
    }
    else{println("a 小")}

    /**
      * for
      * 1 to 10 操作符to操作，可以是1.to(10.2)， 步长是2，类似的操作符是until，唯一的区别是until不包括最后一位
      */
//    for(i <- 1 to 15 if(i%2==0)){
//      println(i)
//    }
    val result = for(i <- 1 to 50 if(i%5==0)) yield i
//      println(result)
//    result.foreach(x=>{
//      println(x)
//    })
//    result.foreach(println(_))
    result.foreach(println)
    // 以上三种是一样的

    val person = new Person("貂蝉",18)
    person.age = 20
    println(person.gender)

    val p1 = new Person("吕布",23,'d')
    println(p1.gender)

    /**
      * 变量 常量
      */
//    var a : Int = 100
//    a = 900
//    println(a)
  }
}
