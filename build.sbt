lazy val root =
  project
    .in(file("."))
    .settings( scalaVersion := "3.1.0"
             , name         := "recursion"
             , version      := "0.1.0"
             )
