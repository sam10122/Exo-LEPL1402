public class Cons {
    // The item inside this list node
    public int v;
    // The next element, null if there is none
    public Cons next;

    // Returns a new Cons by applying function f on all elements
    public Cons map(F f) {
        if(this.next != null){
            return new Cons(f.apply(v),this.next.map(f));
        }
        else{
            return new Cons(f.apply(this.v),null);
        }
    }
    // Returns a new Cons containing all elements that match predicate p
    public Cons filter(P p) {
        if(this.next != null){
            if(p.filter(this.v)){
                return new Cons(this.v,this.next.filter(p));
            }
            return this.next.filter(p);
        }
        else {
            if(p.filter(this.v)){
                return new Cons(this.v,null);
            }
            return null;
        }

    }

    // Constructor
    public Cons(int v, Cons next) {
        this.v = v;
        this.next = next;
    }

    public static void main(String[] args) {
        Cons c = new Cons(1,new Cons(2, new Cons(3,null)));
        System.out.println(c.next.v);
        System.out.println(c.next.v);
        System.out.println(c);
    }
}