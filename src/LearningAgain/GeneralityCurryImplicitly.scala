package LearningAgain

import jdk.nashorn.api.scripting.ScriptUtils

/**
 * 使用curry化结合隐式参数，实现隐式转换
 */
class GeneralityCurryImplicitly[T] {
  def choose(x: T, y: T)(implicit ev: T => Ordered[T]): T = {
    if(x >= y) x else y
  }

  /**
   * 使用curry化结合隐式参数，需要传入一个object
   * 这样可以实现上下文界定
   */
  def select(x: T, y: T)(implicit ord: Ordering[T]): T ={
    if(ord.gteq(x, y)) x else y
  }

}

object GeneralityCurryImplicitly {
  def main(args: Array[String]): Unit = {
    import MyPredef.stu2OrderStu
    import MyPredef.OrderingMan
    val p = new GeneralityCurryImplicitly[Stu]
    val pair = p.choose(new Stu("Bill", 22), new Stu("Kenney", 24))
    println(pair)

    val q = new GeneralityCurryImplicitly[Man]
    val pair2 = q.select(new Man("Fly", 28), new Man("Shrek", 30))
    println(pair2)
  }
}
