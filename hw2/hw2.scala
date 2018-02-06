object hw2 {

  def subs(s: String): String = {
    def subsHelper(i: Int): String = if (i == s.length) "|" else {
      val str = subsHelper(i + 1)
      str + str.replace("|", "|" + s.substring(i, i + 1))
    }

    subsHelper(0).substring(1)
  }

  def lcs(a: String, b: String): String = if (b.contains(a)) a
    else if (b.contains(a.substring(1, a.length())))
      a.substring(1, a.length())
    else if (b.contains(a.substring(0, a.length() - 1)))
      a.substring(0, a.length() - 1)
    else
      lcs(a.substring(1, a.length() - 1), b)

  // Copied from Class Slides
  def append(a: List[Int], b: List[Int]): List[Int] = if (a.isEmpty) b else
    a.head :: append(a.tail, b)

  // Copied from Class Slides
  def reverse(a: List[Int]): List[Int] = if (a.isEmpty) a else
    append(reverse(a.tail), List(a.head))

  def onebits(n: Int): List[Int] = {
    def oneBitsHelper(list: List[Int], i: Int, n: Int): List[Int] =
      if (n == 2)
        (i + 1) :: list
      else if (n % 2 == 0)
        oneBitsHelper(list, i + 1, n / 2)
      else
        oneBitsHelper(i :: list, i + 1, (n - 1) / 2)

    reverse(oneBitsHelper(List(), 0, n))
  }

}