package scalamelb.specs

import org.specs._

object Snowflake extends Specification {

  "A snowflake" should {
    "be cold" in {
      "and icy" in {}
      "and unique" in {}
      "and lightweight" in {}
    }

//    "in the desert" should {    // this is not legal syntax for specs
//      "melt" in {}
//    }
  }
  
}


object SnowflakeSpec extends Specification {
  "A snowflake".isSpecifiedBy(SnowflakeInTheDesertSpec, SnowflakeInTheFridgeSpec, SnowflakeOnTheTongueSpec)
    
  object SnowflakeInTheDesertSpec extends Specification {
    "in the desert" should {
      "melt" in {}
    }
  }
    
  object SnowflakeInTheFridgeSpec extends Specification {
    "in the fidge" should {
      "cool your drinks (a little)" in {}
    }
  }
    
  object SnowflakeOnTheTongueSpec extends Specification {
    "on your tongue" should {
      "not taste funny" in {}
    }
  }
}

