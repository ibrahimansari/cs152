val lst = List("Alpha", "Bravo", "Charlie", "Delta", "Echo", "Foxtrot", "Golf")

lst.filter(_.length < 5)

lst.sortBy(_.length)

lst.reduce((x, y) => if (x.length < y.length) y else x)

def makeMin(c: (String, String) => Boolean) = (x: String, y: String) => if (c(x, y)) x else y

makeMin(_ > _)("Fred", "Wilma")

def makeMin2(c: (String, String) => Boolean)(x: String, y: String) = if (c(x, y)) x else y

def makeMax(c: (String, String) => Boolean)(x : String, y : String) = if (c(x,y)) y else x


makeMax(_ > _)("Fred", "Wilma")