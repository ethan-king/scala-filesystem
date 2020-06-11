package com.eking.scala.commands

import com.eking.scala.filesystem.State

trait Command {
  // changes state

  def apply(state: State): State

}
object Command {

  def emptyCommand: Command = ???

  def from(input: String): Command ={
    val tokens: Array[String] = input.split(" ")

    new UnknownCommand
  }
}