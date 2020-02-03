package factorial

object FactorialDivideAndConquer {
  def factorial(n: Int): BigInt = rangeProduct(1, n)

  private def rangeProduct(n1: Long, n2: Long): BigInt = n2 - n1 match {
    case 0 => BigInt(n1)
    case 1 => BigInt(n1 * n2)
    case 2 => BigInt(n1 * (n1 + 1)) * n2
    case 3 => BigInt(n1 * (n1 + 1)) * ((n2 - 1) * n2)
    case _ =>
      val nm = (n1 + n2) >> 1
      rangeProduct(n1, nm) * rangeProduct(nm + 1, n2)
  }
}
