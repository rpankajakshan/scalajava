package uk.co.zentium.langscala

import org.scalatest.Matchers

object Succinct3 extends App with Matchers {

  def processRefresh() = process(refKey => "refresh processed")

  def processDelta() = process(refKey => "delta processed")

  def obtainRefKey() = 10

  def process(processor: Int => String) = {
    val refKey = obtainRefKey()
    s"$refKey ${processor(refKey)}"
  }

  processRefresh() should be("10 refresh processed")
  processDelta() should be("10 delta processed")
}