import scala.util.matching._

val patterns = List("if|def|val".r, """\p{L}(\p{L}|\p{N}|_)*""".r,
    """[+-]?\p{N}+""".r, "[+*/%<=>-]".r, "[(){};]".r, """\p{Z}+""".r
)

val input = "if(x<0) 0 else root(x);"

def firstMatch(str: String, regexes: List[Regex]) : String = {
    if(regexes.head.findPrefixOf(str).isDefined)
        regexes.head.findPrefixOf(str).get
    else
        firstMatch(str, regexes.tail)
}

firstMatch(input, patterns)

firstMatch(input.substring(2), patterns)

def tokens(input : String, patterns : List[Regex]) : List[String] = {
    if(input.length == 0) Nil
    else {
        val first = firstMatch(input, patterns)
        if(first == null)
            List()
        else
            first :: tokens(input.substring(first.length), patterns)
    }
}

tokens(input, patterns)