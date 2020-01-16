package LearningAgain


// 上下文界定也是为了实现Scala的隐式转换，需要传入一个隐式的object
class GeneralityUpDown[T : Ordering] {
  def bigger(x: T, y: T): T = {
    // implicitly 将Ordering 和T 关联在一起
    val ord = implicitly[Ordering[T]]
    if(ord.gt(x, y)) x else y
  }
}

object GeneralityUpDown {
  def main(args: Array[String]): Unit = {
    import MyPredef.OrderingMan
    val p = new GeneralityUpDown[Man]
    val pair = p.bigger(new Man("andy", 18), new Man("Cammie", 20))
    println(pair)
  }
}
