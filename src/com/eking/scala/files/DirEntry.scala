package com.eking.scala.files

abstract class DirEntry(val parentPath: String, val name: String) {
  // parent class of directory and files
  def path: String = parentPath + Directory.SEPARATOR + name
}
