package com.ximo.scala.programingscala.chapter09

object ObserverApp {

  trait Observer[-State] {
    def receiveUpdate(state: State): Unit
  }

  trait Subject[State] {
    private var observers: List[Observer[State]] = Nil

    def addObserver(observer: Observer[State]): Unit = {
      observers = observer :: observers
    }

    /** 通知 */
    def notifyObservers(state: State): Unit = {
      observers foreach (_.receiveUpdate(state))
    }

    // trait 类比 java8的接口，默认方法
//    trait PureAbstractTrait {
//      def abstractMember(str: String): Int
//    }
    // 包含未实现的类 必须要有 obstruct 的关键字
//    abstract class AbstractClass {
//      def concreteMember(str: String): Int = str.length
//      def abstractMember(str: String): Int
//    }

  }


}
