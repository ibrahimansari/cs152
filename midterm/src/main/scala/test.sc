def allCombinations(as: List[Int], bs: List[Int]) = {
    as.flatMap(x => bs.map(y => (x.toString + y.toString).toInt))
}

println(allCombinations(List(1, 2), List(3, 4, 5)))