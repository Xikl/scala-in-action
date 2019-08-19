package com.ximo.scala.programingscala.chapter07

import scala.io.Source

/**
  *
  *
  * @author xikl
  * @date 2019/8/19
  */
object RemoveBlanksApp {

  def apply(path: String, compressWithSpace: Boolean = false): Seq[String] = {
    val sources = Source.fromFile(path)
    try{
      val lines = sources.getLines().toSeq
      for {
        line <- lines
        if !line.matches("""^\s*$""")
        line2 = if (compressWithSpace) line replaceAll("\\s+", " ") else line
      } yield line2
    } finally {
      sources.close()
    }

  }

  def main(args: Array[String]): Unit = {
    for {
      path2 <- args
      (compress, path) =
      if (path2 startsWith "-")
        (true, path2.substring(1))
      else
        (false, path2)
      line  <- apply(path, compress)
    } println(line)
  }

}
