object problem2 extends App {
  def diffs(lst : List[Int]) = {
    val seed: (List[Int], Option[Int]) = (Nil, None)
    val foldResult = (lst :\ seed)((element, state) =>
      state._2 match {
        case None => (state._1, scala.Option(element))
        case Some(x) => (element - x :: state._1, scala.Option(element))
      }
    )
    foldResult._1
  }

  /*
     Turned in Paper

   */
  println(diffs(List(1, 7, 2, 9)))
}
