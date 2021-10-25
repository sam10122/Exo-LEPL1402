import java.util.function.Function;

public abstract class FTree<A> {
    public final int depth() {
        if(this.left() == null && this.right() == null){
            return 0;
        }
        int left = 1 + this.left().depth();
        int right = 1 + this.right().depth();
        return Math.max(left,right);

    }

    public abstract A value();
    public abstract FTree<A> left();
    public abstract FTree<A> right();

    public final <B> FTree<B> map(Function<A,B> f) {
        if(this.right() == null && this.left() == null){
            return new Leaf<B>(f.apply(this.value()));
        }
        return new Node<>(f.apply(this.value()),this.left().map(f),this.right().map(f));
    }



}
