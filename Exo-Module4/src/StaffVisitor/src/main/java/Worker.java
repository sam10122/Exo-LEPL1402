public class Worker extends Person {
    public Worker(String name,
                  int age,
                  float salary) {
        super(name, age, salary);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
