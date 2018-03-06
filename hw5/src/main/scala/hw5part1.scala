import java.util.Scanner

object hw5part1 {

    abstract class Expr[T] {
        def value: T
    }

    class Op[T](fun: Seq[T] => T, args: Expr[T]*) extends Expr[T] {
        override def value: T = fun.apply(args.map(_.value))
    }

    case class Const[T](value: T) extends Expr[T]

    def sum(arg: Int*): Int = arg.sum

    case class Sum(args: Expr[Int]*) extends Op[Int](sum, args: _*)

    def mult(arg: Int*): Int = arg.product

    case class Product(args: Expr[Int]*) extends Op[Int](mult, args: _*)

    object Rand extends Expr[Int] {
        val gen = new java.util.Random(42)

        override def value: Int = gen.nextInt()
    }

    object Read extends Expr[Int] {
        val scan = new Scanner(System.in)

        override def value: Int = scan.nextInt()
    }

}
