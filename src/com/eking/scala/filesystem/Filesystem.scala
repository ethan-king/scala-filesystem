package com.eking.scala.filesystem

import java.util.Scanner

import com.eking.scala.commands.Command
import com.eking.scala.files.Directory

object Filesystem extends App{

  val root = Directory.ROOT
  // [1, 2, 3, 4]
  /*
  0 (op) 1 =>
  1 (op) 2 => 3
  3 (op) 3 => 6
  6 (op) 4 => 10

  List(1,2,3,4).foldLeft(0) ((x,y) => x + y) // fold left starting from 0
   */
  val initialState = State(root, root)
  initialState.show
  io.Source.stdin.getLines().foldLeft(initialState) ((currentState, newLine) => {
    val newState = Command.from(newLine).apply(currentState)
    newState.show
    newState
  })

//  var state = State(root, root) // need var for stateful programming
//  val scanner = new Scanner(System.in)
//
//  while(true) {
//    state.show
//    val input = scanner.nextLine()
//    state = Command.from(input).apply(state) // Command applied to state to return another state
//  }
}
