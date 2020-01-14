package LearningAgain

object WordCount {
  def main(args: Array[String]): Unit = {
    val lines = List("hello andy hello athena", "hello cammie hello bill", "hello andy hello fly")

    // Map + 压平 另一种写法flatMap(_.split(" "))
    val words: List[String] = lines.flatMap(line => line.split(" "))
    // 每个单词标记为1
    val wordAndOne: List[(String, Int)] = words.map(word => (word, 1))
    // 对单词分组
    val wordAndGroup: Map[String, List[(String, Int)]] = wordAndOne.groupBy(t => t._1)
    // 统计单词数量  另一种写法：mapValues(x => x.size) 默认k, v中的v是list
    val WordAndCount: Map[String, Int] = wordAndGroup.map(group => (group._1, group._2.size))
    // 排序
    val WordCountToList = WordAndCount.toList.sortBy(word => word._2).reverse
    println(WordCountToList)
    val linesUnion = lines.map(line => line.split(" ")).flatten.map(word => (word, 1))
      .groupBy(tp => tp._1).map(t => (t._1, t._2.size)).toList.sortBy(group => group._1).reverse
    println(linesUnion)
    // 2.13 mapValues => view.mapValues
    val linesUnion2 = lines.flatMap(_.split(" ")).map((_, 1)).groupBy(_._1)
      .view.mapValues(_.size).toList.sortBy(_._1)
    println(linesUnion2)
  }
}
