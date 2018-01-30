import org.junit.*;
import static org.junit.Assert.*;

public class ExprTest2 {
    public <T> Const<T> c(T v) { return new Const<T>(v); }

    @Test public void nestedTest2() {
        assertEquals(12, (Object) new Product( new Sum(c(2), c(4)), c(2)).value());
    }

    @Test public void negativeSum() {
        assertEquals(-2, (Object) new Sum(c(-2), c(0)).value());
    }

    @Test public void zeroProduct() {
        assertEquals(0, (Object) new Product(c(0), c(1000)).value());
    }

}
