import java.io.InputStreamReader
import scala.util.parsing.combinator.JavaTokenParsers

object hw6part3 extends App {

  class XMLLikeParser extends JavaTokenParsers {
    def list: Parser[Any] = rep(opt("::") ~ opt("(") ~ opt(",") ~ opt(")") ~> wholeNumber <~ opt("::") ~ opt("(") ~ opt(",") ~ opt(")"))
  }

  val parser = new XMLLikeParser
  parser.parseAll(parser.list, new InputStreamReader(System.in)) match {
    case parser.Success(result, next) => println(result)
    case _ => println("Error")
  }
}
