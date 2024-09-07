object RationalNumberApp {
  class Rational(n: Int, d: Int) {
    require(d != 0, "Denominator cannot be zero")

    // Calculate the greatest common divisor (gcd)
    private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

    // Reduce the rational number to its simplest form
    private val g = gcd(n.abs, d.abs)
    val numerator: Int = n / g
    val denominator: Int = d / g

    // Negate the rational number
    def neg: Rational = new Rational(-numerator, denominator)

    // Override toString to display the rational number
    override def toString: String = s"$numerator/$denominator"
  }

  def main(args: Array[String]): Unit = {
    val x = new Rational(3, 4)
    println(s"Original Rational: $x")
    println(s"Negated Rational: ${x.neg}")
  }
}
