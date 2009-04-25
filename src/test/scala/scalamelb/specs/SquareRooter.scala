package scalamelb.specs

import org.specs._
import org.scalacheck.Prop._

object SquareRooterSpec extends Specification with ScalaCheck {
  "A Square Rooter" should {
    "find the originally squared value (as long as it wasn't negative)" in {
//      forAll { (n: Int) => scala.Math.sqrt(n*n) == n } must pass // fails on input -1
      forAll { n: Int => n >= 0 ==> (scala.Math.sqrt(n*n) == n) } must pass
    }
  }
}
