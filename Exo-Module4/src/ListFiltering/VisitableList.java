public class VisitableList extends Visitable {

    public VisitableList(Object [] elements){
        this.elements = elements;
    }

    @Override
    void accept(Visitor visitor) {
        for(Object i : elements){
            visitor.visit(i);
        }
    }
}