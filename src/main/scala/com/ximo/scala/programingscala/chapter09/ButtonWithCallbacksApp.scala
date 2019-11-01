package com.ximo.scala.programingscala.chapter09

import com.ximo.scala.programingscala.chapter09.ObserverApp.{Observer, Subject}

object ButtonWithCallbacksApp extends App {

  /**
    * weight作为一个标记
    */
  abstract class Widget

  class ButtonWithCallbacks(val label: String,
                            val callbacks: List[() => Unit] = Nil) extends Widget {
    def click(): Unit = {
      updateUi();
      callbacks.foreach(f => f())
    }

    protected def updateUi(): Unit = {
      /* something */
    }
  }

  object ButtonWithCallbacks {
    def apply(label: String, callback: () => Unit) =
      new ButtonWithCallbacks(label, List(callback))

    def apply(label: String) =
      new ButtonWithCallbacks(label, Nil)

  }

  class Button(val label: String) extends Widget {
    def click(): Unit = updateUI()

    def updateUI(): Unit = {}
  }

  class ObservableButton(name: String) extends Button(name) with Subject[Button] {
    override def click(): Unit = {
      super.click()
      notifyObservers(this)
    }
  }

  // 观察者
  class ButtonCountObserver extends Observer[Button] {
    var count = 0
    def receiveUpdate(state: Button): Unit = count += 1
  }
  // 可观察的对象 Subject
  val button = new ObservableButton("Click Me!")
  // 观察者
  val bco1 = new ButtonCountObserver
  // 观察者
  val bco2 = new ButtonCountObserver
  // 添加订阅者
  button addObserver bco1
  // 添加订阅
  button addObserver bco2
  // 触发事件
  (1 to 5) foreach (_ => button.click())
  assert(bco1.count == 5)
  assert(bco2.count == 5)



}
