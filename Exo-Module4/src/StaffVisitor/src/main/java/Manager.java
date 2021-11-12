public class Manager extends Person {
    public Manager(String name,
                   int age,
                   float salary) {
        super(name, age, salary);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public static void main(String[] args) {
        Staff staff = new Staff();
        Worker worker = null;
        staff.addPerson(new Worker("Joe", -15, -15000));
        staff.addPerson(new Worker("",-1,-1000));
        staff.addPerson(new Manager("Mark", 40, 24000));
        MaxWorkerSalaryVisitor v = new MaxWorkerSalaryVisitor();
        staff.accept(v);
        System.out.println(v.getResult());
    }
}
