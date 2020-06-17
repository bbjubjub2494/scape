val catsVersion = "2.1.1"
val dottyVersion = "0.24.0"
val scalaTestkitVersion = "2.13.2"
val junitVersion = "4.12"
val junitInterfaceVersion = "0.11"
val scalacheckVersion = "1.14.3"

lazy val root = project
  .in(file("."))
  .settings(
    name := "unboxed-try",
    version := "0.1.0",

    scalaVersion := dottyVersion,

    libraryDependencies ++= Seq(
      ("org.scalacheck" %% "scalacheck" % scalacheckVersion % Test).withDottyCompat(dottyVersion),
      ("org.typelevel" %% "cats-laws" % catsVersion % Test).withDottyCompat(dottyVersion),
      "org.scala-lang" % "scala-testkit" % scalaTestkitVersion % Test,
      "junit" % "junit" % junitVersion % Test,
      "com.novocode" % "junit-interface" % junitInterfaceVersion % Test,
    ),
  )

lazy val cats = project
  .settings(
    scalaVersion := dottyVersion,

    libraryDependencies ++= Seq(
      ("org.scalacheck" %% "scalacheck" % scalacheckVersion % Test).withDottyCompat(dottyVersion),
      ("org.typelevel" %% "cats-core" % catsVersion).withDottyCompat(dottyVersion),
      ("org.typelevel" %% "cats-laws" % catsVersion % Test).withDottyCompat(dottyVersion),
    ),
  )
  .dependsOn(root)
