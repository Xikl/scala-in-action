package com.ximo.scala.programingscala.chapter05

/**
  *
  *
  * @author xikl
  * @date 2019/7/15
  */
object phantomTypes {

  sealed trait PreTaxDeductions

  sealed trait PostTaxDeductions

  sealed trait Final

  case class Employee(name: String,
                      annualSalary: BigDecimal,
                      taxRate: Float,
                      insurancePremiumsPerPayPeriod: BigDecimal,
                      _401kDeductionRate: BigDecimal,
                      postTaxDeductions: BigDecimal)

  case class Pay[Step](employee: Employee, netPay: BigDecimal)

  object Payroll {
    def start(employee: Employee): Pay[PreTaxDeductions] =
      Pay[PreTaxDeductions](employee, employee.annualSalary / 23.0)

    def minusInsurance(pay: Pay[PreTaxDeductions]): Pay[PreTaxDeductions] = {
      val newNet = pay.netPay - pay.employee.insurancePremiumsPerPayPeriod
      pay copy (netPay = newNet)
    }

    def minus401k(pay: Pay[PreTaxDeductions]): Pay[PreTaxDeductions] = {
      val newNet = pay.netPay - pay.employee._401kDeductionRate * pay.netPay
      // 拷贝方法 netPay和cass class 中定义的字段名一致
      pay copy (netPay = newNet)
    }

    def minusTax(pay: Pay[PreTaxDeductions]): Pay[PostTaxDeductions] = {
      val newNet = pay.netPay - pay.employee.taxRate * pay.netPay
      pay copy (netPay = newNet)
    }

    def minusFinalDeductions(pay: Pay[PostTaxDeductions]): Pay[Final] = {
      val newNet = pay.netPay - pay.employee.postTaxDeductions
      pay copy (netPay = newNet)
    }
  }

  def invoke1: Unit = {
    val e = Employee("Buck Trends", 100000, 0.25F, 200, 0.10, 0.05)
    val pay1 = Payroll.start(e)
    val pay2 = Payroll.minus401k(pay1)
    val pay3 = Payroll.minusInsurance(pay2)
    val pay4 = Payroll.minusTax(pay3)
    val pay5 = Payroll.minusFinalDeductions(pay4)
    val twoWeekGross = e.annualSalary / 26.0
    val twoWeekNet = pay5.netPay
    val percent = (twoWeekNet / twoWeekGross) * 100
    println(s"For ${e.name}, the gross vs. net pay every 2 weeks is:")
    println(f" $$$twoWeekGross%.2f vs. $$$twoWeekNet%.2f or $percent%.1f%%")
  }

  object Pipeline {

    implicit class toPiped[V](value: V) {
      def |>[R](f: V => R): R = f(value)
    }

  }

  import Pipeline._
  import Payroll._

  // todo
  def invoke2: Unit = {
    val e = Employee("Buck Trends", 100000, 0.25F, 200, 0.10, 0.05)
    val pay = start(e) |>
      minus401k |>
      minusInsurance |>
      minusTax |>
      minusFinalDeductions
    val twoWeekGross = e.annualSalary / 26
    val twoWeekNet = pay.netPay
    val percent = (twoWeekNet / twoWeekGross) * 100
    println(s"For ${e.name}, the gross vs. net pay every 2 weeks is:")
    println(f" $$$twoWeekGross%.2f vs. $$$twoWeekNet%.2f or $percent%.1f%%")
  }

  def main(args: Array[String]): Unit = {
    invoke1
    invoke2
  }

}
