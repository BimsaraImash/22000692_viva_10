object RationalNumberApp {
  class Rational(n: Int, d: Int) {
    require(d != 0, "Denominator cannot be zero")

    // Calculate the greatest common divisor (gcd)
    private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

    // Reduce the rational number to its simplest form
    private val g = gcd(n.abs, d.abs)
    val numerator: Int = n / g
    val denominator: Int = d / g

    // Add two rational numbers
    def add(other: Rational): Rational = {
      new Rational(
        numerator * other.denominator + other.numerator * denominator,
        denominator * other.denominator
      )
    }

    // Subtract two rational numbers
    def sub(other: Rational): Rational = {
      new Rational(
        numerator * other.denominator - other.numerator * denominator,
        denominator * other.denominator
      )
    }

    // Negate the rational number
    def neg: Rational = new Rational(-numerator, denominator)

    // Override toString to display the rational number
    override def toString: String = s"$numerator/$denominator"
  }

  def main(args: Array[String]): Unit = {
    val x = new Rational(3, 4)
    val y = new Rational(5, 8)
    val z = new Rational(2, 7)

    // Perform the subtraction x - (y - z)
    val result = x.sub(y.sub(z))
    
    println(s"x = $x")
    println(s"y = $y")
    println(s"z = $z")
    println(s"x - (y - z) = $result")
  }
}
