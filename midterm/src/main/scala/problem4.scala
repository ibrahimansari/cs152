import scala.util.parsing.combinator._

object problem4 extends App {
   class SimpleLanguageParser extends JavaTokenParsers {    
     def expr: Parser[Boolean] = (term ~ opt(("||") ~ expr)) ^^ {
       case a ~ None => a
       case a ~ Some("||" ~ b) => a || b
     } 
    
     def term: Parser[Boolean] = (factor ~ opt(("&&") ~ term)) ^^ {
       case a ~ None => a
       case a ~ Some("&&" ~ b) => a && b
     }
     
     def factor: Parser[Boolean] = "true".toBoolean | "false".toBoolean | "(" ~> expr <~ ")"
  } 
   
  val parser = new SimpleLanguageParser
  val result = parser.parseAll(parser.expr, " !true || !false && !!true")
  println(result)         
}
