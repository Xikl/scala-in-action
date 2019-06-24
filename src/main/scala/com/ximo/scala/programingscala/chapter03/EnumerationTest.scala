package com.ximo.scala.programingscala.chapter03

/**
  *
  *
  * @author xikl
  * @date 2019/6/24
  */
class EnumerationTest {


  object Breed extends Enumeration {
    type Breed = Value

    val doberman = Value("Doberman Pinsche")
    val yorkie = Value("Yorkshire Terrier")
    val scottie = Value("Scottish Terrier")
    val dane = Value("Great Dane")
    val portie = Value("Portuguese Water Dog")
  }

  import Breed._

  // Values 方法
  // 有一个ID???
  println("ID\tBreed")
  for (breed <- Breed.values) println(s"${breed.id}\t$breed")
  Breed.values.foreach(breed => println(s"${breed.id}\t$breed"))

  // 另一种写法
  Breed.values filter (_.toString.startsWith("D")) foreach println

  def isTerrier(breed: Breed): Boolean = breed.toString.endsWith("Terrier")

  println("\nTerriers Again??")
  Breed.values filter isTerrier foreach println
}
