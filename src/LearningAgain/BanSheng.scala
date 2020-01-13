package LearningAgain

private[LearningAgain] class BanSheng {
  // 加了private只能在类的内部或伴生对象中访问
  private var name = "tom"

  // 加了private[this]，只能在内部使用
  private[this] var pet: String = "小强"

  def printPet = {
    println(pet)
  }

  def printId = {
    println(BanSheng.id)
  }
}

object BanSheng {
  val nation = "china"
  private val id = 18
  def main(args: Array[String]): Unit = {
    val u = new BanSheng

    println(u.name)
    println(nation)
    println(BanSheng.id)
    u.printPet

  }
}

