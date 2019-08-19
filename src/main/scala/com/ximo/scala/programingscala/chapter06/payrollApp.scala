package com.ximo.scala.programingscala.chapter06

/**
  *
  *
  * @author xikl
  * @date 2019/8/19
  */
object payrollApp extends App {

  case class Employee(name: String,
                      title: String,
                      annualSalary: Double,
                      taxRate: Double,
                      insurancePremiumsPerWeek: Double)

  val employees = List(
    Employee("Buck Trends", "CEO", 200000, 0.25, 100.0),
    Employee("Cindy Banks", "CFO", 170000, 0.22, 120.0),
    Employee("Joe Coder", "Developer", 130000, 0.20, 120.0)
  )

  /**
    * case class 的模式匹配
    *
    */
  val netPay = employees map {
    case e@Employee(_, _, annualSalary, taxRate, insurancePremiumsPerWeek) => {
      val net = (1.0 - taxRate) * (annualSalary / 52.0) -
        insurancePremiumsPerWeek
      (e, net)
    }
  }

  netPay foreach{case (e, net) => println(f" ${e.name+':'}%-16s $net%10.2f") }

  val report = (netPay foldLeft (0.0, 0.0, 0.0)) {
    case ((totalSalary, totalNet, totalInsurance), (e, net)) =>
      (totalSalary + e.annualSalary/52.0,
        totalNet + net,
        totalInsurance + e.insurancePremiumsPerWeek)
  }
  println("\n** Report:")
  println(f" Total Salary: ${report._1}%10.2f")
  println(f" Total Net: ${report._2}%10.2f")
  println(f" Total Insurance: ${report._3}%10.2f")




}
