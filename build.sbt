lazy val root =
  project
    .in(file("."))
    .settings( scalaVersion := "3.1.0"
             , name         := "recursion"
             , version      := "0.1.0"
             , libraryDependencies ++= Seq(
                 "org.scalacheck" %% "scalacheck" % "1.15.4" % "test",
                 "org.scalatest"  %% "scalatest"  % "3.2.10" % "test"
               )
             )
