object problem1 extends App {
  def diffs(lst: List[Int]) = {
    def helper(lst : List[Int], dif : List[Int]) : List[Int] = {
      if(lst.tail.tail.isEmpty) dif :+ lst.head - lst.tail.head
      else helper(lst.tail, dif :+ lst.head - lst.tail.head)
    }
    helper(lst, List())
  }

  println(diffs(List(3, 1, 4, 1, 5, 9, 2, 6)))
}
