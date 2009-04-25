import sbt._

class SpecsProject(info: ProjectInfo) extends DefaultProject(info) {
  
  // repositories
  val specsRepo = "Specs Repository" at "http://specs.googlecode.com/svn/maven2/"
  
  // dependencies
  val specs = "org.scala-tools.testing" % "specs" % "1.4.4"
  val scalacheck = "org.scala-tools.testing" % "scalacheck" % "1.5"
  val mockito = "org.mockito" % "mockito-core" % "1.7"
  val junit = "junit" % "junit" % "4.4"
}
