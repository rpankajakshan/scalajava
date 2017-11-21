package uk.co.zentium.langscala

import org.scalatest.Matchers

object Succinct2 extends App with Matchers {

  case class Person(id: String, name: String, age: Int)

  def averageAge(people: List[Person]): Double = people.map(_.age).sum / people.size.toDouble

  averageAge(
    List(
      Person("id1", "rp1", 20),
      Person("id2", "rp2", 40),
    )
  ) should be (30.0)
}
