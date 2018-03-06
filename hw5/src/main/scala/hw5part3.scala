import scala.util.parsing.combinator._

object hw5part3 {

    class SimpleLanguageParser extends JavaTokenParsers {
        def expr: Parser[Any] = term ~ opt(("+" | "-") ~ expr)
        def term: Parser[Any] = factor ~ opt(("*" | "/" ) ~ term)
        def factor: Parser[Any] = wholeNumber| ident | "(" ~ expr ~ ")"
        def valdef: Parser[Any] = "val" ~ ident ~ "=" ~ expr
        def eval(x : Any, symbols: Map[String, Int]) : Int = x match {
            case a ~ Some("+" ~ b) => eval(a,symbols) + eval(b,symbols)
            case a ~ Some("-" ~ b) => eval(a,symbols) - eval(b,symbols)
            case a ~ Some("*" ~ b) => eval(a,symbols) * eval(b,symbols)
            case a ~ Some("/" ~ b) => eval(a,symbols) / eval(b,symbols)
            case a ~ None => eval(a,symbols)
            case a : String => Integer.parseInt(a)
            case "(" ~ a ~ ")" => eval(a,symbols)
        }
    }
}
