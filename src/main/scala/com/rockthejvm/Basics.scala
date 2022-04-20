package com.rockthejvm

object Basics extends App {

  //  define a value
  val meaningOfLife: Int = 42

  val aBool = false
  val aString = "Scala is awesome"
  val aComposedString = "I" + " " + "love" + "Scala"
  val anInterpolatedString = s"The meaing of life is $meaningOfLife"

  //  expression = structures that can be reduced to a value
  val anExpression = 2 + 3

  // if - expression
  val ifExpression = if (meaningOfLife > 43) 53 else 999
  val chainedExpressed = {
    if (meaningOfLife > 43 ) 56
    else if (meaningOfLife < 0 ) -2
    else if (meaningOfLife >999) 78
    else 0
  }

  // code block
  val aCodeBlock = {
    val aLocalValue = 67
    aLocalValue + 3
  }

  // defining a function

  def myFunct(x: Int, y: String): String = {
    y + " " + x
  }

  // recursive
  def factorial(n: Int): Int =
    if (n <= 1) 1
    else n * factorial(n - 1)

  // in scala we do not use loops or iterations, use recursion

  // Unit Type = no meaningful value (VOID)
  def myUnitREturningFunction(): Unit = {
    println("no information")
  }

  val theUnit = ()
}
