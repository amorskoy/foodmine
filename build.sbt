name := "foodmine"

version := "1.0"

scalaVersion := "2.11.8"

assemblyJarName in assembly := "foodmine.jar"

libraryDependencies += "com.github.alexandrnikitin" %% "bloom-filter" % "0.4.1"

libraryDependencies += "junit" % "junit" % "4.10" % "test"
libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.0"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.0" % "test"
libraryDependencies += "org.apache.commons" % "commons-csv" % "1.4"

libraryDependencies += "com.twitter" %% "algebird" % "0.12.2"
libraryDependencies += "com.twitter" %% "algebird-core" % "0.12.2"
libraryDependencies += "com.twitter" %% "algebird-util" % "0.12.2"

