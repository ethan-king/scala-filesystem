package com.eking.scala.commands

import com.eking.scala.files.{DirEntry, Directory}
import com.eking.scala.filesystem.State

abstract class CreateEntry(name: String) extends Command {
  override def apply(state: State): State = {
    val wd = state.wd
    if(wd.hasEntry(name)) {
      state.setMessage("Entry " + name + " already exists!")
    } else if (name.contains(Directory.SEPARATOR)) {
      // dis allow mkdir -p something/somethingElse
      state.setMessage(name + " must not contain separators!")
    } else if (checkIllegal(name)) {
      state.setMessage(name + ": illegal entry name!")
    } else {
      doCreateEntry(state, name)
    }
  }

  def checkIllegal(name: String): Boolean = {
    name.contains(".")
  }

  def doCreateEntry(state: State, name: String) : State = {
    def updateStructure(currentDirectory: Directory, path: List[String], newEntry: DirEntry): Directory = {
      if (path.isEmpty) currentDirectory.addEntry(newEntry)
      else {
//        println(path)
//        println(path.head)
//        println(path.head.isEmpty)
//        println(currentDirectory.findEntry(path.head))
        val oldEntry = currentDirectory.findEntry(path.head).asDirectory
        currentDirectory.replaceEntry(oldEntry.name, updateStructure(oldEntry, path.tail, newEntry))
      }
    }
    val wd = state.wd
    //    val fullPath = wd.path

    // 1. get all directories in full path
    val allDirsInPath = wd.getAllFoldersInPath

    // 2. create new dir entry in wd
//    val newDir = Directory.empty(wd.path, name)
    val newEntry: DirEntry = createSpecificEntry(state)

    // 3. update who directory structure starting from the root - dir structure is immutable
    val newRoot = updateStructure(state.root, allDirsInPath, newEntry)

    // 4. find new workingdirectory instance given wd full path in the New directory structure
    val newWd = newRoot.findDescendant(allDirsInPath)

    State(newRoot, newWd)
  }

  def createSpecificEntry(state: State): DirEntry
}
