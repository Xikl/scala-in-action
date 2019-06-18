package com.ximo.scala.programingscala.chapter03

/**
  * if表达式判断
  *
  * @author xikl
  * @date 2019/6/19
  */
object AssignedIf {

  val configFile = new java.io.File("somefile.txt")
  val configFilePath: String = if (configFile.exists()) {
    configFile.getAbsolutePath
  } else {
    configFile createNewFile()
    configFile.getAbsolutePath
  }




}
