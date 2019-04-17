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