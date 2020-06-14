package com.eking.scala.commands
import com.eking.scala.files.{DirEntry, Directory}
import com.eking.scala.filesystem.State

class Mkdir(name: String) extends CreateEntry(name) {
  override def createSpecificEntry(state: State): DirEntry =
    Directory.empty(state.wd.path, name)
}
