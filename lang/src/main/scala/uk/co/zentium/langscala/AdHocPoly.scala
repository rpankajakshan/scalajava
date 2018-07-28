package uk.co.zentium.langscala

trait Adder[A] {
  def add(x: A, y: A): A
}

object Implicitsx {

  implicit object IntAdder extends Adder[Int] {
    override def add(x: Int, y: Int) = x + y
  }

}

abstract class AdHocPoly[A] {

  def add(x: A, y: A)(implicit adder: Adder[A]): A = adder.add(x, y)

//  def run(o : Any) = List(o)
//    .map(_.asInstanceOf[A])
//    .map(f => add(f, f))

}

class CPly extends AdHocPoly[Int]

object Runner extends App {

  import Implicitsx._


//  println(new CPly().run(1))

//  println(List(Some(1), None, Some(2), None).flatten)

  val l = List(1,2,3)

  val o = for {
    i <- l
  } yield i + "a"

  println(o)
}
