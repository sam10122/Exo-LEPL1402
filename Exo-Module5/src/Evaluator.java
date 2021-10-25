import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Evaluator {

    public BiFunction<Boolean, Boolean, Boolean> xor_gate() {
        BiFunction<Boolean,Boolean,Boolean> xor = (a,b) ->{
            if(a == true && b == false){
                return true;
            }
            if(a == false && b == true){
                return true;
            }
            if(a == true && b == true){
                return false;
            }
            else {
                return false;
            }
        };
        return xor;
    }

    public BiFunction<Boolean, Boolean, Boolean> or_gate() {
        BiFunction<Boolean,Boolean,Boolean> or = (a,b) ->{
            if(a == true && b == false){
                return true;
            }
            if(a == false && b == true){
                return true;
            }
            if(a == true && b == true){
                return true;
            }
            else {
                return false;
            }
        };
        return or;
    }

    public BiFunction<Boolean, Boolean, Boolean> and_gate() {
        BiFunction<Boolean,Boolean,Boolean> and = (a,b) ->{
            if(a == true && b == true){
                return true;
            }
            if(a == false && b == false){
                return false;
            }
            else {
                return false;
            }
        };
        return and;
    }

    public Function<Boolean, Boolean> not_gate() {
        Function<Boolean,Boolean> not = (a) ->{
            if(a){
                return false;
            }
            return true;
        };
        return not;
    }

    // Should return a map containing the computation's results (use HashMap)
    // You're asked to store the results under the following keys: "SUM" & "carry_out"
    // TODO WARNING : ONLY USE the previously defined methods to compute the result
    // (INGInious will prevent you from cheating by directly invoking logical operators)
    public Map<String, Boolean> evaluate_circuit(Boolean a, Boolean b, Boolean carry_in) {
        HashMap<String,Boolean> map = new HashMap<String ,Boolean>(){{
            put("SUM", xor_gate().apply(xor_gate().apply(a,b), carry_in));
            put("carry_out", or_gate().apply(and_gate().apply(a,b),and_gate().apply(xor_gate().apply(a,b),carry_in)));
        }};
        return map;
    }



}