package scalamelb.specs

import org.specs._

object ThreadedLists extends Specification {
  
  var listOfStrings:List[String] = Nil
  val withThreeValues = beforeContext{ listOfStrings = "bob" :: "harry" :: "dorothy" :: Nil }
  
  "A list of three Strings" ->-(withThreeValues) should {
    "be of three strings long" in {
      listOfStrings.length must_== 3
    }
  }
}
