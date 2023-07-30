package retcalc

import scala.math.pow


class RetCalc {

  def futureCapital(interestRate: Float, nbOfMonths: Short,
    netIncome: Int, currentExpenses: Int,
    initialCapital: Int): Double = {
      val savings = netIncome - currentExpenses
      val finalValue = initialCapital + savings  * pow(1 + interestRate, nbOfMonths)

      return finalValue
  }
}
