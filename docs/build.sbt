// Uses the out of the box generic theme.
paradoxTheme := Some(builtinParadoxTheme("generic"))

scalaVersion := "2.12.6"

paradoxProperties in Compile ++= Map(
  "snip.g8root.base_dir" -> "../../../../src/main/g8"
)
