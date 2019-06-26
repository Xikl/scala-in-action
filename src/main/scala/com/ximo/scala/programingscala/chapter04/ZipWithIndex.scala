package com.ximo.scala.programingscala.chapter04

/**
  *
  *
  * @author xikl
  * @date 2019/6/26
  */
object ZipWithIndex {

  val itemsCosts = Seq(("Pencil", 0.52), ("Paper", 1.35), ("Notebook", 2.43))
  // Seq[((String, String), Int)] = List(((a,sss),0), ((b,ddd),1))
  val itemsCostsIndices = itemsCosts.zipWithIndex

  for (itemsCostsIndex <- itemsCostsIndices) {
    itemsCostsIndex match {
      case ((item, cost), index) => println(s"$index: $item costs $cost each")
    }
  }

}
