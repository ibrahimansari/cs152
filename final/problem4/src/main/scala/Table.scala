class Table[K,-V](entries: List[(K,V)] = List()) { // TODO: Type variance
  def get(k: K) = entries.foreach(K => K._1 match {
    case None => Nil
    case Some => if(k == K._1) K._2
  })
  // TODO: Implementation
  // TODO: The put method doesn't quite work. Make the appropriate
  // changes.
  def put(k: K, v: V): Table[K, V] = new Table((k, v) :: entries)
}
