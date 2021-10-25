import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.function.Predicate;

abstract class FList<A> implements Iterable<A> {
    /**
     * Returns an empty FList
     */
    public static <A> FList<A> nil() {
        return (Nil<A>) Nil.INSTANCE;
    }

    /**
     * Returns a new FList obtained by prepending a to this list
     */
    public final FList<A> cons(final A a) {
        return new Cons(a, this);
    }

    /**
     * @return the number of elements in this list
     */
    public abstract int length();

    /**
     * @return true if the list is empty, false otherwise
     */
    public abstract boolean isEmpty();

    /**
     * @return the head of the list.
     * @throws NoSuchElementException if the list is empty
     */
    public abstract A head();

    /**
     * @return the tail of the list (i.e. the sublist without the first element of this list)
     * @throws NoSuchElementException if the list is empty
     */
    public abstract FList<A> tail();

    /**
     * Returns a new list containing the outputs obtained by applying function f to each element of this list
     */
    public abstract <B> FList<B> map(Function<A,B> f);

    /**
     * Returns a new list containing only the elements from this list that fullfill predicate f (i.e. f(elem) == true)
     */
    public abstract FList<A> filter(Predicate<A> f);


    public Iterator<A> iterator() {
        return new Iterator<A>() {
            FList<A> elem = FList.this;

            public boolean hasNext() {
                return elem.tail().isEmpty();
            }

            public A next() {
                // TODO
                if(!hasNext()){
                    throw new NoSuchElementException();
                }
                A first = elem.head();
                elem = elem.tail();
                return first;
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }


    private static final class Nil<A> extends FList<A> {
        public static final Nil<Object> INSTANCE = new Nil();

        @Override
        public int length() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return true;
        }

        @Override
        public A head() {
            throw new NoSuchElementException();
        }

        @Override
        public FList<A> tail() {
            throw new NoSuchElementException();
        }

        @Override
        public <B> FList<B> map(Function<A, B> f) {
            return new Nil<>();
        }

        @Override
        public FList<A> filter(Predicate<A> f) {
            return new Nil<>();
        }

        @Override
        public Iterator<A> iterator() {
            return super.iterator();
        }
    }

    private static final class Cons<A> extends FList<A> {
        A head;
        FList<A> next;

        public Cons(A head, FList<A> next){
            this.head = head;
            this.next = next;
        }


        @Override
        public int length() {
            if(this.isEmpty()){
                return 0;
            }
            return 1+ this.next.length();
        }

        @Override
        public boolean isEmpty() {
            return this.head == null;
        }

        @Override
        public A head() {
            if(this.head == null){
                throw new NoSuchElementException();
            }
            return this.head;
        }

        @Override
        public FList<A> tail() {
           if(this.isEmpty()){
               throw new NoSuchElementException();
           }
           return this.next;
        }

        @Override
        public <B> FList<B> map(Function<A, B> f) {
            if(this.next == null){
                return new Cons<>(f.apply(this.head),null);
            }
            return new Cons<>(f.apply(this.head),this.next.map(f));

        }

        @Override
        public FList<A> filter(Predicate<A> f) {
            if(this.next == null){
                if(f.test(this.head)){
                    return new Cons<>(this.head,null);
                }
            }
            if(f.test(this.head)){
                    return new Cons<>(this.head,this.next.filter(f));
            }
            return this.next.filter(f);
        }

        @Override
        public Iterator<A> iterator() {
            return super.iterator();
        }

    }
}