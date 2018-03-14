import java.io.InputStreamReader

import scala.util.parsing.combinator.JavaTokenParsers

object hw6part2 extends App {

  class ListParser extends JavaTokenParsers {
    def list: Parser[Any] = rep(opt("::") ~ opt("(") ~ opt(",") ~ opt(")") ~> wholeNumber <~ opt("::") ~ opt("(") ~ opt(",") ~ opt(")"))
  }

  val parser = new ListParser
  parser.parseAll(parser.list, new InputStreamReader(System.in)) match {
    case parser.Success(result, next) => println(result)
    case _ => println("Error")
  }

}