package uk.co.zentium.langscala

import org.scalatest.Matchers

object Succinct1 extends App with Matchers {

  val validKeyMap = Map(
    "logo" -> List("src"),
    "uuid" -> List("cgid", "src"),
    "pcms" -> List("cgid", "src")
  )

  def hasValidAttributeKeys(idType: String, attributes: Map[String, String]) =
    attributes.keys
      .map(item => if (validKeyMap.contains(idType) && validKeyMap(idType).contains(item)) 0 else 1)
      .sum == 0


  hasValidAttributeKeys("uuid", Map("who" -> "valsome")) should be(false)
  hasValidAttributeKeys("uuid", Map("src" -> "EDITORIAL", "who" -> "valsome")) should be(false)
  hasValidAttributeKeys("uuid", Map("src" -> "EDITORIAL")) should be(true)
}
