
ThisBuild / scalaVersion :="2.13.6"
ThisBuild / organization :="com.catalogue"
ThisBuild / version := "1.0-SNAPSHOT"



lazy val root = (project in file(".")).enablePlugins(PlayScala).settings(
  name := """ProductCatalogue""",
  libraryDependencies ++= Seq(guice,
    "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test,
    "com.typesafe.play" %% "play-slick" % "5.0.0",
    "com.typesafe.play" %% "play-slick-evolutions" % "5.0.0",
    "com.typesafe.play" %% "play-slick-evolutions" % "5.0.0",
    "com.h2database" % "h2" % "1.4.199",
    "org.typelevel" %% "cats-core" % "2.3.0",
    "org.webjars" % "jquery" % "3.6.0",
    "org.webjars" % "bootstrap" % "5.1.1",
    "org.webjars.npm" % "bootstrap-icons" % "1.6.1"
  ),
)



// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.example.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.example.binders._"
