inThisBuild(
  List(
    version := "0.1",
    scalaVersion := "3.4.2"
  ))

lazy val scalaTestVersion = "3.2.18"
lazy val scalaTest = "org.scalatest" %% "scalatest" % scalaTestVersion % Test // Test framework: http://www.scalatest.org/

scalacOptions ++= Seq("-deprecation", "-feature")

libraryDependencies += scalaTest

Compile/mainClass := Some("com.thoughtworks.codepairing.SampleApp")
