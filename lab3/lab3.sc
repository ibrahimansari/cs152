def reduce(lst: List[Int], op: (Int, Int) => Int): Int =
  if (lst.tail.isEmpty) lst.head else
    op(lst.head, reduce(lst.tail, op))

reduce(List(2,3,4,5), (x, y) => x - y)

(1 to 5).reduceLeft(_ - _)

(1 to 5).reduceRight(_ - _)