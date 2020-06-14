package com.eking.scala.commands
import com.eking.scala.files.{DirEntry, File}
import com.eking.scala.filesystem.State

class Touch(name: String) extends CreateEntry(name) {
  override def createSpecificEntry(state: State): DirEntry =
    File.empty(state.wd.path, name)

}
