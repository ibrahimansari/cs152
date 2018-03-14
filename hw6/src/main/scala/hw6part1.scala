import java.io._
import scala.util.parsing.combinator._

object hw6part1 extends App {

  class Expr

  case class Number(value: Int) extends Expr

  case class Variable(name: String) extends Expr

  case class Operator(left: Expr, right: Expr, f: (Int, Int) => Int) extends Expr

  case class Def(name: String, expr: Expr)

  case class Prog(defs: List[Def], expr: Expr) {
    def eval: Int = {
      val m : Map[String, Expr] = defs.map(x => (x.name, x.expr)).toMap
      eval2(expr, m)
    }

    def eval2(expr: Expr, map: Map[String, Expr]): Int =
      expr match {
        case Number(num) => num
        case Variable(name) => eval2(map(name), map)
        case Operator(left, right, f) => f(eval2(left, map), eval2(right, map))
      }
  }

  class SimpleLanguageParser extends JavaTokenParsers {
    def expr: Parser[Expr] = (term ~ rep(("+" | "-") ~ term)) ^^ {
      case a ~ lst => (a /: lst) {
        case (x, "+" ~ y) => Operator(x, y, _ + _)
        case (x, "-" ~ y) => Operator(x, y, _ - _)
      }
    }

    def term: Parser[Expr] = (factor ~ rep(("*" | "/") ~ factor)) ^^ {
      case a ~ lst => (a /: lst) {
        case (x, "*" ~ y) => Operator(x, y, _ * _)
        case (x, "/" ~ y) => Operator(x, y, _ / _)
      }
    }

    def factor: Parser[Expr] = ident ^^ (x => Variable(x)) | wholeNumber ^^ (x => Number(x.toInt)) | "(" ~> expr <~ ")"

    def valdef: Parser[Def] = ("val" ~> ident <~ "=") ~ expr <~ ";" ^^ { case s ~ e => Def(s, e) }

    def prog: Parser[Prog] = rep(valdef) ~ expr ^^ { case s ~ e => Prog(s, e) }

  }

  val parser = new SimpleLanguageParser
  parser.parseAll(parser.prog, new InputStreamReader(System.in)) match {
    case parser.Success(result, next) => println(result.eval)
    case _ => println("Error")
  }

}