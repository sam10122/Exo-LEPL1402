public class Leaf implements Visitable {
    private int value;
    public Leaf(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public int accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
