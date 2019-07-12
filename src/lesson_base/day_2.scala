package lesson_base

object day_2 {
  def main(args: Array[String]): Unit = {
    /**
      * Array
      */
    val arr = Array(1,2,3,4,4,3,"hello")
    arr.foreach(println)
    for(elem<-arr){
      println(elem)
    }
    val arr1 = new Array[String](3)  //  长度是三个

    /**
      * list，有序，可以重复
      * map： 一对一
      * flatMap：一对多
      */
    val list = List(1,2,3)
    val list1 = List[Int](1,2,3)

    /**
      * set，无序，不重复
      */
    val set = Set[Int](1,2,3)
    val set1 = Set[Int](2,3,4)

    val result1 = set.intersect(set1)  // 取交集
    val result2 = set.diff(set1)  //  差集

    /**
      * map，如果有重复的键，则以最后出现的为准
      * map中每个元素就是一个二元组
      */
    val map = Map(1->"a",2->"b",(3,"c"))
    map.foreach(println)
    val value = map.get(2).get  //  取值,如果没有后面的.get，那么得到的是some(b)，因为返回的是Option类型，该类型有None和Some两种类型
    val value1 = map.get(20).getOrElse("xxxx")  //  有就正常返回，没有返回xxxx
    val key = map.keys  //  map中所有的keys
    val vlaue2 = map.values  //  map中的所有keys

    /**
      * tuple 元组,最多支持22个元素
      * 可以new，也可以不new
      * 没有foreach用法
      */
    val tuple = new Tuple5(1,2,3,"a",6) //  可以去掉new，甚至是Tuple
    val tuple2 = (1,2)
    println(tuple._4)  // 取第五个元素
    val iter = tuple.productIterator
    while(iter.hasNext){
      println(iter.next())
    }
    iter.foreach(println)
  }

}
