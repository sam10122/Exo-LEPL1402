import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaExpression {
    public static void main(String[] args) {
        //Add Integer
        Function<Integer,Integer> f1 = (a) -> a+2;

        //String length
        Function<String, Integer> mf = (a) -> a.length();

        //Even Integer
        Predicate<Integer> p1 = (a) -> a%2 == 0;

        //String Comparator
        Comparator<String> comp = (a,b) -> a.compareTo(b);

        //String Length Comparator
        Comparator<String> compLength = (a,b) -> a.length() - b.length();
    }
}
