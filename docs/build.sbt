// Uses the out of the box generic theme.
paradoxTheme := Some(builtinParadoxTheme("generic"))

scalaVersion := "2.13.12"

Compile / paradoxProperties ++= Map(
  "snip.g8root.base_dir" -> "../../../../src/main/g8"
)
