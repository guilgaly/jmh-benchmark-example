package factorial

object FactorialReduce {
  def factorial(x: Int): BigInt =
    (BigInt(1) to BigInt(x)).product
}
