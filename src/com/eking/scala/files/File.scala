package com.eking.scala.files

import com.eking.scala.filesystem.FilesystemException

class File(override val parentPath: String, override val name: String, contents: String)
  extends DirEntry(parentPath, name) {

  override def asDirectory: Directory =
    throw new FilesystemException("A file cannot be converted to a directory")

  def asFile: File = this

  override def getType: String = "File"
}

object File {
  def empty(parentPath: String, name: String): File =
    new File(parentPath, name, "")
}
