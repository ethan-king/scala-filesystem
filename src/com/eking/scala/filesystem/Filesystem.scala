package com.eking.scala.filesystem

import java.util.Scanner

import com.eking.scala.commands.Command
import com.eking.scala.files.Directory

object Filesystem extends App{

  val root = Directory.ROOT
  var state = State(root, root)
  val scanner = new Scanner(System.in)

  while(true) {
    state.show
    val input = scanner.nextLine()
    state = Command.from(input).apply(state) // Command applied to state to return another state
  }
}
