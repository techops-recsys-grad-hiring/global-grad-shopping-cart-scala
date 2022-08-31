import Dependencies._

ThisBuild / scalaVersion     := "3.1.3"
ThisBuild / version          := "1.0-SNAPSHOT"
ThisBuild / organization     := "com.thoughtworks.codepairing"
ThisBuild / organizationName := "thoughtworks"

lazy val root = (project in file("."))
  .settings(
    name := "Shopping Cart",
    libraryDependencies += scalaTest % Test
  )

Compile/mainClass := Some("com.thoughtworks.codepairing.SampleApp")
