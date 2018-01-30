import java.util.ArrayList;

public class Op<T> implements Expr<T>{

    private Function<T> fun;
    private Expr<T>[] args;
    private ArrayList<T> list = new ArrayList<>();

    @SafeVarargs public Op(Function<T> fun, Expr<T>... args) {
        this.fun = fun;
        this.args = args;
    }

    @Override
    public T value() {
        for (Expr<T> arg : args) {
            list.add(arg.value());
        }
        return fun.apply(list);
    }
}