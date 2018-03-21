
def diffs(lst : List[Int]) = {
    val seed: (List[Int], Option[Int]) = (Nil, None)
    val foldResult = (lst :\ seed)((element, state) =>
    if(state._2.isEmpty) (state._1, scala.Option(element))
    else ((element - state._2.getOrElse(, 0)) :: state._1, state._2 = element)
    )
    foldResult._1
}

/*
   Your diagram here...

 */
println(diffs(List(1, 7, 2, 9)))