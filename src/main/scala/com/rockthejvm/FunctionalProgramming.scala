package com.rockthejvm

object FunctionalProgramming extends App {

  // Scala is OO
  class Person(name: String) {
    def apply(age: Int) = println(s"I have aged $age years")
  }

  val bob = new Person("Bob")
  bob.apply(43)
  bob(43) // invokes bob as a function  === bob.apply

  /*
    scala runs on JVM
    Functional Programming:
    - compose functions
    - pass functions as arguments
    - return functions as results

     conclusion: FunctionX

   */

  val simpleIncrementer = new Function1[Int, Int] {
    override def apply(arg: Int): Int = arg + 1
  }
  simpleIncrementer.apply(23)
  simpleIncrementer(23)
  // defined a function!

  // all SCALA functions are instances of these function_x type

  val stringConcatenator = new Function2[String, String, String] {
    override  def apply(arg1: String, arg2: String): String = arg1 + arg2
  }

  stringConcatenator("I Love", "Scala")

  // syntax sugar

  val doubler = (x: Int) => 2 * x
  doubler(4) // 8

  /*
    equivalent to the much longer:
    val doubler: Function1[Int,Int] = new function1[Int,Int] {
      override def apply(x:Int) = 2 * x
    }
   */

  //higher order functions: take functions as arguements/return functions as results
  val aMappedList = List(1,2,3).map(x => x + 1)
//  println(aMappedList)
  val aFlatMapList = List(1,2,3).flatMap(x => List(x, 2 * x))
//  println(aFlatMapList)
  val aFilteredList = List(1,2,3,4,5).filter( _ <= 3) // (x => x <= 3)
//  println((aFilteredList))

  // all the pairs betweeen 1,2,3 and the letters a, b c

  val allPairs = List(1,2,3).flatMap(num => List("a","b", "c").map(letter => s"$num-$letter"))
  println((allPairs))
  // for comprehensions

  val altPairs = for {
    number <- List(1,2,3)
    letter <- List("a", "b", "c")
  } yield s"$number-$letter"

  println(allPairs)


  /*
    Collections
   */

  //list
  val aList = List(1,2,3,4,5)
  val first = aList.head
  val rest = aList.tail
  val aPrependedList = 0 :: aList // List(0,1,2,3,4,5)
  val anExtendedList = 0 +: aList :+ 6 // List(0,1,2,3,4,5,6)

  // sequences
  val aSequence: Seq[Int] = Seq(1,2,3)
  val accessedElement = aSequence.apply(1) // returnrs the number at that index

  // vectors - fast seq implementation
  val aVector = Vector(1,2,3,4,5)

  // sets = no duplicates

  val aSet = Set(1,2,3,4,1,2,3) // Set(1,2,3,4)
  // test if element is contained in set
  val setHas5 = aSet.contains(5 )// false
  val addSet = aSet + 5  // Set(1,2,3,4,5)
  val removeSet = aSet - 3 // Set(1,2,4)


  // ranges
  val aRange = 1 to 1000
  val twoByTwo = aRange.map(2 * _).toList

  //tuples = groups of values under the same value
  val aTuple = ("Bon Jovi", "Rock", 1982)

  // maps
  val aPhonebook: Map[String, Int] = Map (
    ("Dan", 1234),
    "Jane" -> 5678
  )




}
