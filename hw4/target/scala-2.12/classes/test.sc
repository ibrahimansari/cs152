val characters = (s : String) => s.toList.map("" + _)

val letters = Map("2" -> "ABC", "3" -> "DEF", "4" -> "GHI", "5" -> "JKL",
    "6" -> "MNO", "7" -> "PRS", "8" -> "TUV", "9" -> "WXY").map(e => (e._1, characters(e._2)))

letters("3").flatMap(y => letters("2").map(x => x + y))

val cats = (s: List[String], t: List[String]) => s.flatMap(x => t.map(y => x + y))

cats(letters("2"), letters("3"))

val wordsForDigits = (digits: String) => digits.map(x => letters(x.toString)).reduceLeft(cats)

wordsForDigits("72252")

