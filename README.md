### scala-in-action
#### tarit
- 第一个 trait 用extends 剩下的用 with
```scala
class SparkConf(loadDefaults: Boolean) 
      extends Cloneable 
      with Logging 
      with Serializable 
```