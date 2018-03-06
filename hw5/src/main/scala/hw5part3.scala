import scala.util.parsing.combinator._

object hw5part3 {

    class SimpleLanguageParser extends JavaTokenParsers {
        def expr: Parser[Any] = term ~ opt(("+" | "-") ~ expr)
        def term: Parser[Any] = factor ~ opt(("*" | "/" ) ~ term)
        def factor: Parser[Any] = wholeNumber | "(" ~ expr ~ ")"
        def valdef: Parser[Any] = ident 
        def eval(x : Any) : Int = x match {
            case a ~ Some("+" ~ b) => eval(a) + eval(b)
            case a ~ Some("-" ~ b) => eval(a) - eval(b)
            case a ~ Some("*" ~ b) => eval(a) * eval(b)
            case a ~ Some("/" ~ b) => eval(a) / eval(b)
            case a ~ None => eval(a)
            case a : String => Integer.parseInt(a)
            case "(" ~ a ~ ")" => eval(a)
        }
    }
}
