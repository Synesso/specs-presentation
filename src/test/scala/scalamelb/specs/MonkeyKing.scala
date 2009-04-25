package scalamelb.specs

import org.specs._

object MonkeyKingSpec extends Specification with SystemContexts {

  /* Demonstrates explicit, internal system context */
  "The monkey king under attack" should {
    val monkeyKingUnderAttack = systemContext { new MonkeyKing(true) }
    "summon warriors from his ear hairs".withA(monkeyKingUnderAttack) { monkeyKing =>
      monkeyKing.summonsWarriorsFromEarHair must beTrue
    }
  }
  
  /* Demonstrates implicit, internal system context */
  "The monkey king at rest" should {
    implicit val monkeyKingAtRest = systemContext { new MonkeyKing(false) }
    "not summon warriors from his ear hairs" into { (monkeyKing: MonkeyKing) =>
      monkeyKing.summonsWarriorsFromEarHair must beFalse
    }
  }
  
  /* Demonstrates external system context */
  case class MonkeyKingContext(underAttack: Boolean) extends SystemContext[MonkeyKing] {
    def newSystem = new MonkeyKing(underAttack)
  }
  val monkeyKingUnderAttackAgain = MonkeyKingContext(true)
  "The monkey king under attack, again" definedAs(monkeyKingUnderAttackAgain) should {
    implicit val monkeyKingAtRest = systemContext { new MonkeyKing(false) }
    "once more summon warriors from his ear hairs" in { monkeyKing: MonkeyKing =>
      monkeyKing.summonsWarriorsFromEarHair must beTrue
    }
  }

}

class MonkeyKing(underAttack: Boolean) {
  def summonsWarriorsFromEarHair = underAttack
}