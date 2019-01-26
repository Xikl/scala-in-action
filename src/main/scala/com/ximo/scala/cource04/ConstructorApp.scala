package com.ximo.scala.cource04

/**
  *
  * @author xikl
  * @date 2019/1/26
  */
object ConstructorApp {

  def main(args: Array[String]): Unit = {
//    val person = new Person("zwz", 23)
//    println(person.name + person.age)
//
//    val person2 = new Person("rj", 22, "女")
//    println(person2.gender + person2.school + person2.age)

    val student = new Student("zwz", 12, "编程")
    println(student)
  }


}

// 主要构造器
class Person(val name: String, val age: Int) {

  println("构造方法开始")

  val school = "杭电"

  var gender: String = _

  println("person" + this.name + this.age)

  def this(name: String, age: Int, gender: String) {
    this(name, age)
    this.gender = gender
  }


  println("构造方法结束")

}

class Student(name: String, age: Int, var major: String) extends Person(name, age) {

//  override def toString: String = {
//    this.name + "," + this.age + "," + this.major
//  }

  override val school: String = "杭电2"


  println("学生构造器 start")
  this.major = "ss"
  println("学生构造器 end")

  override def toString = s"Student($major, $name, $age, $school)"
}


class Name(s: String) {
  private var _value: String = s

  def value: String = _value

  def value_=(newValue: String): Unit = _value = newValue

  //def value_=(newValue: String): Unit = _value = newValue
}
