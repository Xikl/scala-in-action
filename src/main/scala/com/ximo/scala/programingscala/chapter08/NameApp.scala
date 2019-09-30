package com.ximo.scala.programingscala.chapter08

object NameApp extends App {

  class Name1(var value: String)

  class Name2(val value: String)

  class Name3(s: String){
    private var _value: String = s

    def value: String = _value

    /**
      * 通用写法 _= 可以转化为中缀表达式
      *
      * @param newValue
      */
    def value_=(newValue: String) : Unit = _value = newValue
  }



}
