package com.ximo.scala.programingscala.chapter03

/**
  *
  *
  * @author xikl
  * @date 2019/6/19
  */
object ScalaFor {

  val dogBreeds = List("Doberman", "Yorkshire Terrier", "Dachshund",
    "Scottish Terrier", "Great Dane", "Portuguese Water Dog")

  for (breed <- dogBreeds) {
    println(breed)
  }

  // for 循环中添加 if的判断
  for (breed <- dogBreeds if breed.contains("Dog")){
    println(breed)
  }

  // for yielding 收集操作
  // scala中不成为的规定 多个if的时候 用 {} 单个的时候用 （）
  val newBreeds = for {
    breed <- dogBreeds
    if breed.contains("Dog") || breed.startsWith("D")
  } yield breed

  // for 循环里面 可以加一些 操作 upCasedBreed 是不可变的
  for {
    breed <- dogBreeds
    upCasedBreed = breed.toUpperCase()
  } println(upCasedBreed)

  // 12345678910
    for (i <- 1 to 10) print(i)

}
