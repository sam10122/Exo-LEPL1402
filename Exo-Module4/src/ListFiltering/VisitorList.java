import java.util.List;

public class VisitorList extends Visitor {

    public VisitorList(Class cls) {
        super(cls);
    }

    @Override
    List<Object> getFiltered() {
        return filtered;
    }

    @Override
    void visit(Visitable visitable) {
        for(Object i : visitable.elements){
            if(toFilter.isInstance(i)){
               visit(i);
            }
        }
    }

    @Override
    void visit(Object o) {
        filtered.add(o);
    }

}
