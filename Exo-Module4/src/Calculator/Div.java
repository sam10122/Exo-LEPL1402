public class Div extends Node implements Visitable {

    public Div(Visitable left, Visitable right) {
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
