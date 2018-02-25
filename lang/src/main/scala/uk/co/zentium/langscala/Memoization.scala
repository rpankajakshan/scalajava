package uk.co.zentium.langscala

import org.scalatest.Matchers

import scala.collection.mutable

object Memoization extends App with Matchers {

  val checkPrime: Int => Boolean = {

    def checkPrimeInner(x: Int) = 2 until x forall (v => x % v != 0)

    val cache = mutable.Map[Int, Boolean]()
    x => {
      val now: Long = System.nanoTime()
      if (cache.contains(x)) {
        println("from cache took " + (System.nanoTime() - now))
      } else {
        cache(x) = checkPrimeInner(x)
        println("not from cache took " + (System.nanoTime() - now))
      }
      cache(x)
    }
  }

  println(checkPrime(101))
  println(checkPrime(101))
  println(checkPrime(500))
  println(checkPrime(500))

}