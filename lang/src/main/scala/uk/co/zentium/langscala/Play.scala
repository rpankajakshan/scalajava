package uk.co.zentium.langscala

object Play extends App {

  val validKeyMap = Map(
    "logo" -> List("src"),
    "uuid" -> List("cgid", "src"),
    "pcms" -> List("cgid", "src")
  )

  def hasValidAttributeKeys(idType: String, attributes: Map[String, String]) =
    attributes.keys
      .map(item => if (validKeyMap.contains(idType) && validKeyMap(idType).contains(item)) 0 else 1)
      .sum == 0


  assert(!hasValidAttributeKeys("uuid", Map("who" -> "valsome")))
  assert(!hasValidAttributeKeys("uuid", Map("src" -> "EDITORIAL", "who" -> "valsome")))
  assert(hasValidAttributeKeys("uuid", Map("src" -> "EDITORIAL")))
}
