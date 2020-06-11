package com.eking.scala.files

class Directory(override val parentPath: String, override val name: String, val contents: List[DirEntry])
  extends DirEntry(parentPath, name) {

  def hasEntry(name: String): Boolean = ???
  def getAllFoldersInPath: List[String] = ???
  def findDescendant(path: List[String]): Directory = ???

}

object Directory {
  val SEPARATOR = "/"
  val ROOT_PATH = "/"

  def ROOT: Directory = Directory.empty("", "");

  // use Directory.empty to create new directory
  def empty(parentPath: String, name: String) : Directory =
    new Directory(parentPath, name, List())
}
