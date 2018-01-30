import java.util.List;

public class Mult implements Function<Integer> {

    @Override
    public Integer apply(List<Integer> args) {
        Integer ans = 1;
        for (Integer arg : args)
            ans *= arg;

        return ans;
    }
}
