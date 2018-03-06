object Main extends App {
    class Expr
    case class Number(value : Int) extends Expr
    case class Variable(name : String) extends Expr
    case class Operator(left : Expr, right : Expr,
                        f: (Int, Int) => Int) extends Expr

    def eval(expr : Expr, symbols : Map[String, Int]) : Int =
        expr match {
            case Number(num) => num
            case Variable(name) => symbols(name)
            case Operator(left, right, f) => f(eval(left, symbols), eval(right, symbols))
        }

    val test = Operator(Number(3), Operator(Number(4), Variable("x"), _ * _), _ + _)

    println(eval(test, Map("x" -> 5)))



}
