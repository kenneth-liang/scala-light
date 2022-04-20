package com.rockthejvm

import scala.concurrent.Future
import scala.util.Failure
import scala.util.Success
import scala.util.Try
import scala.concurrent.ExecutionContext.Implicits.global

object Advanced extends App{

  // lazy evaluation
  lazy val aLazyVal = 2

  lazy val lazyValWSE = {
    println("I am so very lazy!")
    43
  }

  val eagerValue = lazyValWSE + 1

  // useful in infinite collections

  //pseudo-collections
  // as their own types
  // Options, Try

  def methodWhichCanReturnNull(): String = "hello scala"
  def anOption = Option(methodWhichCanReturnNull()) // Some("hello scala")
  // option = colelction which contains at most one element: Some(value) or None

  val stringProcessing = anOption match{
    case Some(string)  => s"I have obtained a valid string: $string"
    case None => "I obtained nothing"
  }

  def methodWhichCanThrowException(): String = throw new RuntimeException

  val aTry = Try(methodWhichCanThrowException())
  // a try = collection with either a value if the code went well or an exception if it threw one

  val anotherStringProcessing = aTry match {
    case Success(validValue) => s"valid string: $validValue"
    case Failure(ex) => s"exception: $ex"
  }


  /**
   * Evalueate something on another thread
   * asynchronous programming
   */


  val aFuture = Future {
    println("Loading...")
    Thread.sleep(1000)
    println("I have computed a value")
    67
  }


  // future collection which contains a value when it's evaluated
  // future is composable with map, flatmap and filter
  // monads

  /**
   * Implicit Basics
   *
   */

  // 1. Implicit arguments

  def aMethodWithImplicitArgs(implicit arg: Int) = arg + 1

  implicit val myImplicitInt = 46
  println(aMethodWithImplicitArgs)

  //2. Implicit conversions
  implicit class MyRichInteger(n: Int) {
    def isEven() = n % 2 == 0

  }

  println(23.isEven()) // new myRichInteger(23).isEven()
  // use implicits carefully


}
