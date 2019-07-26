package com.ximo.scala.programingscala.chapter06


object HofsClosure3Example {

  // 将函数定义为一个方法或者 一个属性 都ok
  {
    val factor = 2

    val multiplier = (i: Int) => i * factor
    println(multiplier(2))
  }

 {
   // 放在一个类中
   object MultiplierContext {
     var factor = 2
     def multiplier(i: Int) = i * factor

   }

   (1 to 10) filter (_ % 2 == 0) map MultiplierContext.multiplier product

   MultiplierContext.factor = 3

   (1 to 10) filter (_ % 2 == 0) map  MultiplierContext.multiplier product

 }



}
