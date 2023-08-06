package retcalc

import org.scalactic.{Equality, TolerantNumerics, TypeCheckedTripleEquals}
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class RetCalcSpec extends AnyWordSpec with Matchers with TypeCheckedTripleEquals {

  implicit val doubleEquality: Equality[Double] =
    TolerantNumerics.tolerantDoubleEquality(0.0001)

  "RetCalc.futureCapital" should {
    "calculate the amount of savings I will have in n months" in {
      val retCalc = new RetCalc()
      val actual = retCalc.futureCapital(
        interestRate = 0.04.toFloat / 12, nbOfMonths = 25 * 12,
        netIncome = 3000, currentExpenses = 2000,
        initialCapital = 10000)
      val expected = 541267.1990
      actual should === (expected)
    }
  }

  "RetCalc.simulatePlan" should {
    "calculate the capital at the retirement and the capital after death"
    val (capitalAtRetirement, capitalAfterDeath) = 
    RetCalc.simulatePlan(
      interestRate = 0.04 / 12,
      nbOfMonthSavings = 25 * 12, nbMonthsInRetirement = 40 * 12,
      netIncome = 3000, currentExpenses = 2000,
      initialCapital = 10000)
    capitalAtRetirement should === (541267.1990)
    capitalAfterDeath should === (309867.5316)
  }
}
