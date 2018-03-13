import java.io._
import scala.util.parsing.combinator._

object hw6part2 {

  val parser = new ListParser
  parser.parseAll(parser.list, new InputStreamReader(System.in)) match {
    case parser.Success(result, next) => println(result)
    case _ => println("Error")
  }

  class ListItem
  case class Number(value: Int) extends ListItem
  case class Contents(values: Int*) extends ListItem
  case class Append(left: Number, right: Contents) extends ListItem

  class ListParser extends JavaTokenParsers {
    

  }

}