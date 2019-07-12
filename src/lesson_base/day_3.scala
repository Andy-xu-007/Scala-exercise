package lesson_base




object day_3 {
  def main(args: Array[String]): Unit = {
    import scala.collection.mutable.Map
    val map = Map("a"->100, "b"->200,("c",300),("c",400))
    val map1 = Map("a"->1, "b"->2,("c",3),("c",4))
    val map2 = map.++(map1)  // 合并，后面替换前面的
    val map3 = map.++:(map1)  //  合并，前面替换后面
    map.put("d",400)

  }

}
