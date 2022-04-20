package com.rockthejvm

object ObjectOrientation extends App {

  // class and instance
  class Animal {
    val age: Int = 0
    def eat() = println("I am eating")
  }
  val anAnimal = new Animal

  // inheritance
  class Dog(val name: String) extends Animal // contructor definition

  val aDog = new Dog("Leo")

  // conttructor aguments are NOT fields
  println(aDog.name)

  //subtype poloymorphism
  val aDeclaredAnimal: Animal = new Dog("Hachi")

  aDeclaredAnimal.eat()  // the most derivved moethod will be called at runtime

  //abstract class
  abstract class WalkingAnimal {
    val hasLegs = true // by default public, can restrict by using private or protected
    def walk(): Unit
  }

  // interface - ultimate abstract type

  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  trait Philosopher {
    def ?!(thought: String): Unit // valid method name
  }

  // single-class inheritance, multi-trait mixing
  class Crocodile extends Animal with Carnivore with Philosopher {
    override def eat(animal: Animal): Unit = println("I am eating you, animal!")

    def ?!(thought: String): Unit = println(s"I was thinking: $thought")
  }


  val aCroc = new Crocodile
  aCroc.eat(aDog)
  aCroc eat aDog  // infix notation = object method argument , only available for methods with only ONE argument
  aCroc ?! "what if we could fly"


  //operators in scala are actually methods

  val basicMath = 1 + 2
  val anotherBasicMath = (1).+(2)

  // anonymous classes
  val dinosaur = new Carnivore {
    override def eat(animal: Animal): Unit = println("I am a dinosaur so I can eat anything")
  }


  // singleton
  // the only instance of the MySingleton type
  object MySingleton {
    val mySpecialVal = 1231245123
    def mySpecialMethod(): Int = 5555
    def apply(x: Int): Int = x + 1

    MySingleton.mySpecialMethod()
    MySingleton.apply(65)
    MySingleton(65)

    object Animal { // companions - companion object
      // companions can access each other's private fields or methods
      // singleton Animal and instances of Animal are different things
      val canLiveIndefinitely = false
    }

    val animalsCanLiveForever = Animal.canLiveIndefinitely // static fields/methods

    /*
      case classes = lightweight data structure with some boilerplate
       - sensible equals and hash code
       - serialization
       - companion with apply
       - patter matching
    */

    case class Person(name:String, age: Int)

    // may be constructed without new
    val bob = Person("Bobby", 54) // Person.apply("Bobby, 54)


    //exceptions
    try {
        // code that you can throw
      val x: String = null
      x.length
    } catch {
      case e: Exception => "Some faulty error msg"
    } finally {
      // execute some code no matter what
    }


    // generics
    abstract class MyList[T] {
      def head: T
      def tail: MyList[T]
    }

    // using a generic with a concrete type
    val aList: List[Int] = List(1,2,3)
    val first = aList.head // int
    val rest = aList.tail


    val aStringList = List("Hello", "Scala")
    val firstStr = aStringList.head //string

    // Takeaways
    // 1) Scala we usually operate with IMMUTABLE values/objects
    // any modification to an object must return another object
    // Benefits
    // works miracles in multithreaded/distributed environements
    // helps making sense of the code
    val reversedList = aList.reverse // returns a NEW list


    // 2) Scala is closest to the OO ideal
    //



  }





}
