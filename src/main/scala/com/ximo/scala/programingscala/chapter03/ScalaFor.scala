package com.ximo.scala.programingscala.chapter03

import java.time.LocalDate
import java.util.concurrent.TimeUnit

import java.time.DayOfWeek

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
  for (breed <- dogBreeds if breed.contains("Dog")) {
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

  val dogBreedsOptional = List(Some("Doberman"), None, Some("Yorkshire Terrier"))

  /**
    * 当你尝试从 None 对象中提取对象时难道不会抛出异常吗？的确如此，不过由于此时
    * 推导式会进行有效地检查并忽略 None ，因此不会有异常抛出。这正如我们在第二行代码之
    * 前增加了显式的 if breedOption != None 。
    *
    */
  println("first pass")

  for {
    breedOption <- dogBreedsOptional
    breed <- breedOption
    upCasedBreed = breed.toLowerCase
  } print(upCasedBreed)

  /**
    * 第二个 for 推导式使用了模式匹配，这使得代码更为清新。只有当 BreedOption 是 Some 类
    * 型时，表达式 Some(breed) <- dogBreeds 才会成功执行并提取出 breed ，所有操作一步完
    * 成。 None 元素不再被处理。
    *
    */
  println("second pass:")
  for {
    Some(breed) <- dogBreedsOptional
    upCasedBreed = breed.toUpperCase
  } println(upCasedBreed)

  import java.util.Calendar

  def isFridayThirteen(cal: Calendar): Boolean = {
    val dayOfWeek = cal.get(Calendar.DAY_OF_WEEK)
    val dayOfMonth = cal.get(Calendar.DAY_OF_MONTH)
    (dayOfWeek == Calendar.FRIDAY) && (dayOfMonth == 13)
  }

  /**
    * java8 下
    *
    * @param localDate
    * @return
    */
  def isFridayThirteen(localDate: LocalDate): Boolean = {
    val dayOfWeek = localDate.getDayOfWeek
    val dayOfMonth = localDate.getDayOfMonth
    dayOfWeek.equals(DayOfWeek.FRIDAY) && (dayOfMonth == 13)
  }

  while (!isFridayThirteen(Calendar.getInstance())) {
    println("牛逼")
    TimeUnit.SECONDS.sleep(24 * 60 * 60)
  }

  var count = 0
  do {
    count += 1
    println(count)
  } while (count < 10)


}
