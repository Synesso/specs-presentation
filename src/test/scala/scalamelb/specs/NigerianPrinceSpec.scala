package scalamelb.specs

import org.specs._

object NigerianPrinceSpec extends Specification("A Nigerian Prince's Generous Offer") { 
  "A Nigerian prince with access to an email account" should {
    "contact you in relation to his most generous offer" in {
      // exercise the logic and make assertions ...
    }
  }
  
  "A Nigerian prince of dubious ethics" can {
    "acquire your bank account details" in {}
  }
  
  def denyAnyKnowledge = addToSusVerb("deny any knowledge")
  "A Nigerian prince with several offers made" should denyAnyKnowledge {
    "at a later date" in {}
    "to the police" in {}
    "to his mother" in {}
  }
}