import org.scalatest.FunSuite
import hw5part3._

class ParseSuite extends  FunSuite {
    val parser = new SimpleLanguageParser

    test("No variable") {
        assert(parser.eval(parser.parse(parser.expr, "3 - 4 * 5").get, Map()) == -17)
    }

    test("One variable") {
        assert(parser.eval(parser.parse(parser.expr, "4 * x + 2").get, Map("x" -> 10)) == 42)
    }
}