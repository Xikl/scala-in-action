### scala-in-action
#### tarit
- 第一个 trait 用extends 剩下的用 with
```scala
class SparkConf(loadDefaults: Boolean) 
      extends Cloneable 
      with Logging 
      with Serializable 
```
#### Scala 允许我们把参数列表两边的圆括号替换为花括号
```scala
  // Scala 允许我们把参数列表两边的圆括号替换为花括号 牛逼
  shape.draw(Point(1.0, 2.0))(str => println(s"Drawing $str"))
  // 大括号
  shape.draw(Point(1.0, 2.0)){str => println(s"Drawing $str")}
```
#### scala 类型推断
在实际编程中，你在以下情况中必须提供显式的类型注解。
- 声明了可变的 var 变量或不可变的 val 变量，没有进行初始化。（例如，在类中的
抽象声明，如 val book: String, var count: Int ）。
- 所有的方法参数（如 def deposit(amount: Money) = {…} ）。
- 方法的返回值类型，在以下情况中必须显式声明其类型。
- 在方法中明显地使用了 return （即使在方法末尾也是如此）。
- 递归方法。
- 两个或多个方法重载（拥有相同的函数名），其中一个方法调用了另一个重载方
法，调用者需要显式类型注解。
- Scala 推断出的类型比你期望的类型更为宽泛，如 Any 。
#### 使用sealed 也可以用final来进行限制派生
#### Java 使用尖括号（ <…> ），而 Scala 使用方括号（ […] ），因为在 Scala 中 < 和 > 
```scala
val strings: List[String] = List("aa", "bb", "cc")
```
###$ +A 和 -A
A 之前的 + 表示：如果 B 是 A 的子类，则 List[B] 也是 List[A] 的子类型，这被称为
协类型。协类型很符合直觉，如果我们有一个函数 f(list: List[Any]) ，那么传递
List[String] 给这个函数，也应该能正常工作。
如果类型参数前有 -，则表示另一种关系：如果 B 是 A 的子类型，且 Foo[A] 被声明为
Foo[-A] ，则 Foo[B] 是 Foo[A] 的父类型（称为逆类型）。
#### type 类型成员 和 Example[String]的区别
```scala
abstract class BaseExample{
  type In
  
  val name: In
}

abstract class BaseExample1[In] {
  val name: In
}
```
#### 斯巴达式写法
```scala
  def isEven(n: Int): Boolean = (n % 2) == 0
  // 语言话 “斯巴达式”（斯巴达式，指的是非常简洁的方式）
  List(1, 2, 3, 4) filter isEven foreach println
  // 链式调用
  List(1, 2, 3, 4).filter(isEven).foreach(println)
  // 当然还有写明参数的
  List(1, 2, 3, 4).filter((i: Int) => isEven(i)).foreach((i: Int) => println(i))
  List(1, 2, 3, 4).filter(i => isEven(i)).foreach(i => println(i))
```
#### yielding
```scala
 val dogBreeds = List("Doberman", "Yorkshire Terrier", "Dachshund",
    "Scottish Terrier", "Great Dane", "Portuguese Water Dog")
  // for yielding 收集操作
  // scala中不成为的规定 多个if的时候 用 {} 单个的时候用 （）
  val newBreeds = for {
    breed <- dogBreeds
    if breed.contains("Dog") || breed.startsWith("D")
  } yield breed
```