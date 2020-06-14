package com.eking.scala.commands
import com.eking.scala.filesystem.State

class Pwd extends Command {
  override def apply(state: State): State = {
    state.setMessage(state.wd.path)
  }
}
