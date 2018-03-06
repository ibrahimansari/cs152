object hw5part2 {

    abstract class Expr[T] {
        def eval(symbols: Map[String, T]): T
    }

    def eval[T](d: Def[T], symbols: Map[String, T]): Map[String, T] =
        symbols + (d.name -> d.expr.eval(symbols))

    class Op[T](fun: Seq[T] => T, args: Expr[T]*) extends Expr[T] {
        override def eval(symbols: Map[String, T]): T = fun(args.map(_.eval(symbols)))
    }

    case class Const[T](value: T) extends Expr[T] {
        override def eval(symbols: Map[String, T]): T = value
    }

    def sum(arg: Int*): Int = arg.sum

    case class Sum(args: Expr[Int]*) extends Op[Int](sum, args: _*)

    def mult(arg: Int*): Int = arg.product

    case class Product(args: Expr[Int]*) extends Op[Int](mult, args: _*)

    case class Var[T](name: String) extends Expr[T] {
        override def eval(symbols: Map[String, T]): T = symbols(name)
    }

    case class Def[T](name: String, expr: Expr[T])

}
