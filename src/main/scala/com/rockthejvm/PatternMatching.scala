package com.rockthejvm

object PatternMatching extends App{

  val anInteger = 55
  val order = anInteger match {
    case 1 => "first"
    case 2 => "Second"
    case 3 => "Third"
    case _ => anInteger + "th"
  }

  // PM is an EXPRESSION
  println(order)

  case class Person(name: String, age: Int)
  val bob = Person("Bob", 43)

  val personGreeting = bob match {
    case Person(n, a) => s"Hi my name is $n and I am $a years old."
    case _ => "Something else "
  }

  println(personGreeting)
  // deconstructing tuples
  val aTuple = ("Bon Jovi", "Rock")
  val bandDescription = aTuple match {
    case (band,genre) => s"$band belongs to the genre $genre"
    case _ => "IDK"
  }

  println(bandDescription)

  //decomposing list
  val aList = List(1,2,3)
  val listDescription = aList match {
    case List(_, 2, _) => "List contains 2 on 2nd position"
    case _ => "unknown list"
  }

  // if it doesn't match anything - it will throw an match error
  // PM will try all cases in sequence
}
