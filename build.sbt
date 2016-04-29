libraryDependencies += "com.lihaoyi" %% "ammonite-repl" % "0.5.7" cross CrossVersion.full

initialCommands in (console) := """ammonite.repl.Main.run("")"""

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "1.6.0",
  "org.apache.spark" %% "spark-sql" % "1.6.0"
)
