object LetterCountApp {

  def countLetterOccurrences(words: List[String]): Int = {
    // Map each word to its length and then reduce to get the total count
    words.map(_.length).reduce(_ + _)
  }

  def main(args: Array[String]): Unit = {
    val words = List("apple", "banana", "cherry", "date")
    val totalOccurrences = countLetterOccurrences(words)
    println(s"Total count of letter occurrences: $totalOccurrences")
  }
}
