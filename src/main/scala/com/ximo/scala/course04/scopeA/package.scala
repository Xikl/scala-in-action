package com.ximo.scala.course04

/**
  *
  * @author xikl
  * @date 2019/1/21
  */
package object scopeA {
  class PublicClass1 {

    val publicField = 1

    class Nested {
      val nestedField = 1
    }

    val nested = new Nested

  }

  class PublicClass2 extends PublicClass1 {

    val field2 = this.publicField + 1
    val nField2 = new Nested().nestedField

  }

}

package object scopeB{

  class PublicClass1B extends scopeA.PublicClass1{

      class UsingClass(val publicClass: scopeA.PublicClass1){

        def method = " UsingClass: " +
        " filed " + publicClass.publicField +
        " nested field " + publicClass.nested.nestedField
      }

  }

}
