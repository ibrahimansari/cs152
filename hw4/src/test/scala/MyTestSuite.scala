import hw4._
import org.scalatest.FunSuite

class MyTestSuite extends FunSuite{
    test("Cats") {
        assert(cats(letters("2"), letters("3")).toSet
            == Set("AD", "BD", "CD", "AE", "BE", "CE", "AF", "BF", "CF"))
    }

    test("words for digits") {
        assert(wordsForDigits("72252").contains("SCALA"))
    }
}
