object hw3 {
    def compose(g : Int => Int, f : Int => Int)(x : Int) = g(f(x))

    def flip(f : (Int, Int) => Int)(x : Int, y : Int) = f(y, x)

    def zip(l1 : List[Int], l2 : List[Int], f: (Int, Int) => Int) : List[Int] =
        if(l1.tail == Nil)
            f(l1.head, l2.head) :: l2.tail
        else if (l2.tail == Nil)
            f(l1.head, l2.head) :: l1.tail
        else
        f(l1.head, l2.head) :: zip(l1.tail, l2.tail, f)

    def combineNeighbors(l : List[Int], f : (Int, Int) => Int) : List[Int] =
        if (l.tail.tail.length == 1) f(l.head, l.tail.head) :: l.tail.tail
        else f(l.head, l.tail.head) :: combineNeighbors(l.tail.tail, f)

    def iterateN(x : Int, f : Int => Int, n : Int) : List[Int] =
        if(n == 1) x :: Nil
        else x :: iterateN(f(x), f, n-1)

    def iterateWhile(x : Int, f : Int => Int, p: Int => Boolean) : List[Int] =
        if(!p(x)) Nil
        else x :: iterateWhile(f(x), f, p)

    def iterateUntil(x : Double, f : Double => Double, p : (Double, Double) => Boolean) : List[Double] =
        if(p(x, f(x))) x :: Nil
        else x :: iterateUntil(f(x), f, p)

    def reduceWithDefault(x : Int, l : List[Int], f : (Int, Int)=>Int) : Int = {
        if(l.isEmpty) return x
        def helper(l: List[Int], p: Int): Int =
            if (l.isEmpty) p else
                helper(l.tail, f(p, l.head))
        helper(l.tail, l.head)
    }

    def otherReduceWithDefault(x : Int, l : List[Int], f : (Int, Int) => Int) : Int =
        if(l.isEmpty) x
        else f(l.head, otherReduceWithDefault(x, l.tail, f))

    def both(f : Int => Boolean, g : Int => Boolean)(i : Int) : Boolean = f(i) && g(i)

    def any(l : List[Int => Boolean])(i: Int) : Boolean =
        if(l.tail == Nil) l.head(i)
        else l.head(i) || any(l.tail)(i)
}
