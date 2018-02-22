import scala.util.matching._

object hw4 {

    def firstMatch(str: String, regexes: List[Regex]) : String = {
        if(regexes.head.findPrefixOf(str).isDefined)
            regexes.head.findPrefixOf(str).get
        else
            firstMatch(str, regexes.tail)
    }

    def tokens(input : String, reported : List[Regex], ignored : List[Regex]) : (List[String], Int) = {
        if (input.length == 0) (Nil, -1)
        else {
            (Nil, -1)
        }
    }

    val characters = (s : String) => s.toList.map("" + _)

    val letters = Map("2" -> "ABC", "3" -> "DEF", "4" -> "GHI", "5" -> "JKL",
        "6" -> "MNO", "7" -> "PRS", "8" -> "TUV", "9" -> "WXY").map(e => (e._1, characters(e._2)))

    val cats = (s: List[String], t: List[String]) => s.flatMap(x => t.map(y => x + y))

    val words = io.Source.fromURL("http://horstmann.com/sjsu/spring2018/cs152/words").
        getLines.filter(w => Character.isLowerCase(w(0)) && w.length > 1).
        map(_.toUpperCase).toSet + "SCALA"

    val wordsForDigits = (digits: String) => digits.map(x => letters(x.toString)).reduceLeft(cats).toSet.intersect(words).toList

    val catsSpaces = (s: List[String], t : List[String]) => s.flatMap(x => t.map(y => x + " " + y))

    val wordsForDigitsSequence = (seq: List[String]) =>
        seq.map(e => wordsForDigits(e)).reduceLeft(catsSpaces)

    val grow1 = (c: String, substringLists: List[List[String]]) => substringLists.map(x => c :: x)

    val grow2 = (c: String, substringLists: List[List[String]]) => substringLists.map(x => c + x.head :: x.tail)

    val grow = (c: String, a: List[List[String]]) => grow1(c, a) ++ grow2(c, a)

    val substrings = (s: String) => characters(s.substring(0, s.length - 1)).foldRight(List(List(s.substring(s.length-1))))(grow)

    val phoneMnemonics = (digits: String) => substrings(digits).flatMap(wordsForDigitsSequence)

}
