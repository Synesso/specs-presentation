package scalamelb.specs

import org.specs._

object PhoneBillSpec extends Specification {

  "A phone bill" should {
    val bill = new PhoneBill
    bill.callsMade = "12455" :: "1900 055 655" :: "000" :: "9898 4477" :: bill.callsMade
    "keep a count of calls made" in {
      bill.numberOfCallsMade must_== 4
    }
    
    "must include a call made to my mother" in {
      bill.callsMade must contain("9898 4477")
    }
    
    "export calls to file" in {
      bill.exportFile must (beReadable and not(beHidden))
    }
    
  }
}

class PhoneBill {
  import java.io.File
  var callsMade:List[String] = Nil
  def numberOfCallsMade = callsMade.size
  def exportFile = new File("project")
}
