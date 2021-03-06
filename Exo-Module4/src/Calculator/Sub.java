public class Sub extends Node implements Visitable {

    public Sub(Visitable left, Visitable right) {
        super(left, right);
    }

    @Override
    public Visitable getLeft() {
        return super.getLeft();
    }

    @Override
    public Visitable getRight() {
        return super.getRight();
    }

    @Override
    public int accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
