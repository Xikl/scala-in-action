package com.ximo.scala.programingscala.chapter05

/**
  *
  *
  * @author xikl
  * @date 2019/7/8
  */
object ImplicitArgs extends App {


  def calcTax(amount: Float)(implicit rate: Float): Float = amount * rate

  object SimpleStateSalesTax {
    // 定一个隐式变量
    implicit val rate: Float = 0.05F
  }

  {
    import SimpleStateSalesTax.rate

    val amount = 100F

    // 假如没有指定 隐式变量那么就要直接写明
    println(s"Tax On $amount = ${calcTax(amount)}")
  }

  """
    |分割线
    |
    |
    |
  """.stripMargin



  case class ComplicatedSalesTaxData(baseRate: Float,
                                     isTaxHoliday: Boolean,
                                     storeId: Int)

  object ComplicatedSalesTax {
    private def extraTaxRateForStore(id: Int): Float = {
      id * 0.0F
    }

    /**
      * rate 需要一个ComplicatedSalesTaxData的类型对象
      *
      * @param cstd
      * @return
      */
    implicit def rate(implicit cstd: ComplicatedSalesTaxData): Float = {
      if (cstd.isTaxHoliday) 0.0f
      else cstd.baseRate + extraTaxRateForStore(cstd.storeId)
    }
  }

  {
    // rate 需要一个ComplicatedSalesTaxData的类型对象
    import  ComplicatedSalesTax.rate

    implicit val myStore: ComplicatedSalesTaxData = ComplicatedSalesTaxData(0.06F, isTaxHoliday = false, 1010)

    val amount = 100F
    println(s"tax on $amount = ${calcTax(amount)}")
  }

}
