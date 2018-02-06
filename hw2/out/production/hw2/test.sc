def append(a: List[Int], b: List[Int]): List[Int] = if (a.isEmpty) b else
  a.head :: append(a.tail, b)

def reverse(a: List[Int]): List[Int] = if (a.isEmpty) a else
  append(reverse(a.tail), List(a.head))

def onebits(n: Int) : List[Int] = {
  def helper(partial: List[Int], count: Int, n: Int) : List[Int] = {
    if(n==2){
      return (count+1)::partial
    }
    else if(n%2==0){
      helper(partial, count+1, n/2)
    }
    else {
      helper(count::partial, count+1, (n-1)/2)
    }
  }
  return reverse(helper(List(),0,n))
}

onebits(13)