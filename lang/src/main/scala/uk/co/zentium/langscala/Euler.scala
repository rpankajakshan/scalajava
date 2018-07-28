package uk.co.zentium.langscala

object Euler extends App {

  //  1
  {

    def isModded(num: Long, div: Long) = num % div == 0

    val sum = (1l until 1000l).foldLeft(0l)((acc, num) =>
      if (isModded(num, 3) || isModded(num, 5)) acc + num else acc
    )

    assert(sum == 233168)
  }

  // 2
  {
    val limit = 4000000
    val res = (3 to limit).foldLeft[(Int, (Int, Int))]((2, (1, 2))) { case ((sum, (l, r)), _) =>
      if (r < limit) {
        val nextFib = l + r
        val sumNext = sum + (if (nextFib % 2 == 0) nextFib else 0)
        (sumNext, (r, l + r))
      } else (sum, (l, r))
    }

    assert(res._1 == 4613732)
  }
}
