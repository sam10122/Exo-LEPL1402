import java.util.function.Predicate;
import java.util.function.Function;

public class Cons<E> {
    // The item inside this list node
    public E v;
    // The next element, null if there is none
    public Cons<E> next;

    // Returns a new Cons by applying Function function on all elements
    public <R> Cons <R> map(Function <E,R> function) {
        if(this.next != null){
            return new Cons<>(function.apply(this.v),this.next.map(function));
        }
        return new Cons<>(function.apply(this.v),null);
    }
    // Returns a new Cons containing all elements that match Predicate predicate
    public Cons <E> filter(Predicate <E> predicate) {
        if(this.next != null){
            if(predicate.test(this.v)){
                return new Cons<>(this.v,this.next.filter(predicate));
            }
            return this.next.filter(predicate);
        }
        else{
            if(predicate.test(this.v)){
                return new Cons<>(this.v,null);
            }
            return null;
        }
    }

    // Constructor
    public Cons(E v, Cons<E> next) {
        this.v = v;
        this.next = next;
    }

}
