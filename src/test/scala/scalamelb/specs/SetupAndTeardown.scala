package scalamelb.specs

import org.specs._

object SetupAndTeardown extends Specification {
  def echo(msg: String) = {
//    println(msg)
  }
  
  doBeforeSpec{ echo("Specification-wide setup") }
  
  def createTestFiles(s: String) = echo("Creating test files before example in " + s)
  def deleteTestFiles(s: String) = echo("Deleting test files before example in " + s)
  
  "A file reading process of some sort" should {
    doBefore{ createTestFiles("system 1") }
    doAfter{ deleteTestFiles("system 1") }
    "read the files" in {}
    "make some calculations" in {}
  }
  
  "A file processor of another kind" should {
    createTestFiles("system 2").before
    deleteTestFiles("system 2").after
    "process the file" in {}
  }
  
  "A fully utilised file processor" should {
    doFirst{ echo("do before all examples") }
    "spin its wheels" in { echo("spinning wheels")}
    "chug along" in { echo("chugging along") }
    "throw a fit" in { echo("throwing a fit") }
    doLast{ echo("do after all examples") }
  }
  
  doAfterSpec{ echo("Specification-wide teardown") }
}