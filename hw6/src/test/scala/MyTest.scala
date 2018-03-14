import hw6part2.ListParser
import org.scalatest.FunSuite

class MyTest extends FunSuite {
  val parser = new ListParser
  val result = parser.parse(parser.list, " 2 :: 2 :: (3,2,1,2,1)").get
  test("Test parser") {
    println(result)
  }
}