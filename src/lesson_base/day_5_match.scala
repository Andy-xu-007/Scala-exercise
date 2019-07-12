package lesson_base

/**
  * match 模式匹配
  * 1，case _什么都匹配不上，放在最后
  * 2，可以匹配值，还可以匹配类型
  * 3，匹配过程中会有数值的转换
  * 4，从上往下匹配，匹配上之后会自动终止
  * 5，模式匹配中，外部的“{}”可以省略
  */

object day_5_match {
  def main(args: Array[String]): Unit = {
    val tp = (1,2.0,"abc",'c',true)
    val iter = tp.productIterator
    iter.foreach(MatchTest)
  }

  def MatchTest(o:Any)={
    o match {
      case 1=>println("value is 1")
      case i:Int=>println(s"type is Int, value = $i")
      case _=>println("not match ... ")
    }
  }
  // 偏函数，只匹配一个值，匹配上了放回某值
  // PartialFunction[A,B]，A是匹配的类型，B是匹配上返回的类型
  def MyTest:PartialFunction[String,Int]={
    case "abc"=>2
    case "a" => 1
    case _ => 200
  }

}
