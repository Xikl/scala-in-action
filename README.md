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