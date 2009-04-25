package scalamelb.specs

import org.specs._
import org.specs.mock._

object USBLightSpec extends Specification with Mockito {
  
  "A green USB light" should {
    "be observed but not adjusted" in {
	  val light = mock[Light]
	  light.getColour returns Green
	  
	  object LightObserver {
	    def observeLightsColour = light.getColour
	  }
	  val colour = LightObserver.observeLightsColour
	  colour must_== Green

      light.getColour was called
	  light.setIntensity _ wasnt called
     }
  }
  
  trait Colour
  case object Red extends Colour
  case object Green extends Colour
  class Light {
    def getColour: Any = "some hardware dependant task that needs to be mocked"
    def setIntensity(percent: Double): Any = "another hardware dependant task"
  }
}
